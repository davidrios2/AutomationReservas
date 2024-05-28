package co.com.udea.calidad.reservas.moduloreservas.userinterfaces;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FrontEndLocal extends PageObject {

    public static final Target TIPO_PASAJERO = Target.the("Tipo de Pasajero dropdown")
            .located(By.id("tipo-pasajero"));
    public static final Target NOMBRE = Target.the("Nombre campo")
            .located(By.id("nombre"));
    public static final Target APELLIDO = Target.the("Apellido campo")
            .located(By.id("apellido"));
    public static final Target TIPO_DOCUMENTO = Target.the("Tipo de Documento dropdown")
            .located(By.id("tipo-documento"));
    public static final Target NUMERO_DOCUMENTO = Target.the("Numero de Documento campo")
            .located(By.id("numero-documento"));
    public static final Target AGREGAR_PASAJERO = Target.the("Agregar Pasajero buton")
            .located(By.id("agregar-pasajero"));
    public static final Target AUTORIZAR_TRATAMIENTO = Target.the("Autorizar tratamiento checkbox")
            .located(By.id("autorizar-tratamiento"));
    public static final Target PAGAR = Target.the("Pagar buton")
            .located(By.id("pagar"));
    public static final Target PASAJEROS = Target.the("Pasajeros")
            .located(By.id("pasajeros"));
    public static Target pasajero(int index) {
        return Target.the("Pasajero" + index)
                .locatedBy("#pasajeros tr[id='pasajero-" + index + "']");
    }
}
