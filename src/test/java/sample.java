import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class sample {
    public WebDriver driver;
    public WebDriverWait wait;

    public static void pageLoaded (WebDriver driver, String url, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(url));
    }

    public static void exceptCookies(WebDriver driver) {
        if (driver.findElements(By.cssSelector("#onetrust-accept-btn-handler")).size()!=0)
        { driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();}
    }

    public void waitVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void VideoTest() throws InterruptedException {
        driver.get("https://events.epam.com/");
        pageLoaded(driver, driver.getCurrentUrl(), 60);
        exceptCookies(driver);
        Objects.videos(driver).click();
        //here sleep is important, have to wait for correct cards, another way test returns card before filtering
        sleep(1000);
        Objects.moreFilters(driver).click();
        Objects.category(driver).click();

        //move scroll down to see Testing checkbox
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement categoryTesting = Objects.categoryTesting(driver);
        je.executeScript("arguments[0].scrollIntoView(true);",categoryTesting);
        //page scroll move down too, so return it back to the top
        JavascriptExecutor je2 = (JavascriptExecutor) driver;
        WebElement login = Objects.category(driver);
        je2.executeScript("arguments[0].scrollIntoView(true);",login);
        // now checkbox can be selected
        categoryTesting.click();
        sleep(800);
        Objects.location(driver).click();
        Objects.locationBelarus(driver).click();
        Objects.language(driver).click();
        Objects.languageEnglish(driver).click();

        sleep(800);
        WebElement allSections = driver.findElement(Objects.allVideos);
        List<WebElement> allCards = allSections.findElements(Objects.videoCardHref);

        //collect all links to the cards details
        for (WebElement card : allCards) {
            String eventLink = card.getAttribute("href");
            Objects.linkLocation.add(eventLink);
        }
        //need to wait for topic
        sleep(800);
        //Open each link and verify information
        for (String cardLink : Objects.linkLocation) {
            driver.get(cardLink);
            sleep(800);

            if (driver.findElements(Objects.cardTitle).size() == 0)
            {
                driver.navigate().refresh();
                sleep(2000);
            }

            String cardTopic = driver.findElement(Objects.cardTitle).getText();
            String Country = Objects.videoCountry(driver).getText();

            //collect all labels with topics
            WebElement Topics = driver.findElement(By.xpath("//div[@class='evnt-topics-wrapper']"));
            List<WebElement> allTopics = Topics.findElements(By.xpath("//div[contains(@class,'evnt-talk-topic')]/label"));
            //verify that Testing label exists among labels
            for (WebElement topic : allTopics) {
                String Topic = topic.getText();
                if (Topic.contains("Testing") )
                {Objects.validTopics.add(cardTopic);}
                else
                {Objects.invalidTopics.add(cardTopic); }
            }

            String Language = Objects.videoLanguage(driver).getText();

            if (Country.contains("Belarus") && Language.contains("ENGLISH") && Objects.validTopics.size()!=0 )
            { Objects.validInfo.add(cardTopic); }
            else
            { Objects.invalidInfo.add(cardTopic);}

        }
        if (Objects.invalidInfo.isEmpty())
        {
            System.out.println("all cards contain valid information for set criteria");

        }
        else{
            System.out.println(Objects.invalidInfo + " - this topics should not be  shown for set criteria");

        }
    }

    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

