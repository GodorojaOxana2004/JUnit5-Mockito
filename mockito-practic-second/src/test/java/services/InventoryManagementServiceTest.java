package services;

import dao.InventoryManagementDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InventoryManagementServiceTest {


    // ЭТО МОК! Не настоящий DAO, а "подделка"
    // Мы сами говорим ему что возвращать
    @Mock
    private InventoryManagementDAO daoMock;


    // Это РЕАЛЬНЫЙ сервис, но с МОКИРОВАННЫМ DAO внутри
    // @InjectMocks автоматически вставляет мок в сервис
    @InjectMocks
    private InventoryManagementServices servicesMock;


    @Test
    public void shouldProcessOrderSuccessfully(){
        String productId = "A101";
        int stockAvailable = 100;
        int orderQuantity = 30;
        int expectedNewStock = 70;

        when(daoMock.isProductAvailable(productId)).thenReturn(true);
        when(daoMock.getStockQuantity(productId)).thenReturn(stockAvailable);


        boolean result = servicesMock.processOrder(productId,expectedNewStock);

        assertTrue(result,"Successfully order");

        // ВАЖНО: Проверяем что сервис ПРАВИЛЬНО ВЫЗВАЛ метод updateStock
        // Мы НЕ ПРОВЕРЯЕМ работу updateStock (это делает интеграционный тест)
        // Мы проверяем что сервис ВЫЗВАЛ его с ПРАВИЛЬНЫМИ параметрами
        verify(daoMock,times(1)).updateStock(productId,expectedNewStock);
    }


    @Test
    public void shouldFailWhenInsufficientStock(){
        String productId = "B202";
        int stockAvailable = 5;
        int orderQuantity = 10;

        when(daoMock.isProductAvailable(productId)).thenReturn(true);
        when(daoMock.getStockQuantity(productId)).thenReturn(stockAvailable);

        boolean result = servicesMock.processOrder(productId,orderQuantity);

        assertFalse(result, "Failed order");

        verify(daoMock,never()).updateStock(anyString(),anyInt());
    }


    @Test
    public void shouldFailWhenProductNotAvailable(){
        String productId = "D404";
        int orderQuantity = 50;

        when(daoMock.isProductAvailable(productId)).thenReturn(false);
        when(daoMock.getStockQuantity(productId)).thenReturn(orderQuantity);

        boolean result =  servicesMock.processOrder(productId,orderQuantity);

        assertFalse(result,"Failed order");


        verify(daoMock,never()).getStockQuantity(anyString());
        verify(daoMock,never()).updateStock(anyString(),anyInt());
    }


}
