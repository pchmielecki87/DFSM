package das; 

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DAS {

        public static void main(String[] args) throws IOException {

        //Wprowadzenie wyrazów
        String a="", b="";
        
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj słowo A = zero i słowo B = raz");;
            System.out.print("Podaj słowo A: ");
                a = scanner.next();
            System.out.print("Podaj słowo B: ");
                b = scanner.next();        
        } while (!a.equals("zero") && !b.equals("raz"));

        //Wczytywanie danych z pliku
        File plik = new File("/home/pece/Desktop/WSInf/MT/name1.txt");
        
        if(plik.exists() && !plik.isDirectory()) {
            String zawartosc = new String(Files.readAllBytes(Paths.get("/home/pece/Desktop/WSInf/MT/name.txt")));        
        
            //wyszukiwanie substringa w stringu
            String string1 = "zero";
            String string2 = "raz";

            for(int i=-1; (i=zawartosc.indexOf(string1, i+1)) != -1; ){
                System.out.println("Słowo 'zero' jest na pozycji: "+i);
            }
            for(int i=-1; (i=zawartosc.indexOf(string2, i+1)) != -1; ){
                System.out.println("Słowo 'raz' jest na pozycji: "+i);
            }
            
            //ile razy wystąpiło każde ze słów
            int n = 0, i = 0;

            while (i < zawartosc.length() && (i = zawartosc.indexOf("zero", i)) != -1) {
                ++n;
                ++i;
            }
            System.out.println("Słowo 'zero' wystąpiło " +n+ " razy"); 
            
            n=0;//czyszczenie licznika

            while (i < zawartosc.length() && (i = zawartosc.indexOf("raz", i)) != -1) {
                ++n;
                ++i;
            }
            System.out.println("Słowo 'raz' wystąpiło " +n+ " razy"); 

        } else {
            System.out.println("Nie znaleziono pliku");
        }

    }
}
