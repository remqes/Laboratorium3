import java.util.Random;
import java.util.Scanner;

public class main {
    // ZADANIE 1
    public static short zliczanie(String tekst, char znak){
        short iloscWystapien =0;
        char kolejnyZnak;
        for(int i=0; i<tekst.length();i++){
            kolejnyZnak = tekst.charAt(i);
            if(znak == kolejnyZnak) iloscWystapien++;
        }
        return iloscWystapien;
    }
    public static void zadanie1(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj ciag znakow jaki chcesz przetestowac: ");
        String tekst = scan.nextLine();
        System.out.print("Podaj znak do wyszukania: ");
        char znak = scan.next().charAt(0);
        if(zliczanie(tekst, znak)==0) System.out.println("Tekst nie zawiera znaku '"+znak+"'.");
        else System.out.println("W tekscie znak '"+znak+"' wystapil "+zliczanie(tekst,znak)+" razy.");
    }

    // ZADANIE 2
    public static int sumowanieascii(String tekst){
        int sumowanie =0;
        char znakpomocniczy;
        int liczbapomocnicza;
        for(int i=0;i<tekst.length();i++){
            znakpomocniczy = tekst.charAt(i);
            liczbapomocnicza = (int)znakpomocniczy;
            if((liczbapomocnicza>=48 && liczbapomocnicza<=57) || (liczbapomocnicza>=97&&liczbapomocnicza<=122)){
                sumowanie += liczbapomocnicza;
            }
        }
        return sumowanie;
    }
    public static void zadanie2(){
        System.out.println("Podaj ciag znakow jaki chcesz przetestowac: ");
        Scanner scan = new Scanner(System.in);
        String tekst = scan.nextLine();
        System.out.println("Wynik sumowania tekstu to: "+sumowanieascii(tekst));
    }

    // ZADANIE 3
    public static void zamiana(short liczba){
        if(liczba<=32 || liczba>=127) System.out.println("Wartosc przekracza dopuszczalny zakres.");
        else {
            char znak = (char) liczba;
            System.out.println("Znak po przemianie z liczby " + liczba + " to " + znak);
        }
    }
    public static void zadanie3(){
        System.out.println("Podaj liczbe z zakresu <33,126> do przetestowania: ");
        Scanner scan = new Scanner(System.in);
        short liczba = scan.nextShort();
        zamiana(liczba);
    }

    // ZADANIE 4
    public static void zwracanieLancucha(String tekst){
        char znak;
        for(int i=0; i<tekst.length(); i++){
            znak = tekst.charAt(i);
            System.out.print(znak+" ");
        }
    }
    public static void szyfrowanie(String tekst){
        System.out.println("\n=- SZYFROWANIE -=");
        char znak;
        short liczba;
        for(int i=0; i<tekst.length(); i++){
            znak = tekst.charAt(i);
            liczba = (short)znak;
            if((liczba>=65 && liczba<=87) || (liczba>=97 && liczba<=119)) liczba+=3;
            else if((liczba>=88&&liczba<=90) || (liczba>=120&&liczba<=122)) liczba-=23;
            znak = (char)liczba;
            System.out.print(znak);
        }
    }
    public static void deszyfrowanie(String tekst){
        System.out.println("\n=- DESZYFROWANIE -=");
        char znak;
        short liczba;
        for(int i=0; i<tekst.length(); i++){
            znak = tekst.charAt(i);
            liczba = (short)znak;
            if((liczba>=68 && liczba <=90) || (liczba>=100 && liczba <=122)) liczba-=3;
            else if((liczba>=65 && liczba <=67) || (liczba>=97 && liczba<=99)) liczba+=23;
            znak = (char)liczba;
            System.out.print(znak);
        }
        System.out.println("\n");
    }
    public static void palindrom(String tekst) {
        char znakpocz, znakkon;
        tekst = tekst.toLowerCase();
        boolean jest = true;
        int i = 0, j=tekst.length()-1;
        while(i!=j && j>i){
            znakpocz = tekst.charAt(i);
            znakkon = tekst.charAt(j);
            if((int)znakpocz == 32) i++;
            else if((int)znakkon == 32) j--;
            else{
                if (znakpocz == znakkon) jest = true;
                else jest = false;
                i++; j--;
            }

        }
        if(jest == false) System.out.println("Dany tekst nie jest palindromem.");
        else System.out.println("Dany tekst jest palindromem.");
    }
    public static void zadanie4(){
        System.out.println("Podaj ciag znakow jaki chcesz przetestowac: ");
        Scanner scan = new Scanner(System.in);
        String tekst = scan.nextLine();
        zwracanieLancucha(tekst);
        szyfrowanie(tekst);
        deszyfrowanie(tekst);
        palindrom(tekst);
    }

    // ZADANIE 5
    public static void binarnyCiag(int liczba){
        String binarnie = Integer.toBinaryString(liczba);
        System.out.println(binarnie);
    }
    public static int sekwencja(String binarna){
        long value = Integer.parseInt(binarna,2);
        int count = 0;
        int countMax = 0;
        int factor = value < 0 ? -1 : 1;
        if(binarna.charAt(binarna.length()-1)=='0'){
            int i = binarna.length()-1;
            while (binarna.charAt(i)=='0'){
                value/=2;
                i--;
            }
        }
        while((value * factor) > 0)
        {
            count = value % 2 == 0 ? count + 1 : 0;
            value /= 2;
            countMax = Math.max(count, countMax);
        }
        return countMax;
    }
    public static void zadanie5(){
        System.out.println("Podaj liczbę: ");
        //Scanner scan = new Scanner(System.in);
        //int liczba = scan.nextInt();
        int liczba = new Random().nextInt();
        System.out.println("Wylosowano liczbe: "+liczba);
        binarnyCiag(liczba);
        System.out.println("Podaj liczbę w rep. binarnej: ");
        Scanner scan2 = new Scanner(System.in);
        String binarna = scan2.nextLine();
        if(sekwencja(binarna) == 0) System.out.println("Nie istnieje sekwencja zer.");
        else System.out.println("Sekwencja zer wynosi "+sekwencja(binarna)+".");
    }

    // MAIN
    public static void main(String[] args) {
        //Zadanie 3.1 - Obecnosc w łańcuchu
        //zadanie1();

        //Zadanie 3.2 - Suma ASCII
        //zadanie2();

        //Zadanie 3.3 - Liczba na znak
        //zadanie3();

        //Zadanie 3.4 - Szyfr Cezara
        //zadanie4();

        //Zadanie 3.5 - Binarna zerówka
        zadanie5();
    }

}
