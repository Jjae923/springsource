package com.spring.resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LgTV implements TV {
	
	@Resource(name="sony") 		// 객체 생성되어있는 Speaker 객체 주입해줘
	private Speaker speaker; 
	// config.xml에 sonySpeaker 객체 생성해놨기 때문에 sonySpeaker 주입
	
	public LgTV() {
		super();
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV - 전원 On");
	}
	@Override
	public void powerOff() {
		System.out.println("LGTV - 전원 Off");
	}
	@Override
	public void volumeUp() {
		//System.out.println("LGTV - 볼륨 Up");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		//System.out.println("LGTV - 볼륨 Down");
		speaker.volumeDown();
	}
}
