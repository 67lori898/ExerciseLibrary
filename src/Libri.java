

    //Creazione della clesse libri, con gli attributi che corrispondono alla classe.
    enum genere{narrativo,avventura,romanzo,storico}//-> variabile enum
    public class Libri {
        public String titolo;
        public genere tipo;
        public int anno;
        public String stampa(){
            return String.format("titolo: %s  genere: %s  anno: %d",titolo,tipo,anno);
        }
    }




