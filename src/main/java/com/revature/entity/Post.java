package com.revature.entity;

public class Post {
	
	int postId;
	String text;
	int likeCount;
	
	Users users;

	public Post() {
		super();
	}

	public Post(int postId, String text, int likeCount, Users users) {
		super();
		this.postId = postId;
		this.text = text;
		this.likeCount = likeCount;
		this.users = users;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", text=" + text + ", likeCount=" + likeCount + ", users=" + users + "]";
	}
	
	

}
