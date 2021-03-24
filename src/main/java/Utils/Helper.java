package Utils;

import base.AppUIBaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

public class Helper extends AppUIBaseClass {

    private static final Logger log = LogManager.getLogger(Helper.class);

    public static boolean checkElementPresent(WebElement element) {

        try {
            element.isDisplayed();
            log.info("Element " + element + "Present");
            assertUtility.assertTrue(element.isDisplayed(),"Element is not present");
            return true;
        } catch (NoSuchElementException e) {
            log.info("Element " + element + "not present");
            e.printStackTrace();

        }
        return false;
    }

    public static void waitForElement(WebElement element) {
        int retryCount = 0;
        while (retryCount < 1) {
            try {
                WebDriverWait wait = new WebDriverWait(androidDriver, 20);
                wait.until(ExpectedConditions.visibilityOf(element));
                log.info("Element " + element + " found");
                break;
            } catch (StaleElementReferenceException e) {
                log.error("Stale element error occurred. Retrying element search");
                e.printStackTrace();
                retryCount++;
            }
        }
//        return element.isDisplayed();
    }

    public static void waitForElementToBeClickable(WebElement element) {
        int retryCount = 0;
        while (retryCount < 5) {
            try {
        /*        WebDriverWait wait = new WebDriverWait(driver, 30);
          //      wait.until(ExpectedConditions.visibilityOf(element));*/
                wait.until(ExpectedConditions.elementToBeClickable(element));
                log.info("Element " + element + " found");
                break;
            } catch (StaleElementReferenceException e) {
                log.error("Stale element error occurred. Retrying element search");
                e.printStackTrace();
                retryCount++;
            }
        }
//        return element.isDisplayed();
    }

    public  static void tap(int offsetx, int offsety){
        TouchAction action = new TouchAction(androidDriver);
        action.tap(PointOption.point(offsetx,offsety)).perform();
        //action.press(PointOption.point(568,1395)).moveTo(PointOption.point(560, 455)).release().perform();
    }

    public static void waitFor() {
        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void scrollDown() throws InterruptedException {

        log.info("Scroll call");

        Dimension size_device = androidDriver.manage().window().getSize();
        Double scrollHeightStart = size_device.getHeight() * 0.77;
        int scrollStart = scrollHeightStart.intValue();

        Double scrollHeightEnd = size_device.getHeight() * 0.26;
        int scrollEnd = scrollHeightEnd.intValue();

        Double x = size_device.width * 0.6;

        int startx = x.intValue();

        log.info("Press Coordinates :" + startx + "," + scrollStart);
        log.info("Press Coordinates :" + startx + "," + scrollEnd);
        waitFor();
        Thread.sleep(1000);
        try {
            new TouchAction(androidDriver)
                    .press(point(startx, scrollStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000)))
                    .moveTo(point(startx, scrollEnd))
                    .release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in Scroll");
        }
    }


    public static void scrollRight() throws InterruptedException {

        log.info("Scroll Right");

        Dimension size_device = androidDriver.manage().window().getSize();

        Double y = size_device.getHeight() * 0.3;

        int scrollY = y.intValue();

        Double x1 = size_device.width * 0.45;

        Double x2 = size_device.width * 0.2;

        int startx = x1.intValue();
        int endx = x2.intValue();

        waitFor();

        Thread.sleep(3000);

        try {
            new TouchAction(androidDriver)
                    .press(point(startx, scrollY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                    .moveTo(point(endx, scrollY))
                    .release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in Scroll");

        }

    }

    public static void safeScrollDown() throws InterruptedException {
        //The viewing size of the device
        Dimension size = androidDriver.manage().window().getSize();
        //Starting y location set to 80% of the height (near bottom)
        int starty = (int) (size.height * 0.77);
        //Ending y location set to 20% of the height (near top)
        int endy = (int) (size.height * 0.4);
        //x position set to mid-screen horizontally
        int startx = (int) (size.width * 0.5);

        Thread.sleep(2000);
        (new TouchAction(androidDriver))
                .press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startx, endy))
                .release()
                .perform();

    }
}
