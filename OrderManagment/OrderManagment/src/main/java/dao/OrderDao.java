package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.CallableStatement;

import connection.ConnectionFactory;
import model.Client;
import model.Orders;
public class OrderDao {
	public void insertOrder(Orders order) throws SQLException {
		//opeartie pt inserare in bd
		Connection con=null;
		String query="INSERT INTO orders VALUES(?,?,?,?)";
		try {
			con=ConnectionFactory.getConnection();
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1,order.getIdOrder());
			statement.setInt(2, order.getIdClient());
			statement.setInt(3, order.getIdProduct());
			statement.setInt(4, order.getQuantity());
			statement.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		con.close();
		//inchidem conexiunea la bd
		
	}
	

}
