
public class Fecundation {
    public static void main(String[] args) {
        Cellule cellule1 = new Cellule(23,"Ovum");
        Cellule cellule2 = new Cellule(22,"spermatozoon");
        Cellule cellule3 = new Cellule(21,"spermatozoon ");
        Cellule cellule4 = new Cellule(20,"Ovum");
        Cellule cellule5 = new Cellule(19,"spermatozoon");
        Cellule cellule6 = new Cellule(26,"Ovum");

        System.out.println(cellule1.fecunda(cellule1));
        System.out.println(cellule1.fecunda(cellule2));
        System.out.println(cellule1.fecunda(cellule3));
        System.out.println(cellule1.fecunda(cellule4));
        System.out.println(cellule1.fecunda(cellule5));
        System.out.println(cellule1.fecunda(cellule6));
    }
}
