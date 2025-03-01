/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eserciziolista;


/**
 *
 * @author Mattia
 */
public class ListaConcatenata<T> implements Lista<T> {
    
    private class Nodo{
        T valore = null;
        Nodo next = null;

        public Nodo(T valore, Nodo next) {
            this.valore = valore;
            this.next = next;
        }
    }
    private Nodo head = null;
    
    @Override
    public void push(T v) { // aggiunge un valore in testa
        this.head = new Nodo(v, this.head);
    }

    @Override
    public T pop() { // toglie l'elemento in testa e lo restituisce
        T valore = this.head.valore;
        this.head = this.head.next;
        return valore;
    }

    @Override
    public void pushBack(T v) { // aggiunge un valore in coda
        if(this.head == null){
            push(v);
            return;
        }
        Nodo n = this.head;
        while(n.next != null){
            n = n.next;
        }
        n.next = new Nodo(v, null);
    }

    @Override
    public T popBack() { // toglie l'elemento in coda e lo restituisce
        Nodo n = this.head;
        while(n.next.next != null){
            n = n.next;
        }
        T v = n.next.valore;
        n.next = null;
        return v;
    }
    
    public void stampa(){
        Nodo n = this.head;
        while(n != null){
            System.out.println(n.valore);
            n = n.next;
        }
    }
    
    @Override
    public void add(int i, T v) {
        if(i == 0){
            push(v);
            return;
        }
        if(this.head == null && i != 0) 
            throw new IndexOutOfBoundsException();
        Nodo n = this.head;
        for(int x = 0; x < i - 1; x++){
            n = n.next;
            if(n == null)
                return;
        }
        //n contiene l'elemento prima di quello da aggiungere 
        Nodo nodo = new Nodo(v, n.next);
        n.next = nodo;
        
        
    }

    @Override
    public T del(int i) {
        if(i == 0 && this.head != null){
            return pop();
        }
        Nodo n = this.head;
        for(int x = 0; x < i - 1; x++){
            n = n.next;
            if(n == null){
                throw new NullPointerException();
            }
        }
        T val = n.next.valore;
        n.next = n.next.next;
        return val;
    }

    @Override
    public T get(int i) {
        Nodo n = this.head;
        for(int x = 0; i != x; x++){
            n = n.next;
        }
        return n.valore;
    }

    @Override
    public int size() {
        int c = 0;
        Nodo n = this.head;
        while(n != null){
            n = n.next;
            c++;
        }
        return c;
    }
    
}
