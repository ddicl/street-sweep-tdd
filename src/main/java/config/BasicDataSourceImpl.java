package config;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class BasicDataSourceImpl {

    public static DataSource getDataSource() throws SQLException {
            Properties props = new Properties();
            PGSimpleDataSource ds = null;

            try(FileInputStream fis = new FileInputStream("src/main/resources/db.properties")) {
                props.load(fis);
                ds = new PGSimpleDataSource();
                ds.setUrl(props.getProperty("db.url"));
                ds.setUser(props.getProperty("db.user"));
            } catch (IOException e) {
                System.out.println("Error in getDataSource method: " + e.getMessage());
            }

            return ds;
    }

}
