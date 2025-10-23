import dao.InventoryManagementDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import service.InventoryManagementServices;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StockManagerTest {
    @Mock
    private InventoryManagementDAO repositoryMock; //имитация объекта дао

    @Mock
    private InventoryManagementServices servicesMock; //имитация сервиса

    @BeforeEach
    void setUp(){

        repositoryMock = mock(InventoryManagementDAO.class);

        servicesMock = new InventoryManagementServices(repositoryMock);// создание зависимости между классами
    }

    @Test

    public void happyOrder(){
        String productId = "A101";
        int stockAvailable = 100;
        int orderQuantity = 30;
        int expectedNewStock = 70;

        when(repositoryMock.isProductAvailable(productId)).thenReturn(true);
        when(repositoryMock.getStockQuantity(productId)).thenReturn(stockAvailable);

        boolean result = servicesMock.processOrder(productId, orderQuantity);

        assertTrue(result, "True is correct answer");

        verify(repositoryMock,times(1)).updateStock("A101",expectedNewStock);
    }

    @Test
    public void FailureScenario(){
        String productId = "B202";
        int stockAvailable = 5;
        int orderQuantity = 10;

        when(servicesMock.processOrder(productId,orderQuantity)).thenReturn(false);

        when(repositoryMock.getStockQuantity(productId)).thenReturn(stockAvailable);

        when(servicesMock.processOrder(productId, orderQuantity)).thenReturn(false);

        assertFalse(servicesMock.processOrder(productId,orderQuantity));

        verify(repositoryMock,never()).updateStock(anyString(),anyInt());
    }

    @Test
    public void ExeptionFromRepo(){
        String productId = "C303";

        when(repositoryMock.isProductAvailable(productId))
                .thenThrow(new RuntimeException("DB connection fail"));

        assertThrows(RuntimeException.class,() ->{
            servicesMock.processOrder(productId, 1);
                },"See Exeption");

        verify(repositoryMock,never()).updateStock(anyString(),anyInt());
    }

}
