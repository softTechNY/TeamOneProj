package PageFactorySearch;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by JHANGIR on 1/13/2017.
 */
public class FindStoreMethods {
    @FindBy(how = How.XPATH, using = "")
    public static WebElement findStore;
    public void clickFindStore() { findStore.click();}

    @FindBy(how= How.XPATH, using = "")
    public static WebElement zipInput;
    public void clickFindStoreNEnter(String value){zipInput.sendKeys(value);}

    @FindBy(how =How.XPATH, using = "")
    public static WebElement searchWithinButton;
    public void clickSearchWithinButton(String value) { searchWithinButton.sendKeys(value);}


    @FindBy(how= How.XPATH, using = "")
    public static WebElement submitButton;
    public void clickSubmitButton() {submitButton.click();}


}
