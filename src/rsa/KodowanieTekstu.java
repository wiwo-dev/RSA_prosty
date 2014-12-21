
package rsa;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KodowanieTekstu {
    private String tekst;
    private int e;//wykladnik
    private int n;//modul
    private String zakodowane;
    
    public static void printBytes(byte[] array, String name) {
        for (int k = 0; k < array.length; k++) {
            System.out.println(name + "[" + k + "] = " + "0x"
                    + UnicodeFormatter.byteToHex(array[k]));
        }
    }
    
    
    
    
    public KodowanieTekstu()
    {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tekst ktory chcesz zakodowac: ");
        tekst = sc.nextLine();
        
        byte[] utf8Bytes = new byte[1];
        try {
            utf8Bytes = tekst.getBytes("UTF8");
            byte[] defaultBytes = tekst.getBytes();

            String roundTrip = new String(utf8Bytes, "UTF8");
            System.out.println("roundTrip = " + roundTrip);
            System.out.println();
            //printBytes(utf8Bytes, "utf8Bytes");
            //System.out.println();
            //printBytes(defaultBytes, "defaultBytes");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        kodowanieRSA(utf8Bytes);
        
    }
    
    private void kodowanieRSA(byte[] bajty) {
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
        
        //t = odczyt.nextInt();
        //(e,n);
        //System.out.println( "\nWynik kodowania = " + zakodowane + "\n");

        byte[] zakodowane = new byte[bajty.length];
        for(int i=0; i<bajty.length ; i++)
        {
            zakodowane[i] = (byte) Obliczeniowe.potegowanieModulo(bajty[i], e , n);
        }
        String zakodowany = "";
        try {
            zakodowany = new String(zakodowane, "UTF8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(KodowanieTekstu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Zakodowany tekst: " + zakodowany);
        
        
        
    }
    
    private void koduj(int e, int n)
    {
        
        StringBuffer buffer = new StringBuffer();
        char[] znaki = tekst.toCharArray();
        for(int i=0; i<tekst.length() ; i++)
        {
            int wynik = Obliczeniowe.potegowanieModulo((int) znaki[i] , e , n);
            buffer.append((char) wynik);
        }
        zakodowane = buffer.toString();
    }
    
    
}
