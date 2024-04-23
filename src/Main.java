import java.util.Scanner;

import static tools.Utility.*;

public class Main {
    public static void main(String[] Args) {
        String[] opzioni = {"LIBRERIA", "[1]Inserimento",
                "[2] visualizza", "[3]ricerca", "[4]fine"};
        final int dimScaffale = 9;
        int posizione = 0;
        Scanner scanner = new Scanner(System.in);
        final int numScaffaliMax = 2;
        final int nMAX = 10; //numero massimo di libri che contiene uno scaffale
        Libri[][] scaffali = new Libri[numScaffaliMax][dimScaffale]; // Usiamo l'array bidimensionale per memorizzare i libri

        boolean fine = true;
        int numScaffaliUtilizzati=0;

        do {
            switch (menu(opzioni, scanner)) {
                case 1: {
                    if (posizione < nMAX && numScaffaliUtilizzati<numScaffaliMax) {
                        inserimento(scanner, scaffali, posizione);
                        posizione++;
                        if (posizione == nMAX) {
                            posizione = 0; // Resetto la posizione quando raggiungi il numero massimo di libri
                            numScaffaliUtilizzati++; // Passa allo scaffale successivo incrementandolo
                        }
                    } else {
                        System.out.println("Numero massimo di libri raggiunto per tutti gli scaffali.");
                    }
                    break;
                }
                case 2: {
                    visualizza(scaffali, posizione);
                    break;
                }
                case 3: {
                    //Ricerca ritorna il libro se esiste con tutti i suoi dati inserendo solo il nome
                    System.out.println(ricerca(scaffali, posizione, scanner));
                    break;
                }
                default: {
                    fine = false;
                    System.out.println("Arrivederci, alla prossima!");
                    break;
                }
            }
        } while (fine);
    }

    // Questo metodo permette all'utente l'inserimento dei libri.
    public static void inserimento(Scanner scanner, Libri[][] scaffali, int posizione) {
        String[] scelta = {"GENERE", "[1]narrativo",
                "[2] avventura", "[3]romanzo", "[4]storico"};

        Libri libro = new Libri();
        System.out.println("Inserisci il titolo:");
        libro.titolo = scanner.nextLine();
        System.out.println("Inserisci l'anno:");
        libro.anno = scanner.nextInt();
        scanner.nextLine();
        switch (menu(scelta, scanner)) {
            case 1:
                libro.tipo = genere.narrativo;
                break;
            case 2:
                libro.tipo = genere.avventura;
                break;
            case 3:
                libro.tipo = genere.romanzo;
                break;
            default:
                libro.tipo = genere.storico;
                break;
        }
        scaffali[posizione][posizione] = libro; // Utilizziamo lo stesso indice `posizione` per entrambe le dimensioni dell'array bidimensionale
    }

    // Visualizza
    public static void visualizza(Libri[][] scaffali, int posizione) {
        for (int i = 0; i < scaffali.length; i++) {
            for (int j = 0; j < posizione; j++) {
                if (scaffali[i][j] != null) {
                    System.out.println(scaffali[i][j].stampa());
                }
            }
        }
    }

    public static String ricerca(Libri[][] scaffali, int posizione, Scanner scanner) {
        System.out.println("Inserisci il titolo:");
        String titoloR = scanner.nextLine();
        for (int i = 0; i < scaffali.length; i++) {
            for (int j = 0; j < posizione; j++) {
                if (scaffali[i][j] != null && scaffali[i][j].titolo.equals(titoloR)) {
                    return scaffali[i][j].stampa();
                }
            }
        }
        return "Libro non trovato.";
    }
}


/*  if (scaffali[i][j] != null && scaffali[i][j].titolo.equals(titoloR)) {
                return i; // Restituisci l'indice della riga se il titolo corrisponde
            }*/