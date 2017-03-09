/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugefile;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author YZub
 */
public class FileMap {
    //HashMap<NewString, reiteration count of NewString>
    private Map<String, Long> MyFileMap;
    
    FileMap(int Capacity){
        this.MyFileMap = new HashMap<>(Capacity);
    }
    /*Put into the Map only original value with a counter of it in to it's value*/
    public Long PutValue(String FileString){
        Long fr = this.MyFileMap.get(FileString);//Check for reiteration in map
        return this.MyFileMap.put(FileString, fr == null ? 1 : fr + 1);//Increment value if is reiteration
    }
    
    public Map<String, Long> getMap(){
        return this.MyFileMap;
    }
}
