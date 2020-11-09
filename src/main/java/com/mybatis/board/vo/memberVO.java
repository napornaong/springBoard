package com.mybatis.board.vo;

public class memberVO {
	private String id;
	private String pw;
	@Override
	public String toString() {
		return "memberVO [id=" + id + ", pw=" + pw + ", pnum=" + pnum + ", name=" + name + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String pnum;
	private String name;
}
