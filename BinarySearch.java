public class BinarySearch {
    // Metode binary search iteratif
    public static int binarySearch(int[] arr, int target) {
        int low = 0; // Inisialisasi batas bawah pencarian
        int high = arr.length - 1; // Inisialisasi batas atas pencarian
        // Selama batas bawah masih kurang atau sama dengan batas atas
        while (low <= high) {
            // Hitung indeks tengah untuk menghindari overflow
            int mid = low + (high - low) / 2;
            // Jika elemen di indeks tengah adalah target
            if (arr[mid] == target) {
                return mid; // Kembalikan indeks tempat target ditemukan
            }
            // Jika elemen tengah lebih besar dari target
            if (arr[mid] > target) {
                high = mid - 1; // Abaikan bagian kanan dengan mengatur batas atas ke mid - 1
            }
            // Jika elemen tengah lebih kecil dari target
            else {
                low = mid + 1; // Abaikan bagian kiri dengan mengatur batas bawah ke mid + 1
            }
        }
        // Target tidak ditemukan dalam array
        return -1;
    }
    public static void main(String[] args) {
        // Array yang sudah diurutkan
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        // Elemen yang ingin dicari
        int target = 23;
        // Panggil metode binarySearch dan simpan hasilnya
        int result = binarySearch(arr, target);
        // Tampilkan hasil pencarian
        if (result == -1) {
            System.out.println("Elemen " + target + " tidak ditemukan dalam array");
        } else {
            System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
        }
    }
}