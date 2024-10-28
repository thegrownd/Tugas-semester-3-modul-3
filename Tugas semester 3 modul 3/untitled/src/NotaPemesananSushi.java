import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NotaPemesananSushi {

    private static final Map<String, Integer> daftarMenu = new HashMap<>();
    
        // Menggunakan live template naga
        static {
                daftarMenu.put("Sushi Salmon", 60000);
                daftarMenu.put("Sushi Tuna", 55000);
                daftarMenu.put("Sushi Ebi", 50000);
                daftarMenu.put("Sushi Unagi", 70000);
                daftarMenu.put("Sashimi", 75000);
                daftarMenu.put("Miso Soup", 20000);
            }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> pesanan = new HashMap<>();

        System.out.println("Selamat Datang di Restoran Sushi Kami");
        tampilkanMenu();

        while (true) {
            System.out.print("\nMasukkan nama sushi yang ingin dipesan (ketik 'selesai' jika sudah selesai): ");
            String namaItem = input.nextLine();

            if (namaItem.equalsIgnoreCase("selesai")) {
                break;
            } else if (!daftarMenu.containsKey(namaItem)) {
                System.out.println("Maaf, item tersebut tidak ada di menu Silakan pilih yang lain");
            } else {
                System.out.print("Masukkan jumlah: ");
                int jumlah = input.nextInt();
                input.nextLine();

                pesanan.put(namaItem, pesanan.getOrDefault(namaItem, 0) + jumlah);
            }
        }

        tampilkanNota(pesanan);
        input.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\nDaftar Menu Sushi");
        for (Map.Entry<String, Integer> item : daftarMenu.entrySet()) {
            System.out.printf("%s: Rp %d\n", item.getKey(), item.getValue());
        }
    }

    private static int hitungTotal(Map<String, Integer> pesanan) {
        int total = 0;
        for (Map.Entry<String, Integer> item : pesanan.entrySet()) {
            String namaItem = item.getKey();
            int jumlah = item.getValue();
            total += daftarMenu.get(namaItem) * jumlah;
        }
        return total;
    }

    private static void tampilkanNota(Map<String, Integer> pesanan) {
        System.out.println("\n--- Ringkasan Pemesanan Anda ---");
        for (Map.Entry<String, Integer> item : pesanan.entrySet()) {
            String namaItem = item.getKey();
            int jumlah = item.getValue();
            int harga = daftarMenu.get(namaItem) * jumlah;
            System.out.printf("%s x %d = Rp %d\n", namaItem, jumlah, harga);
        }
        System.out.printf("Total Bayar: Rp %d\n", hitungTotal(pesanan));
        System.out.println("------------------------------");
    }
}
