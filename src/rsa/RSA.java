
package rsa;

import java.util.Scanner;


public class RSA {


    public static void main(String[] args) {
        int wybor;
        do {
        System.out.println("Szyfrowanie danych RSA\n"
                + "(0) - koniec\n"
                + "(1) - generowanie kluczy RSA\n"
                + "(2) - kodowanie RSA jednej liczby\n"
                + "Co wybierasz? : ");
        
        Scanner sc = new Scanner(System.in);
        wybor = sc.nextInt();
        
        switch(wybor)
        {
            case 1:
                new KluczeRSA();
                break;
            case 2:
                Obliczeniowe.kodowanieRSA();
                break;
            
        }
       
        } while (wybor != 0);
        
    }
    
    
    
    
}
