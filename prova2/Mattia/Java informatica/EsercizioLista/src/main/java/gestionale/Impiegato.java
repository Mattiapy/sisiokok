
package gestionale;

import java.io.Serializable;

//package biblioteca.gestionalemain;
public class Impiegato extends Dipendente implements Serializable{
    
    public Impiegato(String nome, String cognome, int oreLavoro){
        super(nome, cognome, oreLavoro);
    }
    
    @Override
    public double calcolaStipendio(){
        double pagaOraria = 8.5;
        return pagaOraria * this.getOreMensili();
    }
}


