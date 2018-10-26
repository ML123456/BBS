package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.FatieDao;
import dao.PinglunDao;
import dao.impl.FatieDaoImpl;
import dao.impl.PinglunDaoImpl;
import entity.Fatie;
import entity.Pinglun;
import sun.misc.FpUtils;
import util.ConnectionFactory;

public class PinglunDaoTest {

	static Connection conn = null;
	
	/**
	 * 向评论表添加信息
	 */
	public static void save(Pinglun pinglun) {
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			PinglunDao pinglunDao=new PinglunDaoImpl();
			
			pinglunDao.save(conn, pinglun);
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获得评论表信息
	 */
	public static List<Object> PinglunQuery(int byid) {

		List<Object> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			PinglunDao pinglunDao=new PinglunDaoImpl();
			Pinglun pinglun=new Pinglun();

			pinglun.setByid(byid);
			
			ResultSet rs = pinglunDao.query(conn, pinglun);

			for (int i = 0; rs.next(); i++) {
				/**
				 * 要想向list插入不同HashMap的值，必须要将HashMap new在for循环内，因为存入list的是HashMap的地址，不是值。。
				 */
				Map<Object, Object> map = new HashMap<>();
				map.put("pid", rs.getInt(1));
				map.put("pcontent", rs.getString(2));
				map.put("userid", rs.getInt(3));
				map.put("byid", rs.getInt(4));
				map.put("time", rs.getString(5));
				
				list.add(i, map);
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 通过byid删除发帖表对于的评论的信息
	 */
	public static void delete(int byid) {
		
		try {
			ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			PinglunDao pinglunDao=new PinglunDaoImpl();
			Pinglun pinglun=new Pinglun();
			
			pinglun.setByid(byid);
			
			pinglunDao.delete(conn, pinglun);
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 通过pid删除评论信息
	 */
	public static void deletePid(int pid) {
		
		try {
			ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			PinglunDao pinglunDao=new PinglunDaoImpl();
			Pinglun pinglun=new Pinglun();
			
			pinglun.setPid(pid);
			
			pinglunDao.deletepid(conn, pinglun);
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
