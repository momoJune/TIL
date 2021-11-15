/* 세 개의 정수를 입력 받아서 합계와 평균을 출력하시오.
 * (단 평균은 소수 이하를 버리고 정수부분만 출력한다.)
 * 
 * 입력 예 
 * 10 25 33
 * 
 * 출력 예
 * sum : 68
   avg : 22
*/
package jung_ol_oper;

import java.util.Scanner;

public class JungOl_oper_01 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int num, num1, num2;
		num  = sc.nextInt();
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.println("sum : "+(num+num1+num2));
		System.out.println("avg : "+((num+num1+num2)/3));
	}

}
