package dao;

public interface InventoryManagementDAO {
    int getStockQuantity(String productId);
    void updateStock(String productId, int newQuantity);
    boolean isProductAvailable(String productId);
}
