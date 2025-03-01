/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionale;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GestionaleMain implements Serializable {
    public static void main(String[] args) {
        int ris = 0;
        Gestionale g;
        String filename = "gestionale.dat";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            g = (Gestionale) in.readObject();
        } catch (Exception e) {
            g = new Gestionale();
        }
        g.stampaDipendenti();
        System.out.println();
        do{
            System.out.println("1) Inserisci dipendenti");
            System.out.println("2) Rimuovi dipendenti");
            System.out.println("3) Inserisci acquisti");
            System.out.println("4) Rimuovi acquisti");
            System.out.println("5) Inserisci vendite");
            System.out.println("6) Rimuovi vendite");
            System.out.println("7) Calcola stipendio mensile di ogni dipendente");
            System.out.println("8) Calcola RAL");
            System.out.println("9) Stampa report riassuntivo");
            System.out.println("10) Salva nel file");
            System.out.println("11) Esci dal programma");
            ris = Read.integerMinMax("", 1, 11);
            switch(ris){
                case 1:{//INSERISCI DIPENDENTI
                    System.out.println("1) Inserisci impiegato");
                    System.out.println("2) Inserisci manager");
                    System.out.println("3) Torna al menu principale");
                    int ris1 = Read.integerMinMax("", 1, 3);
                    switch(ris1){
                        case 1:{
                            String nome = Read.string("Inserisci nome dell'impiegato:");
                            String cognome = Read.string("Inserisci cognome dell'impiegato:");
                            int oreMensili = Read.integer("Inserisci le ore mensili dell'impiegato");
                            g.aggiungiDipendente(new Impiegato(nome, cognome, oreMensili));
                            break;
                        }   
                        case 2:{
                            String nome = Read.string("Inserisci nome dell'impiegato:");
                            String cognome = Read.string("Inserisci cognome dell'impiegato:");
                            int oreMensili = Read.integer("Inserisci le ore mensili dell'impiegato");
                            g.aggiungiDipendente(new Manager(nome, cognome, oreMensili));
                            break;
                        }
                    }
                    break;
                }
                case 2:{//RIMUOVI DIPENDENTI
                    g.stampaDipendenti();
                    System.out.println("Inserisci l'indice del dipendente da rimuovere");
                    int indice = Read.integerMinMax("", 1, g.getDipendentiSize())-1;
                    g.rimuoviDipendente(indice);
                    break;
                }
                case 3:{//INSERISCI ACQUISTI
                    double kg = Read.number("Inserisci il numero di kg dell'acquisto:");
                    double prezzo = Read.number("Inserisci il prezzo dell'acquisto:");
                    g.aggiungiAcquisto(kg, prezzo);
                    break;
                }
                case 4:{//RIMUOVI ACQUISTI
                    g.stampaAcquisti();
                    System.out.println("Inserisci l'indice dell'acquisto da rimuovere");
                    int indice = Read.integerMinMax("", 1, g.getAcquistiSize())-1;
                    g.rimuoviAcquisto(indice);
                    break;
                }
                case 5:{//INSERISCI VENDITE
                    int tipo = Read.integerMinMax("Inserisci il tipo di prodotto:\n1) 100 graffette\n2) 1000 graffette\n3) 5000 graffette", 1, 3);
                    int prezzo = Read.integer("Inserisci quanti pacchetti sono stati venduti:");
                switch (tipo) {
                    case 1:
                        g.aggiungiVendita(Vendita.TipoProdotto.Pacco100, prezzo);
                        break;
                    case 2:
                        g.aggiungiVendita(Vendita.TipoProdotto.Pacco1000, prezzo);
                        break;
                    case 3:
                        g.aggiungiVendita(Vendita.TipoProdotto.Pacco5000, prezzo);
                        break;
                }
                    break;
                }case 6:{//RIMUOVI VENDITE
                    g.stampaAcquisti();
                    System.out.println("Inserisci l'indice dell'acquisto da rimuovere");
                    int indice = Read.integerMinMax("", 1, g.getVenditeSize())-1;
                    g.rimuoviVendita(indice);
                    break;
                }case 7:{
                    g.calcolaStipendioMensile();
                    break;
                }
                case 8:{
                    g.calcolaRAL();
                    break;
                }case 9:{
                    g.stampaReport();
                    break;
                }case 10:{
                    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
                        out.writeObject(g);
                        System.out.println("Dati salvati correttamente");
                    }catch(Exception e){
                        System.out.println("Dati non salvati");
                    }
                }
            }
        }while(ris!=11);
    }
}
