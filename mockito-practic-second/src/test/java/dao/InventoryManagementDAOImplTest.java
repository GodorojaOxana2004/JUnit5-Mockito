package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit test
 * Здесь НЕТ моков, потому что мы проверяем как работает настоящий код
 */
public class InventoryManagementDAOImplTest {

    private void initializeTestData() {

    }
    private InventoryManagementDAOImpl dao;
    @BeforeEach
    void setUp(){
        dao = new InventoryManagementDAOImpl();
        dao.getInventory().put("A101", 100);
        dao.getInventory().put("B202", 50);
        dao.getInventory().put("C303", 25);
        dao.getInventory().put("D404", 0);
    }

    @Test
    public void getStockQuantityTest(){
        int quantity = dao.getStockQuantity("A101");

        assertEquals(100,quantity, "Gonna be 100 quantity");

    }

    @Test
    public void updateStockTest(){
        dao.updateStock("A101", 80);

        int updateStock = dao.getStockQuantity("A101");

        assertEquals(80,updateStock, "Gonna be 80 stock");
    }

    @Test
    public void isProductAvailableTest(){
        boolean isProduct = dao.isProductAvailable("A101");

        assertTrue(isProduct, "Gonna be A101");

    }




    }


