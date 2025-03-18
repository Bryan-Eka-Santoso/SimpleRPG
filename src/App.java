import java.util.*;

public class App {
    public static void playerTurn(Karakter player, Karakter flint, Karakter maddy) {
        if(player.isUnlocked() == true){
            System.out.println(player.getName() + " [HP:" + player.getHp() + "/" + player.getMaxHp() + "]");
        }
        if(flint.isUnlocked() == true){
            System.out.println(flint.getName() + " [HP:" + flint.getHp() + "/" + flint.getMaxHp() + "]");
        }
        if(maddy.isUnlocked() == true){
            System.out.println(maddy.getName() + " [HP:" + maddy.getHp() + "/" + maddy.getMaxHp() + "]");
        }
        System.out.println("==================");
        System.out.println("Current Turn: " + player.getName());
        System.out.println("<a> attack");
        System.out.println("<g> guard");
        System.out.println("<r> run"); 
    }

    public static void flintTurn(Karakter player, Karakter flint, Karakter maddy) {
        if(flint.isUnlocked() == true){
            System.out.println(flint.getName() + " [HP:" + flint.getHp() + "/" + flint.getMaxHp() + "]");
        }
        if(maddy.isUnlocked() == true){
            System.out.println(maddy.getName() + " [HP:" + maddy.getHp() + "/" + maddy.getMaxHp() + "]");
        }
        if(player.isUnlocked() == true){
            System.out.println(player.getName() + " [HP:" + player.getHp() + "/" + player.getMaxHp() + "]");
        }
        System.out.println("==================");
        System.out.println("Current Turn: " + flint.getName());
        System.out.println("<a> attack");
        System.out.println("<g> guard");
        System.out.println("<r> run"); 
    }

    public static void maddyTurn(Karakter player, Karakter flint, Karakter maddy) {
        if(maddy.isUnlocked() == true){
            System.out.println(maddy.getName() + " [HP:" + maddy.getHp() + "/" + maddy.getMaxHp() + "]");
        }
        if(player.isUnlocked() == true){
            System.out.println(player.getName() + " [HP:" + player.getHp() + "/" + player.getMaxHp() + "]");
        }
        if(flint.isUnlocked() == true){
            System.out.println(flint.getName() + " [HP:" + flint.getHp() + "/" + flint.getMaxHp() + "]");
        }
        System.out.println("==================");
        System.out.println("Current Turn: " + maddy.getName());
        System.out.println("<a> attack");
        System.out.println("<g> guard");
        System.out.println("<r> run"); 
    }

    public static void battleGame(Karakter player, Karakter flint, Karakter maddy, Karakter enemy, int turn, int jumlahPemain){
        System.out.println("===== Battle =====");
        System.out.println(enemy.getName() + "[HP:" + enemy.getHp() + "/" + enemy.getMaxHp() + "]");
        System.out.println("-- vs");
        if(jumlahPemain == 1){
            if(turn == 1 && player.getHp() > 0){
                playerTurn(player, flint, maddy);
            } else if(turn == 1 && flint.getHp() > 0){
                flintTurn(player, flint, maddy);
            } else if(turn == 1 && maddy.getHp() > 0){
                maddyTurn(player, flint, maddy);
            }
        } else if(jumlahPemain == 2){
            if(player.getHp() > 0 && flint.getHp() > 0){
                if(turn == 1){
                    playerTurn(player, flint, maddy);
                } else {
                    flintTurn(player, flint, maddy);
                }
            } else if(player.getHp() > 0 && maddy.getHp() > 0){
                if(turn == 1){
                    playerTurn(player, flint, maddy);
                } else {
                    maddyTurn(player, flint, maddy);
                }
            } else if(flint.getHp() > 0 && maddy.getHp() > 0){
                if(turn == 1){
                    flintTurn(player, flint, maddy);
                } else {
                    maddyTurn(player, flint, maddy);
                }
            }
        } else if(jumlahPemain >= 3){
            if(player.getHp() > 0 && flint.getHp() > 0 && maddy.getHp() > 0){
                if(turn == 1){
                    playerTurn(player, flint, maddy);
                } else if(turn == 2){
                    flintTurn(player, flint, maddy);
                } else {
                    maddyTurn(player, flint, maddy);
                }
            }
        }
    }

