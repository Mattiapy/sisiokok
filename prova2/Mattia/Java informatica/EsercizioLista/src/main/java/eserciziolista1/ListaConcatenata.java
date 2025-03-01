/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eserciziolista1;

public class ListaConcatenata <T> {
    private class Node{
        public T valore;
        public static int dimensione = 0;
        public Node next = null;
        public Node(T valore, Node next){
            this.valore = valore;
            this.next = next;
        }
    }
    
    private Node head = null;
    
    public void aggiungiTesta(T valore){
        this.head = new Node(valore, this.head);
    }
    
    public void aggiungiCoda(T valore){
        Node n = this.head;
        while(n.next != null){
            n = n.next;
        }
        n.next = new Node(valore, null);
        
    }
    
    public void aggiungiIndice(int indice, T valore){
        if(indice == 0) {
            this.head = new Node(valore, this.head);
            return;
        }
        Node n = this.head;
        for(int i = 0; i < indice -  1; i++){
            n = n.next;
        }
        n.next = new Node(valore, n.next);
    }
    
    // RIMOZIONE
    public T rimuoviCoda(){
        Node n = this.head;
        while(n.next.next != null){
            n= n.next;
        }
        T val = n.next.valore;
        n.next = null;
        return val;
    }
    
    public T rimuoviIndice(int indice){
        Node n = this.head;
        for(int i = 0; i < indice - 1; i++){
            n = n.next;
        }
        T val = n.next.valore;
        n.next = n.next.next;
        return val;
    }
    public void stampaLista(){
        Node n = this.head;
        while(n != null){
            System.out.println(n.valore);
            n = n.next;
            
        }
    }
}
