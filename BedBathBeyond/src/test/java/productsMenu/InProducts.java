package productsMenu;

import CommonAPI.BaseBlock;
import org.testng.annotations.Test;

/**
 * Created by JHANGIR on 1/7/2017.
 */
public class InProducts  extends BaseBlock {
   // @Test(priority = 1)
    public void products() throws InterruptedException {

        clickByXpath(".//*[@id='collegeBridalArea']/div[1]/a");
        for(int i =1; i<14; i++) {
            mouseHoverByXpath(".//*[@id='collegeBridalArea']/div[1]/div/ul/li["+i+"]/a");
            sleepFor(5);
        }

    }
    @Test(priority = 2)
  //  @Test
    public void checkProducts() throws InterruptedException{
        driver.get("www.bedbathandbeyond.com");
        mouseHoverByXpath(".//*[@id='collegeBridalArea']/div[1]/a");
        sleepFor(5);
        mouseHoverByXpath(".//*[@id='collegeBridalArea']/div[2]/a");
        sleepFor(5);
        mouseHoverByXpath(".//*[@id='shopForCollegeLink']/a");
        sleepFor(5);
        mouseHoverByXpath(".//*[@id='bridalGiftRegistryAnchor']");
        sleepFor(5);

    }



}
