
public class QuickSortInPlace<T extends Comparable> {
  protected T[] d_seq;

  /**
   * Construct a QuickSort object
   * _seq will be sorted on construction
   */
  public QuickSortInPlace(T[] _seq) {
    d_seq = _seq;
    // Note: Make sure right = size-1 for initial call! 
    quickSort(0, d_seq.length-1);
  }

  protected void quickSort( int _left, int _right )
  {
    // 
    // Instead of checking to end recursion at the start, we check to
    // see if recursion is needed when it arises.  It saves one level
    // of recursive calls, at the expense of a couple of comparisions.

    // Pivot selection is always d_seq[right]. It ought to be randomized.
    T pivot = d_seq[_right];

    int pIndex = partition( pivot, _left, _right );
    // The pivot is now at pIndex, so recur on both sides of it.
    // This is the point where we also check to stop recursion.
    if (_left < pIndex - 1) {
      quickSort( _left, pIndex - 1);
    }
    if (pIndex + 1 < _right) {
      quickSort( pIndex + 1, _right);
    }
  }

  /**
   * Partition the array in place After the call all elements smaller
   * than the pivot are on the left of the returned index; all
   * elements larger than the pivot are on the left of the returned
   * index.
   */
  protected int partition(T _pivot, int _left, int _right) {
    T temp;
    int leftIndex = _left; // will scan rightward
    int rightIndex = _right - 1; // will scan leftward
    while (leftIndex <= rightIndex) {
      // Scan rightward to find an element larger than the pivot.
      while ((leftIndex <= rightIndex) && 
             (d_seq[leftIndex].compareTo(_pivot)<0)) {
        leftIndex++;
      }
      // Scan leftward to find an element smaller than the pivot.
      while ((rightIndex >= leftIndex) && 
             (d_seq[rightIndex].compareTo(_pivot)>=0)) {
        rightIndex--;
      }
      if (leftIndex < rightIndex) {
        // Both elements were found.
        temp = d_seq[leftIndex];
        d_seq[leftIndex] = d_seq[rightIndex];
        d_seq[rightIndex] = temp;
      }
    } // The loop continues until the indices cross.
    // Place the pivot by swapping it with the element at leftIndex.
    temp = d_seq[leftIndex];
    d_seq[leftIndex] = d_seq[_right];
    d_seq[_right] = temp;
    return leftIndex;
  }
}
