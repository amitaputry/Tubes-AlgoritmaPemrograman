package Airlines_Ticketing;


import java.util.Scanner;

public class AirlinesTicketing {
    //Inisiasi Scanner
    static Scanner InputNumber = new Scanner(System.in);
    static Scanner InputString = new Scanner(System.in);
    static int[] harga_E = {1000000, 750000, 500000};
    static int[] harga_B = {2000000, 1750000, 1500000};
    static int[] harga_Eks = {3000000, 2750000, 2500000};
    static int kelas, dewasa, anak, balita;
    static String jenisPenumpang, jadwalKeberangkatan;

    private static void showHeader() {
        char admin;

        System.out.println("________________________________________________");
        System.out.println("| Selamat datang di aplikasi airline ticketing |");
        System.out.println("________________________________________________");

        System.out.print("Registrasi (Y) / Keluar (N)\t: ");
        admin = InputString.nextLine().toLowerCase().charAt(0);
        if (admin == 'y') {
            System.out.println("=====Menuju page registrasi=====");
        } else {
            System.out.println("===== Terima kasih sudah mampir^^ =====");
            return;
        }
    }

    private static String[][] doRegistrasi(String[][] arrayAkun) {

        System.out.println("\n====> Registrasi Akun <====");

        System.out.print("Nama Lengkap\t: ");
        arrayAkun[0][0] = InputString.nextLine();
        System.out.print("Email\t\t\t: ");
        arrayAkun[0][1] = InputString.nextLine();
        System.out.print("No. HP\t\t\t: ");
        arrayAkun[0][2] = InputString.nextLine();
        System.out.print("Username\t\t: ");
        arrayAkun[0][3] = InputString.nextLine();
        System.out.print("Password\t\t: ");
        arrayAkun[0][4] = InputString.nextLine();
        System.out.println("Registrasi Berhasil!");

        return arrayAkun;

    }

    private static String[][] doLogin(String[][] arrayAkun) {
        int checkFailed = 0;
        String username;
        String password;

        do {

            if (checkFailed == 2 || checkFailed == 1)
                System.out.println("Maaf user name dan password anda salah");

            System.out.println("\n====> Login Akun <====");
            System.out.print("Username\t: ");
            username = InputString.nextLine();
            System.out.print("Password\t: ");
            password = InputString.nextLine();


            checkFailed++;
        } while ((!username.equals(arrayAkun[0][3]) || !password.equals(arrayAkun[0][4])) && checkFailed < 3);


        if (checkFailed == 3)
            System.out.println("Akun anda diblokir, mau ngehack ya???");
        else
            System.out.println("Anda berhasil masuk");

        printData(arrayAkun);
        return arrayAkun;
    }

    private static void printData(String[][] arrayAkun) {
        System.out.println("\n==> Data akun anda <==");
        System.out.println("Nama\t\t: " + arrayAkun[0][0]);
        System.out.println("Email\t\t: " + arrayAkun[0][1]);
        System.out.println("No. HP\t\t: " + arrayAkun[0][2]);
    }

    private static String[][] TambahDataPemesanan(String[][] arrayPesan) {
        System.out.println("\n===> Pemesanan Tiket <===");
//        Deklarasi array dengan value untuk backup data
        String[][] Tampung = arrayPesan;
//        Mengganti array dengan element ditambah satu
        arrayPesan = new String[Tampung.length + 1][4];
//        Restore data dari tamoung ke arrayPesan
        for (int i = 0; i < Tampung.length; i++) {
            arrayPesan[i][0] = Tampung[i][0];
            arrayPesan[i][1] = Tampung[i][1];
            arrayPesan[i][2] = Tampung[i][2];
            arrayPesan[i][2] = Tampung[i][3];
        }
//        Menambah Data
            System.out.print("Nama lengkap\t: ");
            arrayPesan[Tampung.length][0] = InputString.nextLine();
            System.out.print("Jenis Kelamin\t: ");
            arrayPesan[Tampung.length][1] = InputString.nextLine();
            System.out.print("Usia\t\t\t: ");
            arrayPesan[Tampung.length][2] = InputString.nextLine();
            System.out.print("No. HP\t\t\t: ");
            arrayPesan[Tampung.length][3] = InputString.nextLine();

        return arrayPesan;
    }

