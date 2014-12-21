
package rsa;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KodowanieTekstu2 {
    private String tekst;
    private int e;//wykladnik
    private int n;//modul
    private String sZakodowane;
    
    
    
    
    public KodowanieTekstu2()
    {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tekst ktory chcesz zakodowac: ");
        tekst = sc.nextLine();
        
        int[] doKodowania = new int[tekst.length()];
        for(int i=0; i < doKodowania.length ; i++)
        {
            doKodowania[i] = (int) tekst.charAt(i);
        }
        
        kodowanieRSA(doKodowania);
        
    }
    
    private void kodowanieRSA(int[] ko) {
        int e, n, t;
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Kodowanie danych RSA\n" +
          "--------------------\n\n" +
          "Podaj wykladnik = "); 
       
        e = odczyt.nextInt();
        
        System.out.println("    Podaj modul = ");
      
        n = odczyt.nextInt();
        
        System.out.println( "----------------------------------\n\n" +
          "Koduje tekst: " + tekst);
        
        
        //(e,n);
        //System.out.println( "\nWynik kodowania = " + zakodowane + "\n");

        int[] zakodowane = new int[ko.length];
        for(int i=0; i<ko.length ; i++)
        {
            zakodowane[i] = Obliczeniowe.potegowanieModulo(ko[i], e , n);
        }
        
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<zakodowane.length ; i++)
        {
            //int wynik = Obliczeniowe.potegowanieModulo((int) znaki[i] , e , n);
            buffer.append((char) zakodowane[i]);
        }
        
        sZakodowane = buffer.toString();
        System.out.println( "----------------------------------\n\n" +
          "Zakodowany: " + sZakodowane);
    }
    
//    private void koduj(int e, int n)
//    {
//        
//        StringBuffer buffer = new StringBuffer();
//        char[] znaki = tekst.toCharArray();
//        for(int i=0; i<tekst.length() ; i++)
//        {
//            int wynik = Obliczeniowe.potegowanieModulo((int) znaki[i] , e , n);
//            buffer.append((char) wynik);
//        }
//        sZakodowane = buffer.toString();
//    }
    
    
}
