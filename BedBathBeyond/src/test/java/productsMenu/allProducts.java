package productsMenu;

import CommonAPI.BaseBlock;

/**
 * Created by JHANGIR on 1/7/2017.
 */
public class allProducts extends BaseBlock {
   // @Test(priority = 2)
public void checkProducts() throws InterruptedException{
    mouseHoverByXpath(".//*[@id='collegeBridalArea']/div[1]/a");
    sleepFor(5);
    mouseHoverByXpath(".//*[@id='collegeBridalArea']/div[2]/a");
    sleepFor(5);
    mouseHoverByXpath(".//*[@id='shopForCollegeLink']/a");
    sleepFor(5);

}
}
