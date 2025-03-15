package com.utils;

import com.reporting.Logging;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ResultsZipper {

    private static String[] fileNames = new String[2];
    private static final String REPORT_PATH = System.getProperty("user.dir") + "/Reports/";
    private static final String LOG_PATH = System.getProperty("user.dir") + "/logs/";
    private static final String COMPRESSED_FILE_PATH = System.getProperty("user.dir") + "/CompressedResults/";

    /**
     * This method create a zipped file to be generated as test evidence for reporting purposes
     * and could be directly attached as an evidence to any test management tool
     */
    public static void zipFiles() {
        try {
            fileNames[0] = getLastModifiedFile(REPORT_PATH);
            fileNames[1] = getLastModifiedFile(LOG_PATH);
            File file = new File(COMPRESSED_FILE_PATH);
            if (!file.isDirectory())
                file.mkdir();
            final FileOutputStream fos = new FileOutputStream(COMPRESSED_FILE_PATH + "/Results.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            for (String srcFile : fileNames) {
                File fileToZip = new File(srcFile);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }

            zipOut.close();
            fos.close();
        } catch (Exception ex) {
            Logging.logInfo("Exception caught: ", ex.getMessage());
        }
    }

    private static String getLastModifiedFile(String path) {
        File directory = new File(path);
        if (directory.isDirectory()) {
            File[] dirFiles = directory.listFiles((FileFilter) FileFilterUtils.fileFileFilter());
            if (dirFiles != null && dirFiles.length > 0) {
                Arrays.sort(dirFiles, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
                return dirFiles[0].toString();
            }
        }
        return "";
    }
}
