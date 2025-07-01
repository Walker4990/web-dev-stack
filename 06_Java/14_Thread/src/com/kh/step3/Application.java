package com.kh.step3;

import java.awt.Toolkit;

public class Application {

	public static void main(String[] args) {

		// 첫번째 작업 - 경고음 5번 울리기 - BeepThread -> 지금은 분리되엇ㅇ음
//		BeepThread beep = new BeepThread();
//		TextThread text = new TextThread();
//		
//		Thread t1 = new Thread(beep);
//		Thread t2 = new Thread(text);
		
		// 위에 것 합친거
		Thread t1 = new Thread(new BeepThread());
		Thread t2 = new Thread(new TextThread());
		t1.start();
		t2.start();
		// 두번째 작업 - 띵~ 5번 출력 - TextThread
	
	}

}
