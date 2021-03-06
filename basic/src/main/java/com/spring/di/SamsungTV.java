package com.spring.di;

public class SamsungTV implements TV {
	
	private Speaker speaker; // 멤버변수 객체로 선언 시 초기값은 null
	// 초기화 하려면 ①생성자 생성하거나 ②setterMethod
	
	private int price;
	
	// ②setterMethod 로 객체 초기화
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	// ②setterMethod 로 변수 초기화
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 전원 On");
		System.out.println("스피커 가격 - "+price);
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 전원 Off");
	}
	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV - 볼륨 Up");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV - 볼륨 Down");
		speaker.volumeDown();
	}
}
