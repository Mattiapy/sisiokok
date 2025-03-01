
package gestionale;


import java.io.Serializable;

//package biblioteca.gestionalemain;
public abstract class Dipendente implements Serializable{
    
    private String nome, cognome;
    private int oreMensili;
    
    public Dipendente(String nome, String cognome, int oreLavoro){
        this.nome = nome;
        this.cognome = cognome;
        this.oreMensili = oreLavoro;
    }
    public int getOreMensili(){
        return this.oreMensili;
    }
    public abstract double calcolaStipendio();
    @Override
    public String toString(){
        return "%s %s".formatted(nome, cognome);
    }
}

