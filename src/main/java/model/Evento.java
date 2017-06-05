package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Justin on 01/06/2017.
 */
@XmlRootElement
public class Evento {


    private int num_evento;

    private String des_evento;

    private int quota;
    @XmlAttribute(name = "num_evento")
    public int getNum_evento() {
        return num_evento;
    }

    public void setNum_evento(int num_evento) {
        this.num_evento = num_evento;
    }

    @XmlAttribute(name = "quota")
    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }
    @XmlAttribute(name = "des_event")
    public String getDes_evento() {
        return des_evento;
    }

    public void setDes_evento(String des_evento) {
        this.des_evento = des_evento;
    }
}
