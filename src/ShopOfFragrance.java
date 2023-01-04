

public class ShopOfFragrance {
    public static void main(String[] args) {

        Fragrance chanel  = new Fragrance("Chanel n.5", "Chanel", 100, 218);
        Fragrance fame = new Fragrance("Fame", "Laddy Gaga" , 120, 310);
        Fragrance fantasy = new Fragrance("Fantasy", "Paris Hilton", 60, 104);
        Fragrance TheGolden = new Fragrance("The golden", "Antonio Banderas", 65,12 );


        System.out.println(chanel);
        System.out.println(fame);
        System.out.println(fantasy);
        System.out.println(TheGolden);
        System.out.println("\n");

        TheGolden.addStock(100);
        fame.sell(50);
        fantasy.changePrice(85.3);

        System.out.println(chanel);
        System.out.println(fame);
        System.out.println(fantasy);
        System.out.println(TheGolden);

    }
}
