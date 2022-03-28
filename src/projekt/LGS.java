package projekt;
import java.util.Scanner;
public class LGS {
	
	// Attribute des linearen Gleichungssystem (LGS)
	private Matrix A;
	private Matrix X;
	private Matrix B;
	private Scanner scanner1 = new Scanner(System.in);
	
	// Konstruktor des lineare Gleichungssysteme(LGS). Die Anzahl von Gleichungen und die Anzahl von Unbekannten muss
	// zwei oder drei gleich sein.
	
	public LGS() {
		System.out.println(" Geben Sie die Anzahl von Gleichungen");
		System.out.println(" Anzahl von Gleichungen =");
		 int AnzahlGleichungen = scanner1.nextInt();
		 System.out.println(" Geben Sie die Anzahl von Unbekannten");
		System.out.println(" Anzahl von Unbekannten =");
		int AnzahlUnbekannten = scanner1.nextInt();
		if(!((AnzahlGleichungen==2)||(AnzahlGleichungen==3))){
			System.out.println(" die Anzahl von Gleichungen muss gleich  2 oder 3 sein.");
		} else if(!((AnzahlUnbekannten==2)||(AnzahlUnbekannten==3))){
			System.out.println(" die Anzahl von Unbekannten muss gleich  2 oder 3 sein.");
		}else {
			A= new Matrix(AnzahlGleichungen,AnzahlUnbekannten);
			X=new Matrix(AnzahlUnbekannten,1);
			B=new Matrix(AnzahlGleichungen,1);
		}
		
		
	//	Getter-und Setter-Methoden der Attribute (A, B und X) des LGS 
	}
	public Matrix getA() {
		return this.A;
	}
	public void setA(Matrix A) {
		this.A=A;
	}
	public Matrix getB() {
		return this.B;
	}
	public void setB(Matrix B) {
		this.B=B;
	}
	public Matrix getX() {
		return this.X;
	}
	public void setX(Matrix X) {
		this.X=X;
	}
	
	
	// Hier wird definiert, wie die parameter des LGS( Elemente der Matrix A und B) eingetragen wird. 
	
	public void LGS_erfüllen() {
		System.out.println(" Bildung des LGS A.X= B ; Geben Sie die Elemente([zeile,Spalte]) von A und dann die von B:");
		System.out.println();
		this.getA().matrix_erfüllen();
		System.out.println();
		System.out.println("Die Matrix A ist:");
		this.getA().matrix_zeigen();
		System.out.println();
		this.getB().matrix_erfüllen();
		System.out.println();
		System.out.println("Die Matrix B ist:");
		this.getB().matrix_zeigen();
		System.out.println();
	}
	
	
	// Die nächste Methode erlaubt, das gebildete LGS zu sehen.
	
	public void LGS_zeigen() {
		System.out.println(" Das gebildete LGS ist: ");
		for (int i = 0; i < A.getElements().length; i++) {
			for (int j = 0; j < A.getElements()[0].length; j++) {
			System.out.print(A.getElement(i+1, j+1)+"x"+(j+1)+" +"+ " ");       
			}
			System.out.print("0"+ " = " + B.getElement(i+1, 1) );
			System.out.println();
		}
		
	}
	
	
	
	// Im nächsten wird das LGS mithilfe der Cramersche Regel oder Determinantenmethode gelöst.
	
	public void LGS_lösen() {
		System.out.println();
		System.out.println("Die Lösung dieses LGS ist:");
		if(this.A.getElements().length!=this.A.getElements()[0].length) {
			System.out.println("entweder existiert keine Lösung oder existiert unendlich viele Lösungen");
			
		}else {
			if(this.A.determinant()==0) {
				System.out.println(" die leere Menge.");
			}else {
				double detA = this.A.determinant();
				double detAi;
				Matrix M = new Matrix(this.A.getElements().length,1);
				for(int i=0;i<this.A.getElements().length;i++) {
					M.SetSpalte(1, this.A.getSpalte(i+1));
					this.A.SetSpalte(i+1, this.B);
					detAi= this.A.determinant();
					double xi = detAi/detA;
					this.X.setElement(i+1, 1, xi);
					this.A.SetSpalte(i+1, M);	
				}
				for(int i=0;i<this.X.getElements().length; i++) {
					System.out.println("x"+(i+1)+ " ="+ " "+this.X.getElement(i+1, 1));	
				}
			}
		}		
	}
}
