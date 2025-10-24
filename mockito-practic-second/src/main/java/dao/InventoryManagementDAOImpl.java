package dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManagementDAOImpl implements InventoryManagementDAO{

    private final Map<String,Integer> inventory;

    public InventoryManagementDAOImpl() {
        this.inventory = new ConcurrentHashMap<>();
        initializeTestData();
    }

    public InventoryManagementDAOImpl(Map<String,Integer> inventory) {
        this.inventory = new ConcurrentHashMap<>(inventory);
    }

    private void initializeTestData() {
        inventory.put("A101", 100);
        inventory.put("B202", 50);
        inventory.put("C303", 25);
        inventory.put("D404", 0);
    }
    private void validateProductId(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
    }
    @Override
    public int getStockQuantity(String productId) {
        validateProductId(productId);

        if(!inventory.containsKey(productId)){
            throw new IllegalArgumentException("Product not found" + productId);
        }

        return inventory.get(productId);
    }


    @Override
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

    @Override
    public boolean isProductAvailable(String productId) {
        validateProductId(productId);
        return inventory.containsKey(productId) && inventory.get(productId) > 0;
    }

}
