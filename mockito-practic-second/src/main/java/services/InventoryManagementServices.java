package services;

import dao.InventoryManagementDAO;

public class InventoryManagementServices {
    private final InventoryManagementDAO repository;

    public InventoryManagementServices(InventoryManagementDAO repository) {
        this.repository = repository;
    }

    public boolean processOrder(String productId, int newQuantity) {

            if (!repository.isProductAvailable(productId)) { // 1. Проверить доступность
                // Если isProductAvailable выбрасывает исключение, то оно пролетит дальше
                return false;
            }

            int currentStock = repository.getStockQuantity(productId); // 2. Получить текущее количество

            if (currentStock >= newQuantity) { // 3. Проверить достаточность
                newQuantity = currentStock - newQuantity;
                repository.updateStock(productId, newQuantity); // 4. Обновить запасы
                return true;
            } else {
                return false; // 5. Недостаточно
        }
    }
}
