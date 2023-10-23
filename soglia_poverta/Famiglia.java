
import java.util.InputMismatchException;


public class Famiglia {
    //OVERVIEW: modella una famiglia con un certo reddito complessivo e una dimensione (numero di persone) specifica. Fornisce metodi per determinare se la famiglia si trova al di sotto della soglia di povertà in base ai costi mensili di alloggio e cibo.
//attributi
 double reddito;
 int dimensione;
//costrutture
public Famiglia(double reddito, int dimensione) throws InputMismatchException{
    //MODIFIES: this
    //EFFECTS: inizialliza e restitisce un nuovo oggetto Famiglia con il redditto e la dimesione specificata. Lancia InputMismatchException se la dimensione è negativa
if (dimensione<0){
    throw new InputMismatchException("la dimensione del nucleo famigliare dev'essere positiva");
}
this.reddito=reddito;
this.dimensione=dimensione;
}
//metodi
public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException{
    //EFFECTS: restitusce true se la famiglia si trova sotto la soglia di povertà false altrimenti. Lancia InputMismatchException se costoCasa o costoCibo non sono positivi
   if (costoCasa<0 || costoCibo<0){
 throw new InputMismatchException("i costi di casa e cibo devono essere positiv");
   }
    double costoTotale =costoCasa+(costoCibo*dimensione);
       return costoTotale>(reddito/2);

}
public String toString(){
    //EFFECTS: restituisce una stringa contenente la descrizione della famiglia
    return this.dimensione+" persone con reddito complessivo di "+this.reddito;
}

}
