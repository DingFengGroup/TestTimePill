package com.dingfeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.dingfeng.bean.LoginBean;
import com.dingfeng.common.TimeUtils;
import com.dingfeng.utils.DBUtil;
import com.mysql.jdbc.TimeUtil;


public class RegisterDao {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	/**
	 * 添加用户信息
	 * @param LOginBean user
	 * @return back 0成功  -1失败
	 */
	public int addUser(LoginBean user){
		int back = 0;
		try {
			String sql = "insert into user_info (createTime, accountName, passWord, nickName, Email) values (?,?,?,?,?)";
			con = DBUtil.getConn();
			pst = con.prepareStatement(sql);
			pst.setTimestamp(1, TimeUtils.getDateTime());
			pst.setString(2, user.getAccountName());
			pst.setString(3, user.getPassWord());
			pst.setString(4, user.getNickName());
			pst.setString(5, user.getEmail());
			pst.executeUpdate();
		} catch (Exception e) {
			back = -1;
			e.printStackTrace();
		}finally {
			DBUtil.close(con, null, pst, rs);
		}
		return back;
	}
	
	/**
	 * 验证邮箱是否存在
	 * @param String email
	 * @return int back   存在是0,  不存在是-1
	 */
	public int checkEmail(String email){
		int back = 0;
		try {
			String sql = "select id from user_info where accountName = ?";
			con = DBUtil.getConn();
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			if(!rs.next()){
				back = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, null, pst, rs);
		}
		return back;
	}
	
}
