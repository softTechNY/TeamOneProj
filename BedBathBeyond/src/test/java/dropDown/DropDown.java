package dropDown;

import PageFactorySearch.DropDownMenuPage;
import core.DropdownMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by JHANGIR on 1/7/2017.
 */
public class DropDown extends DropDownMenuPage {
    @Test
    public void Dropdown() throws NullPointerException, InterruptedException {
        //  DropdownMethods drop = PageFactory.initElements(driver, DropdownMethods.class);
        iterate();
    }

    public void iterate() {
        DropdownMethods drop = PageFactory.initElements(driver, DropdownMethods.class);
        for (int i = 1; i <= 15; i++) {
            ClickDropDownMenuXpath();
            clickByXpath(".//*[@id='globalSearchForm']/div[1]/ul/li[" + i + "]/span");


        }
    }

}