    public static void battleGameInput(Karakter enemy, Karakter player, String inputPlay){
        if(inputPlay.equals("a") && player.getHp() > 0){
            System.out.println(player.getName() + " attacks " + enemy.getName());
            int newHp = enemy.getHp() - player.getAttack();
            if(newHp <= 0){
                enemy.setUnlocked(false);
            }
            enemy.setHp(newHp);
        } else if(inputPlay.equals("g")){
            System.out.println(player.getName() + " guards " + enemy.getName());
        } else if(inputPlay.equals("r")){
            System.out.println("You run away!");
        } else if(!inputPlay.equals("a") || !inputPlay.equals("g") || !inputPlay.equals("r")){
            System.out.println(player.getName() + " is hesitating.");
        }
    }

    public static void enemyAttack(Karakter enemy, Karakter player, String inputPlay){
        if(!inputPlay.equals("r")){
            System.out.println(enemy.getName() + " attacks " + player.getName());
            if(inputPlay.equals("g")){
                System.out.println(player.getName() + " blocks the attack");
            } else {
                int newHp = player.getHp() - enemy.getAttack();
                player.setHp(newHp);
                if(player.getHp() < 0){
                    player.setHp(0);
                }
            }
        }
    }

    public static void turnPlay(int jumlahPemain, Karakter enemy, Karakter player, Karakter flint, Karakter maddy, String inputPlay, int turn){
        if(jumlahPemain == 1){
            if(turn == 1 && player.getHp() > 0){
                battleGameInput(enemy, player, inputPlay);
                enemyAttack(enemy, player, inputPlay);
            } else if(turn == 1 && flint.getHp() > 0){
                battleGameInput(enemy, flint, inputPlay);
                enemyAttack(enemy, flint, inputPlay);
            } else if(turn == 1 && maddy.getHp() > 0){
                battleGameInput(enemy, maddy, inputPlay);
                enemyAttack(enemy, maddy, inputPlay);
            }
        } else if(jumlahPemain == 2){
            if(player.getHp() > 0 && flint.getHp() > 0){
                if(turn == 1){
                    battleGameInput(enemy, player, inputPlay);
                    enemyAttack(enemy, player, inputPlay);
                } else {
                    battleGameInput(enemy, flint, inputPlay);
                    enemyAttack(enemy, flint, inputPlay);
                }
            } else if(player.getHp() > 0 && maddy.getHp() > 0){
                if(turn == 1){
                    battleGameInput(enemy, player, inputPlay);
                    enemyAttack(enemy, player, inputPlay);
                } else {
                    battleGameInput(enemy, maddy, inputPlay);
                    enemyAttack(enemy, maddy, inputPlay);
                }
            } else if(flint.getHp() > 0 && maddy.getHp() > 0){
                if(turn == 1){
                    battleGameInput(enemy, flint, inputPlay);
                    enemyAttack(enemy, flint, inputPlay);
                } else {
                    battleGameInput(enemy, maddy, inputPlay);
                    enemyAttack(enemy, maddy, inputPlay);
                }
            }
        } else if(jumlahPemain == 3){
            if(player.getHp() > 0 && flint.getHp() > 0 && maddy.getHp() > 0){
                if(turn == 1){
                    battleGameInput(enemy, player, inputPlay);
                    enemyAttack(enemy, player, inputPlay);
                } else if(turn == 2){
                    battleGameInput(enemy, flint, inputPlay);
                    enemyAttack(enemy, flint, inputPlay);
                } else {
                    battleGameInput(enemy, maddy, inputPlay);
                    enemyAttack(enemy, maddy, inputPlay);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        Random rand = new Random();

        int menu1, menuShop, menuHeal;
        String inputPlay;
        int gold = 100;
        int jumlahPemain = 0;
        Karakter player = null;
        Karakter flint = new Karakter("Flint", 0, 80, 30, 30, false);
        Karakter maddy = new Karakter("Maddy", 0, 60, 40, 40, false);
        // Enemy
        Karakter flintEnemy = new Karakter("Flint", 80, 80, 30, 30, true);
        Karakter maddyEnemy = new Karakter("Maddy", 60, 60, 40, 40, true);
        Karakter goblin = new Karakter("Goblin", 40, 40, 10, 10, true);
        Karakter minotour = new Karakter("Minotour", 90, 90, 20, 20, true);
        Karakter dragon = new Karakter("Dragon", 200, 200, 30, 30, true);

        int[] priceShop = {50, 100, 200};
        
        Boolean namaBenar = false;
        Boolean isStrength = false;
        Boolean isLucky = false;
        boolean afterNotifGoblin = false;
        boolean afterNotifMinotour = false;
        boolean afterNotifFlint = false;
        boolean afterNotifMaddy = false;
        boolean afterNotifPlayer = false;
        boolean afterNotifFlintTim = false;
        boolean afterNotifMaddyTim = false;


        System.out.println("====  Simple RPG ====");
        do {
            System.out.print("Enter your name: ");
            String nama = scanS.nextLine();
            
            if(!nama.equals("Flint") && !nama.equals("Maddy") && nama.length() >= 5){
                namaBenar = true;
                player = new Karakter(nama, 120, 120, 20, 20, true);
                jumlahPemain++;
            } else {
                System.out.println("Invalid Name");
            }
        } while (!namaBenar);
        
        do {
            System.out.println("==== Your Party ====");
            if(player.isUnlocked() == true){
                System.out.println(player.getName() + " [HP:" + player.getHp() + "/" + player.getMaxHp() + "]");
            }
            if(flint.isUnlocked() == true){
                System.out.println(flint.getName() + " [HP:" + flint.getHp() + "/" + flint.getMaxHp() + "]");
            } 
            if(maddy.isUnlocked() == true){
                System.out.println(maddy.getName() + " [HP:" + maddy.getHp() + "/" + maddy.getMaxHp() + "]");
            }
            System.out.println("====================");
            System.out.println("Gold: " + gold + "G");
            System.out.println("====================");
            System.out.println("1. Battle");
            System.out.println("2. Shop");
            System.out.println("3. Check Stats");
            System.out.println("4. Exit");
            do {
                System.out.print(">> ");
                menu1 = scanI.nextInt();

                if(menu1 == 888){
                    gold += 300;
                    System.out.println("Successfully get 300 gold.");
                } else if(menu1 == 111){
                    if(player.isUnlocked() == true){
                        player.setHp(player.getMaxHp());
                    }
                    if(flint.isUnlocked() == true){
                        flint.setHp(flint.getMaxHp());
                    }
                    if(maddy.isUnlocked() == true){
                        maddy.setHp(maddy.getMaxHp());
                    }
                    System.out.println("Successfully set all HP for your party to full.");
                } else if(menu1 == 333){
                    if(player.isUnlocked() == true){
                        player.setHp(20);
                    }
                    if(flint.isUnlocked() == true){
                        flint.setHp(20);
                    }
                    if(maddy.isUnlocked() == true){
                        maddy.setHp(20);
                    }
                    System.out.println("Successfully set all HP for your party to 20.");
                } else if(menu1 == 444){
                    flint.setUnlocked(true);
                    flint.setHp(flint.getMaxHp());
                    maddy.setUnlocked(true);
                    maddy.setHp(flint.getMaxHp());
                    System.out.println("Successfully unlock all characters.");
                    jumlahPemain+=2;
                }
            } while (menu1 < 1 || menu1 > 4 && menu1 != 888 && menu1 != 111 && menu1 != 333 && menu1 != 444);
            
            switch (menu1) {
                case 1:

                Boolean canPlay = true;
                int kosong = 0;

                if(player.getHp() <= 0){
                    kosong++;
                }
                if(flint.getHp() <= 0){
                    kosong++;
                }
                if(maddy.getHp() <= 0){
                    kosong++;
                }
                if(kosong == 3){
                    canPlay = false;
                }
                
                if(canPlay){
                    int getEnemy;
                    int turn = 1;
                    Boolean gameOver = false;
                    Boolean isWin = false;

                    do {
                        boolean isCanAttack = false;
                        int cekKosong = 0;

                            do {
                                getEnemy = rand.nextInt(4);

                                if(getEnemy == 0 && minotour.isUnlocked() == true){
                                    isCanAttack = true;
                                }
                                if(getEnemy == 1 && goblin.isUnlocked() == true){
                                    isCanAttack = true;
                                }
                                if(getEnemy == 2 && flintEnemy.isUnlocked() == true){
                                    isCanAttack = true;
                                }
                                if(getEnemy == 3 && maddyEnemy.isUnlocked() == true){
                                    isCanAttack = true;
                                }

                            } while (!isCanAttack);

                            if(flint.isUnlocked() == true && maddy.isUnlocked() == true){
                                getEnemy = 4;
                            }

                            if(isLucky) {
                                if((getEnemy == 0 && minotour.isUnlocked()) || (getEnemy == 1 && goblin.isUnlocked())) {
                                    Karakter luckyEnemy = null;
                                    int getGold = 0;
                                    
                                    if(getEnemy == 0) {
                                        luckyEnemy = minotour;
                                        minotour.setUnlocked(false);
                                    } else if(getEnemy == 1) {
                                        luckyEnemy = goblin;
                                        goblin.setUnlocked(false);
                                    }
                                    
                                    if(luckyEnemy != null) {
                                        getGold = luckyEnemy.getMaxHp() - luckyEnemy.getAttack();
                                        System.out.println("You used the Lucky Charm! You win the battle.");
                                        System.out.println("Gained " + getGold + " Gold");
                                        gold += getGold;
                                        isLucky = false;
                                    }
                                    break;
                                }
                            }
                            
                            if(getEnemy == 0){
                                battleGame(player, flint, maddy, minotour, turn, jumlahPemain);
                            } else if(getEnemy == 1){
                                battleGame(player, flint, maddy, goblin, turn, jumlahPemain);
                            } else if(getEnemy == 2){
                                battleGame(player, flint, maddy, flintEnemy, turn, jumlahPemain);
                            } else if(getEnemy == 3){
                                battleGame(player, flint, maddy, maddyEnemy, turn, jumlahPemain);
                            } else if(getEnemy == 4){
                                battleGame(player, flint, maddy, dragon, turn, jumlahPemain);
                            }
                            
                            System.out.print(">> ");
                            inputPlay = scanS.nextLine();

                            int nextTurn = 1;
                            if (turn == 1 && jumlahPemain == 2) {
                                nextTurn = 2;
                            } else if (turn == 2 && jumlahPemain == 2) {
                                nextTurn = 1;
                            } else if (jumlahPemain == 3) {
                                if (turn == 3) {
                                    nextTurn = 1;
                                } else {
                                    nextTurn = turn + 1;
                                }                                
                            }

                            if(getEnemy == 0){
                                turnPlay(jumlahPemain, minotour, player, flint, maddy, inputPlay, turn);
                                turn = nextTurn;
                            } else if(getEnemy == 1){
                                turnPlay(jumlahPemain, goblin, player, flint, maddy, inputPlay, turn);
                                turn = nextTurn;
                            } else if(getEnemy == 2){
                                turnPlay(jumlahPemain, flintEnemy, player, flint, maddy, inputPlay, turn);
                                turn = nextTurn;
                            } else if(getEnemy == 3){
                                turnPlay(jumlahPemain, maddyEnemy, player, flint, maddy, inputPlay, turn);
                                turn = nextTurn;
                            } else if(getEnemy == 4){
                                turnPlay(jumlahPemain, dragon, player, flint, maddy, inputPlay, turn);
                                turn = nextTurn;
                            }

                            if(isStrength){
                                isStrength = false;
                                if(player.isUnlocked() == true){
                                    player.setAttack(player.getAttackNoBuff());
                                }
                                if(flint.isUnlocked() == true){
                                    flint.setAttack(flint.getAttackNoBuff());
                                }
                                if(maddy.isUnlocked() == true){
                                    maddy.setAttack(maddy.getAttackNoBuff());
                                }
                            }

                            if(flintEnemy.getHp() <= 0 && afterNotifFlint == false){
                                int getGold = 0;
                                getGold = flintEnemy.getMaxHp() - flintEnemy.getAttack();
                                flintEnemy.setUnlocked(false);
                                flint.setUnlocked(true);
                                flint.setHp(flint.getMaxHp());
                                System.out.println("You defeted Flint.");
                                System.out.println("Gained " + getGold + " Gold");
                                System.out.println("Flint has joined your party!");
                                afterNotifFlint = true;
                                gold += getGold;
                                jumlahPemain++;
                            }

                            if(maddyEnemy.getHp() <= 0 && afterNotifMaddy == false){
                                int getGold = 0;
                                getGold = maddyEnemy.getMaxHp() - maddyEnemy.getAttack();
                                maddyEnemy.setUnlocked(false);
                                maddy.setUnlocked(true);
                                maddy.setHp(maddy.getMaxHp());
                                System.out.println("You defeted Maddy.");
                                System.out.println("Gained " + getGold + " Gold");
                                System.out.println("Maddy has joined your party!");
                                afterNotifMaddy = true;
                                gold += getGold;
                                jumlahPemain++;
                            }

                            if(goblin.getHp() <= 0 && afterNotifGoblin == false){
                                int getGold = 0;
                                getGold = goblin.getMaxHp() - goblin.getAttack();
                                goblin.setUnlocked(false);
                                System.out.println("You defeted Goblin.");
                                System.out.println("Gained " + getGold + " Gold");
                                afterNotifGoblin = true;
                                gold += getGold;
                            }

                            if(minotour.getHp() <= 0 && afterNotifMinotour == false){
                                int getGold = 0;
                                getGold = minotour.getMaxHp() - minotour.getAttack();
                                minotour.setUnlocked(false);
                                System.out.println("You defeted Minotour.");
                                System.out.println("Gained " + getGold + " Gold");
                                afterNotifMinotour = true;
                                gold += getGold;
                            }

                            if(player.getHp() <= 0 && afterNotifPlayer == false && player.isUnlocked()){
                                System.out.println("Your tim Player is die.");
                                afterNotifPlayer = true;
                                jumlahPemain--;
                            }

                            if(flint.getHp() <= 0 && afterNotifFlintTim == false && flint.isUnlocked()){
                                System.out.println("Your tim Flint is die.");
                                afterNotifFlintTim = true;
                                jumlahPemain--;
                            }

                            if(maddy.getHp() <= 0 && afterNotifMaddyTim == false && maddy.isUnlocked()){
                                System.out.println("Your tim Maddy is die.");
                                afterNotifMaddyTim = true;
                                jumlahPemain--;
                            }

                            if(player.getHp() <= 0){
                                cekKosong++;
                            }

                            if(flint.getHp() <= 0){
                                cekKosong++;
                            }

                            if(maddy.getHp() <= 0){
                                cekKosong++;
                            }

                            if(cekKosong == 3){
                                gameOver = true;
                            }

                            if(dragon.getHp() <= 0){
                                isWin = true;
                            }

                        } while (!inputPlay.equals("r") && !gameOver && !isWin && !isLucky);
                        if(gameOver){
                            System.out.println("Game Over !!!");
                        }
                        if(isWin){
                            goblin.setHp(goblin.getMaxHp());
                            goblin.setUnlocked(true);;
                            minotour.setHp(minotour.getMaxHp());
                            minotour.setUnlocked(true);
                            flintEnemy.setHp(flintEnemy.getMaxHp());
                            flintEnemy.setUnlocked(true);
                            maddyEnemy.setHp(maddyEnemy.getMaxHp());
                            maddyEnemy.setUnlocked(true);
                            dragon.setHp(dragon.getMaxHp());
                            dragon.setUnlocked(true);

                            player.setHp(player.getMaxHp());
                            player.setUnlocked(true);
                            flint.setHp(0);
                            flint.setUnlocked(false);
                            maddy.setHp(0);
                            maddy.setUnlocked(false);
                            jumlahPemain = 1;
                            System.out.println("You Win !!!");
                        }
                        if(isLucky && getEnemy == 0){
                            int getGold = 0;
                            getGold = goblin.getMaxHp() - goblin.getAttack();
                            goblin.setUnlocked(false);
                            System.out.println("You used the Lucky Charm! You win the battle.");
                            System.out.println("Gained " + getGold + " Gold");
                            isLucky = false;
                            gold += getGold;
                        }
                        if(isLucky && getEnemy == 1){
                            int getGold = 0;
                            getGold = minotour.getMaxHp() - minotour.getAttack();
                            minotour.setUnlocked(false);
                            System.out.println("You used the Lucky Charm! You win the battle.");
                            System.out.println("Gained " + getGold + " Gold");
                            isLucky = false;
                            gold += getGold;
                        }
                    } else {
                        System.out.println("Your party are wounded.");
                    }

                    break;
                case 2:
                    do {
                        System.out.println("===== Shop =====");
                        System.out.println("1. Healing Potion - 50G");
                        System.out.println("2. Strength Potion - 100G");
                        System.out.println("3. Lucky Charm - 200G");
                        System.out.println("4. Exit");
                        do {
                            System.out.print(">> ");
                            menuShop = scanI.nextInt();
                        } while (menuShop < 1 || menuShop > 4);

                        if(menuShop != 4){
                            if(gold >= priceShop[menuShop-1]){
                                if(menuShop == 1){
                                    System.out.println("You bought a Healing Potion.");
                                    System.out.println("Choose a character to heal: ");

                                    if(player.isUnlocked() == true){
                                        System.out.println("1. " + player.getName());
                                    }
                                    if(flint.isUnlocked() == true){
                                        System.out.println("2. " + flint.getName());
                                    }
                                    if(maddy.isUnlocked() == true){
                                        System.out.println("3. " + maddy.getName());
                                    }

                                    System.out.print(">> ");
                                    menuHeal = scanI.nextInt();

                                    if(menuHeal == 1 && player.isUnlocked() == true){
                                        gold -= priceShop[menuShop-1];
                                        if(player.getHp() <= 0){
                                            jumlahPemain++;
                                        }
                                        player.setHp(player.getMaxHp());
                                        System.out.println("Successfully bought a Healing Potion for the " + player.getName() + ".");
                                    } else if(menuHeal == 2 && flint.isUnlocked() == true){
                                        gold -= priceShop[menuShop-1];
                                        if(flint.getHp() <= 0){
                                            jumlahPemain++;
                                        }
                                        flint.setHp(flint.getMaxHp());
                                        System.out.println("Successfully bought a Healing Potion for the Flint.");
                                    } else if(menuHeal == 3 && maddy.isUnlocked() == true){
                                        gold -= priceShop[menuShop-1];
                                        if(maddy.getHp() <= 0){
                                            jumlahPemain++;
                                        }
                                        maddy.setHp(maddy.getMaxHp());
                                        System.out.println("Successfully bought a Healing Potion for the Maddy.");
                                    } else {
                                        System.out.println("Invalid input.");
                                    }

                                } else if(menuShop == 2){
                                    if(!isStrength){
                                        isStrength = true;
                                        if(player.isUnlocked() == true){
                                            int buffAttack = player.getAttack() + (int)(player.getAttack() * 0.5);
                                            player.setAttack(buffAttack);
                                        }
                                        if(flint.isUnlocked() == true){
                                            int buffAttack = flint.getAttack() + (int)(flint.getAttack() * 0.5);
                                            flint.setAttack(buffAttack);
                                        }
                                        if(maddy.isUnlocked() == true){
                                            int buffAttack = maddy.getAttack() + (int)(maddy.getAttack() * 0.5);
                                            maddy.setAttack(buffAttack);
                                        }
                                        gold -= priceShop[menuShop-1];
                                        System.out.println("Successfully bought a Strength Potion.");
                                    } else {
                                        System.out.println("Failed, you already have a Strength Potion.");
                                    }
                                } else if(menuShop == 3){
                                    if(!isLucky){
                                        isLucky = true;
                                        gold-= priceShop[menuShop-1];
                                        System.out.println("Successfully bought a Lucky Charm.");
                                    } else {
                                        System.out.println("Failed, you already have a Lucky Charm.");
                                    }
                                }
                            } else {
                                System.out.println("Your gold is not enough.");
                            }
                        }
                    } while (menuShop != 4);
                    break;
                case 3:
                    System.out.println("===== Stats =====");
                    if(player.isUnlocked() == true){
                        System.out.println(player.getName());
                        System.out.println("[HP: " + player.getHp() + "/" + player.getMaxHp() + "]");
                        if(isStrength){
                            System.out.println("[Atk:" + player.getAttack() + " (Strength Potion Active)]");
                        } else {
                            System.out.println("[Atk:" + player.getAttack() + "]");
                        }
                    }
                    if(flint.isUnlocked() == true){
                        System.out.println(flint.getName());
                        System.out.println("[HP: " + flint.getHp() + "/" + flint.getMaxHp() + "]");
                        if(isStrength){
                            System.out.println("[Atk:" + flint.getAttack() + " (Strength Potion Active)]");
                        } else {
                            System.out.println("[Atk:" + flint.getAttack() + "]");
                        }
                    }
                    if(maddy.isUnlocked() == true){
                        System.out.println(maddy.getName());
                        System.out.println("[HP: " + maddy.getHp() + "/" + maddy.getMaxHp() + "]");
                        if(isStrength){
                            System.out.println("[Atk:" + maddy.getAttack() + " (Strength Potion Active)]");
                        } else {
                            System.out.println("[Atk:" + maddy.getAttack() + "]");
                        }
                    }
                default:
                    break;
            }
        } while (menu1 != 4);
        scanI.close();
        scanS.close();
    }
}
