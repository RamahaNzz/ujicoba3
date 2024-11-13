import java.util.Scanner;

/**
 * Kelas KalkulatorSederhana adalah program kalkulator sederhana yang
 * dapat melakukan operasi dasar seperti penjumlahan, pengurangan,
 * perkalian, dan pembagian.
 *
 * Program ini menerima dua angka dari pengguna dan sebuah operator,
 * lalu menghitung hasil operasi tersebut. Operasi pembagian dengan nol
 * akan menghasilkan pesan error.
 */
public class KalkulatorSederhana {

    /**
     * Metode utama untuk menjalankan program kalkulator.
     * Program ini meminta input dua angka dan operator dari pengguna,
     * lalu menampilkan hasil operasi yang dipilih.
     *
     * @ramahan args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Kalkulator Sederhana ===");
        double angka1 = getInput("Masukkan angka pertama: ", scanner);
        double angka2 = getInput("Masukkan angka kedua: ", scanner);

        System.out.print("Pilih operasi (+, -, *, /): ");
        char operasi = scanner.next().charAt(0);

        Double hasil = hitung(angka1, angka2, operasi);
        if (hasil != null) {
            System.out.println("Hasil: " + hasil);
        }

        scanner.close();
    }

    /**
     * Meminta input angka dari pengguna.
     *
     * @ramahan prompt pesan yang ditampilkan kepada pengguna
     * @ramahan scanner objek Scanner untuk membaca input pengguna
     * @return nilai double yang dimasukkan oleh pengguna
     */
    private static double getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    /**
     * Menghitung hasil operasi aritmatika berdasarkan angka dan operator yang diberikan.
     * Operasi yang didukung adalah penjumlahan (+), pengurangan (-),
     * perkalian (*), dan pembagian (/).
     *
     * Jika terjadi pembagian dengan nol, metode ini akan menampilkan
     * pesan error dan mengembalikan nilai null.
     *
     * @ramahan angka1 angka pertama dalam operasi
     * @ramahan angka2 angka kedua dalam operasi
     * @ramahan operasi karakter yang menunjukkan operasi aritmatika ('+', '-', '*', '/')
     * @return hasil operasi sebagai Double, atau null jika operator tidak valid atau pembagian dengan nol
     */
    private static Double hitung(double angka1, double angka2, char operasi) {
        switch (operasi) {
            case '+':
                return angka1 + angka2;
            case '-':
                return angka1 - angka2;
            case '*':
                return angka1 * angka2;
            case '/':
                if (angka2 != 0) {
                    return angka1 / angka2;
                } else {
                    System.out.println("Error: Pembagian dengan nol tidak diperbolehkan.");
                    return null;
                }
            default:
                System.out.println("Operasi tidak valid.");
                return null;
        }
    }
}
