package utils;

import jakarta.xml.bind.*;

import java.io.File;
import java.util.Date;
import java.util.logging.Logger;

public class XmlWriter {
    private static Logger logger = Logger.getLogger(ExcelReader.class.getName());
    public static void saveObject(String path, Object object) throws JAXBException {

        Date current = new Date();
        long time = current.getTime();

        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        File outputXmlFile = new File(theDir + "\\req_" + time + ".xml");
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(object, outputXmlFile);

        logger.info("XML marshalling complete");
    }
}