    private static String[][] DeleteDataPemesanan(String[][] arrayPesan) {
        System.out.println("\n===> Hapus Pemesanan <===");

        if (arrayPesan.length == 0) {
            System.out.println("Data Tidak ada");
            return arrayPesan;

        } else {
            System.out.print("Masukkan Nama yang akan dihapus\t: ");
            String removeElement = InputString.nextLine();

            String[][] Tampung = arrayPesan;

            arrayPesan = new String[Tampung.length - 1][4];
            for (int i = 0; i < arrayPesan.length; i++) {
                System.out.println("Proses ke-" + i);
                if (!Tampung[i][0].equals(removeElement)) {
                    System.out.println();
                    arrayPesan[i][0] = Tampung[i][0];
                    arrayPesan[i][1] = Tampung[i][1];
                    arrayPesan[i][2] = Tampung[i][2];
                    arrayPesan[i][3] = Tampung[i][3];
                } else {
                    System.out.println();
                    arrayPesan[i][0] = Tampung[i + 1][0];
                    arrayPesan[i][1] = Tampung[i + 1][1];
                    arrayPesan[i][2] = Tampung[i + 1][2];
                    arrayPesan[i][3] = Tampung[i + 1][3];
                }
            }
            return arrayPesan;
        }
    }


    public static void showPemesanan(String[][] arrayPesan) {
        System.out.println("\n===> Cetak Data Pemesanan <===");

        if (arrayPesan.length == 0) {
            System.out.println("Data tidak ada");
        } else {
            for (int i = 0; i < arrayPesan.length; i++) {
                System.out.println("Pemesanan ke-" + i);
                System.out.println("Nama Lengkap\t: " + arrayPesan[i][0]);
                System.out.println("Jenis Kelamin\t: " + arrayPesan[i][1]);
                System.out.println("Usia\t\t\t: " + arrayPesan[i][2]);
                System.out.println("No. HP\t\t\t: " + arrayPesan[i][3]);

            }
        }
    }
    public static String[][] selectionAsc(String[][] arrayPesan){
        System.out.println("\n ===> Data Diurutkan <===");
        int flag;

        String[] temp = new String[3];
        for (int i = 0; i < arrayPesan.length - 1; i++) {
            flag = i;
            for (int j = i + 1; j < arrayPesan.length; j++) {
                if (arrayPesan[j][0].compareTo(arrayPesan[flag][0]) < 0) flag = j;
            }

            if (flag != i){
                for (int j = 0; j < temp.length; j++)
                    temp[j] = arrayPesan[i][j];
                for (int j = 0; j < temp.length; j++)
                    arrayPesan[i][j] = arrayPesan[flag][j];
                for (int j = 0; j < temp.length; j++)
                    arrayPesan[flag][j] = temp[j];
            }
        }
        return arrayPesan;
    }

    private static void showMenu() {
        System.out.println("\n=====> Menu <=====");
        System.out.println("1. Pesan Tiket\n" +
                "2. Daftar Pesawat\n" +
                "3. Jadwal Penerbangan\n" +
                "4. Lihat Data Pemesanan\n" +
                "5. Hapus Data Pemesanan\n" +
                "6. Keluar");
    }

    private static void listMaskapai() {
        System.out.println("\n====> Daftar Maskapai <====");
        System.out.println("1. Garuda Indonesia (GI)\n" +
                "2. Batik Airline (BA)\n" +
                "3. LionAir (LA)");
    }
    private static void jadwalPenerbangan() {
        System.out.println("===> Jadwal dan Tujuan Penerbangan <===");
        System.out.println("1. Pukul 08.00 jakarta - surabaya\n" +
                "2. Pukul 10.00 Jakarta - bandung\n" +
                "3. Pukul 12.00 Jakarta - papua");
    }

    static String Maskapai;
    private static void selectMaskapai() {
        do {
            System.out.print("\nPilih Maskapai (GI/BA/LA) : ");
            Maskapai = InputString.next().toLowerCase();
        } while (!"gi".equals(Maskapai) && !"ba".equals(Maskapai) && !"la".equals(Maskapai));
    }

    public static void selectJadwal() {
        System.out.println("\n====> Pilih Jadwal Keberangkatan <====");
        System.out.println("1. Pukul 08.00 WIB ");
        System.out.println("2. Pukul 10.00 WIB ");
        System.out.println("3. Pukul 13.00 WIB ");
        do {
            System.out.print("\nPilih Jadwal Keberangkatan (1/2/3) : ");
            jadwalKeberangkatan = InputString.next().toLowerCase();
        } while (!"1".equals(jadwalKeberangkatan) && !"2".equals(jadwalKeberangkatan) && !"3".equals(jadwalKeberangkatan));
    }
    public static void showkelasMaskapai() {
        if ("gi".equals(Maskapai)) {
            System.out.println("\n====> Pilih kelas <====");
            System.out.println("1. Ekonomi\n" +
                    "2. Bisnis\n" +
                    "3. Eksekutif\n" +
                    "4. Ganti Maskapai");

        } else if ("ba".equals(Maskapai)) {
            System.out.println("\n====> Pilih kelas <====");
            System.out.println("1. Ekonomi\n" +
                    "2. Bisnis\n" +
                    "3. Eksekutif\n" +
                    "4. Ganti Maskapai");

        } else if ("la".equals(Maskapai)) {
            System.out.println("\n====> Pilih kelas <====");
            System.out.println("1. Ekonomi\n" +
                    "2. Bisnis\n" +
                    "3. Eksekutif\n" +
                    "4. Ganti Maskapai");

        } else {
            System.out.println("Data tidak ada");
        }
    }

