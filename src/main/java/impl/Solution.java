package impl;

import model.Avvenimento;
import model.Livexml;
import model.Scommessa;
import org.apache.commons.lang.StringUtils;
import service.LiveXmlService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Justin on 01/06/2017.
 */
public class Solution {

    private String path;


    public Solution(String path){
        this.path = path;
    }

    /**
     * This method will crate a list fo Aveenimeto objects ordered by dateTime
     * in decending order
     * @return List<Avvenimento>
     */
    public List<Avvenimento> getAllAvvenimentoDecendingOrderOfDate(){
        List<Avvenimento> returnValue = null;
        LiveXmlService service = new LiveXmlService();
        Livexml liveXml = service.parseFile(path);
        if(liveXml!= null){
            returnValue = liveXml.getAvvenimentos();
            if(returnValue!=null){
               Collections.sort(returnValue, new Comparator<Avvenimento>() {
                   @Override
                   public int compare(Avvenimento o1, Avvenimento o2) {
                       return o2.getDateTime().compareTo(o1.getDateTime());
                   }
               });
            }
        }
        return returnValue;
    }

    /**
     * This method will create a list of Avvenimento objects in descending order of
     * cod_programma
     * @return
     */
    public List<Avvenimento> getAllAvvenimentoDescendingOrderOfCodProgramma(){
        List<Avvenimento> returnValue = null;
        LiveXmlService service = new LiveXmlService();
        Livexml liveXml = service.parseFile(path);
        if(liveXml!= null){
            returnValue = liveXml.getAvvenimentos();
            if(returnValue!=null){
                Collections.sort(returnValue, new Comparator<Avvenimento>() {
                    @Override
                    public int compare(Avvenimento o1, Avvenimento o2) {
                        return o2.getCod_programma().compareTo(o1.getCod_programma());
                    }
                });
            }
        }
        return returnValue;
    }

    /**
     * This method will create a map. The key will be the sigla_sport
     * the value will a string with all the des_tipo separated by ",
     * @return HashMap<String,String>
     */
    public HashMap<String,String>  getDesTipoScoForSiglaSports(){
        LiveXmlService service = new LiveXmlService();
        Livexml liveXml = service.parseFile(path);
        if(liveXml!=null){
            List<Avvenimento> avvenimentoList = liveXml.getAvvenimentos();
            if(avvenimentoList!=null && !avvenimentoList.isEmpty()){
                HashMap<String,HashSet<Scommessa>>  sportScommessaMap= new HashMap<>();
              avvenimentoList.stream().forEach(avvenimento -> {
                  List<Scommessa>  scommessaList = avvenimento.getScommessas();
                    HashSet<Scommessa> scommessaSet = sportScommessaMap.get(avvenimento.getSigla_sport());
                    if(scommessaSet==null){
                        sportScommessaMap.put(avvenimento.getSigla_sport(),new HashSet<>(scommessaList));
                    }
                    else{
                        scommessaSet.addAll(scommessaList);
                        sportScommessaMap.put(avvenimento.getSigla_sport(),scommessaSet);
                    }
                });
              if(sportScommessaMap!=null){
                  HashMap<String,String> siglaSportDestipScoMap = new HashMap<>();
                  sportScommessaMap.forEach((key,value) ->{
                        String desTipoScoList = value.stream().map(Scommessa::getDes_tipo_sco).collect(Collectors.joining(","));
                      siglaSportDestipScoMap.put(key,desTipoScoList);
                  });
                  return siglaSportDestipScoMap;
              }
            }
        }
        return null;
    }

    /**
     * This method will create a map of all the sigla sports. Each of them will have a integer key
     * corresponding to the order of date in the xml.
     * @return
     */
    public HashMap<Integer,String> getAllSiglaSports(){
        LiveXmlService service = new LiveXmlService();
        Livexml liveXml = service.parseFile(path);
        Integer counter = 0;
        if(liveXml!=null){
            List<Avvenimento> avvenimentos = liveXml.getAvvenimentos();
            if(avvenimentos!= null &&!avvenimentos.isEmpty()){
                HashMap<Integer,String> myMap = new HashMap<>();
                for(Avvenimento avvenimento : avvenimentos){
                    counter++;
                    myMap.put(counter,avvenimento.getDes_avvenimento());
                }
                return myMap;
            }
        }
        return null;
    }

    /**
     * This method will take index as input form the console.
     * It will then get the corrsponding sigla sport and will caluclate the egents for it
     * @param index
     * @param siglaSportsMap
     * @return
     */
    public HashMap<Integer,String> getEventsForDesAvvenimento(Integer index,HashMap<Integer,String> siglaSportsMap){
        if(index>0 && siglaSportsMap!=null && !siglaSportsMap.isEmpty()){
            String siglaSport = siglaSportsMap.get(index);
            LiveXmlService service = new LiveXmlService();
            Livexml liveXml = service.parseFile(path);
            if(StringUtils.isNotEmpty(siglaSport)){
                HashMap<Integer,String> scommessaMap = getScommessaListForSiglaSport(siglaSport,liveXml);
                return scommessaMap;
            }
        }
        return null;
    }

    /**
     * This method will get a list of all the Scommessa for a sigla sport
     * @param siglaSport
     * @param livexml
     * @return
     */
    private HashMap<Integer,String> getScommessaListForSiglaSport(String siglaSport, Livexml livexml) {
        if(livexml!=null && StringUtils.isNotEmpty(siglaSport)){
            List<Avvenimento> avvenimentos = livexml.getAvvenimentos().stream().filter(x->siglaSport.equalsIgnoreCase(x.getDes_avvenimento())).collect(Collectors.toList());
            Collections.sort(avvenimentos, new Comparator<Avvenimento>() {
                @Override
                public int compare(Avvenimento o1, Avvenimento o2) {
                    return o1.getDateTime().compareTo(o2.getDateTime());
                }
            });
            HashMap<Integer,String> myReturnMap = new HashMap<>();
            Integer counter = 0;
            for(Avvenimento avvenimento:avvenimentos){
                if(avvenimento.getScommessas()!=null && !avvenimento.getScommessas().isEmpty()){
                    for(Scommessa scommessa: avvenimento.getScommessas()){
                        if(StringUtils.isNotEmpty(scommessa.getDes_tipo_sco())){
                            counter++;
                            myReturnMap.put(counter,scommessa.getDes_tipo_sco());
                        }

                    }
                }
            }
            return myReturnMap;
        }
        return null;
    }


}
