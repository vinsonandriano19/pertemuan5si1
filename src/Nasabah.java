public class Nasabah {
    private String NoRek;
    private String Namansb;
    private long Saldo = 0;
    private int NoKartu;
    private int Pin;
    private String TglDaftar;


    public Nasabah() {
    }

    public Nasabah(String NoRek) {
        this.NoRek = NoRek;
    }
    public Nasabah(String NoRek, String Namansb, long Saldo) {
        this.NoRek = NoRek;
        this.Namansb = Namansb;
        this.Saldo = Saldo;
        this.TglDaftar = java.time.LocalDate.now().toString();
    }

    public Nasabah(String NoRek, String Namansb, long Saldo, int NoKartu, int Pin, String TglDaftar) {
        this.NoRek = NoRek;
        this.Namansb = Namansb;
        this.Saldo = Saldo;
        this.NoKartu = NoKartu;
        this.Pin = Pin;
        this.TglDaftar = TglDaftar;
    }
    
    public String getNoRek() {
        return this.NoRek;
    }

    public void setNoRek(String NoRek) {
        this.NoRek = NoRek;
    }

    public String getNamansb() {
        return this.Namansb;
    }

    public void setNamansb(String Namansb) {
        this.Namansb = Namansb;
    }

    public long getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(long Saldo) {
        this.Saldo = Saldo;
    }

    public int getNoKartu() {
        return this.NoKartu;
    }

    public void setNoKartu(int NoKartu) {
        this.NoKartu = NoKartu;
    }

    public int getPin() {
        return this.Pin;
    }

    public void setPin(int Pin) {
        this.Pin = Pin;
    }

    public String getTglDaftar() {
        return this.TglDaftar;
    }

    public void setTglDaftar(String TglDaftar) {
        this.TglDaftar = TglDaftar;
    }
    
    @Override
    public String toString() {
        return "" +
            "" + getNoRek() + "'" +
            "\t" + getNamansb() + "'" +
            "\t\t" + getSaldo() + "'" +
            "\t" + getNoKartu() + "'" +
            "\t" + getPin() + "'" +
            "\t" + getTglDaftar() + "'" +
            "";
    }
    

}
