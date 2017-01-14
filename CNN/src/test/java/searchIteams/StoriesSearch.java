package searchIteams;

import CommonAPI.BaseBlock;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by JHANGIR on 1/6/2017.
 */
public class StoriesSearch extends BaseBlock {
    @Test
    public void clickUSTab() throws Exception {
        //driver.get("www.cnn.com");
        driver.findElement(By.linkText("U.S.")).click();
        sleepFor(5);
        driver.navigate().back();
        driver.findElement(By.linkText("World")).click();
        sleepFor(5);
        driver.navigate().back();
        driver.findElement(By.linkText("Politics")).click();
        sleepFor(5);
        driver.navigate().back();
        driver.findElement(By.linkText("Opinion")).click();
        sleepFor(5);
        driver.navigate().back();
        driver.findElement(By.linkText("Health")).click();
        sleepFor(5);

    }

}
