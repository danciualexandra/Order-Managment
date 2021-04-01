package start;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

public class Bill {
	public static  void generateBill(String firstName,String lastName,String productName,String quantity,int pret,int id) throws FileNotFoundException, DocumentException {
		String nr=quantity;
		int result = Integer.parseInt(nr);	
		String r=String.valueOf(id);
	
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("chitanta_"+firstName+r+".pdf"));
		 
		document.open();
		Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
		
		
		Paragraph paragraphOne = new Paragraph("Factura comanda", redFont);
		    document.add(paragraphOne);
		    ///
		  
		    
		    
		    Paragraph p = new Paragraph("Id-ul comenzii:"+r);
		    document.add(p);
		    
		    
		    Paragraph paragraphTwo = new Paragraph("Nume: "+lastName);
		    document.add(paragraphTwo);
		    Paragraph paragraphThree = new Paragraph("Prenume: "+firstName);
		    document.add(paragraphThree);
		    
		    Paragraph paragraph4 = new Paragraph("Produs: "+productName);
		    document.add(paragraph4);
		    
		    Paragraph paragraph5 = new Paragraph("Cantitate: "+ quantity);
		    document.add(paragraph5);
		    
		    int total=result*pret;///
		    String sum=String.valueOf(total);
		    Paragraph paragraph6 = new Paragraph("Total: "+sum);
		    document.add(paragraph6);
		    
		 
		    
		 
				document.close();

		
	
	}

}
