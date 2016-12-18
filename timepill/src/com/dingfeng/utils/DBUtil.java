package com.dingfeng.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/timepill", "root", "lichong");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static PreparedStatement prepareStmt(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public static ResultSet executeQuery(Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 释放链接一般是先打开的后关闭
	 * @param conn
	 * @param stmt
	 * @param preStatement
	 * @param rs
	 */
	public static void close(Connection conn, Statement stmt,
			PreparedStatement preStatement, ResultSet rs) {
		
		if (preStatement != null) {
			try {
				preStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			preStatement = null;
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	/**
	 * 开始事务
	 * @param cnn
	 */
	public static void beginTransaction(Connection cnn){
		if(cnn!=null){
			try {
				if(cnn.getAutoCommit()){
					cnn.setAutoCommit(false);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 提交事务
	 * @param cnn
	 */
	public static void commitTransaction(Connection cnn){
		if(cnn!=null){
			try {
				if(!cnn.getAutoCommit()){
					cnn.commit();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 回滚事务
	 * @param cnn
	 */
	public static void rollBackTransaction(Connection cnn){
		if(cnn!=null){
			try {
				if(!cnn.getAutoCommit()){
					cnn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
