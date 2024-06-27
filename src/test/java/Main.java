import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    //web driverı çalıştırıcaz
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();    // Chrome driver'ın setupını yaptık(kurduk).
        WebDriver driver = new ChromeDriver();


        driver.get("https://demoqa.com/text-box");   //İlgili adresi getirir.
        driver.manage().window().maximize();    //Chrome driverın tam ekran olmasını sağladık

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,350)");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.sendKeys("Atakan Başol");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.click();
        userEmail.sendKeys("basolatakan8@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.click();
        currentAddress.sendKeys("Turgut Özal Bulvarı, Yağmur Apt. B Blok Daire:3");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.click();
        permanentAddress.sendKeys("Balıkesir/Erdek");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
                // submitButton.click();

        try{
            Thread.sleep(5000);     //Browser'ı açtıktan sonra 5 saniye bekleyecek.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();     //Tamamen kapattık  (driver.close(); --> Geçerli sekmeyi kapatır.)

    }
}
