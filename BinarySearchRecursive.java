// Program ini menggunakan pendekatan rekursif untuk melakukan pencarian biner dalam Java.
public class BinarySearchRecursive {

    // Fungsi utama yang dieksekusi pertama kali saat program dijalankan.
    public static void main(String[] args) {
        // Membuat array yang sudah diurutkan.
        int[] data = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        // Nilai yang akan dicari di dalam array.
        int target = 14;

        // Menjalankan fungsi binarySearch dengan cara rekursif untuk menemukan posisi target.
        int result = binarySearch(data, 0, data.length - 1, target);

        // Menampilkan hasil pencarian apakah data ditemukan atau tidak.
        if (result == -1)
            System.out.println("Elemen tidak ditemukan dalam array.");
        else
            System.out.println("Elemen ditemukan pada indeks: " + result);
    }

    // Metode rekursif untuk melakukan pencarian biner.
    public static int binarySearch(int[] arr, int left, int right, int key) {
        // Cek apakah batas kiri masih berada dalam rentang pencarian.
        if (right >= left) {
            // Menentukan indeks tengah dari area pencarian saat ini.
            int mid = left + (right - left) / 2;

            // Jika elemen pada posisi tengah sama dengan nilai yang dicari, kembalikan posisinya.
            if (arr[mid] == key)
                return mid;

            // Jika nilai di tengah lebih besar dari yang dicari, lakukan pencarian di sisi kiri.
            if (arr[mid] > key)
                return binarySearch(arr, left, mid - 1, key);

            // Jika nilai di tengah lebih kecil, cari di sisi kanan.
            return binarySearch(arr, mid + 1, right, key);
        }

        // Bila nilai tidak ditemukan, kembalikan -1.
        return -1;
    }
}
