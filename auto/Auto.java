import java.util.InputMismatchException;
import java.util.Scanner;

public class Auto{
//attributi
 double consumo_medio;
 double velocita_max;
 double capacita_max;
 static double carburante;

//costruttore
 public Auto(double capacita_max, double velocita_max, double consumo_medio) throws InputMismatchException{
//MODIFIES: this
//EFFECTS: inizializza e restituisce una'auto con i valori apacita_max,  velocita_max,  consumo_medio, pone carburante=0{
//         lancia InputMismatchException nel caso i valori inseriti siano <=0
 if(capacita_max<=0 || velocita_max<=0 || consumo_medio<=0){
    throw new InputMismatchException("i valori inseriti devono essere positivi");
 }
 this.capacita_max=capacita_max;
 this.consumo_medio=consumo_medio;
 this.velocita_max=velocita_max;
 this.carburante=0;

}

 //metodi
 public void modifica_velocita(double velocta_nuova) throws InputMismatchException{
//MODIFIES: this
//EFFECTS: pone velocita_max = velocita_nuova
           //lancia InputMismatchException se velocita_nuova>velocita_max o velocita_nuova<=0
    if (velocta_nuova>velocita_max ){
        throw new InputMismatchException("L'auto non va così veloce. velocità limitata a "+velocita_max +" km/h");
    }
    if (velocta_nuova<=0){
         throw new InputMismatchException("Non puoi andare a velocità negativa o nulla");
    }
    velocita_max=velocta_nuova;
 }

 public double viaggio(double distanza, double velocita) throws InputMismatchException, CarburanteNonSufficienteException{
//MODIFIES: this
//EFFECTS: restituisce il tempo impiegato a percorrere la distanza passata aggirnanando la quantità di carburante disponibile
//         lancia InputMismatchException se distanza<0 o velocità<0
 if( velocita<=0){
    throw new InputMismatchException("Non puoi andare a velocita' negativa o nulla");
 }
 if(distanza<0){
     throw new InputMismatchException("Non puoi percorrere una distanza negativa");

 }
 if (velocita>velocita_max){
     throw new InputMismatchException("L'auto non va cosi' veloce. velocita' limitata a "+ velocita_max +" km/h");
 }
 double tempo= distanza/velocita;
 double consumo_carburante= distanza/consumo_medio;
 if (carburante-consumo_carburante<0){
    throw new CarburanteNonSufficienteException("Non hai carburante sufficiente");
 }
carburante-=consumo_carburante;
return tempo;


}
 public void rifornimento(double lt) throws InputMismatchException, CapacitaSerbatoioSuperataException{
//MODIFIES: this
//EFFECTS: aggiorna carburante con i litri passati
//         lancia CapacitaSerbatoioSuperataException se lt+carburante>capacita_max e  InputMismatchException se lt<0 
 if(lt<0){
    throw new InputMismatchException("I litri di carburante  inseriti devono essere positivi");
 }
double pieno= lt + carburante;
if (pieno>capacita_max){
    throw new CapacitaSerbatoioSuperataException("Impossibili rifornire, capacita' massima del rebatoio superata");
}
 carburante=pieno;
}
public static double get(){
return carburante;
}


}