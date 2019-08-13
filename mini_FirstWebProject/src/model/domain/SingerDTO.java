package model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SingerDTO {

	private String name;
	private int age;
	private String signatureSong;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[이름 : ");
		builder.append(name);
		builder.append(", 나이 : ");
		builder.append(age);
		builder.append(", 대표곡 : ");
		builder.append(signatureSong);
		builder.append("]\n");
		return builder.toString();
	}

}
