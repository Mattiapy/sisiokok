
import java.io.Serializable;

//package biblioteca.gestionalemain;
public class Vendita implements Serializable{
    public static enum TipoProdotto{
        Pacco100,
        Pacco1000,
        Pacco5000
    }
    TipoProdotto tipo;
    int quantita;

    public Vendita(TipoProdotto tipo, int quantita){
        this.tipo = tipo;
        this.quantita = quantita;
    }

    public int getQuantitaVenduta(){
        return this.quantita;
    }
    
    public double calcolaCosto(){
        switch(this.tipo){
            case Pacco100: return 9.99 * quantita;
            case Pacco1000: return 95 * quantita;
            case Pacco5000: return 450 * quantita;
        }
        return 0;
    }
    
}
