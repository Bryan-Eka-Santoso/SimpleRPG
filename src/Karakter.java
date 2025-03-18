public class Karakter {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int attackNoBuff;
    private boolean isUnlocked;

    public Karakter(String name, int hp, int maxHp, int attack, int attackNoBuff, boolean isUnlocked) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.attackNoBuff = attackNoBuff;
        this.isUnlocked = isUnlocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttackNoBuff() {
        return attackNoBuff;
    }

    public void setAttackNoBuff(int attackNoBuff) {
        this.attackNoBuff = attackNoBuff;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean isUnlocked) {
        this.isUnlocked = isUnlocked;
    }

}
