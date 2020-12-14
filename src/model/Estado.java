package model;

import java.util.HashMap;
import java.util.Map;


public class Estado {
   
  private static int id = 0;
  private String name;
  Map<String, Estado> transition;
  private boolean start;
  private boolean end;

    public Estado() {
        this.name = "q"+id;
        start = false;
        end = false;
        transition = new HashMap<>();
        id++;
        
    }
    public Map<String, Estado> getTransition() {
        return transition;
    }


    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Estado.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    public void setTransition(Map<String, Estado> transition) {
        this.transition = transition;
    }

    public boolean isStart() {
        return start;
    }

    public void setEstadoInicial(boolean start) {
        this.start = start;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEstadoFinal(boolean end) {
        this.end = end;
    }
    
    
    
    
    
        
        
    }
    

    
 
     
 
 
    
    

