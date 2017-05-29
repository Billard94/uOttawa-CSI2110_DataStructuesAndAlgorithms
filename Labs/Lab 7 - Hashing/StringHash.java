public class StringHash implements HashFunction<String>{
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    public long Hash(String key){
        long hash = 0;
        String s = key.toLowerCase();
        for(int i =0; i < key.length(); i++){    
            hash = hash*26 + alpha.indexOf(s.charAt(i)+"");
        }
        //System.out.println(Math.abs(hash));
        return Math.abs(hash);
    }
}
