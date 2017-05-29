public class QuadraticDoubleHashStep implements SteppingFunction{
        public long step(int i, long data, int size){
        return (i*i)*(data%size); 
    }
    public String getType(){return "Quadratic Double Hashing";}
}
