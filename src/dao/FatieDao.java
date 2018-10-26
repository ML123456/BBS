package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Fatie;
import entity.Pinglun;

public interface FatieDao {

	//查询用户信息
	public ResultSet query(Connection conn,Fatie fatie) throws SQLException;
	//通过userid查询用户信息
	public ResultSet queryId(Connection conn,Fatie fatie) throws SQLException;
	//插入用户信息
	public void save(Connection conn,Fatie fatie) throws SQLException;
	//修改用户信息
	public void update(Connection conn,Fatie fatie) throws SQLException;
	//删除用户信息
	public void delete(Connection conn,Fatie fatie) throws SQLException;
}
