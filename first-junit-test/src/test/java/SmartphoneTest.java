
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartphoneTest {

    private Smartphone smartphone;

    @BeforeEach
    void setUp() {
        smartphone = new Smartphone();
    }

    @Test
    public void testIsIphone() {
        assertEquals("iPhone 12", smartphone.getName(), "Название телефона должно быть iPhone 12");
    }

    @Test
    public void testHasLargeDisplay() {
        assertFalse(smartphone.hasLargeDisplay(), "iPhone 12 не имеет большой дисплей (>6.5)");
    }

    @Test
    public void testBigBattery() {
        assertFalse(smartphone.bigBattery(), "iPhone 12 не имеет большую батарею (>4000)");
    }

    @Test
    public void testIsNewRelease() {
        assertFalse(smartphone.isNewRelease(), "iPhone 12 не новый релиз (>=2025)");
    }

    @Test
    public void testGetBattery() {
        assertEquals(2815, smartphone.getBattery(), "iPhone 12 батарея 2815 mAh");
    }

    @Test
    public void testGetYear(){
        assertEquals(2020,smartphone.getYear(), "Год выпуска 2020");
    }

    @Test
    public void testGetModel(){
        assertEquals("A2172",smartphone.getModel(),"Модель телефона A2172");
    }

    @Test
    public void testGetDisplaySize(){
        assertEquals(6.1,smartphone.getDisplaySize(),"Размеры телефона 6.1");
    }

    @Test
    public void testGetRam(){
        assertEquals("4 GB",smartphone.getRam(), "Ram 4GB");
    }
    @Test
    public void testGetRom(){
        assertEquals("64 GB",smartphone.getRom(),"Rom 64 GB");
    }


    @Test
    public void testSmartPhoneRating(){
        assertEquals("Bad phone for buy", smartphone.smartPhoneRating("4 GB", "64 GB",2815));
    }

    @Test
    public void testIsNormalDisplaySizeForUse(){
        assertEquals("Good display size", smartphone.isNormalDisplaySizeForUse(6.1));

    }

}
