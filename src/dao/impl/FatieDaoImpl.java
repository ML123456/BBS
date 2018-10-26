package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.FatieDao;
import entity.Fatie;

public class FatieDaoImpl implements FatieDao {

	/**
	 * 查询发帖信息
	 */
	@Override
	public ResultSet query(Connection conn, Fatie fatie) throws SQLException {
		
		String sql="select * from fatie order by fid desc";
		//PreparedStatement ps=conn.prepareStatement(sql);也行
		PreparedStatement ps=conn.prepareCall(sql);
		
		ResultSet rs=ps.executeQuery();
		
		return rs;
	}
	
	/**
	 * 通过userid查询发帖信息
	 */
	@Override
	public ResultSet queryId(Connection conn, Fatie fatie) throws SQLException {
		
		String sql="select * from fatie where userid=? order by fid desc";
		//PreparedStatement ps=conn.prepareStatement(sql);也行
		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setInt(1, fatie.getUserid());
		
		ResultSet rs=ps.executeQuery();
		
		return rs;
	}
	

	/**
	 * 插入发帖信息
	 */
	@Override
	public void save(Connection conn, Fatie fatie) throws SQLException {

		String sql="insert into fatie(titles,fcontent,userid,photo,username) values(?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
//		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setString(1, fatie.getTitles());
		ps.setString(2, fatie.getFcontent());
		ps.setInt(3, fatie.getUserid());
		ps.setString(4, fatie.getPhoto());
		ps.setString(5, fatie.getUsername());
		
		ps.execute();
	}

	/**
	 * 修改发帖信息
	 */
	@Override
	public void update(Connection conn, Fatie fatie) throws SQLException {
		
		String sql="update fatie set titles=?,fcontent=?,photo=? where fid=?";
		PreparedStatement ps= conn.prepareCall(sql);
		
		ps.setString(1, fatie.getTitles());
		ps.setString(2, fatie.getFcontent());
		ps.setString(3, fatie.getPhoto());
		ps.setInt(4, fatie.getFid());
		
		ps.execute();
	}

	/**
	 * 删除发帖信息
	 */
	@Override
	public void delete(Connection conn, Fatie fatie) throws SQLException {

		String sql="delete from fatie where fid=?";
		PreparedStatement ps= conn.prepareCall(sql);
		
		ps.setInt(1, fatie.getFid());
		
		ps.execute();
	}

}
