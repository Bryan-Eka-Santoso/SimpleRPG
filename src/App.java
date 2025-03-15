import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);

        int menu1;
        int gold= 200;
        Boolean namaBenar = false;
        Karakter player = null;
        Karakter flint = new Karakter("Flint", 80, 80, 30);
        Karakter maddy = new Karakter("Maddy", 60, 60, 40);
        
        do {
            System.out.println("====  Simple RPG ====");
            do {
                System.out.print("Enter your name: ");
                String nama = scanS.nextLine();
                
                if(nama != "Flint" && nama != "Maddy" && nama.length() == 5){
                    namaBenar = true;
                    player = new Karakter(nama, 120, 120, 20);
                } else {
                System.out.println("Invalid Name");
            }
        } while (!namaBenar);

        System.out.println("==== Your Party ====");
        System.out.println(player.getNama() + " [HP:" + player.getHpSekarang() + "/" + player.getHpAwal() + "]");
        System.out.println("====================");
        System.out.println("Gold: " + gold + "G");
        System.out.println("====================");
        System.out.println("1. Battle");
        System.out.println("2. Shop");
        System.out.println("3. Check Status");
        System.out.println("4. Exit");
        do {
            System.out.print(">> ");
            menu1 = scanI.nextInt();
        } while (menu1 < 1 || menu1 > 4);
        
        switch (menu1) {
            case 1:
                    System.out.println("===== Battle =====");
                break;
            case 2:
                    System.out.println("==== Shop ====");
                    
                break;
            case 3:
                
                break;
            default:
                break;
        }

        } while (menu1 != 4);
    }
}
