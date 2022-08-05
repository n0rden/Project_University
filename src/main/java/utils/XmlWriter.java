package utils;

import jakarta.xml.bind.*;

import java.io.File;

public class XmlWriter {
    public static void saveObject(String path, Object o) throws JAXBException {

        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        File outputXmlFile = new File(theDir + "\\req.xml");
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(o, outputXmlFile);
    }
}