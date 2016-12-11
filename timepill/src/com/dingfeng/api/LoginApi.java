package com.dingfeng.api;

import com.dingfeng.bean.LoginBean;

public interface LoginApi {

	/**
	 * 登录
	 * @param accountName
	 * @param passWord
	 * @return
	 */
	public LoginBean login(String accountName,String passWord);
}
