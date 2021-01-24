package Airlines_Ticketing;

import java.util.Random;
import java.util.Scanner;

public class AirlinesTicketing {
    //Inisiasi Scanner
    static Scanner InputData    = new Scanner(System.in);
    static Scanner InputString  = new Scanner(System.in);
    static String code = "";
    static String maskapai;
    static int kelas;
    static int penumpang;
    static String HP;
    static int usia;
    static String  Nama_P, mail, jenisKelamin, jenisPenumpang;
    static Scanner DPEkonomi = new Scanner(System.in);
    static int[] harga_E = {1000000, 750000, 500000};
    static int[] harga_B = {2000000, 1750000, 1500000};
    static int[] harga_Eks = {3000000, 2750000, 2500000};

    public static void main(String[] args) {
        //memanggil procedure tampilanAwal
        tampilanAwal();

        //memanggil procedure toDoList
        toDoList();
    }

    public static void tampilanAwal(){
        char admin;

        System.out.println("________________________________________________");
        System.out.println("| Selamat datang di aplikasi airline ticketing |");
        System.out.println("________________________________________________");

        System.out.print("Registrasi (Y) / Keluar (N) : ");
        admin = InputString.next().toLowerCase().charAt(0);

        if (admin == 'y') {
            System.out.println("=====Menuju Page Registrasi=====");
            String[] arrayAkun = doRegistrasi();
            doLogin(arrayAkun);
        } else if (admin == 'n'){
            System.out.println("===== Terima kasih sudah mampir^^ =====");
            //Agar program berhenti
            System.exit(0);
        } else {
            System.exit(0);
        }
    }

    public static void toDoList(){
        String[] arrayAkun = new String[6];
        int pilih;
        do {
            showMenu();
            System.out.print("\nPilih Angka : ");
            pilih = InputData.nextInt();
            switch (pilih) {
                case 1:
                    //arrayPesan = TambahPemesanan(arrayPesan);
                    listMaskapai();
                    selectMaskapai();
                    showKelasMaskapai();
                    break;
                case 2:
                    listMaskapai();
                    break;
                case 3:
                    DeleteDataPemesesanan(arrayAkun);
                    break;
                case 4:
                    showData(arrayAkun);
                case 5:
                    System.out.println("Terima kasih sudah sudah mampir di aplikasi Airlines Ticketing^^");
                    break;
            }
        } while (pilih != 5);
    }

    private static String[] doRegistrasi(){
        String[] arrayAkun = new String[5];

        System.out.println("\n====> Registrasi Akun <====");
        System.out.print("Nama Lengkap\t: ");
        arrayAkun[0] = InputData.nextLine();
        System.out.print("Email\t\t\t: ");
        arrayAkun[1] = InputData.nextLine();
        System.out.print("No. HP\t\t\t: ");
        arrayAkun[2] = InputData.nextLine();
        System.out.print("Username\t\t: ");
        arrayAkun[3] = InputData.nextLine();
        System.out.print("Password\t\t: ");
        arrayAkun[4] = InputData.nextLine();
        System.out.println("[Selamat, Registrasi Berhasil!]");

        return arrayAkun;
    }

    private static void doLogin(String[] arrayAkun){
        //inisialisasi variabel
        int checkFailed = 0;
        String username;
        String password;
        
        //melakukan percabangan untuk mengecek username dan password
        do {
            if (checkFailed == 2 || checkFailed == 1)
                System.out.println("[ERROR, Username dan Password anda salah!]");

            System.out.println("\n====> Login Akun <====");
            System.out.print("Username\t: ");
            username = InputData.nextLine();
            System.out.print("Password\t: ");
            password = InputData.nextLine();


            checkFailed++;
        } while ((!username.equals(arrayAkun[3]) || !password.equals(arrayAkun[4])) && checkFailed < 3);


        if (checkFailed == 3)
            System.out.println("Akun anda diblokir, mau ngehack ya???");
        else
            System.out.println("[SELAMAT ! Anda berhasil masuk]");

        printData(arrayAkun);
    }

    private static void printData(String[] arrayAkun){
        System.out.println("\n==> Data akun anda <==");
        System.out.println("Nama : " + arrayAkun[0]);
        System.out.println("Email : " + arrayAkun[1]);
        System.out.println("No. HP : " + arrayAkun[2]);
    }

    private static String showKodeTransaksi(){
        Random angkaRandom = new Random();
        for (int i = 0; i < 4; i++) {
            code += (angkaRandom.nextInt(10) + '0');
        }
        return code;
    }

