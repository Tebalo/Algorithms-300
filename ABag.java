import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
*Filename: ABag.java
*@author Bopaki Tebalo
*@author Wapa Teko Omogolo Edzani
*@version 0.1
*Descripion:The{@code ABag} class represents a bag of generic items.
*It supports insertion an iterating over the items in arbitrary order.
*This implementation uses a doubly linked list with a non-static class 
*node.
*/
public class ABag<E>implements Iterable<E>{
	private Node first;
	private Node last;
	/**
	*bag concstructor. Does nothing at the moment...
	*/
	public ABag(){
       this.first = first;
       this.last = last;
	}
	/**
	*@return BagIterator
	*/
	public Iterator<E> iterator(){ 
		return new BagIterator();
	}
	/**
	*An iterator over a double-linked list.
	**/
	public class BagIterator implements Iterator<E>{
        private Node current = first;
          /**
           *@return current != null checks if there is a next item in the iterator.
           */
           public boolean hasNext(){
            	return current != null;
           }
          /**
           *@return the next item E the iterator(and advances the iterator).
           */
           public E next(){
        	    if(!hasNext()) throw new NoSuchElementException();
        	    E item = current.data;
          	    current = current.next;
        	    return item;
           }
          /**
           *This method is optional in the Iterator interface
           */
            public void remove(){
              	throw new UnsupportedOperationException();
            }
	}
	/**
	*Adds the item at the front of this bag.
	*@param item the data to add to this bag.
	**/
	public void addFront(E item){
       Node oldFirst = first;
       first = new Node();
       first.data = item;
       first.next = oldFirst;
	}
	/**
	*Adds the item at the back of this bag.
	*@param item the data to add to this bag.
	**/
	public void addBack(E item){
        Node temp = new Node();
        temp.data = item;
        last = temp;
	}
	/**
	*@return true when the bag is empty, false otherwise.
 	**/
	public boolean isEmpty(){
	    return first == null;
	}
	/**
	*Returns the number of items in this bag.
	*@return the items in this bag.
	**/
	public int size(){
		int sum = 0;
		for(Node t = first; t != null; t = t.next)
			sum++;
		return sum;
	}
	/**
	*@param i index of node.
	*@return data at index i in the bag.
	*@return null when index i is out of bounds.
	**/
	public E get(int i){
		int sum = 0;
		Node t;
		//Iterator<Node> it = t.iterator();
		for(t = first; t != null; t = t.next){
		//while(it.hasNext()){
            if(sum == i)
            	return t.data;

            sum++;
		}
		return null;
		}
	/**
	*@return a Size of a bag in a form of "Size  [4]";
	**/
	public String toString(){
		return "Size [" + String.format("%.2f", size()) + "]";
	}
	/**
	*Helper linked list class
	**/
	private class Node{
		E data;
		Node next;
		Node prev;
	}
}
