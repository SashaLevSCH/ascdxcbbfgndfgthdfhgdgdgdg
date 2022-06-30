package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import PageLocators.HealthCareGovPageLocators.VerifyYourIdentityLocators;
import setup.BasePage;

import java.util.Map;
import java.util.NoSuchElementException;

public class VerifyYourIdentityPage extends BasePage {
    private static final Logger log = LogManager.getLogger(VerifyYourIdentityPage.class);


    private VerifyYourIdentityLocators verifyYourIdentityPage;

    public VerifyYourIdentityPage(WebDriver driver) {
        super(driver);
        this.verifyYourIdentityPage = new VerifyYourIdentityLocators();
        PageFactory.initElements(driver, verifyYourIdentityPage);
    }




    public void countyQuestion(Map<String, String> map) {
        try {

            javaScriptScrollIntoView(verifyYourIdentityPage.countyquestion);

            String QuestionText = verifyYourIdentityPage.countyquestion.getText();
            //System.out.print("Found Question: " + QuestionText);
            WebElement answer = driver.findElement(By.xpath("//a[contains(.,'" + map.get("COUNTY OF RESIDENCE") + "')]"));

            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answer);
            answer.click();

        } catch (NoSuchElementException e) {
        }
    }


    public void secondquestion(Map<String, String> map) {
        WebElement secondquestion = driver.findElement(By.cssSelector("div[class='lite-card ridp-questions blue-bg'] div:nth-child(4) div:nth-child(1)"));
        String basetext = secondquestion.getText();
        if(basetext.contains("choose the city from the following list where this street is located")) {
           //System.out.print("Found Question 2: " + basetext);
            WebElement answer = driver.findElement(By.xpath("//a[contains(.,'" + map.get("PREVIOUS CITY OF RESIDENCE") + "')]"));
            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answer);
            answer.click();
        }
        else if(basetext.contains("following businesses have you been associated with")) {
            WebElement answer = driver.findElement(By.cssSelector("div[class='lite-card ridp-questions blue-bg'] div:nth-child(4) div:nth-child(2)"));
            String answertext = answer.getText();
            if (answertext.contains( map.get("BUSINESS NAME"))){
                WebElement answerclick = driver.findElement(By.xpath("//a[contains(.,'" + map.get("BUSINESS NAME") + "')]"));
                String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
                ((JavascriptExecutor) driver).executeScript(js, answerclick);
                answerclick.click();
            }
        else if(answertext.contains("NONE OF THE ABOVE/DOES NOT APPLY")){
           // WebElement answer = driver.findElement(By.xpath("//a[contains(.,'" + map.get("BUSINESS NAME") + "')]"));
            WebElement answerclick = driver.findElement(By.xpath("//a[contains(.,'NONE OF THE ABOVE/DOES NOT APPLY')]"));
            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answerclick );
                answerclick .click();

        }
        else {
                System.out.print("Question Not Found: " + basetext);
            }
        }
    }




    public void thirdquestion(Map<String, String> map) {
        WebElement thrirdquestion = driver.findElement(By.cssSelector("div[class='lite-card ridp-questions blue-bg'] div:nth-child(5) div:nth-child(1)"));
        String thirdquestiontext = thrirdquestion.getText();
      //  System.out.print("Found Question 3: " + thirdquestiontext);
        if(thirdquestiontext.contains("Which of the following is a current or previous employer")) {
            System.out.print("Found Question 3: " + thirdquestiontext);
            WebElement answer3 = driver.findElement(By.xpath("//a[contains(.,'" + map.get("EMPLOYER") + "')]"));
            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answer3);
            answer3 .click();
        }

        else if(thirdquestiontext.contains("Please select the city that you have previously resided in")) {
            System.out.print("Found Question 3: " + thirdquestiontext);
            WebElement answer3 = driver.findElement(By.xpath("(//a[contains(.,'NONE OF THE ABOVE/DOES NOT APPLY')])[3]"));
            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answer3);
            answer3 .click();

        }
    }

    public void fourthquestion(Map<String, String> map) {
       // javaScriptScrollIntoView(verifyYourIdentityPage.fourthquestion);
        WebElement fourthquestion = driver.findElement(By.xpath("(//div[@class='question-label'])[4]"));
        String fourthquestiontext = fourthquestion.getText();
      System.out.print("Found Question 3: " + fourthquestiontext);
        if(fourthquestiontext.contains("Please select the vehicle that you purchased")) {
            System.out.print("Found Question 4: " + fourthquestiontext);
            WebElement answer4 = driver.findElement(By.xpath("(//a[contains(.,'NONE OF THE ABOVE/DOES NOT APPLY')])[4]"));
            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answer4);
            answer4.click();

        }
        else if(fourthquestiontext.contains("Please select the street name from the following choices")) {
            System.out.print("Found Question 3: " + fourthquestiontext);
            WebElement answer4 = driver.findElement(By.xpath("(//a[contains(.,'NONE OF THE ABOVE/DOES NOT APPLY')])[4]"));
            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answer4);
            answer4.click();

        }

      else if(fourthquestiontext.contains("Which of the following is a previous phone number of yours?")) {
            System.out.print("Found Question 3: " + fourthquestiontext);
            WebElement answer4 = driver.findElement(By.xpath("(//a[contains(.,'NONE OF THE ABOVE/DOES NOT APPLY')])[4]"));
            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answer4);
            answer4.click();

        }

        else if(fourthquestiontext.contains("you graduated from which of the following High Schools?")) {
            System.out.print("Found Question 3: " + fourthquestiontext);
            WebElement answer4 = driver.findElement(By.xpath("(//a[contains(.,'NONE OF THE ABOVE/DOES NOT APPLY')])[4]"));
            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
            ((JavascriptExecutor) driver).executeScript(js, answer4);
            answer4.click();

        }

    }


    public void enterIdentityDetails(Map<String, String> map) {

        verifyYourIdentityPage.phoneNumber.sendKeys(Keys.HOME, map.get("PHONE"));
        verifyYourIdentityPage.dob.sendKeys(Keys.HOME, map.get("DOB/YOB"));
        inputText(verifyYourIdentityPage.street, map.get("ADDRESS"));
        inputText(verifyYourIdentityPage.city, map.get("CITY"));
        inputText(verifyYourIdentityPage.zip, map.get("ZIP"));
        clickUsingJS(verifyYourIdentityPage.continueBtn);
        hardWait(5);
        countyQuestion(map);
        secondquestion(map);
        thirdquestion(map);
        fourthquestion(map);
        hardWait(5);
        clickUsingJS(verifyYourIdentityPage.Verifymyidentity);
        hardWait(5);



    }


}
