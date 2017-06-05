package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Justin on 01/06/2017.
 */
@XmlRootElement
public class Scommessa {

    private int cod_tipo_sco;

    private String des_tipo_sco;

    private int massimo_avv;

    private int minimo_avv;

    private String attivo_handicap;

    private int handicap;

    private int cod_stato_accett;

    private List<Evento> eventos;
    @XmlAttribute(name = "cod_tipo_sco")
    public int getCod_tipo_sco() {
        return cod_tipo_sco;
    }

    public void setCod_tipo_sco(int cod_tipo_sco) {
        this.cod_tipo_sco = cod_tipo_sco;
    }
    @XmlAttribute(name = "des_tipo_sco")
    public String getDes_tipo_sco() {
        return des_tipo_sco;
    }

    public void setDes_tipo_sco(String des_tipo_sco) {
        this.des_tipo_sco = des_tipo_sco;
    }
    @XmlAttribute(name = "massimo_avv")
    public int getMassimo_avv() {
        return massimo_avv;
    }

    public void setMassimo_avv(int massimo_avv) {
        this.massimo_avv = massimo_avv;
    }
    @XmlAttribute(name = "minimo_avv")
    public int getMinimo_avv() {
        return minimo_avv;
    }

    public void setMinimo_avv(int minimo_avv) {
        this.minimo_avv = minimo_avv;
    }
    @XmlAttribute(name = "attivo_handicap")
    public String getAttivo_handicap() {
        return attivo_handicap;
    }

    public void setAttivo_handicap(String attivo_handicap) {
        this.attivo_handicap = attivo_handicap;
    }
    @XmlAttribute(name = "handicap")
    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }
    @XmlAttribute(name = "cod_stato_accett")
    public int getCod_stato_accett() {
        return cod_stato_accett;
    }

    public void setCod_stato_accett(int cod_stato_accett) {
        this.cod_stato_accett = cod_stato_accett;
    }
    @XmlElement(name = "evento")
    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
