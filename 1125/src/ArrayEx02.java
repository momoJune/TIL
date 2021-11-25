import java.util.Arrays;

/*
 * 3행 3열의 배열을 만들고
 * 1 2 3   00 01 02		00 10 20	
 * 4 5 6   10 11 12		01 11 21		   
 * 7 8 9   20 21 22		02 12 22	
 * 로 초기화한 후에 출력하시오
 */
public class ArrayEx02 {
	public static void main(String[] args) {
//		int row = 3, col= 3;
//		int ar[][] = new int[row][col]; // C/C++과 다르게 배열 선언시 변수를 사용가능 하다.
//		
//		System.out.println(Arrays.deepToString(ar));
//
//		for(int i=0;i<ar.length;i++)
//			for(int j=0;j<ar[i].length; j++)
//				ar[i][j] = i*row + j +1; // [0][0], [0][1],[0][2],[0][3], [0][5] ....
//
//		System.out.println(Arrays.deepToString(ar));
//		arrayPrint(ar);
		int row =3, col =3;
		int ar[][]= new int[row][col];
		
		System.out.println(Arrays.deepToString(ar));
		
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[i].length;j++) {
				ar[i][j] = i*row + j+1;
				System.out.printf("%3d", ar[j][i]);
			}
		}
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[i].length;j++) {
				System.out.printf("%3d", ar[j][i]);
			}System.out.println();
		}
//	-------------------------------------------------------------------------------------------	
		for(int i=0;i<ar.length;i++)
			for(int j=0;j<ar[i].length; j++)
				ar[j][i] = i*row + j +1;  // [0][0], [1][0],[2][0],[3][0], [4][0] ....
		
		arrayPrint(ar);
	}
	
	private static void arrayPrint(int ar[][]) {
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[i].length; j++) {
				System.out.printf("%3d ", ar[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
