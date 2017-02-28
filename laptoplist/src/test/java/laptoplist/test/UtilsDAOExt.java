package laptoplist.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import laptoplist.utils.DBPropUtil;

public class UtilsDAOExt {

	Connection connection;

	private Connection getConnection() {
		Connection conn = null;
		try {
			DBPropUtil dbpu=new DBPropUtil();
			Class.forName(dbpu.getProperty("db.driver"));
			conn = DriverManager.getConnection(dbpu.getProperty("db.connection"),
					dbpu.getProperty("db.user"),
					dbpu.getProperty("db.pass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void execQueryUpdate(String propName){
		try(Connection conn=getConnection()){
			PreparedStatement pstmt=conn.prepareStatement(new DBPropUtil().getProperty(propName));
			pstmt.executeUpdate();
		} catch (IOException|SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteTable() {
		execQueryUpdate("table.laptop.drop");
//		Connection conn = getConnection();
//		try {
//			Statement statement = conn.createStatement();
//			String sql = "DROP TABLE IF EXISTS wine";
//			statement.executeUpdate(sql);
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public void addTwoRows() {
		execQueryUpdate("table.laptop.create");
		execQueryUpdate("table.laptop.populate");
//		Connection conn = getConnection();
//		Statement stmt;
//		PreparedStatement ps = null;
//		try {
//			String sql = "CREATE TABLE wine " + "(id int(11) NOT NULL AUTO_INCREMENT, "
//					+ " name varchar(45) DEFAULT NULL," + " year varchar(45) DEFAULT NULL,"
//					+ " grapes varchar(45) DEFAULT NULL, " + " country varchar(45) DEFAULT NULL, "
//					+ " region varchar(45) DEFAULT NULL, " + " description  blob, "
//					+ " picture varchar(256) DEFAULT NULL, " + " PRIMARY KEY (id)) ";
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
//			ps = conn.prepareStatement(
//					"INSERT INTO wine (name, grapes, country, region, year, picture, description) VALUES (?, ?, ?, ?, ?, ?, ?)",
//					new String[] { "ID" });
//			ps.setString(1, "CHATEAU DE SAINT COSME");
//			ps.setString(2, "Grenache / Syrah");
//			ps.setString(3, "France");
//			ps.setString(4, "Southern Rhone / Gigondas");
//			ps.setString(5, "2009");
//			ps.setString(6, "saint_cosme.jpg");
//			ps.setString(7, "excellent complement to fish dishes");
//			ps.executeUpdate();
//			ps = conn.prepareStatement(
//					"INSERT INTO wine (name, grapes, country, region, year, picture, description) VALUES (?, ?, ?, ?, ?, ?, ?)",
//					new String[] { "ID" });
//			ps.setString(1, "LAN RIOJA CRIANZA");
//			ps.setString(2, "Tempranillo");
//			ps.setString(3, "Spain");
//			ps.setString(4, "Rioja");
//			ps.setString(5, "2006");
//			ps.setString(6, "lan_rioja.jpg");
//			ps.setString(7, "Light and bouncy, with a hint of black truffle");
//			ps.executeUpdate();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
