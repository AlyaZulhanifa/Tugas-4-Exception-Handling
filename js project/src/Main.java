import java.util.Scanner;

// Parent class (Superclass) - Barang
class Barang {
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;

    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public void displayInfo() {
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Barang: Rp" + hargaBarang);
    }
}

// Child class (Subclass) - Transaksi
class Transaksi extends Barang {
    private String noFaktur;
    private int jumlahBeli;
    private double total;

    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang) {
        super(kodeBarang, namaBarang, hargaBarang); // Memanggil constructor parent class
        this.noFaktur = noFaktur;
    }

    public void setJumlahBeli(int jumlahBeli) throws IllegalArgumentException {
        if (jumlahBeli <= 0) {
            throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!");
        }
        this.jumlahBeli = jumlahBeli;
        this.total = jumlahBeli * hargaBarang;
    }

    public void displayTransaksi() {
        System.out.println("No Faktur: " + noFaktur);
        displayInfo(); // Memanggil method dari parent class
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total Harga: Rp " + total);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input Data Barang dan Transaksi
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();

            // Membuat objek Transaksi
            Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang);

            // Mengatur jumlah beli dengan exception handling
            transaksi.setJumlahBeli(jumlahBeli);

            // Menampilkan informasi transaksi
            System.out.println("\n=== Informasi Transaksi ===");
            transaksi.displayTransaksi();

        } catch (IllegalArgumentException e) {
            // Menangani kesalahan input jumlah beli
            System.out.println("Kesalahan: " + e.getMessage());
        } catch (Exception e) {
            // Menangani kesalahan umum lainnya
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
