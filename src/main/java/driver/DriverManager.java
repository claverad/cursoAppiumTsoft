package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities capabilities = new DesiredCapabilities(  );


    protected void iniciarSession(String nombreDispositivo, String SO, String aplicacion, String udid, boolean emulador) {

        try {
            server = new URL( "http://127.0.0.1:4723/wd/hub" );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        capabilities.setCapability( "deviceName",nombreDispositivo );
        capabilities.setCapability( "platformName", SO );
        capabilities.setCapability( "app", aplicacion );
        if(!emulador){
            capabilities.setCapability( "udid",udid);
        }
        driver = new AndroidDriver( server, capabilities );
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
    }

    protected AppiumDriver getDriver(){
        return driver;
    }
}
