package com.spring.autowired;

public class SamsungSpeaker implements Speaker {

	public SamsungSpeaker() {
		System.out.println("SamsungSpeaker() 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungSpeaker -- 소리 올리기");
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungSpeaker -- 소리 내리기");
	}
}
