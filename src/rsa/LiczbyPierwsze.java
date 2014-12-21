package rsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LiczbyPierwsze {

    public List<Integer> liczbyPierwsze = new ArrayList<Integer>();
    public int doIlu;

    public LiczbyPierwsze(int doIlu) {
        this.doIlu = doIlu;
        generuj();

    }

    //generowanie liczb pierwszych
    //algorytm zaczerpnięty z wikipedii - sito eratostenesa
    public void generuj() {
        int n = doIlu;
        boolean[] numbersTable = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (numbersTable[i] == true) {
                continue;
            }
            for (int j = 2 * i; j <= n; j += i) {
                numbersTable[j] = true;
            }
        }
        //Liczby pierwsze z przedziału od 2 do n
        for (int i = 2; i <= n; i++) {
            if (numbersTable[i] == false) {
                liczbyPierwsze.add(i);
            }
        }
    }
 public int losuj() {
        int ileRazem = liczbyPierwsze.size();
        int pierwsza;

        Random generator = new Random();
        pierwsza = liczbyPierwsze.get(generator.nextInt(ileRazem));
        return pierwsza;
    }

    public int losujInna(int stara) {
        int p2;
        do {
            p2 = losuj();
        } while (p2 == stara);
        return p2;
    }

}
