/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionale;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class Read {


    private static BufferedReader in = new BufferedReader(
        new InputStreamReader(System.in)
    );

    /*
     * 0) stampa in output il messaggio
     * 1) leggi una stringa dall'input
     * 2) restituisci la stringa appena letta
     */
    public static String string(String message) {
        String input="";
        System.out.print(message);
        try{ input = in.readLine(); }
        catch(IOException e){System.exit(1);}
        return input;
    }

    /*
     * 0) stampa in output il messaggio
     * 1) leggi una stringa dall'input
     * 2) prova a convertire la stringa in un intero (parsing)
     * 3) se la conversione avviene con successo, restituisci il numero intero
     * 4) in caso contrario, stampa un messaggio di errore e ritorna al punto 0
     */
    public static int integer(String message) {
        boolean controllo=true;
        int n=0;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            try { n=Integer.parseInt(input); }
            catch (Exception e) { System.out.println("ERRORE DI CONVERSIONE AD INTERO"); controllo=true; }
        }
        return n;
    }

    /* Leggi in input un numero intero che deve essere >= min */
    public static int integerMin(String message, int min) {
        boolean controllo=true;
        int n=0;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            try { n=Integer.parseInt(input); if (n<min){controllo=true;}}
            catch (Exception e) { System.out.println("ERRORE DI CONVERSIONE AD INTERO"); controllo=true; }
        }
        return n;
    }

    /* Leggi in input un numero intero che deve essere <= max */
    public static int integerMax(String message, int max) {
        boolean controllo=true;
        int n=0;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            try { n=Integer.parseInt(input); if (n>max){controllo=true;}}
            catch (Exception e) { System.out.println("ERRORE DI CONVERSIONE AD INTERO"); controllo=true; }
        }
        return n;
    }

    /* Leggi in input un numero intero che deve essere compreso tra max e min (estremi inclusi) */
    public static int integerMinMax(String message, int min, int max) {
        boolean controllo=true;
        int n=0;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            try { n=Integer.parseInt(input); if (n>max || n<min){controllo=true;}}
            catch (Exception e) { System.out.println("ERRORE DI CONVERSIONE AD INTERO"); controllo=true; }
        }
        return n;
    }

    /*
     * 0) stampa in output il messaggio
     * 1) leggi una stringa dall'input
     * 2) se la stringa letta e' uguale al contenuto della variabile yes, restituisci true
     * 3) se la stringa letta e' uguale al contenuto della variabile no, restituisci false
     * 4) in caso contrario, stampa un messaggio di errore e torna al punto 0
     */
    public static boolean yesOrNo(String message, String yes, String no) {
        boolean controllo=true,risultato=false;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            if (input.equals(yes)){risultato = true;}
            else if (input.equals(no)){risultato = false;}
            else {controllo=true;}
        }
        return risultato;
    }

    /*
     * Permette all'utente di selezionare una delle opzioni (passate come ArrayList)
     * e restituisce l'indice corrispondente all'opzione selezionata
     */
    public static int select(String message, ArrayList<String> options) {
        /*System.out.println(options.toString());
        String input = Read.string(message);
        int i=0;
        boolean controllo=false;
        for (String s : options){
            if (input.equals(s)){controllo=true;break;}
            i++;
        }
        if (controllo==false){return -1;}
        else {return i;}
        */
        for (int i=0;i<options.size();i++){
            System.out.println("["+i+"] " + options.get(i));
        }
        return Read.integerMinMax(message, 0, options.size()-1);
    }

    /*
     * QUA FINISCONO GLI ESERCIZI INTERESSANTI:
     * il resto dei metodi sono utili ma la loro implementazione
     * e' molto simile ad altri gia' implementati e quindi non richiesta
    */


    /* Leggi in input una stringa di lunghezza >= minLength */
    public static String stringMin(String message, int minLength) {
        boolean controllo=true;
        String input="";
        while (controllo){
            controllo = false;
            input = Read.string(message);
            if (input.length() < minLength){controllo=true;}
        }
        return input;
    }

    /* Leggi in input una stringa di lunghezza <= maxLength */
    public static String stringMax(String message, int maxLength) {
        boolean controllo=true;
        String input="";
        while (controllo){
            controllo = false;
            input = Read.string(message);
            if (input.length() > maxLength){controllo=true;} 
        }
        return input;
    }

    /* Leggi in input una stringa di lunghezza compresa tra minLenght e  maxLength (estremi inclusi) */
    public static String stringMinMax(String message, int minLength, int maxLength) {
        boolean controllo=true;
        String input="";
        while (controllo){
            controllo = false;
            input = Read.string(message);
            if (input.length() > maxLength || input.length() < minLength){controllo=true;} 
        }
        return input;
    }

    /* Leggi in input un numero con la virgola */
    public static double number(String message) {
        boolean controllo=true;
        double n=0;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            try { n=Double.parseDouble(input); }
            catch (Exception e) { System.out.println("ERRORE DI CONVERSIONE A DOUBLE"); controllo=true; }
        }
        return n;
    }

    /* Leggi in input un numero con la virgola che deve essere >= min */
    public static float numberMin(String message, float min) {
        boolean controllo=true;
        float n=0;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            try { 
                n=Float.parseFloat(input);
                if (n < min){controllo=true;}
            }
            catch (Exception e) { System.out.println("ERRORE DI CONVERSIONE A FLOAT"); controllo=true; }
        }
        return n;
    }

    /* Leggi in input un numero con la virgola che deve essere <= max */
    public static float numberMax(String message, float max) {
        boolean controllo=true;
        float n=0;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            try { 
                n=Float.parseFloat(input);
                if (n > max){controllo=true;}
            }
            catch (Exception e) { System.out.println("ERRORE DI CONVERSIONE A FLOAT"); controllo=true; }
        }
        return n;
    }

    /* Leggi in input un numero con la virgola che deve essere compreso tra max e min (estremi inclusi) */
    public static float numberMinMax(String message, float min, float max) {
        boolean controllo=true;
        float n=0;
        while (controllo){
            controllo = false;
            String input = Read.string(message);
            try { n=Float.parseFloat(input); if (n>max || n<min){controllo=true;}}
            catch (Exception e) { System.out.println("ERRORE DI CONVERSIONE A FLOAT"); controllo=true; }
        }
        return n;
    }
}

