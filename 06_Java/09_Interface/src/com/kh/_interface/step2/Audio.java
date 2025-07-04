package com.kh._interface.step2;

public class Audio implements RemoteControl {
	private int volume;
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > Volume.MAX_VOLUME) {
			this.volume = Volume.MAX_VOLUME;
		}else if (volume < Volume.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else this.volume = volume;
		System.out.println("현재 볼륨 : " + this.volume);
	}
	
	@Override
	public void search(String url) {
	}

}
