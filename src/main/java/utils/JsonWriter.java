package utils;

import jakarta.xml.bind.JAXBException;

import java.io.*;
import java.nio.file.Files;
import java.util.Date;
import java.util.logging.Logger;

public class JsonWriter {

    private static Logger logger = Logger.getLogger(ExcelReader.class.getName());

    public static void saveObject(String path, String json) throws IOException {

        Date current = new Date();
        long time = current.getTime();

        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        File outputJsonFile = new File(theDir + "\\req_" + time + ".json");
        FileOutputStream fos = new FileOutputStream(outputJsonFile);
        fos.write(json.getBytes());
        fos.close();
        logger.info("Json file created successfully");
    }
}
