package study.techno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class City {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait( driver, 5 );
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();


        // to select "Setup", the first child of group items
        driver.findElement( By.cssSelector( ".group-items > :nth-child(1)" ) ).click();
        // to select "Parameters", the first child of  the first child of group items
       driver.findElement( By.cssSelector( ".group-items > :nth-child(1) > .children > :nth-child(1)" ) ).click();
//        // to select " cities ", the second child of the first child of  the first child of group items
        driver.findElement( By.cssSelector( ".group-items > :nth-child(1) > .children > :nth-child(1) > .children > :nth-child(2)" ) ).click();
//
//        // Click on the plus button, element that has attribute 'data-icon' with value 'plus'
        driver.findElement( By.cssSelector( "[data-icon='plus']" ) ).click();
//
       WebElement nameTextbox = driver.findElement( By.cssSelector( "mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input" ) );
       String mycity = "mycity";nameTextbox.sendKeys( mycity );
//
//        //     8. Choose any country in the dropdown
       driver.findElement(By.cssSelector("#mat-select-2")).click();
//
//
       driver.findElement(By.cssSelector("#mat-option-30")).click();
//
//        //    9.Click on save
//
//
        WebElement saveIcon = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        saveIcon.click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='City successfully created']" ) ) );
            System.out.println("Creation success!");
        } catch( Exception e) {
            System.out.println("Creation failure!");
        }


        wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[text()='" + mycity + "']" ) ) );
        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-edit-button" ) ).click();

        WebElement editTextbox = driver.findElement( By.cssSelector( "mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input" ) );
        editTextbox.sendKeys( "1" );

        WebElement editSaveButton = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        editSaveButton.click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='City successfully updated']" ) ) );
            System.out.println("Updated success!");
        } catch( Exception e) {
            System.out.println("Updated failure!");
        }


        wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[text()='" + mycity + "1" + "']" ) ) );
        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-delete-button" ) ).click();

        driver.findElement( By.cssSelector( "mat-dialog-container button[type=\"submit\"]" ) ).click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='City successfully deleted']" ) ) );
            System.out.println("Deleted success!");
        } catch( Exception e) {
            System.out.println("Deleted failure!");
        }
   }



}