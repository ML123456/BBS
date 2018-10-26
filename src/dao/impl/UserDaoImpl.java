package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {
	
	/**
	 * 登录验证
	 */
	@Override
	public ResultSet login(Connection conn, User user) throws SQLException {
		String sql="select * from user where name=?";
		//PreparedStatement ps=conn.prepareStatement(sql);也行
		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setString(1, user.getName());
		
		ResultSet rs=ps.executeQuery();
		
		return rs;
	}
	
	/**
	 * 查询用户信息
	 */
	@Override
	public ResultSet query(Connection conn, User user) throws SQLException {
		
		String sql="select * from user where userid=?";
		//PreparedStatement ps=conn.prepareStatement(sql);也行
		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setInt(1, user.getUserid());
		
		ResultSet rs=ps.executeQuery();
		
		return rs;
	}
	

	/**
	 * 保存(插入)用户信息
	 */
	@Override
	public void save(Connection conn, User user) throws SQLException {
		
		String sql="insert into user(name,password,email,family,intro) values(?,?,?,?,?)";
		//PreparedStatement ps=conn.prepareStatement(sql);也行
		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getFamily());
		ps.setString(5, user.getIntro());
		
		ps.execute();
	}

	/**
	 * 根据用户指定的id更新用户信息
	 */
	@Override
	public void update(Connection conn, User user) throws SQLException {
		
		String sql="update user set name=?,password=?,email=?,family=?,intro=? where userid=?";
		PreparedStatement ps= conn.prepareCall(sql);
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getFamily());
		ps.setString(5, user.getIntro());
		ps.setInt(6, user.getUserid());
		
		ps.execute();
	}

	/**
	 * 删除指定用户信息
	 */
	@Override
	public void delete(Connection conn, User user) throws SQLException {
		
		String sql="delete from user where userid=?";
		PreparedStatement ps= conn.prepareCall(sql);
		
		ps.setInt(1, user.getUserid());
		
		ps.execute();
	}
}
