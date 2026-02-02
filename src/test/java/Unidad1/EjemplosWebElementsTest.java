package Unidad1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemplosWebElementsTest {

    //driver
    public WebDriver driver;

    //preparacion
    @BeforeAll //Antes de ejecutar todo
    public static void preparacion(){
        String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        //System.out.println(rutaDriver);
        System.setProperty("webdriver.chrome.driver", rutaDriver); //se setear driver
    }

    //pre condiciones
    @BeforeEach //Antes de cada Test
    public void preparacion_tests(){
        driver = new ChromeDriver();//Cargar el driver
        driver.get("https://demowebshop.tricentis.com");//levantar la pagina
    }

    //pos condiciones
    @AfterEach //Despues de cada Test
    public void posCondiciones_test(){
        driver.close();
    }

    //pos ejecucion
    @AfterAll
    public static void finEjecucion(){

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
                "No customer account found", driver.findElement(By.xpath("//form/div/div/span")).getText()+"\n"+driver.findElement(By.xpath("//form/div/div/ul/li")).getText());



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
                "The credentials provided are incorrect", driver.findElement(By.xpath("//form/div/div/span")).getText()+"\n"+driver.findElement(By.xpath("//form/div/div/ul/li")).getText());

//CASO 3 HACER LOGIN CORRECTO
        //LOGOUT
        //AGREGAR COMPRA A CARRITO
        //ERROR AL AGREGAR CODIGO DESCUENTO
        //ERROR AL AGRGAR GIFT CARD ERRONEO
        //ACTULIZAR DATOS CARRITO

    }

//    @Test//Login correcto
//
//    public void Caso003_LoginCorrecto() throws InterruptedException {
//        Thread.sleep(1000); //espera
//        By locatorLinkLogin = By.linkText("Log in");//localizador
//
//        WebElement linkLogin = driver.findElement(locatorLinkLogin);
//        linkLogin.click();
//        Thread.sleep(1000);
//
//        //insertar mail
//        driver.findElement(By.id("Email")).sendKeys("antonia.agn@gmail.com");
//        Thread.sleep(1000);
//
//        //insertar pass
//        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("anto9563");
//        Thread.sleep(1000);
//
//        //boton login
//        driver.findElement(By.xpath("//input[@value='Log in']")).click();
//
//        //validacion (Resultado esperado vs Resultado Obtenido)
//
//        Assertions.assertEquals("Log out",);



       //     }


}
