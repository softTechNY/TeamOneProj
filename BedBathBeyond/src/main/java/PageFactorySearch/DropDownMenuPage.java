package PageFactorySearch;

import CommonAPI.BaseBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JHANGIR on 1/8/2017.
 */
public class DropDownMenuPage extends BaseBlock {
    public List<String> getMenus() {
        List<String> items = new ArrayList<String>();
        items = getTextFromWebElements("#searchDropdownBox option");

        return items;
    }

    public void typeOnInputSearch(List<String> data) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            typeByCss("#twotabsearchtextbox", data.get(i));
            input();
            sleepFor(2);
            clearBox();
        }
    }

    public void input() {
        keysInput("#twotabsearchtextbox");
    }

    public void clearBox() {
        clearInput("#twotabsearchtextbox");
    }


    @FindBy(how = How.XPATH, using = "")
    public static WebElement ddmenu;

    public void ClickDropDownMenuXpath() {ddmenu.click();}
    public void clickOnItem(int i) throws NullPointerException {
        driver.findElement(By.xpath("")).click();

    }

}


