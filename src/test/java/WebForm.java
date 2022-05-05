import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{

    private final String DATABASE_NAME = "Database";
    private final String USERNAME = "Brukernavn";
    private final String PASSWORD = "Passord";

    @FindBy(id = "database")
    private WebElement databaseName;

    @FindBy(id = "loginname")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/small")
    private WebElement alertFailed;

    @FindBy(xpath = "//*[@id=\"logo-row\"]/div/img[1]")
    private WebElement findLogo;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterDatabaseName(){
        this.databaseName.sendKeys(DATABASE_NAME);
    }

    public void enterUsername(){
        this.username.sendKeys(USERNAME);
    }

    public void enterPassword(){
        this.username.sendKeys(PASSWORD);
    }

    public void pressLoginBtn(){
        this.loginBtn.click();
    }

    public void verifyAlertFailed(){
        this.alertFailed.isDisplayed();
    }

    public void findLogo(){
        this.findLogo.isDisplayed();
    }

    public void readTitle(){
        String title = driver.getTitle();
        if (title.equalsIgnoreCase("hano ontime"))
            System.out.println("Title matches");
        else
            System.out.println(title);
    }
}