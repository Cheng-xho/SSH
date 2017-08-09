package com.neusoft.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.neusoft.bean.User;
import com.neusoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
//	@Override
//	public String execute() throws Exception {
//		// TODO Auto-generated method stub
//		return super.execute();
//	}
	public String login(){ 
	
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
	
		User userExist = userService.login(user);
		
		if(userExist!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", userExist);
			return "loginsuccess";
		}
		return "login";
	}

}
