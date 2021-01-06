package page;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;
import static report.AllureReport.addStep;

public class Carrusel {

    private AppiumDriver driver;

    public Carrusel(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements( new AppiumFieldDecorator( driver ), this );
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVista;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista;
    @AndroidFindBy(id = "com.rodrigo.registro:id/textView")
    private MobileElement descripcionVista;
    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement botonNext;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement botonPermitir;
    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement botonHecho;

    public void recorrerCarrusel(){
        System.out.println("[Vista Carrusel] ");
        for (int click = 1; click < 4; click++){
            System.out.println("\t[realizando TAB [ " +click+" de 3 ]");
            botonNext.click();
        }
    }

    public void tapBtnHecho(){
        botonPermitir.click();
        botonHecho.click();
    }

    public void validarVista(){
        if(iconoVista.isDisplayed()){
            addStep("validar vista 1 de carrusel", true, Status.PASSED, false);
        }else {
            addStep("validar vista 1 de carrusel", true, Status.FAILED, true);
        }
    }

    public void validarTextoVista1(){
        if(descripcionVista.getText().equals( "Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios." )){
            addStep("validar vista 1 de carrusel - descripcion", true, Status.PASSED, false);
        }else {
            addStep("validar vista 1 de carrusel - descripcion", true, Status.FAILED, true);
        }
    }

}
