package kr.green.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyVO {
	public MyVO(String string, int i) {
	}
	private String name;
	private int age;
}
