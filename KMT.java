import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	
public class KMT {

	public static int row;
	public static int col;
	
	public static int getRow() {
		return row;
	}



	public  void setRow(int row) {
		this.row = row;
	}



	public static int getCol() {
		return col;
	}



	public void setCol(int col) {
		this.col = col;
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\input.txt");
		KMT kt = new KMT();
		int i=getRow();
		int j=getCol();
		int[][] w=new int [i][j];
		 w=	kt.ReadMatrixFromFile(file);
		 int [] max= new int []{0} ;
		 
		
		//getting the max for the matrix
		for(i=0;i<getRow();i++){
			for(j=0;j<getCol();j++){
				if(max[0]<w[i][j]){
					max[0]=w[i][j];
				}
				
			}
			
		}
		//subtracting  matrix value from max
		for(i=0;i<getRow();i++){
		for(j=0;j<getCol();j++){
			if(max[0]>=w[i][j]){
				w[i][j]=max[0]-w[i][j];
				//System.out.println(w[i][j]);
			}
			
		}
		
	}
		int [] minCol = minOfCol(w);
		
		int [][] reducedColumn=ColReduction(w,minCol);
		
		
		//To DO
		//if condition to check
		//Check for atlease 1 zero in all the rows to bypass the row reduction
		
		
		int []minRow=minOfRow(reducedColumn);
		
		
		int [][] reducedRow=RowReduction(reducedColumn,minRow);
		
		assignment(reducedRow);
	//	System.out.println(reducedRow);
	 
		
	}
	
	public static void assignment(int [][] w){
		int [] opt;
		int j;
		for(int i=0;i<getRow();i++){
			List<Integer> numOfZero= new ArrayList<Integer>();
			for(j=0;j<getCol();j++){
			if(w[i][j]==0)	
			{
			numOfZero.add(w[i][j]);
			}
			
		}
			if(numOfZero.size()==1)
			{
				System.out.println("Value of i: "+i);
				
				System.out.println("Value of i: "+j);
			}
			
		}
			
		
		
		
		
	}
	public static int [] minOfCol(int [][] w){
		
		
		int [] minCol= new int [getCol()];
		for (int i=0;i<w.length; i++)
		{
			int minimumValue= Integer.MAX_VALUE;
			for(int j=0; j<w[i].length; j++){
				if (w[j][i]< minimumValue)
				{
					minimumValue=w[i][j];
				}
			}
			minCol[i]=minimumValue;
		}
		
		return minCol;
	}
	
public static int [] minOfRow(int [][] w){
		
		
		int [] minRow= new int [getRow()];
		for (int j=0;j<getCol(); j++)
		{
			int minimumValue= Integer.MAX_VALUE;
			for(int i=0; i<getRow(); i++){
			//	System.out.println(w[i][j]);
				if (w[i][j]< minimumValue)
				{
					minimumValue=w[i][j];
				}
				
			}
			minRow[j]=minimumValue;
			
		}
		
		return minRow;
	}
	
	public static int [][] ColReduction(int [][]w, int []m){
		for (int i=0;i<w.length; i++)
		{
			
			for(int j=0; j<w[i].length; j++){
				w[i][j]= w[i][j]-m[i];
			}
		}
		
		return w;
	}
	
	
	public static int [][] RowReduction(int [][]w, int []m){
		for (int j=0;j<getCol(); j++)
		{
			
			for(int i=0; i<getRow(); i++){
				w[i][j]= w[i][j]-m[j];
				System.out.println(w[i][j]);
			}
		}
		
		return w;
	}
	
	
	 public  int[][] ReadMatrixFromFile (File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		int size=0;
		int [][] w= null;
		String line = null;
		row=0;
		while ((line = br.readLine()) != null) {
			
		//System.out.println(line);
		String[] column = line.split(" ");
		if(w== null){
		size=column.length;
		w=new int [size][size];
		}
			for (col=0; col<size; col++)
			{
				
				 w[row][col]=Integer.parseInt(column[col]);
				 
			}
			row++;
			
		
			
		}
		
		return w;
	 
		
	}
}