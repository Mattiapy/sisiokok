
import java.io.Serializable;

//package biblioteca.gestionalemain;
public class Manager extends Dipendente implements Serializable{
    
    public Manager(String nome, String cognome, int oreLavoro){
        super(nome, cognome, oreLavoro);
    }
    private final Gestionale g = new Gestionale();
    @Override
    public double calcolaStipendio(){
        double pagaOrariaMensile = 25;
        return pagaOrariaMensile * this.getOreMensili() + ((g.calcolaUtile() / 100) * 0.5);
    }
}
