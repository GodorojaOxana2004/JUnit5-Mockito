import com.example.mockitotraining.model.Customer;
import com.example.mockitotraining.repository.CustomerRepository;
import com.example.mockitotraining.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Test
    void calculateDiscountForVip(){

        CustomerRepository mockRepository = Mockito.mock(CustomerRepository.class);

        when(mockRepository.findById(1L))
                .thenReturn(new Customer(1L,"VIP"));


        CustomerService service = new CustomerService(mockRepository);

        double result = service.calculateDiscount(1L,100.0);

        assertEquals(80.0,result);

        verify(mockRepository, times(1)).findById(1L);
    }

    @Test
    void testCalculateDiscountForRegular() {
        CustomerRepository mockRepository = mock(CustomerRepository.class);
        when(mockRepository.findById(2L))
                .thenReturn(new Customer(2L, "REGULAR"));

        CustomerService service = new CustomerService(mockRepository);
        double result = service.calculateDiscount(2L, 100.0);

        assertEquals(90.0, result); //10% скидка
        verify(mockRepository, times(1)).findById(2L);
    }

    @Test
    void testCalculateDiscountForNewCustomer() {
        CustomerRepository mockRepository = mock(CustomerRepository.class);
        when(mockRepository.findById(3L))
                .thenReturn(new Customer(3L, "NEW"));

        CustomerService service = new CustomerService(mockRepository);
        double result = service.calculateDiscount(3L, 100.0);

        assertEquals(100.0, result); //нет скидки
        verify(mockRepository, times(1)).findById(3L);
    }


}
