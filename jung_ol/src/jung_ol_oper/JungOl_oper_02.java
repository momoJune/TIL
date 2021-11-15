/* 정수 2개를 입력받아서 첫 번째 수에는 
 * 100을 증가시켜 저장하고 두 번째 수는 10으로 
 * 나눈 나머지를 저장한 후 두 수를 차례로 
 * 출력하는 프로그램을 작성하시오.
 * 
 * 입력 예 
 * 20 35
 * 
 * 출력 예
 * 120 5
*/
package jung_ol_oper;

import java.util.Scanner;

public class JungOl_oper_02 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int num, num1;
		num = sc.nextInt();
		num1= sc.nextInt();
		
		num += 100;
		num1 %= 10;
		System.out.println(num+" "+num1);
		
	}

}
