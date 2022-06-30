package utils;
import java.sql.*;
import java.util.logging.Level;

public class JDBCConnection {
	Connection conn = null;
	Connection  qaconn= null;


	public Connection getConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			Logs.LOGGER.info(
					"Where is your MySQL JDBC Driver? " + "Include in your library path!" + " " + e.getMessage());
			return null;
		}

		Logs.LOGGER.info("MySQL JDBC Driver found!");

		try {

			DriverManager.setLoginTimeout(400);
			conn = DriverManager.getConnection(Constants.dburl, Constants.dbuserName,Constants.dbpassword);

			Logs.LOGGER.info("Connected to Databse");
		} catch (SQLException e) {
			e.printStackTrace();
			Logs.LOGGER.log(Level.SEVERE, "Connection Failed! Check Logs" + " " + e.getMessage());
			return null;
		}
		try {
			if (conn != null) {
				Logs.LOGGER.info("You made it, take control of your database now!");
			}
		} catch (Exception e) {
			Logs.LOGGER.info("Databse connection Lost");
		}

		return conn;
	}



	public Connection getQAConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			Logs.LOGGER.info(
					"Where is your MySQL JDBC Driver? " + "Include in your library path!" + " " + e.getMessage());
			return null;
		}

		Logs.LOGGER.info("MySQL JDBC Driver found!");

		try {

			DriverManager.setLoginTimeout(400);
			qaconn = DriverManager.getConnection(Constants.qadburl, Constants.qadbuserName,Constants.qadbpassword);

			Logs.LOGGER.info("Connected to Databse");
		} catch (SQLException e) {
			e.printStackTrace();
			Logs.LOGGER.log(Level.SEVERE, "Connection Failed! Check Logs" + " " + e.getMessage());
			return null;
		}
		try {
			if (qaconn != null) {
				Logs.LOGGER.info("You made it, take control of your database now!");
			}
		} catch (Exception e) {
			Logs.LOGGER.info("Databse connection Lost");
		}

		return qaconn;
	}

	public ResultSet fetchValueFromQADB(String query) {
		ResultSet rs = null;
		Connection qaconn;
		try {
			Statement stmt;
			qaconn = getConnection();
			stmt = qaconn.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
		} catch (Exception e) {
			Logs.LOGGER.warning("Cannot fetch results from Database" + " " + e.getMessage());
		}
		return rs;

	}



	public ResultSet fetchValueFromDB(String query) {
		ResultSet rs = null;
		Connection con;
		try {
			Statement stmt;
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
		} catch (Exception e) {
			Logs.LOGGER.warning("Cannot fetch results from Database" + " " + e.getMessage());
		}
		return rs;

	}

	public boolean fetchDBResults(String query) {
		boolean dbresult;
		Connection con;
		try {
			Statement stmt;
			con = getConnection();
			stmt = con.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(query);
			dbresult = rs.next();
			return dbresult;
		} catch (SQLException e) {
			dbresult = false;
			Logs.LOGGER.warning("Cannot fetch results from Database" + " " + e.getMessage());
			return dbresult;
		}

	}

	public boolean fetchQADBResults(String query) {
		boolean dbresult;
		Connection qaconn;
		try {
			Statement stmt;
			qaconn = getConnection();
			stmt = qaconn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(query);
			dbresult = rs.next();
			return dbresult;
		} catch (SQLException e) {
			dbresult = false;
			Logs.LOGGER.warning("Cannot fetch results from Database" + " " + e.getMessage());
			return dbresult;
		}

	}


}
