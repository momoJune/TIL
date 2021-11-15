/* 두 개의 정수를 입력받아서  첫 번째수는 
 * 후치 증가 연산자를 사용하고 두 번째 수는 전치 감소 
 * 연산자를 사용하여 두 수의 곱을 구한 후 각각의 값을 출력하는 
 * 프로그램을 작성하시오.
 * 
 * 입력 예 
 * 10 20
 * 
 * 출력 예
 * 11 19 190
*/
package jung_ol_oper;

import java.util.Scanner;

public class JungOl_oper_04 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int num, num1, k;
		
		num = sc.nextInt();
		num1= sc.nextInt();
		k = num++ * --num1;
		
		System.out.println( num+" "+num1+" "+k);
		
		
		
	}

}
