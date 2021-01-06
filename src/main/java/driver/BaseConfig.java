package driver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;

import static driver.DriverContext.setUP;

public class BaseConfig {
    public static final String pathDirectorio = new File("").getAbsolutePath();
    public static final String app = new String( pathDirectorio.concat( "\\myApp\\registroDeUsuarios.apk" ) );

    @BeforeMethod
    public void iniciarSession() {

        setUP("emulator-5554","Android", app, "emulator-5554", true );
    }

    @AfterMethod
    public void cerrarSession(){
        DriverContext.quitDriver();
    }
}
