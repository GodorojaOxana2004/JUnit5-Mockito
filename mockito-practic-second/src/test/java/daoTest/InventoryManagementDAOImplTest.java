package daoTest;

import dao.InventoryManagementDAOImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ИНТЕГРАЦИОННЫЙ ТЕСТ - тестируем РЕАЛЬНУЮ реализацию DAO
 * Здесь НЕТ моков, потому что мы проверяем как работает настоящий код
 */
public class InventoryManagementDAOImplTest {


    private InventoryManagementDAOImpl dao;
    @BeforeEach
    void setUp(){
        dao = new InventoryManagementDAOImpl();
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


