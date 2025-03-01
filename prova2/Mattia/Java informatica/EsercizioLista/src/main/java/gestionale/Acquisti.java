
package gestionale;

import java.io.Serializable;

public class Acquisti implements Serializable{
    private double prezzo;
    private double kg;
    
    public Acquisti(double kg, double prezzo){
        this.kg = kg;
        this.prezzo = prezzo;
    }
    
    public double getPrezzo(){
        return this.prezzo;
    }
    public double getKg(){
        return this.kg;
    }
    
    public double calcolaCosto(){
        return this.kg * prezzo;
    }
    @Override
    public String toString(){
        return "Chilogrammi " + this.kg + " Prezzo: " + this.prezzo;
    }
    
}
