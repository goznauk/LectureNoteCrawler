package com.goznauk;

public class Main {
    public static void main(String[] args) {
        // Edit this part! - example source
        final String targetSourcePath = "http://your.com/url/here";
        final String targetFilePath = "./";


        // Edit the targetName by your naming rule
        for(int i = 1; i<100;i++) {
            final String num = Integer.toString(i);

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    // (Url, targetPath, targetName)
                    HttpDownloader.download(targetSourcePath + num + ".pdf", targetFilePath, num + ".pdf");
                }
            });
            t.run();
        }
    }
}
