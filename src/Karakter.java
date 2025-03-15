public class Karakter {
    private String nama;
    private int hpAwal;
    private int hpSekarang;
    private int attack;

    public Karakter(String nama, int hpAwal, int hpSekarang, int attack) {
        this.nama = nama;
        this.hpAwal = hpAwal;
        this.hpSekarang = hpSekarang;
        this.attack = attack;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getHpAwal() {
        return hpAwal;
    }
    public void setHpAwal(int hpAwal) {
        this.hpAwal = hpAwal;
    }
    public int getHpSekarang() {
        return hpSekarang;
    }
    public void setHpSekarang(int hpSekarang) {
        this.hpSekarang = hpSekarang;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

}
