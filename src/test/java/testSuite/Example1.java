package testSuite;

import driver.BaseConfig;
import driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.Test;
import testClases.TestCarrusel;
import static report.AllureReport.addStep;

public class Example1 extends BaseConfig {


    @Test
    public void test(){
        MobileElement botonNext = (MobileElement) DriverContext.getDriver().findElementById("com.rodrigo.registro:id/next");
        botonNext.click();
        addStep("validar vista", true, Status.PASSED, false);
    }

    @Test
    public void testCarrusel(){
        TestCarrusel testCarrusel = new TestCarrusel();
        testCarrusel.validaciones();
    }
}
