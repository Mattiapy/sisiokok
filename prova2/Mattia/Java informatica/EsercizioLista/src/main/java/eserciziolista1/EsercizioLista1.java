
package eserciziolista1;
public class EsercizioLista1 {
    public static void main(String[] args) {
        ListaConcatenata<String> l = new ListaConcatenata<>();
        l.aggiungiIndice(0, "1");
        l.aggiungiIndice(0, "2");
        l.aggiungiIndice(0, "3");
        l.aggiungiIndice(0, "5");
        
        l.aggiungiIndice(2, "4");
        l.stampaLista();
    }
    
}
