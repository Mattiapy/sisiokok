package eserciziolista2;
public class ListaConcatenata <T> {
    private class Node{
        public Node next;
        public T value;
        public Node(T value, Node next){
            this.next = next;
            this.value = value;
        }
    }
    Node head = null;
   
    public void aggiungiTesta(T valore){
        this.head = new Node(valore, this.head);
    }
   
    public T rimuoviTesta(){ // ritornare il valore dell'elemento rimosso
        if(this.head == null) throw new NullPointerException();
        T val = this.head.value;
        this.head = this.head.next;
        return val;
    }
    
    public void aggiungiCoda(T val){
        if(this.head == null) {
            aggiungiTesta(val);
            return;
        }
        
        Node n = this.head;
        while(n.next != null){
            n = n.next;
        }
        
        n.next = new Node(val, null);
    }
    
    public T togliCoda(){
        if(this.head == null)
            throw new NullPointerException();
        
        if(this.head != null && this.head.next == null){
            return rimuoviTesta();
        }
        
        Node n = this.head;
        while(n.next.next != null){
            n = n.next;
        }
        
        T val = n.next.value;
        n.next = null;
        return val;
    }
   
    public void aggiungiIndice(T val, int indice){
        if(this.head == null || indice == 0) {
            aggiungiTesta(val);
        }
        
        if(indice < 0)
            throw new ArrayIndexOutOfBoundsException();
        
        Node n = this.head;
        for(int i = 0; i < indice - 1; i++){
            n = n.next;
        }
        
        n.next = new Node(val, n.next);
    }
   
    public T rimuoviIndice(int indice){
        if(this.head == null || indice == 0) {
            throw new NullPointerException();
        }
        
        if(indice < 0)
            throw new ArrayIndexOutOfBoundsException();
        
        Node n = this.head;
        for(int i = 0; i < indice - 1; i++){
            n = n.next;
        }
        
        T v = n.next.value;
        n.next = n.next.next;
        return v;
    }
    
    public void stampaLista(){
        Node n = this.head;
        while(n!=null){
            System.out.println(n.value);
            n = n.next;
        }
    }
}