import java.util.Arrays; // Mengimpor kelas Arrays untuk operasi array seperti sort dan toString
import java.util.Comparator; // Mengimpor interface Comparator (tidak digunakan di kode ini, bisa dihapus)
import java.util.Scanner; // Mengimpor kelas Scanner untuk input dari pengguna

// Interface untuk mendefinisikan perilaku pencarian secara generik
interface Searchable<T> {
    int compare(T value); // Metode pembanding yang harus diimplementasikan sesuai jenis data
}

public class GenericBinarySearch {

    // Metode binary search generik untuk semua jenis data menggunakan interface Searchable
    public static <T> int binarySearch(T[] array, Searchable<T> searchable) {
        int low = 0; // Indeks awal
        int high = array.length - 1; // Indeks akhir

        // Perulangan selama batas bawah tidak melebihi batas atas
        while (low <= high) {
            int mid = low + (high - low) / 2; // Menghitung indeks tengah

            int comparison = searchable.compare(array[mid]); // Membandingkan nilai target dengan elemen tengah

            if (comparison == 0) { // Jika cocok
                return mid; // Kembalikan indeks ditemukan
            } else if (comparison < 0) { // Jika target lebih kecil
                high = mid - 1; // Persempit ke kiri
            } else { // Jika target lebih besar
                low = mid + 1; // Persempit ke kanan
            }
        }

        return -1; // Data tidak ditemukan
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input

        System.out.println("=== SISTEM PENCARIAN DATASET ===");
        System.out.println("Pilih jenis data yang ingin dicari:");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        System.out.println("3. String");
        System.out.print("Pilihan Anda (1-3): ");

        int pilihan = scanner.nextInt(); // Membaca input pilihan dari user
        scanner.nextLine(); // Membersihkan buffer setelah nextInt()

        switch (pilihan) { // Menentukan jenis data berdasarkan pilihan user
            case 1:
                // Pencarian data Integer
                Integer[] dataInteger = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; // Dataset integer

                System.out.println("\nData Integer: " + Arrays.toString(dataInteger)); // Menampilkan dataset
                System.out.print("Masukkan nilai integer yang dicari: ");
                int targetInt = scanner.nextInt(); // Membaca nilai yang dicari

                // Memanggil binary search dengan implementasi interface Searchable secara anonim
                int indexInt = binarySearch(dataInteger, new Searchable<Integer>() {
                    @Override
                    public int compare(Integer value) {
                        return targetInt - value; // Hasil perbandingan
                    }
                });

                // Menampilkan hasil pencarian
                if (indexInt != -1) {
                    System.out.println("Nilai " + targetInt + " ditemukan pada indeks " + indexInt);
                } else {
                    System.out.println("Nilai " + targetInt + " tidak ditemukan dalam dataset");
                }
                break;

            case 2:
                // Pencarian data Double
                Double[] dataDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9}; // Dataset double

                System.out.println("\nData Double: " + Arrays.toString(dataDouble)); // Menampilkan dataset
                System.out.print("Masukkan nilai double yang dicari: ");
                double targetDouble = scanner.nextDouble(); // Membaca nilai yang dicari

                // Binary search untuk Double menggunakan compare bawaan
                int indexDouble = binarySearch(dataDouble, new Searchable<Double>() {
                    @Override
                    public int compare(Double value) {
                        return Double.compare(targetDouble, value); // Gunakan metode compare untuk double
                    }
                });

                // Menampilkan hasil pencarian
                if (indexDouble != -1) {
                    System.out.println("Nilai " + targetDouble + " ditemukan pada indeks " + indexDouble);
                } else {
                    System.out.println("Nilai " + targetDouble + " tidak ditemukan dalam dataset");
                }
                break;

            case 3:
                // Pencarian data String
                String[] dataString = {"alpha", "beta", "delta", "gamma", "omega", "sigma", "theta", "zeta"};
                Arrays.sort(dataString); // Mengurutkan array String agar bisa digunakan binary search

                System.out.println("\nData String: " + Arrays.toString(dataString)); // Menampilkan dataset
                System.out.print("Masukkan string yang dicari: ");
                String targetString = scanner.nextLine(); // Membaca string target

                // Binary search untuk String dengan compareTo
                int indexString = binarySearch(dataString, new Searchable<String>() {
                    @Override
                    public int compare(String value) {
                        return targetString.compareTo(value); // Gunakan compareTo untuk String
                    }
                });

                // Menampilkan hasil pencarian
                if (indexString != -1) {
                    System.out.println("String \"" + targetString + "\" ditemukan pada indeks " + indexString);
                } else {
                    System.out.println("String \"" + targetString + "\" tidak ditemukan dalam dataset");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid!"); // Jika input user di luar 1-3
        }

        scanner.close(); // Menutup Scanner
    }
}