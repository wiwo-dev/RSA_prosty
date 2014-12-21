

package rsa;

import java.util.Scanner;

public class Obliczeniowe {
    
    
    //największy wspólny dzielnik dwoch liczb
    public static int nwd(int a, int b)
    {
        int t;
        while(b != 0)
        {
            t = b;
            b=a%b;
            a=t;
        }
        return a;
    }
    
    
    //obliczanie odwrotnosci modulo n
    public static int odwrotnoscModulo(int a, int n) {
        int a0, n0, p0, p1, q, r, t;

        p0 = 0;
        p1 = 1;
        a0 = a;
        n0 = n;
        q = n0 / a0;
        r = n0 % a0;
        while (r > 0) {
            t = p0 - q * p1;
            if (t >= 0) {
                t = t % n;
            } else {
                t = n - ((-t) % n);
            }
            p0 = p1;
            p1 = t;
            n0 = a0;
            a0 = r;
            q = n0 / a0;
            r = n0 % a0;
        }
        return p1;
    }
    
    
    
    //do szyfrowania kluczem publicznym c=t^e mod n
    //a = podstawa (to co chcemy zaszyfrować - liczba)
    //w - wykladnik (z klucza publicznego)
    // n - moduł
    public static int potegowanieModulo(int a, int w, int n) {
        int pot, wyn, q;

        // wykładnik w rozbieramy na sumę potęg 2
        // przy pomocy algorytmu Hornera. Dla reszt
        // niezerowych tworzymy iloczyn potęg a modulo n.
        pot = a;
        wyn = 1;
        for (q = w; q > 0; q /= 2) {
            if (q % 2 == 1) {
                wyn = (wyn * pot) % n;
            }
            pot = (pot * pot) % n; // kolejna potęga
        }
        return wyn;
    }
    
    
    public static void kodowanieRSA() {
        int e, n, t;
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Kodowanie danych RSA\n" +
          "--------------------\n\n" +
          "Podaj wykladnik = "); 
       
        e = odczyt.nextInt();
        
        System.out.println("    Podaj modul = ");
      
        n = odczyt.nextInt();
        
        System.out.println( "----------------------------------\n\n" +
          "Podaj kod RSA   = ");
        
        t = odczyt.nextInt();
        
        System.out.println( "\nWynik kodowania = " + potegowanieModulo(t, e, n) + "\n");

        
    }
}
