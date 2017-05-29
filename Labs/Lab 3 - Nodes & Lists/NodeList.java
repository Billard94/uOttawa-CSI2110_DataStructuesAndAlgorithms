import java.util.NoSuchElementException;
import java.util.LinkedList;

public class NodeList<E> {
  // The linked list which is to be adapted
  protected LinkedList<E> linkedList = new LinkedList<E>();

  // Directly available
  public int size() {
    return linkedList.size();
  }

  // Directly available
  public boolean isEmpty() {
     return linkedList.isEmpty();
  }

  // fix me!
  public boolean isFirst(E element) {
    if (first() == element){
     return true;
    }
    else{
     return false;
    }
  }

  // fix me!
  public boolean isLast(E element) {
    if (last() == element){
      return true;
     }
     else{
      return false;
     }
  }

  // Directly available
  public E first() 
    throws NoSuchElementException {
    return linkedList.element();
  }


  // Directly available
  public E last() 
    throws NoSuchElementException {
    return linkedList.getLast();
  }

  // fix me!
  E prev(E element)
    throws NoSuchElementException {
    throw new NoSuchElementException();
    // return null;
  }


  // fix me!
  E next(E element)
    throws NoSuchElementException {
    throw new NoSuchElementException();
    // return null;
  }

  // fix me!
  public void swapElements(E element1, E element2)
    throws NoSuchElementException {
    throw new NoSuchElementException();
  }
  

  // fix me!
  public void set(E currElement, E repElement)
    throws NoSuchElementException {
    throw new NoSuchElementException();
  }


  // Directly available
  public void addFirst(E element) {
    linkedList.addFirst(element);
    return;
  }

  // Directly available
  public void addLast(E element) {
    linkedList.addLast(element);
    return;
  }

  // fix me!
  public void addBefore(E currElement,E addElement)
    throws NoSuchElementException {
    throw new NoSuchElementException();
  }

  // fix me!
  public void addAfter(E currElement,E addElement) 
    throws NoSuchElementException {
    throw new NoSuchElementException();
  }
  
  // fix me!
  public E remove(E element) 
    throws NoSuchElementException {
    throw new NoSuchElementException();
  }
}
