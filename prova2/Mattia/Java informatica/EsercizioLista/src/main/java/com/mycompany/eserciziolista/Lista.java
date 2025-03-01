package com.mycompany.eserciziolista;

public interface Lista<T> {
    public abstract void add(int i, T v);

    // elimina l'elemento alla posizione i e lo restituisce
    public abstract T del(int i);

    // restituisce l'elemento alla posizione i
    public abstract T get(int i);

    // restituisce la lunghezza della lista
    public abstract int size();
    
    void push(T v); // aggiunge un valore in testa
    T pop(); // toglie l'elemento in testa e lo restituisce
    void pushBack(T v); // aggiunge un valore in coda
    T popBack(); // toglie l'elemento in coda e lo restituisce
}
