package com.dingfeng.manage;

import com.dingfeng.api.LoginApi;
import com.dingfeng.bean.LoginBean;
import com.dingfeng.dao.LoginDao;

public class LoginManage implements LoginApi{

	@Override
	public LoginBean login(String accountName, String passWord) {
		LoginDao loginDao = new LoginDao();
		LoginBean loginBean = loginDao.isLogin(accountName, passWord);
		return loginBean;
	}
}
