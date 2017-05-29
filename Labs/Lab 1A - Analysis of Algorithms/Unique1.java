
public class Unique1{

 public static boolean unique1(int[] input){
  for(int i = 0; i < input.length-1; i++){
   for(int j = i+1; j < input.length; j++){
    if(input[i] == input[j])
     return false;
   }
  }
  return true;  
 }

}