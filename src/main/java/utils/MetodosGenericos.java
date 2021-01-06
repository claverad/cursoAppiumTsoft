package utils;

import driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MetodosGenericos {

    public static boolean esperarObjeto(MobileElement elemento, int tiempo){
        try {
            System.out.println("Buscando elemento: [ "+elemento+" ]" + ", esperamos ["+tiempo+"] segundos para que aparezca");
            WebDriverWait wait = new WebDriverWait( DriverContext.getDriver(), tiempo );
            wait.until( ExpectedConditions.visibilityOf(elemento) );
            System.out.println("Se encontró el elemento [ "+elemento+" ]");
            return true;
        }catch (Exception e){
            System.out.println("No se encontró el elemento [ "+elemento+" ]");
            return false;
        }
    }

    public  static void swipeDown(){
        int ancho = (int) (DriverContext.getDriver().manage().window().getSize().width * 0.08D);
        int startPoint = (int) (DriverContext.getDriver().manage().window().getSize().height * 0.9D);
        int endPoint = (int) (DriverContext.getDriver().manage().window().getSize().height * 0.65D);

        TouchAction touchAction = new TouchAction( DriverContext.getDriver() );
        touchAction.press( PointOption.point( ancho, startPoint ) ).waitAction( WaitOptions.waitOptions( Duration.ofMillis( 500L ) )).moveTo( PointOption.point( ancho, endPoint ) ).release().perform();
        System.out.println("Swipe hacia abajo");

    }
}
