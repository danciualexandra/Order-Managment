package model;

public class Product {
	private int idProduct;
	private String nameProduct;
	private double priceProduct;
	private int stock;
	 public Product(){

	   
	    	
	    }
	 public Product(int id,String name,double price,int s) {
		 idProduct=id;
		 nameProduct=name;
		 priceProduct=price;
		 stock=s;
	 }
	 public Product(int stock) {
		 this.stock=stock;
	 }
	 public Product(String nameProduct) {
		 this.nameProduct=nameProduct;
	 }
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public double getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(double priceProduct) {
		this.priceProduct = priceProduct;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", priceProduct=" + priceProduct
				+ ", stock=" + stock + "]";
	}
	
///getter si setter
	//to string
	 

	

}
