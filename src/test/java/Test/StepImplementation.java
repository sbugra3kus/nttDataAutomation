package Test;

import Test.BaseTest;
import com.opencsv.CSVReader;
import com.thoughtworks.gauge.Step;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static Constants.Constants.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StepImplementation extends BasePage {
    private static Logger logger = LogManager.getLogger(BasePage.class);

    @Step("Anasayfanın Açıldığı Kontrol Edilir")
    public void assertMainpage(){
        logger.info("Ana sayfa kontrol ediliyor");
        Assert.assertEquals(FIRST_LINK, driver.getCurrentUrl());
        logger.info("Ana sayfa Açıldı.");
    }

    @Step("ZoomOut")
    public void zoomOut(){
        logger.info("Sayfa Küçültülüyor");
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='50%';");
        logger.info("Sayfa Küçültüldü.");
    }
    @Step("Forms Butonuna Tıklama")
    public void searchButton() {
        logger.info("Forms butonuna Tıklanıyor");
        WebElement ele = driver.findElement(By.xpath(Formlar));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
        logger.info("Forms butonuna Tıklandı");
    }
    @Step("Pratik Form Butonuna Tıklama")
    public void PratikFormu() {
        logger.info("Pratik Form butonuna Tıklanıyor");
        WebElement ele = driver.findElement(By.xpath(PratikFormu));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
        logger.info("Pratik Form butonuna Tıklandı");
    }
    @Step("Pratik Form isim doldurma")
    public void PratikFormName() throws IOException {
        String[] csvCell;
        logger.info("Pratik Form Name Alanını doldurma");
        CSVReader csvReader = new CSVReader(new FileReader("src/test/java/Constants/csvfile.csv"));
        while ((csvCell = csvReader.readNext()) !=null){
            String name = csvCell[0];
            WebElement ele = driver.findElement(By.id(firstName));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()", ele);
            driver.findElement(By.id(firstName)).sendKeys(name);
        }
        logger.info("Pratik Form Name dolduruldu.");
    }
    @Step("Pratik Form soyisim doldurma")
    public void PratikFormLastname() throws IOException {
        String[] csvCell;
        logger.info("Pratik Form Last Name Alanını doldurma");
        CSVReader csvReader = new CSVReader(new FileReader("src/test/java/Constants/csvfile.csv"));
        while ((csvCell = csvReader.readNext()) !=null){
            String Lastname = csvCell[1];
            WebElement ele = driver.findElement(By.id(lastName));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()", ele);
            driver.findElement(By.id(lastName)).sendKeys(Lastname);
        }
        logger.info("Pratik Form Last Name dolduruldu.");
    }
    @Step("Pratik Form Email doldurma")
    public void PratikFormEmail() throws IOException {
        String[] csvCell;
        logger.info("Pratik Form Email doldurma");
        CSVReader csvReader = new CSVReader(new FileReader("src/test/java/Constants/csvfile.csv"));
        while ((csvCell = csvReader.readNext()) !=null){
            String mail = csvCell[2];
            WebElement ele = driver.findElement(By.id(userEmail));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()", ele);
            driver.findElement(By.id(userEmail)).sendKeys(mail);
        }
        logger.info("Pratik Form Email dolduruldu.");
    }
    @Step("Pratik Form numara doldurma")
    public void PratikFormNumber() throws IOException {
        String[] csvCell;
        logger.info("Pratik Form numara doldurma");
        CSVReader csvReader = new CSVReader(new FileReader("src/test/java/Constants/csvfile.csv"));
        while ((csvCell = csvReader.readNext()) !=null){
            String number = csvCell[3];
            WebElement ele = driver.findElement(By.id(userNumber));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()", ele);
            driver.findElement(By.id(userNumber)).sendKeys(number);
        }
        logger.info("Pratik Form numara dolduruldu.");
    }
    @Step("Pratik Form adres doldurma")
    public void PratikFormaddress() throws IOException {
        String[] csvCell;
        logger.info("Pratik Form adres doldurma");
        CSVReader csvReader = new CSVReader(new FileReader("src/test/java/Constants/csvfile.csv"));
        while ((csvCell = csvReader.readNext()) !=null){
            String address = csvCell[4];
            WebElement ele = driver.findElement(By.id(currentAddress));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()", ele);
            driver.findElement(By.id(currentAddress)).sendKeys(address);
        }
        logger.info("Pratik Form adres dolduruldu.");
    }
    @Step("Pratik Form cinsiyet seçme")
    public void PratikFormgender() throws IOException {
        logger.info("Pratik Form cinsiyet Tıklanıyor");

            WebElement ele = driver.findElement(By.id(Gender));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()", ele);
        logger.info("Pratik Form erkek seçildi.");
    }
    @Step("Pratik Form Submit butona tıklama")
    public void PratikFormSubmit() throws IOException {
        logger.info("Pratik Form Submit butonuna Tıklanıyor");

        WebElement ele = driver.findElement(By.id(submit));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
        logger.info("Pratik Form Submit butonuna Tıklandı");
    }
    @Step("Ekran görüntüsü alma")
    public void ScreenShoot() throws IOException {
        logger.info("Ekran Görüntüsü Alınıyor");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(image));
        logger.info("Ekran Görüntüsü Alındı.");
    }

    @Step("<x> saniye bekle")
    public void waitForSecond(Integer x) throws InterruptedException {
        logger.info("Static bekleme konuluyor");
        Thread.sleep(1000 * x);
        logger.info("Static bekleme yapıldı");
    }


}


