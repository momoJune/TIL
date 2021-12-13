package kr.green.maven.Java1206;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/*
주어진 문자열(공백 없이 쉼표로 구분되어 있음)을 가지고 아래 문제에 대한 프로그램을 작성하세요.
이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌
1. 김씨와 이씨는 각각 몇 명 인가요?
2. "이재영"이란 이름이 몇 번 반복되나요?
3. 중복을 제거한 이름을 출력하세요.
4. 중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.
 */
public class SetEx03 {
	public static void main(String[] args) {
		String names[] = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌".split(",");
		List<String> list = Arrays.asList(names);
		Set<String> set1 = new HashSet<>(list);
		System.out.println("3번답 : " + set1);
		Set<String> set2 = new TreeSet<>(set1);
		System.out.println("4번답 : " + set2);
		
	}
}