import java.io.*;
import java.util.*;

public class Main {
    public static Pacient[] vector = new Pacient[1000];
    public static final String FileName = "pacienti.txt";
    private static int k = 0;

    static public void DateToVector(){
        try(ObjectInputStream cin = new ObjectInputStream(new FileInputStream(FileName))) {
            Pacient pacient1;
            while ((pacient1 = (Pacient) cin.readObject()) != null){
                vector[k] = pacient1;
                k++;
            }
        }
        catch (EOFException eof){}
        catch (IOException | ClassNotFoundException ex ){}
    }

    public static void addPatience(Scanner scanner){
        Pacient pacient = new Pacient();
        try {
            System.out.print("Id(ex.:001):");
            pacient.setId(scanner.nextLine());
            System.out.print("Nume(ex.:Belîi):");
            pacient.setNume(scanner.nextLine());
            System.out.print("Prenume(ex.:Alexandra):");
            pacient.setPrenume(scanner.nextLine());
            System.out.print("Patronimic(ex.:Leonid):");
            pacient.setPatronimic(scanner.nextLine());
            System.out.print("Adresa(ex.:Livezilor_1):");
            pacient.setAdresa(scanner.nextLine());
            System.out.print("Telefon(ex.:078064842):");
            pacient.setTelefon(scanner.nextLine());
            System.out.print("Numar Polita Asigurare(ex.:123):");
            pacient.setNr_polita(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Sectie(ex.:Chirurgie):");
            pacient.setSecție(scanner.nextLine());
            System.out.print("Diagnoza(ex.:Panic attacks):");
            pacient.setDiagnoză(scanner.nextLine());

            vector[k] = pacient;
            k++;
            System.out.println("\u001B[33mPacientul a fost adăugat cu succes în fișier.\u001B[0m");
        }
        catch (InputMismatchException e){
            System.out.println("Ai introdus un tip de date nevalabil");
        }
    }

    public static void ShowPatiences (){
        if (k == 0){
            System.out.println("\u001B[35mÎn fișier nu sunt înscriși pacienți\u001B[0m");
            return;
        }
        try {


        System.out.println("Lista pacienților din fișier:");
            for(int i = 0; i < vector.length; i++)
                System.out.println(vector[i].toString());//System.out.println(studenti[i]);
        }
        catch (NullPointerException e){}
    }

    static void Save() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FileName))) {
            for (int i = 0; i < k; i++) {
                outputStream.writeObject(vector[i]);
            }
        }
        catch (IOException e) {}
    }

    public static void Diagnoza(String diagnoza){
        if (k == 0){
            System.out.println("\u001B[35mÎn fișier nu sunt înscriși pacienți\u001B[0m");
            return;
        }
        else {
            System.out.println("Lista pacienților cu " + diagnoza + ":");
            for(int i=0; i < k; i++)
                if (vector[i].getDiagnoză().equals(diagnoza))
                System.out.println(vector[i].toString());
            }
    }

    public static void Polițe(int a, int b){
        boolean ok = false;
        if (k == 0){
            System.out.println("\u001B[35mÎn fișier nu sunt înscriși pacienți\u001B[0m");
            return;
        }
        else {
            for(int i=0; i < k; i++)
                if (vector[i].getNr_polita() >= a && vector[i].getNr_polita() <= b)
                    ok = true;
            if (ok == false)
                System.out.println("Nu sunt în fișier pacienți cu numărul poliței de asigurare cuprins între " + a + " și " + b);
            else{
                System.out.println("Lista pacienților cu numărul poliței de asigurare de la " + a + " la " + b);
                for(int i=0; i < k; i++)
                    if (vector[i].getNr_polita() >= a && vector[i].getNr_polita() <= b)
                        System.out.println(vector[i].toString());
            }
        }

    }

    public static void Poliță(int poliță){
        boolean ok = false;
        if (k == 0){
            System.out.println("\u001B[35mÎn fișier nu sunt înscriși pacienți\u001B[0m");
            return;
        }
        else {
            for(int i=0; i < k; i++)
                if (vector[i].getNr_polita() == poliță){
                    System.out.println("Pacientul cu polița " + poliță + ": \n" + vector[i].toString());
                    ok = true;
                    return;
                }
            if (ok == false)
                System.out.println("În fișier nu există pacient cu numărul poliței " + poliță);

        }

    }

    public static int Secție(String secție){
        int cnt = 0;
        if (k == 0){
            System.out.println("\u001B[35mÎn fișier nu sunt înscriși pacienți\u001B[0m");
            return 0;
        }
        else {
            for(int i=0; i < k; i++)
                if (vector[i].getSecție().equals(secție))
                    cnt++;
        }
        return cnt;
    }

    public static void Prenume(String prenume){
        if (k == 0)
            System.out.println("\u001B[35mÎn fișier nu sunt înscriși pacienți\u001B[0m");
        else {
            System.out.println("Lista pacienților cu prenumele " + prenume + ":");
            for(int i=0; i < k; i++)
                if (vector[i].getPrenume().equals(prenume))
                    System.out.println(vector[i].toString());
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DateToVector();
        while (true){
            System.out.println("\u001B[32mMeniu\u001B[0m \n" +    "1) Introducerea unui nou pacient în fișier;\n" +
                                                                  "2) Afișarea datelor din fișier;\n" +
                                                                  "3) Afișarea listei pacienților cu o diagnoză anumită;\n" +
                                                                  "4) Afișarea datelor pacienților cu numărul poliței de asigurare cuprinse într-un interval anumit;\n" +
                                                                  "5) Afișarea datelor pacientului cu un număr anumit al poliței de asigurare;\n" +
                                                                  "6) Afișarea numărului de pacienți dintr-o secție anumită;\n" +
                                                                  "7) Afișarea datelor paciențiilor după un prenume anumit");
            System.out.println("Alegerea ta:");
            int n = scanner.nextInt();
            scanner.nextLine();
                    switch (n){
                        case 1:
                            addPatience(scanner); Save();  break;

                        case 2:
                            ShowPatiences();
                            break;

                        case 3:
                            System.out.print("Ce diagnoză vă interesează: ");
                            String diagnoza = scanner.nextLine();
                                    Diagnoza(diagnoza);     break;

                        case 4:
                            System.out.print("Te interesează pacienții cu numărul poliței de asigurare cuprinse între: ");
                            int a = scanner.nextInt();
                            System.out.print(" și ");
                            int b = scanner.nextInt();
                            scanner.nextLine();
                            Polițe(a, b);
                            break;


                        case 5:
                        System.out.print("Numărul poliței: ");
                            int poliță = scanner.nextInt();
                            scanner.nextLine();
                            Poliță(poliță);  break;

                        case 6:
                            System.out.println("În care secție te interesează câți pacienți sunt: ");
                            String secție = scanner.nextLine();
                            System.out.println("În secția " + secție + " sunt " + Secție(secție) + " pacienți"); break;


                        case 7: System.out.print("Lista pacienților cu ce prenume: ");
                            String prenume = scanner.nextLine();
                            Prenume(prenume);     break;
                        default:
                            System.err.println("Numarul introdus trebuie să aparțină intervalului [1-7].");
                    }


            System.out.println("\n===============");

            System.out.println("Introduceti \u001B[36mSTOP\u001B[0m pentru" + " a opri executia sau orice pentru a continua");
            String mesaj = scanner.nextLine();
            if(mesaj.equalsIgnoreCase("stop")) break;
        }
    }
}