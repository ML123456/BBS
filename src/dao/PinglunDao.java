package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Pinglun;
import entity.User;

public interface PinglunDao {

	//查询用户信息
	public ResultSet query(Connection conn,Pinglun pinglun) throws SQLException;
	//插入用户信息
	public void save(Connection conn,Pinglun pinglun) throws SQLException;
	//修改用户信息
	public void update(Connection conn,Pinglun pinglun) throws SQLException;
	//通过byid删除用户信息
	public void delete(Connection conn,Pinglun pinglun) throws SQLException;
	//通过pid删除用户信息
	public void deletepid(Connection conn,Pinglun pinglun) throws SQLException;
}
