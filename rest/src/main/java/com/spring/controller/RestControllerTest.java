package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.SampleVO;

@RestController	   // return 값을 마음대로 전송할 수 있음
public class RestControllerTest {
	@GetMapping(value="/hello", produces="text/plain;charset=utf-8")   // produces : 서버가 생산해내는 데이터 타입 지정
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/sendVO")
	public SampleVO sendVO() {
		SampleVO sample = new SampleVO();
		sample.setMno("1234");
		sample.setFirstName("hong");
		sample.setLastName("Dong");
		
		return sample;
	}
	
	@GetMapping(value="/sendlist", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<SampleVO> sendList() {
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i=0;i<10;i++) {
			SampleVO sample = new SampleVO();
			sample.setMno("1234");
			sample.setFirstName("hong");
			sample.setLastName("Dong");
			list.add(sample);
		}
		return list;
	}
	
	// ResponseEntity : 데이터 + Http 상태 코드
	
	@GetMapping("/check")   // http://localhost:8080/check?height=180&weight=74
	public ResponseEntity<SampleVO> check(double height, double weight) {
		SampleVO vo = new SampleVO();
		vo.setMno("123");
		vo.setFirstName(height+"");
		vo.setLastName(weight+"");
		
		ResponseEntity<SampleVO> entity = null;
		if(height < 150) {
			// 400 : HttpStatus.BAD_REQUEST
			entity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
		}else {
			// 200 : HttpStatus.OK
			entity = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return entity;
	}

	// http://localhost:8080/check?cat=bag&pid=123 이렇게 처리X
	// http://localhost:8080/product/bags/1234   앞이 category 뒤가 productID
	// http://localhost:8080/product/bags/4567
	// http://localhost:8080/product/shoes/9876		주소가 매번 바뀔 수 있음
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,@PathVariable("pid") String pid) {
		return new String[] {"category : "+cat, "productID : "+pid};
	}
	
}














