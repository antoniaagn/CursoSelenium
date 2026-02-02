package Unidad1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemplosNvaegadorNavegacion {
    public static void main(String[] args) throws InterruptedException {

        String rutaDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
        //System.out.println(rutaDriver);

        System.setProperty("webdriver.chrome.driver",rutaDriver);
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");

        Thread.sleep(5000); //espera



    }

}
