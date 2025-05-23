import java.time.LocalDate; // Mengimpor kelas LocalDate untuk menangani tanggal
import java.time.format.DateTimeFormatter; // Mengimpor kelas DateTimeFormatter untuk format tanggal
import java.util.Scanner; // Mengimpor kelas Scanner untuk input dari pengguna

// Kelas Acara untuk merepresentasikan informasi suatu acara
class Acara {
    LocalDate tanggal; // Menyimpan tanggal acara
    String nama;       // Menyimpan nama acara
    String lokasi;     // Menyimpan lokasi acara
    String deskripsi;  // Menyimpan deskripsi acara

    // Konstruktor untuk menginisialisasi objek Acara
    public Acara(LocalDate tanggal, String nama, String lokasi, String deskripsi) {
        this.tanggal = tanggal;   // Mengatur tanggal acara
        this.nama = nama;         // Mengatur nama acara
        this.lokasi = lokasi;     // Mengatur lokasi acara
        this.deskripsi = deskripsi; // Mengatur deskripsi acara
    }

    // Override method toString untuk menampilkan detail acara dengan format rapi
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy"); // Format tanggal jadi format lokal
        return String.format("Tanggal: %s\nNama Acara: %s\nLokasi: %s\nDeskripsi: %s",
                            tanggal.format(formatter), nama, lokasi, deskripsi); // Mengembalikan informasi acara
    }
}

// Kelas utama tempat program dijalankan
public class PencarianAcara {
    public static void main(String[] args) {
        // Array berisi daftar acara yang sudah diurutkan berdasarkan tanggal
        Acara[] jadwalAcara = {
            new Acara(LocalDate.of(2025, 5, 10), "Workshop Java", "Ruang Pelatihan A", "Workshop dasar pemrograman Java"),
            new Acara(LocalDate.of(2025, 5, 15), "Seminar AI", "Aula Utama", "Seminar tentang perkembangan Artificial Intelligence"),
            new Acara(LocalDate.of(2025, 5, 20), "Kompetisi Coding", "Lab Komputer", "Kompetisi coding untuk mahasiswa"),
            new Acara(LocalDate.of(2025, 5, 25), "Tech Talk", "Auditorium", "Diskusi tentang teknologi terbaru"),
            new Acara(LocalDate.of(2025, 6, 1), "Career Fair", "Gedung Serbaguna", "Pameran karir bidang IT"),
            new Acara(LocalDate.of(2025, 6, 5), "Webinar Cloud Computing", "Online", "Webinar tentang teknologi cloud"),
            new Acara(LocalDate.of(2025, 6, 10), "Hackathon", "Co-Working Space", "Hackathon 24 jam"),
            new Acara(LocalDate.of(2025, 6, 15), "Workshop Database", "Ruang Pelatihan B", "Workshop database SQL dan NoSQL"),
            new Acara(LocalDate.of(2025, 6, 20), "Game Development Talk", "Ruang Multimedia", "Diskusi tentang pengembangan game")
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna

        System.out.println("=== SISTEM PENCARIAN ACARA ==="); // Menampilkan judul aplikasi
        System.out.println("Format tanggal: yyyy-MM-dd (contoh: 2025-05-20)"); // Menampilkan petunjuk format input
        System.out.print("Masukkan tanggal yang ingin dicari: "); // Meminta pengguna memasukkan tanggal
        String tanggalInput = scanner.nextLine(); // Membaca input tanggal dari pengguna

        try {
            LocalDate tanggalCari = LocalDate.parse(tanggalInput); // Mengubah input string menjadi objek LocalDate

            int index = cariAcaraByTanggal(jadwalAcara, tanggalCari); // Melakukan pencarian acara berdasarkan tanggal

            System.out.println("\nHASIL PENCARIAN:"); // Menampilkan header hasil pencarian
            if (index != -1) { // Jika acara ditemukan
                System.out.println("Acara ditemukan pada tanggal " + tanggalInput + "!"); // Tampilkan info sukses
                System.out.println(jadwalAcara[index]); // Tampilkan detail acara
            } else {
                System.out.println("Tidak ada acara yang terjadwal pada tanggal " + tanggalInput + "."); // Jika tidak ditemukan
            }
        } catch (Exception e) { // Menangani error parsing tanggal (misal salah format)
            System.out.println("Format tanggal tidak valid. Gunakan format yyyy-MM-dd."); // Pesan kesalahan format
        }

        scanner.close(); // Menutup scanner untuk mencegah memory leak
    }

    // Metode binary search untuk mencari acara berdasarkan tanggal
    public static int cariAcaraByTanggal(Acara[] jadwalAcara, LocalDate tanggal) {
        int low = 0; // Inisialisasi batas bawah
        int high = jadwalAcara.length - 1; // Inisialisasi batas atas

        // Selama masih ada rentang pencarian
        while (low <= high) {
            int mid = low + (high - low) / 2; // Menghitung indeks tengah secara aman

            if (jadwalAcara[mid].tanggal.isEqual(tanggal)) { // Jika tanggal di tengah sama dengan yang dicari
                return mid; // Kembalikan indeks acara
            }

            if (jadwalAcara[mid].tanggal.isAfter(tanggal)) { // Jika tanggal tengah lebih besar dari target
                high = mid - 1; // Geser pencarian ke kiri
            } else {
                low = mid + 1; // Geser pencarian ke kanan
            }
        }

        return -1; // Jika tidak ditemukan, kembalikan -1
    }
}