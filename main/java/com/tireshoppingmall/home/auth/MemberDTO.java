package com.tireshoppingmall.home.auth;

public class MemberDTO {

	private String u_id;
	private String pw_password;
	private String i_name;
	private String i_phoneNum;
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String u_id, String pw_password, String i_name, String i_phoneNum) {
		super();
		this.u_id = u_id;
		this.pw_password = pw_password;
		this.i_name = i_name;
		this.i_phoneNum = i_phoneNum;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getPw_password() {
		return pw_password;
	}
	public void setPw_password(String pw_password) {
		this.pw_password = pw_password;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public String getI_phoneNum() {
		return i_phoneNum;
	}
	public void setI_phoneNum(String i_phoneNum) {
		this.i_phoneNum = i_phoneNum;
	}
	@Override
	public String toString() {
		return "MemberDTO [u_id=" + u_id + ", pw_password=" + pw_password + ", i_name=" + i_name + ", i_phoneNum="
				+ i_phoneNum + "]";
	}
		
}
