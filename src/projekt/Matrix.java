package projekt;
import java.util.Scanner;
import java.util.ArrayList;
public class Matrix {
	
	// Attribut der Matrix
	private double[][] elements;
    private Scanner scanner = new Scanner(System.in);
	
	// Konstruktur für Matrixen.Mit der Anzahl von Zeilen und der AnZahl von Spalten wird eine Tabelle von
    // Tabellen gebildet(eine Matrix). Mit dem Konstruktor wird auch gezwungen dass, die Anzahl von Zeilen und die Anzahl von 
    // Spalten 1; 2 oder 3 gleich ist.
    
	public Matrix(int anzahlZeile, int anzahlSpalte) {
		if(!((anzahlZeile==1)||(anzahlZeile==2)||(anzahlZeile==3))){
			System.out.println(" die Anzahl von Zeilen muss gleich 1 oder 2 oder 3");
		} else if(!((anzahlSpalte==1)||(anzahlSpalte==2)||(anzahlSpalte==3))){
			System.out.println(" die Anzahl von Spalten muss gleich 1 oder 2 oder 3");
		}else {
	    elements= new double[anzahlZeile][anzahlSpalte];
		}
	}
	
	
	
	// Getter- und Setter-Methoden für die Einträge(elements) der Matrix, für eine Spalte der Matrix und für die 
	// ganze Matrix.
	
	public double getElement(int zeile, int spalte){
		return elements[zeile-1][spalte-1];
	}
	
	public void setElement(int zeile, int spalte, double wert) {
		elements[zeile-1][spalte-1] = wert;
	}
	
	public double[][] getElements(){
		return elements;
	}
	
	public void setElements(double[][] v) {
		elements=v;
	}
	
	public Matrix getSpalte(int spalte) {
		Matrix M = new Matrix(this.getElements().length,1);
		for(int i=0;i<this.getElements().length;i++) {
			M.setElement(i+1,1,this.getElement(i+1, spalte));
		}
		return M ;
	}
	
	public void SetSpalte(int spalte, Matrix B){
		for(int i=0; i<this.getElements().length;i++) {
			this.setElement(i+1,spalte,B.getElement(i+1, 1));
		}
	}
	
	
	// Hier wird die Methode matrix_erfüllen() zum Eintragen der Elemente der Matrix definiert.
	
	public void matrix_erfüllen() {
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements[0].length; j++) {
				System.out.print(" [" + (i + 1) + "," + (j + 1) + "]=");
				double t = scanner.nextDouble();
				setElement(i+1,j+1,t);
			}
		}
		
	}
	
	// Die nächste Methode erlaubt die gebildete Matrix zu sehen.
	
	public void matrix_zeigen(){
		
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements[0].length; j++) {
			System.out.print(elements[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	
	// Die Methode determinant() rechnet das Determinant von 2x2-Matrixen und von 3x3-Matrixen. Für 3x3-Matrixen
	// wird die Regel von Sarrus angewandt.
	
	public double determinant() {
		if((this.getElements().length ==this.getElements()[0].length)&&(this.getElements().length==2)) {
			double l1=this.getElement(1, 1)*this.getElement(2, 2);
			double l2 =this.getElement(2, 1)*this.getElement(1, 2);
			double det2= l1-l2;
			return det2;
		}else {
			double l1=this.getElement(1, 1)*this.getElement(2, 2)*this.getElement(3, 3);
			double l2= this.getElement(1, 2)*this.getElement(2, 3)*this.getElement(3, 1);
			double l3=this.getElement(1, 3)*this.getElement(2, 1)*this.getElement(3, 2);
			double l4=this.getElement(3, 1)*this.getElement(2, 2)*this.getElement(1, 3);
			double l5=this.getElement(3, 2)*this.getElement(2, 3)*this.getElement(1, 1);
			double l6=this.getElement(3, 3)*this.getElement(2, 1)*this.getElement(1, 2);
			double det3= (l1+l2+l3)-(l4+l5+l6);
			return det3;	
		}	
	}
}
