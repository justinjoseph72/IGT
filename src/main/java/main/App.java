package main;

import impl.Solution;
import model.Avvenimento;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Justin on 01/06/2017.
 */

public class App {

    /**
     * Starting point need to provide the path to the xml file
     * @param args
     */

    public static void main(String[] args){
        if(args.length>0){
            String path = args[0];
            if(StringUtils.isNotEmpty(path)){
                Solution solution = new Solution(path);
                displayMenu(solution);
            }
            else{
                System.out.println("Please provide a valid path to the test xml!!!");
            }
        }
        else{
            System.out.println("Please provide a path to the test xml!!!");
        }
     }

    /**
     * THis method will display the menu
     * @param solution
     */
    private static void displayMenu(Solution solution) {
        System.out.print("");
        System.out.println("\t\t******** Menu*********** ");
        System.out.println("\t\t***************************** ");
        System.out.println("\tPlease choose from the following options");
        System.out.printf("\t\t%d.   A List ordered by cod_program\n",1);
        System.out.printf("\t\t%d.   A List ordered by dateTime\n",2);
        System.out.printf("\t\t%d.   A List of different desp_tipo divided by sigla_sport\n",3);
        System.out.printf("\t\t%d.   A List of sigla sports\n",4);
        System.out.printf("\t\t%d.   Quit\n",5);
        System.out.println();
        System.out.print("Your choice: ");
        String option = System.console().readLine();

        switch (option){
            case "1":
                List<Avvenimento> codProgramList= solution.getAllAvvenimentoDescendingOrderOfCodProgramma();
                if(codProgramList!=null && !codProgramList.isEmpty()){
                    codProgramList.forEach(obj -> System.out.println(obj.getSigla_sport() + ", " + obj.getDes_manif()
                            + ", " + obj.getDes_avvenimento() + " , " + obj.getDateTime()));
                }
                else{
                    System.out.println(" No output");
                }
                displayMenu(solution);
                break;
            case "2":
                List<Avvenimento> orderByDateList= solution.getAllAvvenimentoDecendingOrderOfDate();
                if(orderByDateList!=null && !orderByDateList.isEmpty()){
                    orderByDateList.forEach(obj -> System.out.println(obj.getSigla_sport() + ", " + obj.getDes_manif()
                            + ", " + obj.getDes_avvenimento() + " , " + obj.getDateTime()));
                }
                else{
                    System.out.println(" No output");
                }
                displayMenu(solution);
                break;
            case "3":
                HashMap<String,String> siglaSportMap = solution.getDesTipoScoForSiglaSports();
                if(siglaSportMap!=null && !siglaSportMap.isEmpty()){
                    siglaSportMap.forEach((key,value)->{
                        System.out.println("sigla_sport = " + key);
                        System.out.println(value);
                    });
                }
                else{
                    System.out.println(" No output");
                }
                displayMenu(solution);
                break;
            case "4":
                HashMap<Integer,String> myMap = solution.getAllSiglaSports();
                if(myMap!=null && !myMap.isEmpty()){
                    myMap.forEach((key,value) -> {
                        System.out.printf("\t\t%d.  %s\n",key,value);
                    });
                    System.out.print("Please select a sport : ");
                    String inputIndex = System.console().readLine();
                    if(StringUtils.isNotEmpty(inputIndex) && StringUtils.isNumeric(inputIndex)){
                        Integer index = Integer.parseInt(inputIndex);
                        HashMap<Integer,String>  scommessaMap= solution.getEventsForDesAvvenimento(index,myMap);
                        if(scommessaMap!= null && !scommessaMap.isEmpty()){
                                scommessaMap.forEach((key,value) -> {
                                    System.out.printf("%d.  %s\n",key,value);
                                });
                            }
                    }else{
                        System.out.println("Invalid entry");
                    }
                }
                displayMenu(solution);
                break;
            case "5":
                System.exit(0);
                default:
                    System.out.print("Invalid entry");
                    displayMenu(solution);
        }
    }
}
