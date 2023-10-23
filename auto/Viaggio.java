import java.util.InputMismatchException;
import java.util.Scanner;

public class Viaggio{
public static void main(String[] args) {
   double capacita_max = Double.parseDouble(args[0]);
   double velocita_max = Double.parseDouble(args[1]);
   double consumo_medio = Double.parseDouble(args[2]);
   double km_totali = 0;

   Auto auto = null;

   try {
       auto = new Auto(capacita_max, velocita_max, consumo_medio);
   } catch (InputMismatchException e1) {
       System.out.println(e1.getMessage());
   }

   Scanner scanner = new Scanner(System.in);
   System.out.println("Inserisci una tratta (<L. riforniti> <km da fare> <velocita'>");

   while (scanner.hasNext()) {
       double lt = scanner.nextDouble();
       double km = scanner.nextDouble();
       double velocita = scanner.nextDouble();

       try {
           auto.rifornimento(lt);
           double tempo = auto.viaggio(km, velocita);
           km_totali += km;

           int ore = (int) tempo;
           int minuti = (int) ((tempo - ore) * 60);
           System.out.print("Tempo necessario: " + ore + " ore e " + minuti + " minuti");
           System.out.println("Ti rimangono " + Auto.get() + " L di carburante");
       } catch (InputMismatchException e2) {
           System.out.println(e2.getMessage());
           System.out.println("Ti rimangono " + Auto.get() + "L di carburante");
       } catch (CarburanteNonSufficienteException | CapacitaSerbatoioSuperataException e3) {
           System.out.println(e3.getMessage());
           System.out.println("Ti rimangono " + Auto.get() + "L di carburante");
       }

       System.out.println("Inserisci una tratta (<L. riforniti> <km da fare> <velocita'>)");
   }

   System.out.println("Hai percorso " + km_totali + " km totali");
}
}