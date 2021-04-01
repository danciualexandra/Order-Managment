package model;

public class Orders {
	private int idOrder;
	private int idClient;
	private int idProduct;
	private int quantity;
		public Orders() {
			
		}
		public Orders(int idO,int idC,int idP,int q) {
		idOrder=idO;
		idClient=idC;
		idProduct=idP;
		quantity=q;
			
		}
		///getter setter si to string 
		//pt orders
		@Override
		public String toString() {
			return "Orders [idOrder=" + idOrder + ", idClient=" + idClient + ", idProduct=" + idProduct + ", quantity="
					+ quantity + "]";
		}
		public int getIdOrder() {
			return idOrder;
		}
		public void setIdOrder(int idOrder) {
			this.idOrder = idOrder;
		}
		public int getIdClient() {
			return idClient;
		}
		public void setIdClient(int idClient) {
			this.idClient = idClient;
		}
		public int getIdProduct() {
			return idProduct;
		}
		public void setIdProduct(int idProduct) {
			this.idProduct = idProduct;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		
		

}
