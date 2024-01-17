package helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utility {

    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }

    public static JSONObject userRequestLimitedBody(String firstName, String lastName, String email) {
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("firstName", firstName);
        bodyObj.put("lastName", lastName);
        bodyObj.put("email", email);
        return bodyObj;
    }


    //PRODUCT PRESENCE (FOR HOMEPAGE)
    public static void validateProductPresence(WebDriver driver, By productCard, List<String> expectedProductNames) {
        //VERIFY NUM OF PRODUCT
        List<WebElement> product = driver.findElements(productCard);
        int expectedProductCount = expectedProductNames.size();
        assertEquals(expectedProductCount, product.size());

        //VERIFY NAME OF PRODUCT
        for(int numBlock = 1; numBlock <= expectedProductCount; numBlock++) {
            WebElement actualProductName = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[" + numBlock + "]/div/div/h4/a"));
            assertEquals(expectedProductNames.get(numBlock-1), actualProductName.getText());
        }
    }
}


