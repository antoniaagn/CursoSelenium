package Unidad1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EjemplosWebElementsTest {

    //driver
    public WebDriver driver;
    private WebDriverWait wait;


    //preparacion
    @BeforeAll //Antes de ejecutar todo
    public static void preparacion() {
        String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        //System.out.println(rutaDriver);
        System.setProperty("webdriver.chrome.driver", rutaDriver); //se setear driver
    }

    //pre condiciones
    @BeforeEach //Antes de cada Test
    public void preparacion_tests() {
        driver = new ChromeDriver();//Cargar el driver
        driver.get("https://demowebshop.tricentis.com");//levantar la pagina
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //pos condiciones
    @AfterEach //Despues de cada Test
    public void posCondiciones_test() {
        driver.close();
    }

    //pos ejecucion
    @AfterAll
    public static void finEjecucion() {

    }

    @Test//login erroneo user no creado

    public void Caso001_LoginErroneo_User_NOOK() throws InterruptedException {

        Thread.sleep(1000); //espera
        By locatorLinkLogin = By.linkText("Log in");//localizador

        WebElement linkLogin = driver.findElement(locatorLinkLogin);
        linkLogin.click();
        Thread.sleep(1000);


        //insertar mail
        driver.findElement(By.id("Email")).sendKeys("anto@selenium.cl");
        Thread.sleep(1000);


        //insertar pass
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
        Thread.sleep(1000);

        //boton login
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        //extraer mensaje de error de mail invalido
        //        String resultadoObtenidoMensaje = driver.findElement(By.xpath("//form/div/div/span")).getText();
        //        System.out.println(resultadoObtenidoMensaje);
        //
        //        String resultadoEsperado = "Login was unsuccessful. Please correct the errors and try again.\n" +
        //                "No customer account found"; // todo esto se elimina para ser reemplazado por el Assertion.assertequals

        Assertions.assertEquals("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found", driver.findElement(By.xpath("//form/div/div/span")).getText() + "\n" + driver.findElement(By.xpath("//form/div/div/ul/li")).getText());


    }

    @Test//login erroneo Usuario Creado, pass invalida

    public void Caso002_LoginErroneo_Pass_NOOK() throws InterruptedException {

        Thread.sleep(1000); //espera
        By locatorLinkLogin = By.linkText("Log in");//localizador

        WebElement linkLogin = driver.findElement(locatorLinkLogin);
        linkLogin.click();
        Thread.sleep(1000);


        //insertar mail
        driver.findElement(By.id("Email")).sendKeys("domingo.saavedra.111@algo.com");
        Thread.sleep(1000);


        //insertar pass
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
        Thread.sleep(1000);

        //boton login
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        //extraer mensaje de error de mail invalido

        Assertions.assertEquals("Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect", driver.findElement(By.xpath("//form/div/div/span")).getText() + "\n" + driver.findElement(By.xpath("//form/div/div/ul/li")).getText());

//CASO 3 HACER LOGIN CORRECTO >> OK CASO 3
        //LOGOUT>> EN PROCESO >> OK CASO 4
        //AGREGAR COMPRA A CARRITO >> EN PROCESO CASO 5
        //ERROR AL AGREGAR CODIGO DESCUENTO
        //ERROR AL AGRGAR GIFT CARD ERRONEO
        //ACTULIZAR DATOS CARRITO

    }

    @Test//Login correcto

    public void Caso003_LoginCorrecto() throws InterruptedException {
        Thread.sleep(1000); //espera
        By locatorLinkLogin = By.linkText("Log in");//localizador

        WebElement linkLogin = driver.findElement(locatorLinkLogin);
        linkLogin.click();
        Thread.sleep(1000);

        //insertar mail
        driver.findElement(By.id("Email")).sendKeys("antonia.agn@gmail.com");
        Thread.sleep(1000);

        //insertar pass
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("anto9563");
        Thread.sleep(1000);

        //boton login
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        //validacion (Resultado esperado vs Resultado Obtenido)

        String resultadoEsperado = "Log out";

        String resultadoObtenido = driver.findElement(By.xpath("//a[contains(@class,'ico-logout')]")).getText();

        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test//LogOut

    public void Caso004_LogOut() throws InterruptedException {
        Thread.sleep(1000); //espera
        By locatorLinkLogin = By.linkText("Log in");//localizador

        WebElement linkLogin = driver.findElement(locatorLinkLogin);
        linkLogin.click();
        Thread.sleep(1000);

        //insertar mail
        driver.findElement(By.id("Email")).sendKeys("antonia.agn@gmail.com");
        Thread.sleep(1000);

        //insertar pass
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("anto9563");
        Thread.sleep(1000);

        //boton login
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Thread.sleep(1000);

        //boton log out
        driver.findElement(By.xpath("//a[contains(@class,'ico-logout')]")).click();
        Thread.sleep(1000);

        //validacion (Resultado esperado vs Resultado Obtenido)

        String resultadoEsperado = "Log in";

        String resultadoObtenido = driver.findElement(By.xpath("//a[contains(@class,'ico-login')]")).getText();

        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test//Agregar Compra al Carrito

    public void Caso005_AgregarCompraAlCarrito() throws InterruptedException {
        Thread.sleep(1000); //espera
        By locatorLinkLogin = By.linkText("Log in");//localizador

        WebElement linkLogin = driver.findElement(locatorLinkLogin);
        linkLogin.click();
        Thread.sleep(1000);

        //insertar mail
        driver.findElement(By.id("Email")).sendKeys("antonia.agn@gmail.com");
        Thread.sleep(1000);

        //insertar pass
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("anto9563");
        Thread.sleep(1000);

        //boton login
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        //Elegir producto
        //1. seleccionar Item "Book"
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[@href='/books']")).click();

        //2. seleccionar libro llamado "Fiction"
        //driver.findElement(By.xpath("//a[@href='/fiction']")).click();
        //esta forma es la recomendada por la IA
        By linkFiction = By.xpath("//div[@class='item-box']//a[text()='Fiction']");
        wait.until(ExpectedConditions.elementToBeClickable(linkFiction)).click();

        //3. seleccionar "Add to Cart"
        //driver.findElement(By.xpath("//input[@id='add-to-cart-button-45']")).click();
        //esta forma es la recomendada por la IA
        By addToCart = By.id("add-to-cart-button-45");
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

        // Validación del mensaje tipo toast
        By bar = By.id("bar-notification");
        By msg = By.cssSelector("#bar-notification p.content");

        wait.until(ExpectedConditions.presenceOfElementLocated(bar));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bar));

        //validacion (Resultado esperado vs Resultado Obtenido)

        String resultadoEsperado = "The product has been added to your shopping cart";

        String resultadoObtenido =wait
                .until(ExpectedConditions.visibilityOfElementLocated(msg))
                .getText();
        //Espera hasta que aparezca el mensaje del carrito en pantalla,cuando lo veas, lee el texto que muestra y guárdalo en resultadoObtenido.
//driver.findElement(By.xpath("//div[@id='bar-notification']//p[@class='content']")).getText(); este era mi codigo q no funciona


                Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }


}
