public class QuadraticProbeStep implements SteppingFunction{
    public long step(int i, long data, int size){
        return i*i; 
    }
    public String getType(){return "Quadratic Probing";}
}
