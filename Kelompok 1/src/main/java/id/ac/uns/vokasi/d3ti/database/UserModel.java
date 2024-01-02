package id.ac.uns.vokasi.d3ti.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserModel {
	Connection con;
	Statement st;
	ResultSet rs;
	User user;

	public UserModel() {
		try {
			String url="jdbc:mysql://127.0.0.1/universitas?user=root&password=";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(url);
			user=new User();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User getUserByUsername(String username) {
		String query = "SELECT * FROM user WHERE username='"+username+"'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				user.setId(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setStatus(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}