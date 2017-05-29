
public class BubbleSort<T extends Comparable> {

  public BubbleSort(T[] _seq ) {
    for (int i = 0; i < _seq.length; i++) {
        for (int j = 1; j < _seq.length - i; j++) {
          // if (_seq[j - 1] > _seq[j]) {
          if (_seq[j - 1].compareTo(_seq[j]) > 0 ) {
            T temp = _seq[j];
            _seq[j] = _seq[j - 1];
            _seq[j - 1] = temp;
          }
        }
    }
  }
}
