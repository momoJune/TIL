package kr.green.thred5;

public class PrintThread extends Thread {
    SharedArea sharedArea; // 공유영역
    // 생성자
    PrintThread(SharedArea area) {   
        sharedArea = area;
    }
    // 스레드 오버라이딩
    public void run() {
       for (int cnt = 0; cnt < 3; cnt ++) {
    	   // 이부분도 작업 전환이 이루어지면 않된다.
    	   // 작업 전환이 이루어지면 안되는 부분을 반드시 synchronized블록으로 감싸줘야 한다.
    	   synchronized (sharedArea) {
    		   int sum = sharedArea.account1.balance +
    				   sharedArea.account2.balance;
    		   System.out.println("계좌 합계 : " + sum);
    	   }
    	 
    	   try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
