package com.otz.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	static Connection getconnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grs","root","j009090c");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
	public static String getImgPath() {
		String path="E:/OTZ/Project/Grievance/GrievanceRedressalSystem/GrievanceRedressalSystem/src/main/webapp/Image";
		return path;
	}
}
