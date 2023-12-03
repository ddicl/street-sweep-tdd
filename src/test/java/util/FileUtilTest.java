package util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilTest {

    private static URL url;
    private static URL dataUrl;
    private static URL badUrl;
    private static URL malformedUrl;
    private static final String fileName = "street_sweeping_data_test.csv";
    private static final String falseFileName = "false_test.csv";

    @BeforeAll
    public static void init() {
        try {
            url = new URL("https://www.google.com");
            dataUrl = new URL("https://data.boston.gov/dataset/00c015a1-2b62-4072-a71e-79b292ce9670/resource/9fdbdcad-67c8-4b23-b6ec-861e77d56227/download/tmpx9lbex7l.csv");
            badUrl = new URL("https://gkjhkjhhlk.jhkjh");
        } catch(MalformedURLException e) {
            System.out.println("Error in FileUtilTest init method: " + e.getMessage());
        }
    }

    @Test
    void fetchUrl_returns_url() {
        URL urlFromMethod = null;
        try {
            urlFromMethod = FileUtil.fetchUrl("https://www.google.com");
        } catch (MalformedURLException e) {
            fail();
        }
        assertNotNull(urlFromMethod);
        assertEquals(url, urlFromMethod);
    }

    @Test
    void fetchUrl_throws_exception_when_malformed() {
        try {
            FileUtil.fetchUrl("fsfsfsf");
            fail();
        } catch(MalformedURLException ignored) {}
    }

    @Test
    void downloadFile_returns_true() {
        assertNotNull(dataUrl);
        assertTrue(FileUtil.downloadFile(dataUrl, fileName));
    }

    @Test
    void downloadFile_returns_false_when_invalid_url() {
        assertNotNull(badUrl);
        assertFalse(FileUtil.downloadFile(badUrl, falseFileName));
    }

    @AfterAll
    public static void cleanup() {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println(file.getName() + " was deleted.");
        } else {
            System.out.println(file.getName() + " was NOT deleted.");
        }
    }

}
