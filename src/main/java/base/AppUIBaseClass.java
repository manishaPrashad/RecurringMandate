package base;

/**
 * Class functionality-Base Class for  UPI 2 functionality
 * Author name:- Manisha kumari
 */


import Utils.AssertUtility;
import Utils.Helper;

import com.github.javafaker.Faker;
import com.utilities.fileUtils.PropertiesUtility;
import com.utilities.mobileUtils.ActionsUtility;
import com.utilities.mobileUtils.MobileUtility;
import com.utilities.webUtils.LaunchApplication;
import com.utilities.webUtils.WaitUtility;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.MalformedURLException;

import java.util.*;

import static com.sun.activation.registries.LogSupport.log;


public class AppUIBaseClass extends LaunchApplication {

    public static AndroidDriver androidDriver;
    public static AssertUtility assertUtility = new AssertUtility();
    public static MobileUtility mobileActions = new MobileUtility();
    public static StopWatch stopWatch = new StopWatch();
    public static double ts;
    public static ConnectionState connection;
    public static Properties properties;
    public static WebDriverWait wait;
   // private static final Logger log = LogManager.getLogger(AppUIBaseClass.class);
    public static Faker faker = new Faker();
    public static ActionsUtility actionUtils;
    private static int methodCallCount = 1;
    public static HashMap<String, ArrayList<String>> db;
    public static ArrayList<String> columnDetails;


    public static String configFileName = "src\\main\\resources\\Properties\\config.properties";
    public static Helper helperClass = new Helper();


    public AppUIBaseClass() {
        properties = PropertiesUtility.getApplicationProperties(configFileName);

    }



    public static void launchAppium() throws MalformedURLException {
        if (methodCallCount++ == 1) {
            isNoReset = true;
            androidDriver = (AndroidDriver) launchMobileDevice(properties, null);
            System.out.println(androidDriver + " driver");
            wait = new WebDriverWait(androidDriver, 30);
        } else {
            androidDriver.launchApp();
        }
    }

    public static void scrollDown() throws InterruptedException {
        TouchActions action = new TouchActions(androidDriver);
        action.scroll(10, -200);
        action.perform();
    }



    public static void enterKeyPadVal(String stringOfDigits) {
        for (char c : stringOfDigits.toCharArray()) {

            ((AndroidDriver) androidDriver).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + c)));
        }
    }

    public static void applyWait() throws InterruptedException {
        WaitUtility.averageWait();
    }

    @Step("{0}")
    public static void logToReport(String message) {

        log(message);
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES);
    }

    public static void closeDriver() {
        androidDriver.quit();
    }

    public static void dragNotification() {
        androidDriver.openNotifications();
        WaitUtility.averageWait();
        androidDriver.navigate().back();
    }

    public static void identifyNatify() {
        Set<String> contextNames = androidDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextNames + "nativity");
        }
    }

    public static void unloackDevice() {
        androidDriver.lockDevice();
        System.out.println("lock");
        androidDriver.unlockDevice();
        System.out.println("unloack");
        ActionsUtility.swipeUp(androidDriver);
        WaitUtility.minimumWait();

    }

    public static void waitAndActionOnElement(WebElement element) {
        helperClass.waitForElement(element);
        assertUtility.assertTrue(element,true,"element not visible");
        //saveScreenshotPNG();
        element.click();
    }


    public static Map<String, String> testData = new HashMap<String, String>();

    public static void writeMaptoFile() throws IOException {
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(new FileOutputStream("data.properties"), null);
    }

    public static void exitApp(){
        androidDriver.closeApp();
    }


    public static void loopToNavigateBack (){
        int counter = 1;
        for (int i = 0; i <= counter; i++) {
            androidDriver.navigate().back();
        }




}}






