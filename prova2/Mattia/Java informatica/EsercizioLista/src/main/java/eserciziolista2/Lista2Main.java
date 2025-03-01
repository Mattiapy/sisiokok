
package eserciziolista2;
public class Lista2Main {
    public static void main(String[] args) {
        ListaConcatenata <String> l  = new ListaConcatenata<>();           
        l.aggiungiCoda("21");
        l.togliCoda();
        l.stampaLista();   
    }   
}