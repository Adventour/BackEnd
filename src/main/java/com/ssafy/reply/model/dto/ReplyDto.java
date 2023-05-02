package com.ssafy.reply.model.dto;

public class ReplyDto {
	private int replyId;
	private int articleNo;
	private String userId;
	private String content;
	private int likes;
	private String registerTime;

	public ReplyDto() {
	}

	public ReplyDto(int replyId, int articleNo, String userId, String content, int likes, String registerTime) {
		super();
		this.replyId = replyId;
		this.articleNo = articleNo;
		this.userId = userId;
		this.content = content;
		this.likes = likes;
		this.registerTime = registerTime;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String toString() {
		return "ReplyDto [replyId=" + replyId + ", articleNo=" + articleNo + ", userId=" + userId + ", content="
				+ content + ", likes=" + likes + ", registerTime=" + registerTime + "]";
	}
}
