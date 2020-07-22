package com.spring.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.domain.AttachFileVO;
import com.spring.mapper.AttachMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileCheckTask {
	
	@Autowired
	private AttachMapper attach;
	
	private String getYesterDayFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		String str = sdf.format(cal.getTime());
		
		return str.replace("-", File.separator); // 2020/07/21 리턴
	}
	
	@Scheduled(cron="0 * * * * *")
	public void checkFiles() {
		log.warn("파일 체크 스케줄링 실행.....");
		
		// DB에서 어제 날짜의 파일 목록 가져오기
		List<AttachFileVO> oldList = attach.getYesterdayFiles();
		// Stream : JAVA 8에서 추가됨(컬렉션 요소를 하나씩 참조해서 람다식으로 처리하게 해줌)
		Stream<AttachFileVO> stream = oldList.stream();
		// Path를 for문 돌리듯 붙여냄
		Stream<Path> filePath = stream.map(vo -> Paths.get("d:\\upload", vo.getUploadPath(), vo.getUuid()+"_"+vo.getFileName()));
		// 모은 Path를 List로 수집
		List<Path> fileListPaths = filePath.collect(Collectors.toList());
		
		// 썸네일 이미지 작업하기 / filtering을 통해서 type별로 분류하고 map을 이용해서 
		oldList.stream().filter(vo -> vo.isFileType() == true).map(vo -> Paths.get("d:\\upload", vo.getUploadPath(), "s_"+vo.getUuid()+"_"+vo.getFileName()))
																														.forEach(p -> fileListPaths.add(p));
		// 어제 날짜의 폴더에 접근해서 DB파일 목록이랑 다른 내용들
		File targetDir = Paths.get("d:\\upload", getYesterDayFolder()).toFile();
		File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath())==false);
		// 삭제하기
		for(File f : removeFiles) {
			log.warn("삭제파일 : "+f.getAbsolutePath());
			f.delete();
		}
	}
}
