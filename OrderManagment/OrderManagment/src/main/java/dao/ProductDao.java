package dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;
import model.Product;


import connection.ConnectionFactory;
import model.Client;
public class ProductDao {
	public void insertProduct(Product product)throws SQLException {
		Connection con=null;
		try {
		 con=ConnectionFactory.getConnection();
			PreparedStatement statement=con.prepareStatement("INSERT INTO Product VALUES(?,?,?,?)");
			statement.setInt(1,product.getIdProduct());
			statement.setString(2, product.getNameProduct());
			statement.setDouble(3,product.getPriceProduct() );
			statement.setInt(4, product.getStock());
			statement.executeUpdate();
			
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		con.close();
		
		
		
	}
	public void deleteProduct(Product product)throws SQLException{
		
		try
		{
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement statement=con.prepareStatement("DELETE FROM Product WHERE idProduct="+product.getIdProduct());
			statement.executeUpdate();
			System.out.println("Produsul cu id-ul= "+product.getIdProduct()+" s-a sters");
			
		}catch(SQLException exp) {
			System.out.println(exp.getMessage());
		}
		
	}
	public void del(Product product)throws SQLException{
		Connection con=null;
		try {
		 con=ConnectionFactory.getConnection();
			PreparedStatement statement=con.prepareStatement("DELETE FROM Product WHERE nameProduct=?");
			statement.setString(1, product.getNameProduct());
			statement.executeUpdate();
			System.out.println("Produsul cu numele="+product.getNameProduct()+" s-a sters");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void scadeStoc(String s,String nameProduct)throws SQLException {

		Connection con=null;
		PreparedStatement statement = null;
		String number = s;
		int result = Integer.parseInt(number);	
		
		String queryStoc = "UPDATE Product SET stock=stock-? WHERE nameProduct=?";
		
			try{ con=ConnectionFactory.getConnection();
			 statement=con.prepareStatement( queryStoc);
			 statement.setInt(1,result);
			 statement.setString(2,nameProduct);
			 
			 statement.executeUpdate();
				
					
					
				
				
			}
			catch(SQLException e){
				System.out.println(e.getMessage());	}
		}

	
	
	public ArrayList<Product> getAllProducts()throws SQLException{
		Connection dbCon=null;
		int idProduct;
		String nameProduct="";
		double priceProduct;
		int stock;
		ArrayList<Product> all=new ArrayList<Product>();
		try {
			dbCon=ConnectionFactory.getConnection();
			PreparedStatement statement=dbCon.prepareStatement("SELECT * FROM Product");
			ResultSet result =statement.executeQuery();
			while(result.next()) {
				idProduct=result.getInt("idProduct");
				nameProduct=result.getString("nameProduct");
				priceProduct=result.getDouble("priceProduct");
				stock=result.getInt("stock");
				Product product = new Product(idProduct, nameProduct, priceProduct,stock);
		    	all.add(product);
		    	
					
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return all;
		
	}
	public int verificareProdus(String productName) throws SQLException
	{
		int ok=0;
		for(Product prod : this.getAllProducts())		
			if(prod.getNameProduct()==productName)		
				ok=1;			
		return ok;
	}
	public void updateProdus(String s,String nameProduct) throws SQLException
	{
		Connection con=null;
		PreparedStatement statement = null;
		String number = s;
		int result = Integer.parseInt(number);	
		
		String queryStoc = "UPDATE Product SET stock=stock+? WHERE nameProduct=?";
		
			try{ con=ConnectionFactory.getConnection();
			 statement=con.prepareStatement( queryStoc);
			 statement.setInt(1,result);
			 statement.setString(2,nameProduct);
			 
			 statement.executeUpdate();
				
					
					
				
				
			}
			catch(SQLException e){
				System.out.println(e.getMessage());	}
		}
		
	}


	
	/*public static void main(String[]args)  {
		ProductDao p=new ProductDao();
		try {
			//p.insertProduct(new Product(2,"banane",5,20));
			p.deleteProduct(new Product(2,"banane",5,20));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


