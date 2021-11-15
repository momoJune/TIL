/* 한 개의 정수를 입력 받아서 후치증가 연산자를 사용하여 
 * 출력한 후 전치 증가 연산자를 사용하여 출력하는프로그램을 작성하시오.
 * 
 * 입력 예 
 * 5
 * 
 * 출력 예
 * 5
   7
*/
package jung_ol_oper;

import java.util.Scanner;

public class JungOl_oper_03 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int num;
		num = sc.nextInt();
		System.out.println(num);
		num++;
		
		++num;
		System.out.println(num);
		
	}

}
