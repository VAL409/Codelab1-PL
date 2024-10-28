# Store Inventory Management

Store Inventory Management adalah program berbasis Java yang dirancang untuk mengelola inventaris dan transaksi penjualan alat elektronik. Program ini mencakup fitur untuk memproses penjualan dan pengembalian, serta menampilkan jumlah barang yang tersedia di inventaris.

## Fitur

- **Pengelolaan Inventaris**: Memungkinkan untuk mengatur jumlah alat elektronik yang tersedia.
- **Penjualan dan Pengembalian**: Mampu memproses permintaan penjualan dan pengembalian barang berdasarkan stok yang tersedia.
- **Dukungan Item Elektronik**: Mendukung item elektronik seperti laptop, smartphone, dan tablet.
- **Tampilan Inventaris**: Menampilkan jumlah barang yang tersedia di dalam inventaris.

## Struktur Program

- **ElectronicItem**: Enum untuk mendefinisikan jenis alat elektronik yang tersedia (LAPTOP, SMARTPHONE, TABLET).
- **PurchaseRequest**: Kelas untuk merepresentasikan permintaan pembelian atau pengembalian alat elektronik, termasuk validasi ketersediaan barang dan pembaruan jumlah barang dalam inventaris.
- **StoreInventory**: Kelas utama untuk mengelola inventaris, memproses penjualan, pengembalian, dan menampilkan jumlah alat elektronik yang tersedia.

## Penggunaan

1. **Inisialisasi Inventaris**: Saat `StoreInventory` diinisialisasi, jumlah default setiap item elektronik ditentukan (Laptop: 10, Smartphone: 15, Tablet: 5).
2. **Proses Penjualan**:
   - Membuat objek `PurchaseRequest` dengan jenis item dan jumlah yang diinginkan.
   - Memanggil `processSale(PurchaseRequest)` untuk memproses penjualan.
   - Jika barang tersedia dalam jumlah yang mencukupi, maka inventaris diperbarui, dan jumlah barang yang terjual dicatat.
3. **Proses Pengembalian**:
   - Membuat objek `PurchaseRequest` dengan jenis item dan jumlah yang ingin dikembalikan.
   - Memanggil `processReturn(PurchaseRequest)` untuk memproses pengembalian.
   - Jika jumlah pengembalian valid (tidak melebihi jumlah yang terjual), maka inventaris diperbarui.
4. **Menampilkan Inventaris**: Memanggil `displayItems()` untuk menampilkan jumlah alat elektronik yang tersedia saat ini.

## Contoh Penggunaan

```java
public class Main {
    public static void main(String[] args) {
        StoreInventory store = new StoreInventory();

        // Tampilkan inventaris awal
        store.displayItems();

        // Proses penjualan
        PurchaseRequest saleRequest = new PurchaseRequest(ElectronicItem.LAPTOP, 2);
        store.processSale(saleRequest);

        // Tampilkan inventaris setelah penjualan
        store.displayItems();

        // Proses pengembalian
        PurchaseRequest returnRequest = new PurchaseRequest(ElectronicItem.LAPTOP, 1);
        store.processReturn(returnRequest);

        // Tampilkan inventaris setelah pengembalian
        store.displayItems();
    }
}