    private static void printKode(){
        System.out.println("===> Check Data <===");
        for (int i = 1; i <= 1; i++) {
            System.out.println("Kode Transaksi : " + showKodeTransaksi());

        }
    }

    private static void DeleteDataPemesesanan(String[] arrayAkun){
        if (arrayAkun.length == 0) {
            System.out.println("\n> Hapus data pemesanan");
            {
                System.out.print("Masukkan Kode pemesanan\t: ");
                String removeElement = InputString.nextLine();

                String[] arrayTemp = arrayAkun;

                arrayAkun = new String[arrayTemp.length - 1];
                for (int i = 0; i < arrayAkun.length; i++) {
                    System.out.println("Proses ke-" + i);
                    if (!arrayTemp[0].equals(removeElement)) {
                        arrayAkun[0] = arrayTemp[0];
                        arrayAkun[1] = arrayTemp[1];
                        arrayAkun[2] = arrayTemp[2];
                    } else {
                        arrayAkun[0] = arrayTemp[1];
                        arrayAkun[1] = arrayTemp[1 + 1];
                        arrayAkun[2] = arrayTemp[2 + 1];
                    }
                }
            }
        } else {
            System.out.println("[Data Kosong !]");
        }
    }

    private static String[][] TambahPemesanan(String[][] arrayPesan) {
        System.out.println("\n===> Pemesanan Tiket <===");
//        Deklarasi array dengan value untuk backup data
        String[][] Tampung = arrayPesan;
//        Mengganti array dengan element ditambah satu
        arrayPesan = new String[Tampung.length + 1][3];
//        Restore data dari arrayTemp ke arrayMahasiswa
        for (int i = 0; i < Tampung.length; i++) {
            arrayPesan[i][0] = Tampung[i][0];
            arrayPesan[i][1] = Tampung[i][1];
            arrayPesan[i][2] = Tampung[i][2];
        }
//        Menambah Data
        System.out.print("Nama lengkap\t: ");
        arrayPesan[Tampung.length][0] = InputString.nextLine();
        System.out.print("Email\t\t\t: ");
        arrayPesan[Tampung.length][1] = InputString.nextLine();
        System.out.print("No. HP\t\t\t: ");
        arrayPesan[Tampung.length][2] = InputString.nextLine();

        return arrayPesan;
    }

    private static void showData(String[] Pemesanan) {
        if (Pemesanan.length == 0) {
            System.out.println("=======> Data Pemesanan <=======");
            for (int i = 0; i < Pemesanan.length; i++) {
                System.out.println("Pemesanan ke-" + (i) + "\t: ");
                System.out.println("Kode Transaksi : " + code);
                System.out.println("Nama : " + Pemesanan[0]);
                System.out.println("Email : " + Pemesanan[1]);
                System.out.println("No. HP : " + Pemesanan[2]);
            }
        } else {
                //jika tidak ada data
                System.out.println("[MAAF, Data Kosong!]");
                toDoList();
            }
        }

    private static void showMenu() {
        System.out.println("\n=====> Menu <=====");
        System.out.println("1. Pesan Tiket");
        System.out.println("2. Daftar Pesawat");
        System.out.println("3. Hapus Data Pemesanan");
        System.out.println("4. Lihat Data Pemesanan");
        System.out.println("5. Keluar");
    }

    private static void listMaskapai() {
        System.out.println("\n====> Daftar Maskapai <====");
        System.out.println("1. Garuda Indonesia (GI)");
        System.out.println("2. Batik Airline (BA)");
        System.out.println("3. LionAir (LA)");
    }

    private static void selectMaskapai() {
        do {
            System.out.print("\nPilih Maskapai (GI/BA/LA) : ");
            maskapai = InputString.next().toLowerCase();
        } while (!"gi".equals(maskapai) && !"ba".equals(maskapai) && !"la".equals(maskapai));
    }

    public static void listPenumpang() {
        System.out.println("\n====> Jenis Penumpang <====");
        System.out.println("1. Dewasa (DW) ");
        System.out.println("2. Anak-anak (AN) ");
        System.out.println("3. Balita (BL) ");
    }

    public static void selectPenumpang() {
        do {
            System.out.print("\nPilih Jenis Penumpang (DW/AN/BL) : ");
            jenisPenumpang = InputString.next().toLowerCase();
        } while (!"dw".equals(jenisPenumpang) && !"an".equals(jenisPenumpang) && !"bl".equals(jenisPenumpang));
    }

