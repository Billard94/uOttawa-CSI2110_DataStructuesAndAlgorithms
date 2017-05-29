public class DoubleHashStep implements SteppingFunction{
    public long step(int i, long data, int size){
        return i*(data%size); 
    }
    public String getType(){return "Double Hashing";}
}
