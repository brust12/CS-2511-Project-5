/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;
import framework.problem.State;

/**
 *
 * @author Riley Brust
 */
public class FarmerState implements State{
    public FarmerState(String f,String w, String g, String c){
        this.farmer = f;
        this.wolf = w;
        this.goat = g;
        this.cabbage = c;
    }
    
    @Override
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        FarmerState otherFarmer = (FarmerState) other;
        return this.farmer.equals(otherFarmer.farmer) &&
               this.wolf.equals(otherFarmer.wolf) &&
               this.goat.equals(otherFarmer.goat) &&
               this.cabbage.equals(otherFarmer.cabbage);

    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        //Add top line
        sb.append("   |  |   \n");
       //Farmer
        if(farmer.equals("West")){
            sb.append(onwest("F"));
        }else{
            sb.append(oneast("F"));
        }
        //Wolf
        if(wolf.equals("West")){
            sb.append(onwest("W"));
        }else{
            sb.append(oneast("W"));
        }
        //Goat
        if(goat.equals("West")){
            sb.append(onwest("G"));
        }else{
            sb.append(oneast("G"));
        }
        //Cabbage
        if(cabbage.equals("West")){
            sb.append(onwest("C"));
        }else{
            sb.append(oneast("C"));
        }
        //Add bottom line
        sb.append("   |  |   ");
        
            
        
        return sb.toString();
    }
    
    private String onwest(String c){
        String returnString = " ";
        returnString+=c;
        returnString+=" |  |   \n";
        return returnString;
    }
    private String oneast(String c){
        String returnString = "   |  | ";
        returnString +=c;
        returnString += " \n";
        return returnString;
    }
    
    public String[] getState(){
        String[] state={farmer, wolf, goat, cabbage};
        return state;
        
    }
    
    private final String farmer;
    private final String wolf;
    private final String goat;
    private final String cabbage;
}
