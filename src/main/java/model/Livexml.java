package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
public class Livexml {


    private String creazione;
    private List<Avvenimento> avvenimentos;

    @XmlAttribute
    public String getCreazione() {
        return creazione;
    }

    public void setCreazione(String creazione) {
        this.creazione = creazione;
    }

    @XmlElement(name = "avvenimento")
    public List<Avvenimento> getAvvenimentos() {
        return avvenimentos;
    }

    public void setAvvenimentos(List<Avvenimento> avvenimentos) {
        this.avvenimentos = avvenimentos;
    }
}
