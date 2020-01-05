package study.techno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Nationality {

    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver" );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait( driver, 5 );
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );

        driver.get( "https://test-basqar.mersys.io" );
        driver.findElement( By.cssSelector( "[formcontrolname=\"username\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "[formcontrolname=\"password\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "button[aria-label=\"LOGIN\"]" ) ).click();

        // to select "Setup", the first child of group items
        driver.findElement( By.cssSelector( ".group-items > :nth-child(1)" ) ).click();
        // to select "Parameters", the first child of  the first child of group items
        driver.findElement( By.cssSelector( ".group-items > :nth-child(1) > .children > :nth-child(1)" ) ).click();
        // to select "Nationalities", the forth child of the first child of  the first child of group items
        driver.findElement( By.cssSelector( ".group-items > :nth-child(1) > .children > :nth-child(1) > .children > :nth-child(4)" ) ).click();

        // Click on the plus button, element that has attribute 'data-icon' with value 'plus'
        driver.findElement( By.cssSelector( "[data-icon='plus']" ) ).click();

        WebElement nameTextbox = driver.findElement( By.cssSelector( "mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input" ) );
        String myUniqueNationality = "MyUniqueNationality";
        nameTextbox.sendKeys( myUniqueNationality );

        WebElement saveIcon = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        saveIcon.click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Nationality successfully created']" ) ) );
            System.out.println("Creation success!");
        } catch( Exception e) {
            System.out.println("Creation failure!");
        }


        wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[text()='" + myUniqueNationality + "']" ) ) );
        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-edit-button" ) ).click();

        WebElement editTextbox = driver.findElement( By.cssSelector( "mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input" ) );
        editTextbox.sendKeys( "1" );

        WebElement editSaveButton = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        editSaveButton.click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Nationality successfully updated']" ) ) );
            System.out.println("Updated success!");
        } catch( Exception e) {
            System.out.println("Updated failure!");
        }


        wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[text()='" + myUniqueNationality + "1" + "']" ) ) );
        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-delete-button" ) ).click();

        driver.findElement( By.cssSelector( "mat-dialog-container button[type=\"submit\"]" ) ).click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Nationality successfully deleted']" ) ) );
            System.out.println("Deleted success!");
        } catch( Exception e) {
            System.out.println("Deleted failure!");
        }
    }
}
