package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {
	
	// uploadForm 보여주는 컨트롤러 생성
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("uploadForm 요청");
	}

	@PostMapping("/uploadForm")
	public void uploadFormPost(MultipartFile[] uploadFile) {
		log.info("upload 요청");
		String uploadPath = "d:\\upload";
		for(MultipartFile f:uploadFile) {
			log.info("----------------------------");
			log.info("upload File Name : "+f.getOriginalFilename());
			log.info("upload File Size : "+f.getSize());
			
			File saveFile = new File(uploadPath, f.getOriginalFilename());
			try {
				// 서버 폴더에 파일 저장(File, Path 객체로 저장)
				f.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}

























