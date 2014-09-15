package com.goznauk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by goznauk on 2014. 9. 15..
 */
public class HttpDownloader {
    public static void download(String targetSourcePath, String targetFilePath, String targetFilename) {
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            URL url = new URL(targetSourcePath);
            URLConnection urlConnection = url.openConnection();
            is = urlConnection.getInputStream();
            byte[] buffer = new byte[1024];
            int readBytes;

            fos = new FileOutputStream(targetFilePath + targetFilename);

            while((readBytes = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readBytes);
            }
            System.out.println(targetFilePath + targetFilename + " is downloaded");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }

    }
}