    public static void selectKelas() {
        System.out.print("Pilih kelas : ");
        kelas = InputNumber.nextInt();

        if (kelas == 1) {
            System.out.println("===> Ekonomi <===");
            selectPenumpang();
            showEkonomi();
            selectJadwal();


        } else if (kelas == 2) {
            System.out.println("===> Bisnis <===");
            selectPenumpang();
            showBisnis();
            showEkonomi();

        } else if (kelas == 3) {
            System.out.println("===> Eksekutif <===");
            selectPenumpang();
            showEksekutif();
            showEkonomi();
        } else {
            System.out.println("Mengganti Maskapai");
            selectMaskapai();
        }
    }
    public static void selectPenumpang() {
        System.out.println("\n> Jenis Penumpang <");
        System.out.println("1. Dewasa (DW) ");
        System.out.println("2. Anak-anak (AN) ");
        System.out.println("3. Balita (BL) ");
        do {
            System.out.print("\nPilih Jenis Penumpang (DW/AN/BL) : ");
            jenisPenumpang = InputString.next().toLowerCase();
        } while (!"dw".equals(jenisPenumpang) && !"an".equals(jenisPenumpang) && !"bl".equals(jenisPenumpang));
    }

    private static void showEkonomi() {
        if (!"dw".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            dewasa = InputNumber.nextInt();

            int hargaDewasa = dewasa * harga_E[0];
            System.out.println("===> Total Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaDewasa);

        } else if (!"an".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            anak = InputNumber.nextInt();

            int hargaAnak = anak * harga_E[1];
            System.out.println("===> Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaAnak);

        } else if ("bl".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            balita = InputNumber.nextInt();

            int hargaBalita = balita * harga_E[2];
            System.out.println("===> Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaBalita);
        } else {
            System.out.println("Tidak ada data lain");
        }
    }
    private static void showBisnis() {
        if (!"dw".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            dewasa = InputNumber.nextInt();

            int hargaDewasa = dewasa * harga_B[0];
            System.out.println("===> Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaDewasa);

        } else if (!"an".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            anak = InputNumber.nextInt();

            int hargaAnak = anak * harga_B[1];
            System.out.println("===> Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaAnak);

        } else if ("bl".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            balita = InputNumber.nextInt();

            int hargaBalita = balita * harga_B[2];
            System.out.println("===> Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaBalita);
        }
    }

    private static void showEksekutif() {
        if (!"dw".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            dewasa = InputNumber.nextInt();

            int hargaDewasa = dewasa * harga_Eks[0];
            System.out.println("===> Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaDewasa);

        } else if (!"an".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            anak = InputNumber.nextInt();

            int hargaAnak = anak * harga_Eks[1];
            System.out.println("===> Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaAnak);

        } else if ("bl".equals(jenisPenumpang)) {
            System.out.print("Jumlah Penumpang : ");
            balita = InputNumber.nextInt();

            int hargaBalita = balita * harga_Eks[2];
            System.out.println("===> Biaya Maskapai <===");
            System.out.println("Dewasa : " + hargaBalita);
        }
    }

    private static void CheckDataPenumpang() {
        String data;

        do {
            System.out.print("Apakah data sudah benar? (Y/N) : ");
            data = InputString.next().toLowerCase();
        } while (!"y".equals(data));
        if ("y".equals(data)) {
            System.out.println("===> Data Tersimpan, silahkan melanjutkan pembayaran <===");
        } else {
            System.out.println("==> Mengulang Pengisian Data <===");
        }
    }

    public static void main(String[] args) {
//        Array untuk menyimpan nim di index ke-0, nama di index ke-1, prodi di index ke-2
        String[][] arrayPesan = new String[0][5];
        String[][] arrayAkun = new String[5][5];
        int pilih;

        showHeader();
        doRegistrasi(arrayAkun);
        doLogin(arrayAkun);
        do{
            showMenu();
            System.out.print("Pilih\t: ");
            pilih = InputNumber.nextInt();
            switch (pilih){
                case 1 :
                    arrayPesan = TambahDataPemesanan(arrayPesan);
                    listMaskapai();
                    selectMaskapai();
                    showkelasMaskapai();
                    selectKelas();
                    CheckDataPenumpang();
                    break;
                case 2 :
                    listMaskapai();
                    break;
                case 3:
                    jadwalPenerbangan();
                    break;
                case 4 :
                    arrayPesan = selectionAsc(arrayPesan);
                    showPemesanan(arrayPesan);
                    break;
                case 5 :
                    DeleteDataPemesanan(arrayPesan);
                    break;
                case 6 :
                    System.out.println("\nTerima kasih sudah mengunjungi Airline Ticketing");
                    break;
            }
        } while (pilih != 5);
    }
}

