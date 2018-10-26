package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public interface UserDao {
	
	//登录验证
	public ResultSet login(Connection conn,User user) throws SQLException;
	//查询用户信息
	public ResultSet query(Connection conn,User user) throws SQLException;
	//插入用户信息
	public void save(Connection conn,User user) throws SQLException;
	//修改用户信息
	public void update(Connection conn,User user) throws SQLException;
	//删除用户信息
	public void delete(Connection conn,User user) throws SQLException;
}
