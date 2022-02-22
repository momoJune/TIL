package kr.green.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeopleVO {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
}
