package driver;

import io.appium.java_client.AppiumDriver;

public class DriverContext {

    private static DriverManager driverManager = new DriverManager();

    public static void setUP(String nombreDispositivo, String SO, String aplicacion, String udid, boolean emulador){
        driverManager.iniciarSession(nombreDispositivo, SO, aplicacion, udid, emulador);
    }

    public static AppiumDriver getDriver(){
        return driverManager.getDriver();
    }

    public static void quitDriver(){
        driverManager.getDriver().quit();
    }
}