    private static void SearchKelas() {
        System.out.print("\nPilih kelas (1/2/3/4) : ");
        kelas = InputData.nextInt();
    }

    public static void showKelasMaskapai() {
        if ("gi".equals(maskapai)) {
            System.out.println("\n====> Pilih kelas <====");
            System.out.println("1. Ekonomi");
            System.out.println("2. Bisnis");
            System.out.println("3. Eksekutif");
            System.out.println("4. Ganti Maskapai");
            selectKelas();

        } else if ("ba".equals(maskapai)) {
            System.out.println("\n====> Pilih kelas <====");
            System.out.println("1. Ekonomi");
            System.out.println("2. Bisnis");
            System.out.println("3. Eksekutif");
            System.out.println("4. Ganti Maskapai");
            selectKelas();

        } else if ("la".equals(maskapai)) {
            System.out.println("\n====> Pilih kelas <====");
            System.out.println("1. Ekonomi");
            System.out.println("2. Bisnis");
            System.out.println("3. Eksekutif");
            System.out.println("4. Ganti Maskapai");
            selectKelas();

        } else {
            System.out.println("Data tidak ada");
        }
    }

    public static void selectKelas() {
        do {
            SearchKelas();
            switch (kelas) {
                case 1 :
                    showEkonomi();
                    break;
                case 2 :
                    showBisnis();
                    break;
                case 3 :
                    showEksekutif();
                    break;
                case 4 :
                    System.out.println("Mengganti Maskapai");
                    listMaskapai();
                    selectMaskapai();
            }
        } while (kelas != 4);
    }

    private static void showEkonomi() {
        System.out.println("===> Ekonomi <===");

        System.out.println("Nama Penumpang : " + Nama_P);
        System.out.println("Jenis Kelamin (Pria/Wanita) : " + jenisKelamin);
        System.out.println("Usia : " + usia);
        System.out.println("No. HP : " + HP);
        System.out.println("Jumlah Penumpang : " + penumpang);

        checkIn();
        printKode();
        listPenumpang();
        selectPenumpang();
        CheckDataPenumpang();
    }

    private static void showBisnis() {
        System.out.println("===> Ekonomi <===");

        System.out.println("Nama Penumpang : " + Nama_P);
        System.out.println("Jenis Kelamin (Pria/Wanita) : " + jenisKelamin);
        System.out.println("Usia : " + usia);
        System.out.println("No. HP : " + HP);
        System.out.println("Jumlah Penumpang : " + penumpang);

        checkIn();
        printKode();
        listPenumpang();
        selectPenumpang();
        CheckDataPenumpang();
    }

    private static void showEksekutif() {
        System.out.println("===> Ekonomi <===");
        checkIn();
        printKode();

        System.out.println("Nama Penumpang : " + Nama_P);
        System.out.println("Jenis Kelamin (Pria/Wanita) : " + jenisKelamin);
        System.out.println("Usia : " + usia);
        System.out.println("No. HP : " + HP);
        System.out.println("Jumlah Penumpang : " + penumpang);

        listPenumpang();
        selectPenumpang();
        CheckDataPenumpang();
    }

    private static void checkIn() {
        System.out.print("Masukkan jumlah penumpang : ");
        penumpang = InputData.nextInt();
        int[] jumlah = new int[penumpang];

        for (int i = 0; i <= jumlah.length; i++) {
            if (penumpang <= i) {
                System.out.print("Nama Penumpang : ");
                Nama_P = DPEkonomi.nextLine();
                System.out.print("Jenis Kelamin (Pria/Wanita)  : ");
                jenisKelamin = DPEkonomi.nextLine();
                System.out.print("Usia : ");
                usia = DPEkonomi.nextInt();
                System.out.print("No. HP : ");
                HP = DPEkonomi.nextLine();
                DPEkonomi.nextLine();

                System.out.println("\n===> Jenis Penumpang <===");
                listPenumpang();
                selectPenumpang();
                CheckDataPenumpang();
            }
        }
    }

    private static void CheckDataPenumpang() {
        String data;

        do {
            System.out.print("Apakah data sudah benar? (Y/N) : ");
            data = InputString.next();
        } while (!"y".equals(data) && !"n".equals(data));
        if ("y".equals(data)) {
            System.out.println("===> Lanjut menuju pembayaran <===");
        } else if ("n".equals(data)) {
            System.out.println("==> Mengulang Pengisian Data <===");
            checkIn();
        } else {
            System.out.println("Kode yang anda masukkan salah!");
        }
    }
}
