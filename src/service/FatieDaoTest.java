package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.regexp.internal.recompile;

import dao.FatieDao;
import dao.UserDao;
import dao.impl.FatieDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Fatie;
import entity.User;
import util.ConnectionFactory;

public class FatieDaoTest {
	
	static Connection conn = null;
	
	/**
	 * 获得发帖表信息
	 */
	public static List<Object> FatieQuery() {

		List<Object> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			FatieDao fatieDao = new FatieDaoImpl();
			Fatie fatie = new Fatie();

			ResultSet rs = fatieDao.query(conn, fatie);

			for (int i = 0; rs.next(); i++) {
				/**
				 * 要想向list插入不同HashMap的值，必须要将HashMap new在for循环内，因为存入list的是HashMap的地址，不是值。。
				 */
				Map<Object, Object> map = new HashMap<>();
				map.put("fid", rs.getInt(1));
				map.put("titles", rs.getString(2));
				map.put("fcontent", rs.getString(3));
				map.put("userid", rs.getInt(4));
				map.put("photo", rs.getString(5));
				map.put("time", rs.getString(6));
				map.put("username", rs.getString(7));
				
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
	 * 通过userid查询发帖表信息
	 */
	public static List<Object> QueryId(int userid) {

		List<Object> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			FatieDao fatieDao = new FatieDaoImpl();
			Fatie fatie = new Fatie();

			fatie.setUserid(userid);
			
			ResultSet rs = fatieDao.queryId(conn, fatie);

			for (int i = 0; rs.next(); i++) {
				/**
				 * 要想向list插入不同HashMap的值，必须要将HashMap new在for循环内，因为存入list的是HashMap的地址，不是值。。
				 */
				Map<Object, Object> map = new HashMap<>();
				map.put("fid", rs.getInt(1));
				map.put("titles", rs.getString(2));
				map.put("fcontent", rs.getString(3));
				map.put("userid", rs.getInt(4));
				map.put("photo", rs.getString(5));
				map.put("time", rs.getString(6));
				map.put("username", rs.getString(7));
				
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
	 * 向发帖表添加信息
	 */
	public static void save(Fatie fatie) {
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			FatieDao fatieDao=new FatieDaoImpl();
			
			fatieDao.save(conn, fatie);
			
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
	 * 通过fid修改发帖表信息
	 */
	public static void update(Fatie fatie) {
		
		try {
			ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			FatieDao fatieDao=new FatieDaoImpl();
			
			fatieDao.update(conn, fatie);
			
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
	 * 通过fid删除发帖表信息
	 */
	public static void delete(int fid) {
		
		try {
			ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			FatieDao fatieDao=new FatieDaoImpl();
			Fatie fatie=new Fatie();
			
			fatie.setFid(fid);
			
			fatieDao.delete(conn, fatie);
			
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
	
	public static String save1() {
		return "12345";
	}
	
	
}
