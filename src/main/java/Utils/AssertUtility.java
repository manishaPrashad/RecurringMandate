package Utils;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class AssertUtility {

    public static SoftAssert softAssert=new SoftAssert();

    public static void assertTrue(boolean assertCondition,String assertStatment){
        softAssert.assertTrue(assertCondition,assertStatment);
    }

    public static void assertEqual(String assertText,String actualText,String errorMessage){
        softAssert.assertEquals(assertText,actualText,errorMessage);
    }
    public static void assertEqual(ArrayList<String> assertText, String actualText, String errorMessage){
        softAssert.assertEquals(assertText,actualText,errorMessage);
    }

    public static void assertEqualText(boolean assertText,String message){
        softAssert.assertEquals(assertText,message);
    }

    public static void assertEqual(boolean request_money, String validation_failed) {
    }

    public static void assertEqualNo(int integerVal,int actualVal,String errorMessage){
        softAssert.assertEquals(integerVal,actualVal,errorMessage);
    }

    public static void assertTrue(WebElement refTag, boolean b, String ref_tag_doesn_not_appear) {
    }
}
