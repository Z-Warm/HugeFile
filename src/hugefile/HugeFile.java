/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugefile;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**
 *
 * @author Iurii
 */
public class HugeFile {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args){
     //TODO !!!Before we have to calculate all count of frases for set capacity for map
     //according to that count here.
     FileMap MyFileMap = new FileMap(Integer.MAX_VALUE);//Create Hash map with set capacity
     long N = 100000;//First maximum values count
     try{
     BufferedReader Rdr = Files.newBufferedReader(Paths.get("in.txt"), Charset.defaultCharset());
        Rdr.readLine();//Read file line by line
        for (String Line; (Line = Rdr.readLine()) != null;) {
            StringTokenizer st = new StringTokenizer(Line, "|");
            while(st.hasMoreTokens()){//Share line for frases by token and put frases in to HashMap
                System.out.println(st.nextToken());
                MyFileMap.PutValue(st.nextToken());//Put value into map with compearing
            }
        }
     }catch(IOException e){
         System.err.println("Error of reading file.");
     }  
     /*Delete objects from map where Value<100000*/
     Iterator IT =  MyFileMap.getMap().entrySet().iterator();
     while (IT.hasNext())
        {
            Entry<String,Long> pair = (Entry<String,Long>) IT.next();
            long Value;
            Value = pair.getValue();//Get value of counter in entry
            if(Value < N) MyFileMap.getMap().remove(IT.next());//If value is less then criteria than remove it
        }
     /*Also, we could sort thsat map by key*/
     Map<String, Long> TreeMap = new TreeMap<>(MyFileMap.getMap()); 
     System.out.println(TreeMap);
    }
    
}
