
package rsa;


public class KluczeRSA {
    public int e;//wykladnik publiczny
    public int n;//modul
    public int d;//wykladnik prywatny
    
    public KluczeRSA() {
       
        int p, q, phi;
        System.out.println("Generuje klucze RSA");

        // generujemy dwie różne, losowe liczby pierwsze
        LiczbyPierwsze lp = new LiczbyPierwsze(100);
        p = lp.losuj();
        q = lp.losujInna(p);

        
        //obliczam phi oraz n
        phi = (p - 1) * (q - 1);
        n = p * q;

        // wyznaczamy wykładniki e i d
        for (e = 3; Obliczeniowe.nwd(e, phi) != 1; e += 2);
        d = Obliczeniowe.odwrotnoscModulo(e, phi);
        // gotowe, wypisujemy klucze

        System.out.println("KLUCZ PUBLICZNY\n" +
          "wykladnik e = " + e
                + "\n    modul n = " + n
                + "\n\nKLUCZ PRYWATNY\n" +
          "wykladnik d = " + d + "\n" + "Publiczny to (e,n) a Prywatny to (d,n)");
        
    }
}
