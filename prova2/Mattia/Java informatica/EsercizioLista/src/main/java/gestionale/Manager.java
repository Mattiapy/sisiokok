
package gestionale;


import java.io.Serializable;

//package biblioteca.gestionalemain;
public class Manager extends Dipendente implements Serializable{
    
    private Gestionale g;
    public Manager(String nome, String cognome, int oreLavoro, Gestionale g){
        super(nome, cognome, oreLavoro);
        this.g = g;
    }
    
    @Override
    public double calcolaStipendio(){
        double pagaOrariaMensile = 25;
        return pagaOrariaMensile * this.getOreMensili() + ((g.calcolaUtile() / 100) * 0.5);
    }
}

