package productsMenu;

import CommonAPI.BaseBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JHANGIR on 1/7/2017.
 */
public class InProductsTxt  extends BaseBlock {
  //  @Test
    public void getProductsTxt() throws InterruptedException {
        clickByXpath(".//*[@id='collegeBridalArea']/div[1]/a");
        List<String> list = new ArrayList(14);
        for (int i = 0; i < list.size(); i++) {
            list = getTextFromWebElements(".//*[@id='collegeBridalArea']/div[1]/div/ul/li[" + i + "]/a");

        }
        for (String el : list) {
            System.out.println(el);
        }
    }
}
