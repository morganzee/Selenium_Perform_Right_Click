package RightClick;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightClick {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        String browser = "CHROME";

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\Selenium Webdriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\Selenium Webdriver\\chromedriver.exe");
            driver = new EdgeDriver();
        }
        //This url is used for a prompt
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        //get browser title
        String getTitle = driver.getTitle();
        System.out.println("Page Title :" + getTitle);

        WebElement btn = driver.findElement(By.xpath("//span[text()='right click me']"));
        //Actions class is a built-in feature that assist keyboard and mouse events
        Actions builder = new Actions(driver);

        //What this does is to make sure the right web element is clicked on in this case "right click me"
        builder.contextClick(btn).build().perform();

        //Click on copy
        driver.findElement(By.xpath("//span[text()='Copy']")).click();

        Thread.sleep(3000);

        //This is to capture the alert when the copy is click on after the right click
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        if(alertText.equals("clicked: copy")){
            System.out.println("Right click was successful");
        }else{
            System.out.println("Right click was unsuccessful");
        }

        //This would click on the Ok button
        alert.accept();
        //Close browser
        driver.quit();
    }
}
