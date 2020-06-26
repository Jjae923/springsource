package com.spring.component;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")     // 객체 생성이 목적
public class LgTV implements TV {
	
//	@Autowired       	// 객체 생성되어있는 Speaker 객체 주입해줘
//	@Qualifier("samsungSpeaker")
	@Resource(name="samsung")
	private Speaker speaker; 
	
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
