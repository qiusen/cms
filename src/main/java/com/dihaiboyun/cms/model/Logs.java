package com.dihaiboyun.cms.model;

import java.util.Date;		            

/**
 * 日志
 * 
 * @author cg
 *
 * @date 2014-08-22
 */
@SuppressWarnings("serial")
public class Logs extends BaseModel{
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 昵称
	 */
	private String nickname;
	
	/**
	 * IP
	 */
	private String ip;
	
	/**
	 * 操作标识：LOGIN、LOGOFF，……
	 */
	private String act;
	
	/**
	 * 操作时间
	 */
	private Date opttime;
	
	/**
	 * 操作内容
	 */
	private String content;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public Date getOpttime() {
		return opttime;
	}
	public void setOpttime(Date opttime) {
		this.opttime = opttime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
