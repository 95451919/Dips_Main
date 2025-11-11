package Pages;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class SamplePage {

public static WebDriver driver;
    public void login_Page() throws InterruptedException {
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
            driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Elements']")));

        WebElement element1 =driver.findElement(By.xpath("//*[text()='Elements']"));
        Assert.assertEquals("Elements",element1.getText().trim());

    }

    public void login(String username, String password){
        try {
            System.out.println(username + " " + password);
           // String abc = driver.findElement().getText();
           // Assert.assertEquals(username, abc);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void userClick(String click){
        try {
           WebElement element= driver.findElement(By.xpath("//h5[text()='" + click + "']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void userClickonelement(String clickonelement){
        WebElement element=driver.findElement(By.xpath("//span[text()='"+clickonelement+"']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void uservalidatelastname(String first,String last){
        String actual =driver.findElement(By.xpath("(//div[text()='"+first+"']/following-sibling::div)[1]")).getText().trim();
        Assert.assertEquals(actual,last);
    }
    public void m1(Map<String,String>expect) {

        for (Map.Entry<String, String> en : expect.entrySet()) {

            System.out.println(en.getKey() + " " + en.getValue());

        }
    }
        public void userEnterTheDetails(Map<String,String>expect) throws InterruptedException {

            String fullname1=expect.get("FullName");
            String email1=expect.get("Email");
            String curradd1=expect.get("CurrentAdress");
            String peradd1=expect.get("PermanatAdress");

            WebElement fullname =driver.findElement(By.xpath("//input[@id='userName']"));
            WebElement email =driver.findElement(By.xpath("//input[@id='userEmail']"));
            WebElement curradd =driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
            WebElement peradd =driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));

            fullname.sendKeys(fullname1);
            email.sendKeys(email1);
            curradd.sendKeys(curradd1);
            peradd.sendKeys(peradd1);
            Thread.sleep(5000);

          WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);


    }

}
