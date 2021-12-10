package kr.green.thred7;

public class AppMain {
	public static void main(String[] args) {
		// 이 프로그램의 문제점은 무엇일까요?
		// 생산자 스레드가 데이터를 생성하기 전에 소비자 스레드가 데이터를 소비 했기 때문에 
		// 계산이 되지만 계산 전에 값을 출력해서 값이 항상 0.0나온다. 
		SharedArea sharedArea = new SharedArea();
		
		CalcThread thread1 = new CalcThread();
		thread1.setSharedArea(sharedArea);
		
		PrintThread thread2 = new PrintThread();
		thread2.setSharedArea(sharedArea);
		
		ProgressThread thread3 = new ProgressThread();
		// 데몬 스레드 : 다른 모든 스레드가 끝나면 나도 자동으로 끝내라
		thread3.setDaemon(true);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
