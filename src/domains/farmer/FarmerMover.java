
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author riley
 */
public class FarmerMover extends Mover{
    public static final String ALONE = "Farmer Goes Alone";
    public static final String WOLF = "Farmer Takes Wolf";
    public static final String GOAT = "Farmer Takes Goat";
    public static final String CABBAGE = "Farmer Takes Cabbage";
    
            public FarmerMover() {
            super.addMove(ALONE, s -> tryAlone(s));
            super.addMove(WOLF, s -> tryWolf(s));
            super.addMove(GOAT, s -> tryGoat(s));
            super.addMove(CABBAGE, s -> tryCabbage(s));
        }
    
    private State tryAlone(State state){
         FarmerState p = (FarmerState) state;
         FarmerState other0 = new FarmerState("East","East","West","East"); 
         FarmerState other1 = new FarmerState("West","East","West","East");
         FarmerState other2 = new FarmerState("West","West","East","West");
         FarmerState other3 = new FarmerState("East","West","East","West");
         String[] cur = p.getState();
        String newfarm = cur[0];
         if(state.equals(other0) ||
            state.equals(other1) ||
            state.equals(other2) ||
            state.equals(other3) 
             )
         {
             
             if(newfarm.equals("West")){
                 cur[0]="East";
             }
             if(newfarm.equals("East")){
                 cur[0]= "West";
             }
             return new FarmerState(cur[0],cur[1],cur[2],cur[3]);
         }else{
             return null;
         }
         
    }
    
    private State tryWolf(State state){
        FarmerState p = (FarmerState) state;
        String[] cur = p.getState();
        //Farmer, Wolf, Goat , Cabbage
         FarmerState other0 = new FarmerState("West","West","East","West"); 
         FarmerState other1 = new FarmerState("East","East","West","East");
         FarmerState other2 = new FarmerState("West","West","West","East"); 
         FarmerState other3 = new FarmerState("East","East","East","West");        
        
         if(state.equals(other0) ||
            state.equals(other1) ||
            state.equals(other2) ||
            state.equals(other3)){
             String newfarm = cur[0];
             if(newfarm.equals("West")){
                 cur[0]="East";
                 cur[1]="East";
             }
             if(newfarm.equals("East")){
                 cur[0]= "West";
                 cur[1]= "West";
             }
             return new FarmerState(cur[0],cur[1],cur[2],cur[3]);
         }else{
        
        
     return null;
    }
   }
   
    private State tryGoat(State state){
         FarmerState p = (FarmerState) state;
        String[] cur = p.getState();
        String newfarm = cur[0];
        if(cur[0].equals(cur[2])){
            if(newfarm.equals("West")){
                 cur[0]="East";
                 cur[2]="East";
             }
             if(newfarm.equals("East")){
                 cur[0]= "West";
                 cur[2]= "West";
             }
             return new FarmerState(cur[0],cur[1],cur[2],cur[3]);
        }else 
            return null;
}
    private State tryCabbage(State state){
        FarmerState p = (FarmerState) state;
        String[] cur = p.getState();
         FarmerState other0 = new FarmerState("West","East","West","West"); 
         FarmerState other1 = new FarmerState("West","West","East","West");
         FarmerState other2 = new FarmerState("East","West","East","East"); 
         FarmerState other3 = new FarmerState("East","East","West","East");  
         
         
          if(state.equals(other0) ||
            state.equals(other1) ||
            state.equals(other2) ||
            state.equals(other3)){
            String newcab = cur[3];
                if(newcab.equals("West")){
                    cur[0]="East";
                    cur[3]="East";
                }
                if(newcab.equals("East")){
                    cur[0]= "West";
                     cur[3]= "West";
                }
            return new FarmerState(cur[0],cur[1],cur[2],cur[3]);
          }else{
               return null;
           }
       
    }
    
    
}

