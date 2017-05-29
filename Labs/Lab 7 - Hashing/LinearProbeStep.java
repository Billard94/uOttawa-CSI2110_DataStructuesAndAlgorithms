public class LinearProbeStep implements SteppingFunction{
    public long step(int i, long data, int size){
        return i; 
    }
    public String getType(){return "Linear Probing";}
}