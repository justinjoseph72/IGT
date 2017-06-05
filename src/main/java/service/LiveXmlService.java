package service;

import model.Livexml;
import org.apache.commons.lang.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Justin on 01/06/2017.
 */
public class LiveXmlService {

    /**
     * This method will parse the xml file provided in the path
     * @param path
     * @return
     */
    public Livexml parseFile(String path){
        Livexml model = null;
        if(StringUtils.isNotEmpty(path)){
            try{
                File file = new File(path);
                JAXBContext jaxbContext = JAXBContext.newInstance(Livexml.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                model=(Livexml) jaxbUnmarshaller.unmarshal(file);
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }
        return model;
    }
}
