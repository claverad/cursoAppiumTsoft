package report;


import driver.DriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class AllureReport {

    private static SoftAssert softAssert = new SoftAssert();

    public static void addStep(String descripcion, Boolean screenShot, Status status, Boolean fatal){
        String uuid = UUID.randomUUID().toString();
        StepResult stepResult = new StepResult().setName( descripcion ).setStatus( status );
        Allure.getLifecycle().startStep( uuid, stepResult );
        if(screenShot){
            reporteScreenShot();
        }
        Allure.getLifecycle().stopStep(uuid);
        if(status.equals( Status.FAILED )){
            softAssert.fail(descripcion);
        }
        if(fatal){
            Assert.fail( descripcion );
        }
        System.out.println("Reporte: [ "+descripcion +" ]");
    }

    private static void reporteScreenShot(){
        File scrFile;
        scrFile =  DriverContext.getDriver().getScreenshotAs( OutputType.FILE );
        File foto = new File( scrFile.getPath());
        InputStream image;
        try {
            image = new FileInputStream( foto );
            Allure.addAttachment( "Imagen adjunta", image );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void finalAssert(){
        softAssert.assertAll();
    }

}
