package com.dingfeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dingfeng.bean.LoginBean;
import com.dingfeng.utils.DBUtil;

public class LoginDao {

	public LoginBean isLogin(String accountName, String passWord) {
		
		Connection connection = DBUtil.getConn();
		String sql = "select * from user_info where accountName = ? and passWord = ? ";// 编写sql语句，第一个字段不需要插入，是自动增加的
		PreparedStatement preparedStatement = null;
		LoginBean loginBean = new LoginBean();
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, accountName);
			preparedStatement.setString(2, passWord);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				loginBean.setAccountName(rs.getString("accountName"));
				loginBean.setPassWord(rs.getString("passWord"));
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(connection, preparedStatement, preparedStatement, null);
		}
		return loginBean;
	}
}
