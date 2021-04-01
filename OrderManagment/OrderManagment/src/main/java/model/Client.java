package model;

public class Client {
	private int idClient;
	private String firstName;
	private String lastName;
	private String address;
	
	public Client(int id,String firstName,String lastName,String address)
	{
		super();
		this.idClient=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		
	}
	public Client() {
		
	}
	public Client(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + "]";
	}
	

	///am testat operatiile de baza,direct aici pt a fi mai rapid 
	//pas cu pas cum adaugam cate o functie noua
	
	/*public static void main(String[]args)
	{
		Client client=new Client();
		client.address= "Voinicenilor";
		client.firstName="Ale";
		client.lastName="Danciu";
		client.id=1;
		System.out.println(client.toString());
	}
	
	*/

}
