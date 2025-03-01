/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionale;

import java.io.Serializable;

//package biblioteca.gestionalemain;
public class Impiegato extends Dipendente implements Serializable{
    
    public Impiegato(String nome, String cognome, int oreLavoro){
        super(nome, cognome, oreLavoro);
    }
    
    @Override
    public double calcolaStipendio(){
        double pagaOraria = 8.5;
        return pagaOraria * this.getOreMensili();
    }
}


