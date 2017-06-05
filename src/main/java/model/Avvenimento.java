package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Justin on 01/06/2017.
 */

@XmlRootElement
public class Avvenimento {

    private String cod_programma;

    private String sigla_sport;

    private String sigla_manif;

    private String des_manif;

    private String num_avvenimento;

    private String des_avvenimento;

    private LocalDateTime dateTime;

    private String des_sport;

    private List<Scommessa> scommessas;

    @XmlAttribute(name = "cod_programma")
    public String getCod_programma() {
        return cod_programma;
    }

    public void setCod_programma(String cod_programma) {
        this.cod_programma = cod_programma;
    }
    @XmlAttribute(name = "sigla_sport")
    public String getSigla_sport() {
        return sigla_sport;
    }

    public void setSigla_sport(String sigla_sport) {
        this.sigla_sport = sigla_sport;
    }
    @XmlAttribute(name="sigla_manif")
    public String getSigla_manif() {
        return sigla_manif;
    }

    public void setSigla_manif(String sigla_manif) {
        this.sigla_manif = sigla_manif;
    }
    @XmlAttribute(name = "des_manif")
    public String getDes_manif() {
        return des_manif;
    }

    public void setDes_manif(String des_manif) {
        this.des_manif = des_manif;
    }
    @XmlAttribute(name = "num_avvenimento")
    public String getNum_avvenimento() {
        return num_avvenimento;
    }

    public void setNum_avvenimento(String num_avvenimento) {
        this.num_avvenimento = num_avvenimento;
    }
    @XmlAttribute(name = "des_avvenimento")
    public String getDes_avvenimento() {
        return des_avvenimento;
    }

    public void setDes_avvenimento(String des_avvenimento) {
        this.des_avvenimento = des_avvenimento;
    }

    @XmlAttribute(name = "des_sport")
    public String getDes_sport() {
        return des_sport;
    }

    public void setDes_sport(String des_sport) {
        this.des_sport = des_sport;
    }
    @XmlElement(name = "scommessa")
    public List<Scommessa> getScommessas() {
        return scommessas;
    }

    public void setScommessas(List<Scommessa> scommessas) {
        this.scommessas = scommessas;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlAttribute(name ="dateTime")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
