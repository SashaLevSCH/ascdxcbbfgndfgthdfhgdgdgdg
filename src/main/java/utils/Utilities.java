package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utilities {


    public static void waitUntilElementDisplayed(WebDriver driver, int waitTime, By selector) {
        WebDriverWait wait = (new WebDriverWait(driver, waitTime));
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }


    public static String genertaeRandomNumbers(Integer length) {

        return RandomStringUtils.randomNumeric(length);
    }

    public static String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(5).toLowerCase();
    }

    public static String GenerateEmail(String Name, Integer NameLength, String Domain) {
        String GeneratedEmail = Utilities.generateRandomString(Name, NameLength) + "@" + Domain;
        return GeneratedEmail;
    }

    public static String generateRandomString(String word, int repeat) {
        Random rand = new Random();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            int randIndex = rand.nextInt(word.length());
            res.append(word.charAt(randIndex));
        }
        return res.toString();
    }

    public static int generateRandomDigits(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }


    public static int getRandomNumberInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, (max + 1)).findFirst().getAsInt();
    }

    public static int RandomNum() {
        int rand1 = getRandomNumberInts(1000, 10000);
        return rand1;
    }

    public static String getDateTime(){
        ZonedDateTime date = ZonedDateTime.now();
        String d = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm").format(date);
        System.out.println(d);
        return d;
    }

    public static String getTime(){
        String d = new SimpleDateFormat("HH.mm.a", Locale.US).format(new Date());
        return d;
    }



    public List<String> getValuesByKeyInJSONArrayUsingJava8(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }
    String FileName ="src/test/resources/TestData/QAData.json";

    public static org.json.simple.JSONObject readTestData(String strScenarioName, String testDataFileName) throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(testDataFileName);

        System.out.println("Scenario Data for - "+ strScenarioName);

        Object obj = jsonParser.parse(reader);

        org.json.simple.JSONObject dataObject = (org.json.simple.JSONObject) obj;

        org.json.simple.JSONObject jsonChild = (org.json.simple.JSONObject) dataObject.get(strScenarioName);

        return jsonChild;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Utilities.readTestData("signup","src/test/resources/TestData/QAData.json"));

    }
}
