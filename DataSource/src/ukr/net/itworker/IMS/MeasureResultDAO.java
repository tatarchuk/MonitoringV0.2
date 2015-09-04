package ukr.net.itworker.IMS;

import java.sql.*;

public class MeasureResultDAO {
	
	private String user = "";
	private String password = "";
	private Connection conn = null;
	private PreparedStatement stmt = null;
	
	public MeasureResultDAO(String user, String password) {		
		this.user = user;
		this.password = password;
	}
	
	private void getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ims", user, password);
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertMeasureResult(MeasureResult mr) {
		try {
		getConnection();
		stmt = conn.prepareStatement("insert into measurement_results " 
		+ "(time, temperature, humidity) " + "values (?, ?, ?)");		
		java.sql.Timestamp dateTime = new java.sql.Timestamp(mr.getCurrentDate().getTime());
		stmt.setTimestamp(1, dateTime);
		stmt.setDouble(2, mr.getTemperatureValue());
		stmt.setDouble(3, mr.getHumidityValue());
		stmt.executeUpdate();
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
