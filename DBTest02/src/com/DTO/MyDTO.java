package com.DTO;

// DTO : Data Transfer Object
// VO : Value Object
// db에 있는 data를 전달 -> db의 컬럼과 같은 이름으로 field 생성하기
public class MyDTO {
	
	/*
	 * NO NUMBER PRIMARY KEY,
	 * NAME VARCHAR2(100),
	 * NICKNAME VARCHAR2(200)
	 */

	private int no;
	private String name;
	private String nickname;
	
	public MyDTO() {}
	
	public MyDTO(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + nickname + "\n";
	}
}
