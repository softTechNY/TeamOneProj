package Utility;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Created by JHANGIR on 1/8/2017.
 */
public class DBConnect {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    // List<String> list = new ArrayList<String>();

    public static Properties loadPropertiesFile() throws Exception{
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("C:\\Users\\rrt\\IdeaProjects\\MoonShot\\Generic\\lib\\MySQL.properties");
        prop.load(ism);
        ism.close();

        return prop;
    }

    // Connect to Database

}
