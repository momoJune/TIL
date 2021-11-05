import java.util.Scanner;

public class Ex02_IntegerType {

	public static void main(String[] args) {
		
		String birth1 = "192919";
		int    birth2 = 19941123;
		System.out.println("생일 : " + birth1);
		System.out.println("생일 : " + birth2);
		
		int year = birth2/10000;
		System.out.print(year + "년 ");
		
		int month = birth2%10000/100;
		System.out.print(month + "월 ");
		
		int day = birth2%100;
		System.out.println(day + "일");
		
	
		
	}
	

}


