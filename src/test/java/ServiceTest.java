import empoloeeLab.Service;
import empoloeeLab.exception.ValidationException;
import org.testng.annotations.*;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

/**
 * All rights reserved
 * <p>
 * Created by Anna_Slizun on 3/31/2018.
 */
@Test
public class ServiceTest {

    private Service service;

    @BeforeTest
    void setUp(){
        service = new Service();
    }

    @DataProvider(name = "surnameProvider")
    public static Object[] getData(){
        return new Object[]{"Bin", "Taylor", "Abcd"};

    }

    @Test(expectedExceptions = ValidationException.class, dataProvider = "surnameProvider",
    description = "Should throw exception when name is null")
    public void testNullCase(String surname) throws ValidationException {
       // assertEquals("Taylor", surname);
        service.register(null, surname, "@.com");
    }

    @Test(groups = "brokenTests")
    public void testNullCase2() throws ValidationException {
        service.register(null, "Taylor", "@.com");
    }

}
