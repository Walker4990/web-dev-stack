package com.kh.step4;

public class CountThread extends Thread{
	
	Application process;
	public CountThread(Application process) {
		this.process = process;
	}

public void run() {
	// InputThread에서 숫자를 입력하면 카운트 다운 그 자리에서 종료
	for(int i = 10; i> 0; i--) {
		if(process.check) break;
		System.out.println(i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	if(!process.check) {
		System.out.println("시간 초과 값 입력 불가능");
		System.exit(0);
	}
	}
}
