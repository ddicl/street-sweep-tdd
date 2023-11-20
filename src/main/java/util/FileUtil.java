package util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtil {

    public static URL fetchUrl(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("Error in fetchUrl method: " + e.getMessage());
        }
        return url;
    }

    public static boolean downloadFile(URL url, String fileName) {
        File file = new File(System.getProperty("user.dir") + "/" + fileName);
        boolean fileWasWritten = false;
        try (BufferedInputStream in = new BufferedInputStream(url.openStream()); FileOutputStream out = new FileOutputStream(file)) {
            out.write(in.readAllBytes());
            fileWasWritten = true;
        } catch (IOException e) {
            fileWasWritten = false;
            System.out.println("Error in downloadFile method: " + e.getMessage());
        }
        return fileWasWritten;
    }

}
