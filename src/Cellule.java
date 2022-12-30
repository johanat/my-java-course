public class Cellule {

    int numberDeChromosomes;
    String type;

    Cellule(int numberDeChromosomes,String type){
        this.numberDeChromosomes=numberDeChromosomes;
        this.type=type;
    }

    Cellule fecunda (Cellule cellule1 ){

        String cigoto = "cellule";

        Cellule newcellule= new Cellule( cellule1.numberDeChromosomes+numberDeChromosomes,cigoto);
        return newcellule;
    }

    @Override
    public String toString() {
        return "Number of Chromosomes: "+numberDeChromosomes+ " Type: "+type;
    }
}
