import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Objects {

    public static WebElement element= null;
    public static By locationCanada =  By.xpath("//label[@data-value='Canada']");
    public static By topic = By.xpath("//div[contains(@class,'evnt-talk-topic')]/label");
    public static By cardTitle = By.className("evnt-talk-title");
    public static By eventsFromTopMenu = By.cssSelector("li.nav-item:nth-child(2) > a:nth-child(1)");
    public static By eventsFromBottomMenu = By.xpath("//div[@class='evnt-cards-container']/h3/a[@href='/all-events']");
    public static By filter = By.cssSelector(".evnt-toggle-filters-button");
    public static By upcomingEventsCounter = By.cssSelector("a.active:nth-child(1) > span:nth-child(3)");
    public static By upcomingEvents = By.xpath("//div[contains(@class, 'evnt-upcoming-events')]");
    public static By numberOfUpcomingEvents = By.xpath("//div[contains(@class, 'evnt-event-card')]");
    public static By pastEventsCounter = By.cssSelector("a.active:nth-child(1) > span:nth-child(3)");
    public static By pastEvents = By.xpath("//div[@class='evnt-cards-container']");
    public static By numberOfPastEvents = By.xpath("//div[contains(@class, 'evnt-event-card')]");
    public static By allUpcomingSections = By.xpath("//div[contains(@class, 'evnt-upcoming-events')]");
    public static By allCards = By.xpath("//div[@class='evnt-event-dates']/div/div/p/span[@class='date']");
    public static By allPastSection = By.xpath("//div[@class='evnt-cards-container']");
    public static By allVideos = By.xpath("//div[@class='evnt-talks-row']");
    public static By videoCardHref = By.xpath("//div[@class='evnt-talk-card']/a");
    public static By CardTitle = By.xpath("//div[@class='evnt-card-body']/div/div/h1/span");
    public static By eventContent = By.xpath("//div[contains(@class, 'evnt-content-text')]/h1");
    public static List<String> duringThisWeek = new ArrayList<>();
    public static List<String> duringNotThisWeek = new ArrayList<>();
    public static List<String> validTopics = new ArrayList<>();
    public static List<String>  invalidTopics = new ArrayList<>();
    public static List<String>  validInfo = new ArrayList<>();
    public static List<String>  invalidInfo = new ArrayList<>();
    public static List<String>  linkLocation = new ArrayList<>();

    // main page-------------------------------------------------------------------

    public static WebElement events(WebDriver driver) {
        element = driver.findElement(By.cssSelector("li.nav-item:nth-child(2) > a:nth-child(1)"));
        return element;
    }

    public static WebElement pastEvents(WebDriver driver) {
        element = driver.findElement(By.cssSelector("li.evnt-tab-item:nth-child(2) > a:nth-child(1) > span:nth-child(1)"));
        return element;
    }

    public static WebElement locations(WebDriver driver) {
        element = driver.findElement(By.cssSelector("#filter_location > span:nth-child(1)"));
        return element;
    }

    public static WebElement card(WebDriver driver) {
        element = driver.findElement(numberOfUpcomingEvents);
        return element;
    }

    public static WebElement videos(WebDriver driver){
        element = driver.findElement(By.cssSelector("li.nav-item:nth-child(3) > a:nth-child(1)"));
        return element;
    }

    public static WebElement moreFilters(WebDriver driver){
        element = driver.findElement(By.xpath("//div[contains(@class, 'show-more')]/span"));


        return element;
    }

    public static WebElement category(WebDriver driver){
        element = driver.findElement(By.id("filter_category"));
        return element;
    }

    public static WebElement categoryTesting(WebDriver driver){
        element = driver.findElement(By.xpath("//label[@data-value='Testing']"));
        return element;
    }

    public static WebElement location(WebDriver driver){
        element = driver.findElement(By.id("filter_location"));
        return element;
    }

    public static WebElement locationBelarus(WebDriver driver){
        element = driver.findElement(By.xpath("//label[@data-value='Belarus']"));
        return element;
    }

    public static WebElement language(WebDriver driver){
        element = driver.findElement(By.id("filter_language"));
        return element;
    }

    public static WebElement languageEnglish(WebDriver driver){
        element = driver.findElement(By.xpath("//label[@data-value='ENGLISH']"));
        return element;
    }
    public static WebElement videoCountry(WebDriver driver){
        element = driver.findElement(By.xpath("//div[contains(@class,'evnt-talk-details')and contains(@class,'location')]/span"));
        return element;
    }
    public static WebElement videoTopic(WebDriver driver){
        element = driver.findElement(By.xpath("//div[contains(@class,'evnt-talk-topic')]/label"));
        return element;
    }

    public static WebElement videoLanguage(WebDriver driver){
        element = driver.findElement(By.xpath("//div[contains(@class,'evnt-talk-details') and contains(@class,'language')]/span"));
        return element;
    }

    public static  WebElement videoSearch(WebDriver driver){
        element = driver.findElement(By.cssSelector(".evnt-search-filter > input:nth-child(1)"));
        return element;
    }
}
