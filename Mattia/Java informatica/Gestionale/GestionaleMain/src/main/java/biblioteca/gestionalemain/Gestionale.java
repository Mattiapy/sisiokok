
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gestionale implements Serializable{
    private List <Dipendente> l = new ArrayList<>();
    private List <Acquisti> a = new ArrayList<>();
    private List <Vendita> v = new ArrayList<>();
    
    
    
    public void stampaReport(){
        System.out.println("IMPIEGATI: ");
        for(int i = 0; i < l.size(); i++){
            if(l.get(i) instanceof Impiegato){
                System.out.println((i+1)+") "+l.get(i));
            }
        }
        System.out.println("MANAGER: ");
        for(int i = 0; i < l.size(); i++){
            if(l.get(i) instanceof Manager){
                System.out.println((i+1)+") "+l.get(i));
            }
        }
        System.out.print("TOTALE ACQUISTI:");
        double totAcquisti = 0;
        for(Acquisti acq : a){
            totAcquisti += acq.calcolaCosto();
        }
        System.out.println(totAcquisti);

        System.out.print("TOTALE VENDITE:");
        double totVendite = 0;
        for(Vendita ven : v){
            totVendite += ven.calcolaCosto();
        }
        System.out.println(totVendite);
        System.out.println("L'utile dell'azienda e' "+this.calcolaUtile());
        System.out.print("Totale di kg acquistati: ");
        double totKg = 0;
        for(Acquisti acq : a){
            totKg += acq.getKg()    ;
        }
        System.out.println(totKg);
        
    }

    public void calcolaStipendioMensile(){
        for(int i = 0; i < l.size(); i++){
            System.out.println((i+1) + ") " + l.get(i) + " Stipendio mensile: " + l.get(i).calcolaStipendio());
        }
    }

    public void calcolaRAL(){
        for(int i = 0; i < l.size(); i++){
            System.out.println((i+1) + ") " + l.get(i) + " RAL: " + (l.get(i).calcolaStipendio() * 12));
        }
    }

    public double calcolaUtile(){
        double totAcquisti = 0;
        for(Acquisti acq : this.a){
            totAcquisti += acq.calcolaCosto();
        }
        double totVendite = 0;
        for(Vendita ven : this.v){
            totAcquisti += ven.calcolaCosto();
        }
        return totVendite - totAcquisti;
    }
    
    //DIPENDENTI
    
    public int getDipendentiSize(){
        return l.size();
    }
    
    public void aggiungiDipendente(Dipendente d){
        l.add(d);
    }
    
    public void stampaDipendenti(){
        for(int i = 0; i < l.size(); i++){
            System.out.println((i+1)+") "+l.get(i));
        }
    }
    
    public void rimuoviDipendente(int indice){
        l.remove(indice);
        if(l.size() == 0){
            System.out.println("Non ci sono più dipendenti\n");
        }else{
            System.out.println("Dopo la rimozione del dipendente:");
            this.stampaDipendenti();
            System.out.println();
        }
    }
    
    //ACQUISTI
    
    public int getAcquistiSize(){
        return a.size();
    }
    
    public void aggiungiAcquisto(double kg, double prezzo){
        a.add(new Acquisti(kg, prezzo));
    }
    
    public void stampaAcquisti(){
        for(int i = 0; i < a.size(); i++){
            System.out.println((i+1)+") "+a.get(i));
        }
    }
    
    public void rimuoviAcquisto(int indice){
        a.remove(indice);
        System.out.println("Dopo la rimozione del'acquisto:\n");
        this.stampaAcquisti();
    }
    
    //VENDITE
    
    public int getVenditeSize(){
        return v.size();
    }
    
    public void aggiungiVendita(Vendita.TipoProdotto prodotto, int quantita){
        v.add(new Vendita(prodotto, quantita));
    }
    
    public void stampaVendite(){
        for(int i = 0; i < v.size(); i++){
            System.out.println((i+1)+") "+v.get(i));
        }
    }
    
    public void rimuoviVendita(int indice){
        v.remove(indice);
        System.out.println("Dopo la rimozione della vendita:\n");
        this.stampaVendite();
    }
}