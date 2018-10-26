package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Via;

public interface ViaDao {
	//查询头像信息
	public ResultSet query(Connection conn,Via via) throws SQLException;
	//插入头像信息
	public void save(Connection conn,Via via) throws SQLException;
	//修改头像信息
	public void update(Connection conn,Via via) throws SQLException;
	//删除头像信息
	public void delete(Connection conn,Via via) throws SQLException;
}
