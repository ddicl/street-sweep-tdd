package util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtil {

    public static URL fetchUrl(String urlString) throws MalformedURLException {
        return new URL(urlString);
    }

    public static void downloadFile(URL url, String fileName) throws UtilException {
        File file = new File(System.getProperty("user.dir") + "/" + fileName);
        try (BufferedInputStream in = new BufferedInputStream(url.openStream()); FileOutputStream out = new FileOutputStream(file)) {
            out.write(in.readAllBytes());
        } catch (IOException e) {
            throw new UtilException("Error in downloadFile method: " + e.getMessage());
        }
    }

}
