package Modul3;
import java.util.HashMap;
import java.util.Map;

/**Enum untuk mendefinisikan jenis alat elektronik yang dijual*/
enum ElectronicItem {
    LAPTOP, SMARTPHONE, TABLET
}

/**Objek Parameter untuk menyimpan data pembelian alat elektronik*/
class PurchaseRequest {
    private final ElectronicItem item;
    private final int quantity;

    /**Konstruktor untuk membuat objek PurchaseRequest.
     @param item     jenis alat elektronik yang akan dibeli
     @param quantity jumlah alat elektronik yang akan dibeli
     */
    public PurchaseRequest(ElectronicItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**Mendapatkan jenis alat elektronik dari permintaan pembelian.
     @return jenis alat elektronik
     */
    public ElectronicItem getItem() {
        return item;
    }

    /**Mendapatkan jumlah alat elektronik yang akan dibeli.
     @return jumlah alat elektronik
     */
    public int getQuantity() {
        return quantity;
    }

    /**Mengecek apakah alat elektronik yang diminta tersedia dalam inventaris.
     @param items inventaris alat elektronik
     @return true jika alat elektronik tersedia dalam jumlah yang cukup
     */
    public boolean isItemAvailable(Map<ElectronicItem, Integer> items) {
        return items.containsKey(item) && items.get(item) >= quantity;
    }

    /**Memperbarui jumlah alat elektronik dalam inventaris.
     @param items  inventaris alat elektronik
     @param change perubahan jumlah (positif untuk penambahan, negatif untuk pengurangan)
     */
    public void updateInventory(Map<ElectronicItem, Integer> items, int change) {
        items.put(item, items.get(item) + change);
    }
}

/**Kelas StoreInventory untuk mengelola penjualan dan pengembalian alat elektronik.
 */
class StoreInventory {
    private final Map<ElectronicItem, Integer> items = new HashMap<>();
    private final Map<ElectronicItem, Integer> soldItems = new HashMap<>();

    /**Konstruktor untuk membuat inventaris awal dengan jumlah alat elektronik.
     */
    public StoreInventory() {
        items.put(ElectronicItem.LAPTOP, 10);
        items.put(ElectronicItem.SMARTPHONE, 15);
        items.put(ElectronicItem.TABLET, 5);
    }

    /**Memproses penjualan alat elektronik berdasarkan permintaan pembelian.
     @param request permintaan pembelian yang berisi jenis dan jumlah alat elektronik
     */
    public void processSale(PurchaseRequest request) {
        if (request.isItemAvailable(items)) {
            request.updateInventory(items, -request.getQuantity());
            soldItems.put(request.getItem(), soldItems.getOrDefault(request.getItem(), 0) + request.getQuantity());
            System.out.println(request.getQuantity() + " " + request.getItem() + " telah terjual.");
        } else {
            System.out.println("Barang tidak tersedia atau jumlah tidak mencukupi.");
        }
    }


    /**Memproses pengembalian alat elektronik berdasarkan permintaan pengembalian.
     *permintaan pengembalian yang berisi jenis dan jumlah alat elektronik*/

    public void processReturn(PurchaseRequest request) {
        if (soldItems.containsKey(request.getItem()) && soldItems.get(request.getItem()) >= request.getQuantity()) {
            request.updateInventory(items, request.getQuantity());
            soldItems.put(request.getItem(), soldItems.get(request.getItem()) - request.getQuantity());
            System.out.println(request.getQuantity() + " " + request.getItem() + " telah dikembalikan.");
        } else {
            System.out.println("Jumlah pengembalian melebihi jumlah yang terjual atau barang tidak dijual.");
        }
    }


     /**Menampilkan daftar alat elektronik yang tersedia beserta jumlahnya.*/

    public void displayItems() {
        System.out.println("Daftar Alat Elektronik:");
        for (Map.Entry<ElectronicItem, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

