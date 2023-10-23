import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class reddito {

    public static void main(String[] args){
    double costoCibo= Double.parseDouble(args[0]);
    double costoCasa= Double.parseDouble(args[1]);
    try{
        if(costoCibo<0 || costoCasa<0){
            throw new InputMismatchException("inserire valori positivi");
        }
        }catch(InputMismatchException e0){
            System.out.println(e0.getMessage());
            return;
        }
    Scanner scanner= new Scanner(System.in);
    String descr="";
    int n_famiglie=0;
    System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");
      
    while(scanner.hasNext()){
        double reddito= scanner.nextDouble();
        int dimensione= scanner.nextInt();
        System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");
      
        
        try {
             Famiglia famiglia= new Famiglia(reddito, dimensione);
             if(famiglia.sottoSogliaPoverta(costoCasa, costoCibo)){
                descr+=famiglia+"\n";
                   n_famiglie++;             

            }
            
             
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        
    }
  }
String[] famString= descr.split("\n");
  System.out.println(n_famiglie+" famiglie sotto la soglia di poverta':");
  for (int i=1; i<=n_famiglie; i++)
System.out.println("Famiglia "+i+" "+famString[i-1]);
  
}
}
