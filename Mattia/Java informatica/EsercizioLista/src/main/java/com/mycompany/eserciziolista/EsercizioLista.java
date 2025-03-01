/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eserciziolista;

/**
 *
 * @author Mattia
 */
public class EsercizioLista {

    public static void main(String[] args) {
        ListaConcatenata<String> saluti = new ListaConcatenata<>();
        saluti.add(0,"Push 1");
        saluti.add(1,"Push 2");
        saluti.stampa();
        System.out.println(saluti.get(1));
        saluti.del(0);
        System.out.println();
        saluti.stampa();
        
        System.out.println(saluti.size());
    }
}
