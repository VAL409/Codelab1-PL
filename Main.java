package Modul3;

//* Kelas utama untuk menjalankan aplikasi inventaris toko.
 //*//
public class Main {
    public static void main(String[] args) {
        StoreInventory storeInventory = new StoreInventory();
        storeInventory.displayItems();

        PurchaseRequest purchaseRequest = new PurchaseRequest(ElectronicItem.LAPTOP, 2);
        storeInventory.processSale(purchaseRequest);

        PurchaseRequest returnRequest = new PurchaseRequest(ElectronicItem.LAPTOP, 1);
        storeInventory.processReturn(returnRequest);
    }
}