package dataToSearch;

import Utility.DataReader;

import java.io.IOException;

/**
 * Created by JHANGIR on 1/8/2017.
 */
public class ItemsToBeSearched {

    //Option 2, supply search.data from External source like excel files.
    DataReader dr = new DataReader();
    public String [] getData()throws IOException {
        String path = System.getProperty("user.dir")+"/Data/items.xlsx";
        String [] st = dr.fileReader(path);
        return st;
    }
}


