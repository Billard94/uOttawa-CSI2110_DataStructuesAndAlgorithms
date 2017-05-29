public class ReverseStringHash implements HashFunction<String>{
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    public long Hash(String key){
        long hash = 0;
        String s = key.toLowerCase();
        for(int i =key.length()-1; i >= 0; i--){    
            hash = hash*26 + alpha.indexOf(s.charAt(i)+"");
        }
        return Math.abs(hash);
    }
}