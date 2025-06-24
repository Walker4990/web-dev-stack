package com.kh._interface.step2;

public interface RemoteControl extends Volume, Searchable{
	// 인터페이스끼리는 extends, 다중 상속도 가능
	void turnOn();
	void turnOff();
}
