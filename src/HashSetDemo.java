// Demo af HashSet, hvor vi viser hvordan HashSet kan bruges (og misbruges)
// EK apr. 2023

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    private static final SecureRandom s = new SecureRandom();

    public static void main(String[] args) {

        // Fyld 10 varer i hashsettet varer
        HashSet varer = new HashSet();

        for (int i=0; i<10; i++) {
            Vare v = new Vare(s.nextInt(10000), Integer.toString(s.nextInt(1000)), 1);
            varer.add(v);
        }

        // Lav en vare v1 og add den også
        Vare v1 = new Vare(9999999, "FUNDET", 1);
        varer.add(v1);

        // Hvis vi ændrer på et af v1's attributter der er med i hashkoden går det galt
        //v1.setNavn("av");
        // Men hvis det ikke er med i hashkoden kan vi godt:
        //v1.setAntal(8);

        // Vis alle elementer i varer
        Iterator i = varer.iterator();
        while (i.hasNext()) {
            Vare v = (Vare) i.next();
            System.out.println(v.getVarenr()+ " " + v.getVarenavn());
        }

        // Check om v1 findes (det gør den ikke hvis vi ændrer i en attribut på v1, der er en del af hashkoden)
        if (varer.contains(v1))
            System.out.println("fundet");
        else
            System.out.println("Ikke fundet");

        // Lav ny vare v2
        Vare v2 = v1;
        // Fjern v1
        varer.remove(v1);
        // Opdater v2 og add den.
        v2.setNavn("HEJ");
        varer.add(v2);

        // Skriv varer ud og se at opdatering er ok
        i = varer.iterator();
        while (i.hasNext()) {
            Vare v = (Vare) i.next();
            System.out.println(v.getVarenr()+ " " + v.getVarenavn());
        }

    }
}