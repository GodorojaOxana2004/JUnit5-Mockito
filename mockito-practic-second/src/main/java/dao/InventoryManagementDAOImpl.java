package dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManagementDAOImpl implements InventoryManagementDAO{

    private final Map<String,Integer> inventory;

    public InventoryManagementDAOImpl() {
        this.inventory = new ConcurrentHashMap<>();
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    private void validateProductId(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
    }

    public int getStockQuantity(String productId) {
        validateProductId(productId);

        if(!inventory.containsKey(productId)){
            throw new IllegalArgumentException("Product not found" + productId);
        }

        return inventory.get(productId);
    }



    public void updateStock(String productId, int newQuantity) {
        validateProductId(productId);

        if (newQuantity < 0 ){
            throw new IllegalArgumentException("Not be new quantity null" + newQuantity);
        }

        if(!inventory.containsKey(productId)){
            throw new IllegalArgumentException("Product not found" + productId);
        }

        inventory.put(productId,newQuantity);
    }


    public boolean isProductAvailable(String productId) {
        validateProductId(productId);
        return inventory.containsKey(productId) && inventory.get(productId) > 0;
    }

}
