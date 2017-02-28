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
	}

	public void addTwoRows() {
		execQueryUpdate("table.laptop.create");
		execQueryUpdate("table.laptop.populate");
	}

}
