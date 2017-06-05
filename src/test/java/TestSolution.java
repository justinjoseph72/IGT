import impl.Solution;
import model.Avvenimento;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Justin on 01/06/2017.
 */
public class TestSolution {
    String path ="C:\\IGT\\Java_EE_Test.xml";

    @Test
    public void test_getAllAvvenimentoDecendingOrderOfDate(){
        Solution solution = new Solution(path);
        List<Avvenimento> myList = solution.getAllAvvenimentoDecendingOrderOfDate();
        assertNotNull(myList);
        myList.forEach(obj -> System.out.println(obj.getSigla_sport() + " " + obj.getDes_manif()
        + " " + obj.getDes_avvenimento() + "  " + obj.getDateTime()));
    }

    @Test
    public void test_getAllAvvenimentoDescendingOrderOfCodProgramma(){
        Solution solution = new Solution(path);
        List<Avvenimento> myList = solution.getAllAvvenimentoDecendingOrderOfDate();
        assertNotNull(myList);
        myList.forEach(obj -> System.out.println(obj.getSigla_sport() + " " + obj.getDes_manif()
                + " " + obj.getDes_avvenimento() + "  " + obj.getDateTime()));
    }

    @Test
    public void test_getDesTipoScoForSiglaSports(){
        Solution solution = new Solution(path);
        HashMap<String,String> myMap = solution.getDesTipoScoForSiglaSports();
        assertNotNull(myMap);
        myMap.forEach((key,value)->{
            System.out.println("sigla_sport = " + key);
            System.out.println(value);
        });
    }

    @Test
    public void test_AllSiglaSports(){
        Solution solution = new Solution(path);
        HashMap<Integer,String> myMap = solution.getAllSiglaSports();
        assertNotNull(myMap);
        myMap.forEach((key,value) -> {
            System.out.printf("%d.  %s\n",key,value);
        });
    }

    @Test
    public void test_getEventsForDesAvvenimento(){
        Solution solution = new Solution(path);
        HashMap<Integer,String> myMap = solution.getAllSiglaSports();
        assertNotNull(myMap);
        myMap.forEach((key,value) -> {
            System.out.printf("%d.  %s\n",key,value);
        });
        HashMap<Integer,String> myMap1 = solution.getEventsForDesAvvenimento(2,myMap);
        assertNotNull(myMap1);
        myMap1.forEach((key,value) -> {
            System.out.printf("%d.  %s\n",key,value);
        });
    }


}
