import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class KMT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMT kt = new KMT();
		kt.readText();
	}
	
	public void readText(){
	
		try {
			FileReader fr=new FileReader("c:\\input.txt");
			LineNumberReader ln= new LineNumberReader(fr);
			BufferedReader sc=new BufferedReader(fr);
			
			//BufferedReader b=new BufferedReader(new LineNumberReader(new FileReader("c:\\input.txt")));
			 
			int rows=ln.getLineNumber();
			ln.readLine();
			
			int column=0;
			int [][] w = new int [rows][column];
			while(ln.readLine()!=""){
				System.out.println(sc.readLine());
				String[] col = sc.readLine().split(" ");
				column=col.length;
				rows ++;
 	     	 }
			
			
			}
			catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}