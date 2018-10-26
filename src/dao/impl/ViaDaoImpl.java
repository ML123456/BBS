package dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ViaDao;
import entity.Via;

public class ViaDaoImpl implements ViaDao {

	/**
	 * 查询头像信息
	 */
	@Override
	public ResultSet query(Connection conn, Via via) throws SQLException {
		
		String sql="select * from via where userid=?";
		//PreparedStatement ps=conn.prepareStatement(sql);也行
		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setInt(1, via.getUserid());
		
		ResultSet rs=ps.executeQuery();
		
		return rs;
	}

	/**
	 * 插入头像信息
	 * @throws IOException 
	 */
	@Override
	public void save(Connection conn, Via via) throws SQLException {

		String sql="insert into via(userid,photo) values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
//		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setInt(1, via.getUserid());
		ps.setString(2, via.getPhoto());

		ps.execute();
	}

	/**
	 * 修改头像信息
	 */
	@Override
	public void update(Connection conn, Via via) throws SQLException {
		String sql="update via set photo=? where userid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
//		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setString(1, via.getPhoto());
		ps.setInt(2, via.getUserid());

		ps.execute();
	}

	/**
	 * 删除头像信息
	 */
	@Override
	public void delete(Connection conn, Via via) throws SQLException {
		
	}

}
