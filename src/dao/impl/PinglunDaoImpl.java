package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.PinglunDao;
import entity.Pinglun;

public class PinglunDaoImpl implements PinglunDao{

	/**
	 * 按被评论表的id查询评论表信息
	 */
	@Override
	public ResultSet query(Connection conn, Pinglun pinglun) throws SQLException {
		
		String sql="select * from pinglun where byid=?";
		//PreparedStatement ps=conn.prepareStatement(sql);也行
		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setInt(1, pinglun.getByid());
		
		ResultSet rs=ps.executeQuery();
		
		return rs;
	}

	/**
	 * 插入评论信息
	 */
	@Override
	public void save(Connection conn, Pinglun pinglun) throws SQLException {
		
		String sql="insert into pinglun(pcontent,userid,byid) values(?,?,?)";
		//PreparedStatement ps=conn.prepareStatement(sql);也行
		PreparedStatement ps=conn.prepareCall(sql);
		
		ps.setString(1, pinglun.getPcontent());
		ps.setInt(2, pinglun.getUserid());
		ps.setInt(3, pinglun.getByid());
		
		ps.execute();
	}

	/**
	 * 修改评论信息
	 */
	@Override
	public void update(Connection conn, Pinglun pinglun) throws SQLException {
		
		String sql="update pinglun set pcontent=? where pid=?";
		PreparedStatement ps= conn.prepareCall(sql);
		
		ps.setString(1, pinglun.getPcontent());
		ps.setInt(2, pinglun.getPid());
		
		ps.execute();
	}

	/**
	 * 通过byid删除评论信息
	 */
	@Override
	public void delete(Connection conn, Pinglun pinglun) throws SQLException {

		String sql="delete from pinglun where byid=?";
		PreparedStatement ps= conn.prepareCall(sql);
		
		ps.setInt(1, pinglun.getByid());
		
		ps.execute();
	}
	
	/**
	 * 通过pid删除评论信息
	 */
	@Override
	public void deletepid(Connection conn, Pinglun pinglun) throws SQLException {

		String sql="delete from pinglun where pid=?";
		PreparedStatement ps= conn.prepareCall(sql);
		
		ps.setInt(1, pinglun.getPid());
		
		ps.execute();
	}

}
