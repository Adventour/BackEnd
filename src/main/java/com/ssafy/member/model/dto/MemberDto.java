package com.ssafy.member.model.dto;

public class MemberDto {
	private String userId;
	private String userName;
	private String userPwd;
	private String userEmail;
	private int userSido;
	private int userGugun;
	private String salt;
	
	
	public String getUserId() { return userId; }
	
	public void setUserId(String userId) { this.userId = userId; }
	
	public String getUserName() { return userName; }
	
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getUserPwd() { return userPwd; }
	
	public void setUserPwd(String userPwd) { this.userPwd = userPwd; }
	
	public String getUserEmail() { return userEmail; }
	
	public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

	public int getUserSido() { return userSido; }

	public void setUserSido(int userSido) { this.userSido = userSido; }

	public int getUserGugun() { return userGugun; }

	public void setUserGugun(int userGugun) { this.userGugun = userGugun; }
	
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail="
				+ userEmail + ", userSido=" + userSido + ", userGugun=" + userGugun + "]";
	}


	
}
