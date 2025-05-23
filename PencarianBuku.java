// Program ini melakukan pencarian judul buku dalam daftar menggunakan algoritma binary search.
import java.util.Arrays;
import java.util.Scanner;

public class PencarianBuku {

    // Fungsi utama yang pertama kali dijalankan saat program dieksekusi.
    public static void main(String[] args) {
        // Array berisi daftar judul buku.
        String[] koleksiBuku = {
            "Laskar Pelangi", "Negeri 5 Menara", "Ayat-Ayat Cinta",
            "Bumi", "Hujan", "Pulang"
        };

        // Mengurutkan judul-judul buku agar sesuai dengan syarat binary search.
        Arrays.sort(koleksiBuku);

        // Menyediakan fasilitas input untuk pengguna.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul buku yang ingin Anda cari: ");
        String judulDicari = scanner.nextLine();

        // Melakukan pencarian posisi judul buku dengan binary search.
        int indeks = Arrays.binarySearch(koleksiBuku, judulDicari);

        // Menentukan apakah buku ditemukan atau tidak, lalu menampilkan hasilnya.
        if (indeks >= 0) {
            System.out.println("Buku \"" + judulDicari + "\" ditemukan di indeks ke-" + indeks);
        } else {
            System.out.println("Buku \"" + judulDicari + "\" tidak tersedia dalam koleksi.");
        }

        // Menutup objek scanner setelah selesai digunakan.
        scanner.close();
    }
}
