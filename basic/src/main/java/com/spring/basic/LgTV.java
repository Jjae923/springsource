package com.spring.basic;

public class LgTV implements TV {
	
	private Speaker speaker; // 멤버변수 객체로 선언 시 초기값은 null
	// 초기화 하려면 ①생성자 생성하거나 ②setmethod
		
	public LgTV() {
		super();
	}
	
	public LgTV(Speaker speaker) {
		super();
		this.speaker = speaker;
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
