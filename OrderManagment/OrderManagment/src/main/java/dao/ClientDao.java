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
public class ClientDao {

		
	protected static final Logger LOGGER = Logger.getLogger(ClientDao.class.getName());
	public  void afisareClienti() throws SQLException 
	{
		Client client = null;
		Connection con = ConnectionFactory.getConnection();
		String query="SELECT * FROM Client";
		PreparedStatement afisare = null;
		ResultSet rez = null;
		int idClient=0;
		String firstName="";
	
		String address="";
		String lastName="";
		try {
			afisare = con.prepareStatement(query);
			rez = afisare.executeQuery();
			while(	rez.next() ) 
			{
				idClient=rez.getInt("idClient");
			  
			    firstName=rez.getString("firstName");
			    lastName= rez.getString("lastName");
				
				address = rez.getString("address");				
		        client = new Client(idClient, firstName, lastName, address);
				System.out.println("Afisare client : ");
				System.out.println(client.toString());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	public void insertClient(Client client)throws SQLException
	{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement statement=null;
		try {
		
		     statement=con.prepareStatement("INSERT INTO Client VALUES(?,?,?,?)");
			statement.setInt(1, client.getIdClient());
			statement.setString(2, client.getFirstName());
			statement.setString(3, client.getLastName());
			statement.setString(4, client.getAddress());
			statement.executeUpdate();
			
			
		}catch(SQLException exception) {
			System.out.println(exception.getMessage());
		}
		con.close();
		statement.close();
	
	}
	
	///operatie de stergere client din db in functie de prenume si nume
	public void del(Client client)throws SQLException{
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement statement=null;
		try {
			statement=con.prepareStatement("DELETE FROM Client WHERE firstName=? AND lastName=?");
			statement.setString(1, client.getFirstName());
			statement.setString(2, client.getLastName());
			statement.executeUpdate();
			System.out.println("Clientul cu prenumele "+client.getFirstName()+"si numele "+client.getLastName()+" este sters");
		}catch(SQLException exp) {

			System.out.println(exp.getMessage());
					}
		con.close();
		statement.close();
		
	}
	public Client cautareClient(int idc) throws SQLException
	{
		Client client = null;
		Connection con = ConnectionFactory.getConnection();
		String query="SELECT * FROM Client WHERE idClient="+idc;
		PreparedStatement afisare = null;
		ResultSet rez = null;
		
		
	
		try {
			afisare = con.prepareStatement(query);
		rez=afisare.executeQuery();
			while(	rez.next() ) 
			{
				int idClient=rez.getInt("idClient");
			 String firstName = rez.getString("firstName");
			String  lastName=rez.getString("lastName");
			 String address = rez.getString("address");				
				client = new Client(idClient, firstName, lastName, address);	
				//System.out.println("Clientul a fost gasit");
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			
		return client;
		
	}
	
	/*public static void main(String[]args) throws SQLException
	{
		ClientDao c=new ClientDao();
		//c.insertClient(new Client(2,"Andreea","Pop","Cluj"));
		
		
		//d.deleteClient(new Client(2,"Andreea","Pop","Cluj"));
		ClientDao f=new ClientDao();
		//f.afisareClienti();
	ClientDao d=new ClientDao();
	d.cautareClient(1);
	
	
	
		
		
	}*/
	
}


