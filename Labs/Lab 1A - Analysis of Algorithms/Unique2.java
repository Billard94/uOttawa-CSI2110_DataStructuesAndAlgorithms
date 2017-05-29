
import java.util.*;
public class Unique2{
 
 public static boolean unique2(int[] input){
  Arrays.sort(input);
  for(int i = 0; i < input.length-1; i++){
   if(input[i] == input[i+1]) 
    return false;
  }
  return true;
 }
 

}