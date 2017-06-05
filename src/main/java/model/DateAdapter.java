package model;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Justin on 01/06/2017.
 */
public class DateAdapter extends XmlAdapter<String,LocalDateTime> {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        LocalDateTime dateTime = null;
        if(StringUtils.isNotEmpty(v)){
            dateTime = LocalDateTime.parse(v, formatter);
        }
        return dateTime;
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        if(v!=null){
            return v.format(formatter);
        }
        return null;

    }
}
