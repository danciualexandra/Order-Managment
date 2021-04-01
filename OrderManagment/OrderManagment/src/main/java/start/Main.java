package start;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import com.google.protobuf.Message;
import com.itextpdf.text.DocumentException;

import connection.ConnectionFactory;
import dao.ClientDao;
import dao.OrderDao;
import dao.ProductDao;
import model.Client;
import model.Orders;
import model.Product;

public class Main {
	public static void whichLine(int j)throws SQLException, IOException, DocumentException {
		String line=Files.readAllLines(Paths.get("filename.txt")).get(j);
		///folosesc separator daca nu este cuvant
		//stochez intr-un vector de string
		//verific cu ce am in fisier
		String[] words = line.split("\\W+");
		
		for(int i=0;i<words.length;i++) {
			if(words[i].equals("Delete")&&words[i+1].contentEquals("client")) {
				ClientDao client =new ClientDao();
				client.del(new Client(words[i+2],words[i+3]));
				break;
			}
			if(words[i].equals("Insert")&&words[i+1].contentEquals("client")) {
				ClientDao client =new ClientDao();
				 Random rand=new Random();
				int max=16;
				int min=10;
				int id = rand.nextInt((max - min) + 1) + min;
				client.insertClient(new Client(id,words[i+2],words[i+3],words[i+4]));
				
				break;
			}
			if(words[i].contentEquals("Delete")&&words[i+1].contentEquals("product")) {
				ProductDao product=new ProductDao();
				product.del(new Product(words[i+2]));
				break;
			}
			
				if(words[i].contentEquals("Insert") && words[i+1].contentEquals("product")) {
					ProductDao p=new ProductDao();
					if(words[i+2].contentEquals("lemon")) {
						p.updateProdus(words[i+3],words[i+2]);
						break;
				}else {
					if(words[i+2].contentEquals("apple")) {
						p.updateProdus(words[i+3],words[i+2]);///cantitate,nume
						break;
				
				}
					
				}		
			
			}
				if(words[i].contentEquals("Insert") && words[i+1].contentEquals("product")) {
					ProductDao p=new ProductDao();
					if(words[i+2].contentEquals("orange")) {
						p.updateProdus(words[i+3],words[i+2]);
						break;
					}}
				if(words[i].contentEquals("Insert") && words[i+1].contentEquals("product")) {
					ProductDao p=new ProductDao();
					if(words[i+2].contentEquals("peach")) {
						p.updateProdus(words[i+3],words[i+2]);
						break;
					}}
				
				if(words[i].contentEquals("Order")) {
					OrderDao order=new OrderDao();
					ProductDao p=new ProductDao();
					if(words[i+3].contentEquals("apple")) {
					p.scadeStoc(words[i+4], words[i+3]);
					Random rand=new Random();
					int max=30;
					int min=1;
					int id = rand.nextInt((max - min) + 1) + min;
					String number = words[i+4];
					int result = Integer.parseInt(number);	
					order.insertOrder(new Orders(id,id+1,1,result));
					Bill bill=new Bill();
					int pret=4;
					Bill.generateBill(words[i+1],words[i+2],words[i+3],words[i+4],pret,id);
					break;
						
					}
					
				}
		}
		for(int i=0;i<words.length;i++) {
			if(words[i].contentEquals("Order")) {
				OrderDao order=new OrderDao();
				ProductDao p=new ProductDao();
				if(words[i+3].contentEquals("peach")) {
					p.scadeStoc(words[i+4], words[i+3]);
					Random rand=new Random();
					int max=30;
					int min=1;
					int id = rand.nextInt((max - min) + 1) + min;
					String number = words[i+4];
					int result = Integer.parseInt(number);	
					order.insertOrder(new Orders(id,id+1,2,result));
					Bill bill=new Bill();
					int pret=4;
					Bill.generateBill(words[i+1],words[i+2],words[i+3],words[i+4],pret,id);
					break;
					
					
				}else if(words[i+3].contentEquals("orange")){
					p.scadeStoc(words[i+4], words[i+3]);
					Random rand=new Random();
					int max=30;
					int min=1;
					int id = rand.nextInt((max - min) + 1) + min;
					String number = words[i+4];
					int result = Integer.parseInt(number);	
					order.insertOrder(new Orders(id,id+1,3,result));
					Bill bill=new Bill();
					int pret=4;
					Bill.generateBill(words[i+1],words[i+2],words[i+3],words[i+4],pret,id);
					break;
					
				}
					
				
				
			}
		}
		for(int i=0;i<words.length;i++) {
			if(words[i].contentEquals("Insert") && words[i+1].contentEquals("product")) {
				ProductDao p=new ProductDao();
				if(!(words[i+2].contentEquals("lemon"))&&!(words[i+2].contentEquals("peach"))&&!(words[i+2].contentEquals("apple"))&&!(words[i+2].contentEquals("orange"))) {
					Random rand=new Random();
					int max=30;
					int min=8;
					int id = rand.nextInt((max - min) + 1) + min;
					int pret = Integer.parseInt(words[i+4]);
					int cant=Integer.parseInt(words[i+3]);
					p.insertProduct(new Product(id,words[i+2],pret,cant));
					break;
			}
		}
		}
		
	
		for(int i=0;i<words.length;i++) {
			if(words[i].contentEquals("Order")) {
				OrderDao order=new OrderDao();
				ProductDao p=new ProductDao();
				if(words[i+3].contentEquals("lemon")) {
					p.scadeStoc(words[i+4], words[i+3]);
					Random rand=new Random();
					int max=60;
					int min=6;
					int id = rand.nextInt((max - min) + 1) + min;
					String number = words[i+4];
					int result = Integer.parseInt(number);	
					order.insertOrder(new Orders(id,id+1,2,result));
					Bill bill=new Bill();
					int pret=4;
					Bill.generateBill(words[i+1],words[i+2],words[i+3],words[i+4],pret,id);
					break;
					
					
				}
			}
		}
		
	}

	public static void main(String[]args) throws SQLException, IOException, DocumentException  {
		
////vad cate linii am in fisier
		///executa linie cu linie
		///daca se mai adauga in fisierul filename cerinte de executat se adauga aici whichline(line-1)
		///am inceput numaratoarea de la 0
				
		whichLine(0);	
		whichLine(1);
		whichLine(2);
		whichLine(3);
		whichLine(4);
		whichLine(5);
		whichLine(6);
	///se mai adauga aici daca ai avem linii
		
			
			
			
		
	
	}
}

	
	
