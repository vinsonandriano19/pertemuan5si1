import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Nasabah> nasabah = new ArrayList<Nasabah>();
        ArrayList<String> logMutasi = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        init(nasabah);
        String yn = "y";

        do{

            menu();

            int pilihan = 0;
            pilihan = input.nextInt();

            if(pilihan==1){
                clearScreen();
                String NoRek;
                String Namansb;
                long Saldo = 0;
                System.out.print("Nama Nasabah\t : \t");
                Namansb = input.next();
                System.out.print("Nomor Rekening\t : \t");
                NoRek = input.next();
                System.out.print("Saldo Awal\t : \t");
                Saldo = input.nextLong();

                nasabah.add(new Nasabah(NoRek, Namansb, Saldo));
            }

            else if(pilihan==2){
                clearScreen();
                String NoRek;
                long setoran = 0;
                System.out.print("Nomor Rekening\t : \t");
                NoRek = input.next();
                System.out.print("Nominal Setoran (IDR)\t : \t");
                setoran = input.nextLong();
                boolean found = false;
                 
                int i=0;
                for (Nasabah nasabah2 : nasabah) {
                    if(nasabah2.getNoRek().equals(NoRek)){

                        System.out.println("\nNomor Rekening Penerima ditemukan");
                        found = true;
                        System.out.println("===========================================================");
                        Nasabah tmpnsb = nasabah2;
                        tmpnsb.setSaldo(tmpnsb.getSaldo() + setoran);
                        nasabah.set(i, tmpnsb);
                        System.out.println(nasabah2);
                        System.out.println("===========================================================");

                        System.out.println("Setoran telah berhasil\n");
                        logMutasi.add("- Setor Uang " +setoran+ " ke Rekening " +tmpnsb.getNoRek()+ " Atas Nama " + tmpnsb.getNamansb());
                    }
                    i++;
                }
                if(found = false){
                    System.out.println("\nNomor Rekening Pengirim tidak ditemukan");
                }
            }

            else if(pilihan==3){
                clearScreen();
                for (String string : logMutasi) {
                    System.out.println(string);
                }
            }

            else if(pilihan==4){
                clearScreen();
                String NoRek;
                String NoRek2;
                long transfer = 0;
                System.out.print("Nomor Rekening Pengirim\t : \t");
                NoRek = input.next();
                System.out.print("Nomor Rekening Penerima\t : \t");
                NoRek2 = input.next();
                System.out.print("Nominal Transfer (IDR)\t : \t");
                transfer = input.nextLong();

                boolean found = false;
                //if(nasabah.contains(new Nasabah(NoRek)))
                //    System.out.println("\nNomor Rekening ditemukan");
                //else 
                //    System.out.println("\nNomor Rekening tidak ditemukan");
                
                int i=0;
                int j=0;
                for (Nasabah nasabah4 : nasabah) {
                    if(nasabah4.getNoRek().equals(NoRek)){
                        System.out.println("\nNomor Rekening Pengirim ditemukan");
                        found = true;
                        Nasabah tmpnsb = nasabah4;
                        tmpnsb.setSaldo(tmpnsb.getSaldo() - transfer);
                        nasabah.set(i, tmpnsb);
                        System.out.println(nasabah4);
                        
                        logMutasi.add("- Transfer Uang " +transfer+ " Dari Rekening " +tmpnsb.getNoRek()+ " Atas Nama " + tmpnsb.getNamansb());
                    }
                    i++;
                }
                if(found = false){
                    System.out.println("\nNomor Rekening Pengirim tidak ditemukan");
                }
                
                for (Nasabah nasabah4 : nasabah) {
                    if(nasabah4.getNoRek().equals(NoRek2)){
                        System.out.println("\nNomor Rekening Penerima ditemukan");
                        found = true;
                        Nasabah tmpnsb = nasabah4;
                        tmpnsb.setSaldo(tmpnsb.getSaldo() + transfer);
                        nasabah.set(j, tmpnsb);
                        System.out.println(nasabah4);

                        System.out.println("\nTransfer telah berhasil");
                        logMutasi.add("  Ke Rekening " +tmpnsb.getNoRek()+ " Atas Nama " + tmpnsb.getNamansb());
                    }
                    j++;
                }
                if(found = false){
                    System.out.println("\nNomor Rekening Penerima tidak ditemukan");
                }
            }

            else if(pilihan==5){
                clearScreen();
                cetakNamaNasabah(nasabah);
            }

            else if(pilihan==6){
                break;
            }

            else{
                continue;
            }

            System.out.print("\nApakah anda ingin kembali ke menu utama (y/n) : ");
            yn = input.next();
            if(yn.equalsIgnoreCase("n")){
                clearScreen();
                System.out.println("\nTerima Kasih\n");
            }
        }while(yn.equalsIgnoreCase("y"));


        //cetakNamaNasabah(nasabah);

        //nsb3.setNamansb("Kimberly");
        //nasabah.set(2,nsb3);
        //cetakNamaNasabah(nasabah);

        //hapusNasabah(nasabah,1);
        //cetakNamaNasabah(nasabah);

        //nasabah.remove(nsb1);
        //cetakNamaNasabah(nasabah);
    }
    
    public static ArrayList<Nasabah> init(ArrayList<Nasabah> nasabah){
        Nasabah nsb1 = new Nasabah("0214578","Michael",500000);
        nasabah.add(nsb1);
        Nasabah nsb2 = new Nasabah("0214571","Gilbert",500000);
        nasabah.add(nsb2);
        Nasabah nsb3 = new Nasabah("0214572","Kimberly",500000);
        nasabah.add(nsb3);
        nasabah.add( new Nasabah("0214573","Wilbert",500000));
        return nasabah;
    }

    public static void menu(){
        System.out.println("\nAplikasi Banking");
        System.out.println("1. Tambah Nasabah Baru");
        System.out.println("2. Setor Uang");
        System.out.println("3. Cetak Mutasi");
        System.out.println("4. Transfer Uang");
        System.out.println("5. Cetak Nasabah");
        System.out.println("6. Keluar");
        System.out.print("\nMasukkan Pilihan Anda : ");
    }

    public static void hapusNasabah(ArrayList<Nasabah> nasabah, int idx){
        nasabah.remove(idx);
    }

    public static void cetakNamaNasabah(ArrayList<Nasabah> nasabah){
            System.out.println("No.Rekening\tNama\t\tSaldo\tNo.Kartu\tPIN\tTgl.Daftar");
            System.out.println("==================================================================================");
            for (Nasabah nsbh : nasabah) {
                System.out.println(nsbh);
            }
            System.out.println("==================================================================================");
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
