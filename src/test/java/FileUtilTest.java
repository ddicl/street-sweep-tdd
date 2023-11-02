import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilTest {

    @Test
    void fetchUrl_returns_url() {
        URL url = null;
        URL urlFromMethod = null;

        try {
            url = new URL("https://www.google.com");
        } catch(MalformedURLException e) {
            System.out.println("Error in fetchUrl_returns_url test: " + e.getMessage());
        }
        urlFromMethod = FileUtil.fetchUrl("https://www.google.com");

        assertEquals(url, urlFromMethod);
    }

    @Test
    void downloadFile_returns_true() {
        String fileName = "street_sweeping_data.csv";
        URL url = null;

        try {
            url = new URL("https://data.boston.gov/dataset/00c015a1-2b62-4072-a71e-79b292ce9670/resource/9fdbdcad-67c8-4b23-b6ec-861e77d56227/download/tmpx9lbex7l.csv");
        } catch (MalformedURLException e) {
            System.out.println("Error in downloadFile_returns_file_name test: " + e.getMessage());
        }

        assert url != null;
        assertTrue(FileUtil.downloadFile(url, fileName));
    }

    @Test
    void downloadFile_returns_false_when_invalid_url() {
        String fileName = "false_test.csv";
        URL url = null;

        try {
            url = new URL("https://gkjhkjhhlk.jhkjh");
        } catch (MalformedURLException e) {
            System.out.println("Error in downloadFile_returns_file_name test: " + e.getMessage());
        }

        assert url != null;
        assertFalse(FileUtil.downloadFile(url, fileName));
    }

}
