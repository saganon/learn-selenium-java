package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Main {

    static protected WebDriver driver;
    static {
        chromedriver().setup();
        var options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
    }

    public static void main(String[] args) {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("learn selenium");

        WebElement passwordInput = driver.findElement(By.name("my-password"));
        passwordInput.sendKeys("1234");

        WebElement textAreaInput = driver.findElement(By.name("my-textarea"));
        textAreaInput.sendKeys("I am learning selenium");

        List<WebElement> elements = driver.findElements(By.cssSelector("div[class=form-check]"));
        System.out.println(elements.size());

        WebElement checkBox1 = driver.findElement(By.id("my-check-1"));
        checkBox1.click();

        WebElement checkBox = driver.findElement(By.id("my-check-2"));
        boolean isSelected = checkBox.isSelected();

        if (!isSelected) {
            checkBox.click();
        }

        WebElement radioButton = driver.findElement(By.id("my-radio-2"));
        radioButton.click();

        Select dropdown = new Select(driver.findElement(By.name("my-select")));
        dropdown.selectByValue("1");
        /*
        Other options:

        dropdown.deselectByVisibleText("Three");
        dropdown.selectByIndex(1);
         */

        String filePath = "/Users/nb-dk-0288/Documents/personal-code/learn-selenium-java/resources/file.txt"; // absolute path
        WebElement upload = driver.findElement(By.name("my-file"));
        upload.sendKeys(filePath);

        WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
        button.click();

        /*
        Below command is for click the text link

        WebElement returnToIndex = driver.findElement(By.xpath("//a[normalize-space(text())='Return to Index']"));
        returnToIndex.click();
        */

        driver.quit();
    }
}