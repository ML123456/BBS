package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.ViaDao;
import dao.impl.ViaDaoImpl;
import entity.Via;
import util.ConnectionFactory;

public class ViaDaoTest {

	static Connection conn = null;
	

	/**
	 * 插入头像表信息
	 * 
	 * @throws FileNotFoundException
	 */
	public static void save(int userid, String vianame){

		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			ViaDao viaDao = new ViaDaoImpl();
			Via via = new Via();

			via.setUserid(userid);
			via.setPhoto(vianame);

			viaDao.save(conn, via);
			
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
	 * 查询头像表信息
	 * 
	 * @throws Exception
	 */
	public static Map<Object, Object> query(int userid) {

		Map<Object, Object> map=new HashMap<>();
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			ViaDao viaDao = new ViaDaoImpl();
			Via via = new Via();
			via.setUserid(userid);

			ResultSet rs = viaDao.query(conn, via);
			while (rs.next()) {
				map.put("viaid", rs.getInt("userid"));
				map.put("photo", rs.getString("photo"));
			}

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
		
		return map;
	}
	
	/**
	 * 修改头像表信息
	 * 
	 * @throws FileNotFoundException
	 */
	public static void update(int userid, String vianame){

		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);

			ViaDao viaDao = new ViaDaoImpl();
			Via via = new Via();

			via.setUserid(userid);
			via.setPhoto(vianame);

			viaDao.update(conn, via);
			
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
	
	
	
}
