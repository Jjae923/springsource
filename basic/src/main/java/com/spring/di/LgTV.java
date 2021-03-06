package com.spring.di;

public class LgTV implements TV {
	
	private Speaker speaker; // 멤버변수 객체로 선언 시 초기값은 null
	// 초기화 하려면 ①생성자 생성하거나 ②setterMethod
	
	private int price; // 일반필드 아직 초기화 안했기 때문에 기본값 0
	// 초기화 하려면 ①생성자 생성하거나 ②setterMethod
		
	public LgTV() {
		super();
	}
	// ①생성자 생성하여 객체 초기화
	public LgTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}
	
	// ①생성자 생성하여 객체, 변수 초기화
	public LgTV(Speaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
	}	
	// new LgTV(new SonySpeaker(), 200000); / 자바코드라면 이렇게 초기화 할 것
	
	@Override
	public void powerOn() {
		System.out.println("LGTV - 전원 On");
		System.out.println("스피커 가격 - "+price);
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
