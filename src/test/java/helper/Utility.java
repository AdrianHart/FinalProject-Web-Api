package helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;
import java.util.Random;

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

    public static String generateRandomAlphabet(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            randomString.append(alphabet.charAt(index));
        }
        return randomString.toString();
    }

    public static String generateRandomNumeric(int length) {
        String number = "0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(number.length());
            randomString.append(number.charAt(index));
        }
        return randomString.toString();
    }

    public static void validateProductPresence(WebDriver driver, By productCard, List<String> expectedProductNames) {
        List<WebElement> product = driver.findElements(productCard);
        int expectedProductCount = expectedProductNames.size();
        assertEquals(expectedProductCount, product.size());

        for(int numBlock = 1; numBlock <= expectedProductCount; numBlock++) {
            WebElement actualProductName = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[" + numBlock + "]/div/div/h4/a"));
            assertEquals(expectedProductNames.get(numBlock-1), actualProductName.getText());
        }
    }
}


