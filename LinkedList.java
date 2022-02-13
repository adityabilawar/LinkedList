import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient element insertion and
 * removal. This class contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class LinkedList {
	private Node first;

	/**
	 * Constructs an empty linked list.
	 */
	public LinkedList() {
		// complete code to initialize the instance variable
		first = null;
	}

	/**
	 * Returns the first element in the linked list.
	 * 
	 * @return the first element in the linked list
	 */
	public Object getFirst() {
		if (first == null) {throw new NoSuchElementException();
		}  
		return first.data;
	
	}

	/**
	 * Removes the first element in the linked list.
	 * 
	 * @return the removed element
	 */
		public Object removeFirst() {
			if (first == null) {throw new NoSuchElementException();
			}
			// complete code to delete the first node
			// remember, we know that the linked list is not empty
			// also remember to return the data held in that removed node
			Object element = first.data;
			first = first.next;
			return element;
			
		}

	/**
	 * Adds an element to the front of the linked list.
	 * 
	 * @param element the element to add
	 */
	public void addFirst(Object element) {
		// complete code to add a new node containing element
		// at the beginning of the linked list
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
		
	}
	
	public String toString() {
		
		String a = "";
			ListIterator iter = this.listIterator();
		while (iter.hasNext())
				a += iter.next() + "\n";
			return a;
		}
	
	/**
	 * Returns an iterator for iterating through this list.
	 * 
	 * @return an iterator for iterating through this list
	 */
	public ListIterator listIterator() {
		return new LinkedListIterator();
	}
/**
 * We will use a private inner class for our Node class
 * as well as for our LinkedListIterator class
 * Notice that the class is private, but the 
 * instance variables are public (Why?)
 *
 */
	private class Node {
		public Object data;
		public Node next;
		
		public Node() {

		}
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private class LinkedListIterator implements ListIterator {
		private Node position;
		private Node previous;
		private boolean isAfterNext; //this is a flag that tracks if next() has been called

		/**
		 * Constructs an iterator that points to the front of the linked list.
		 */
		public LinkedListIterator() {
			position = null;
			previous = null;
			isAfterNext = false;  // set to true after traversing node to allow for remove() and set()
		}

		/**
		 * Moves the iterator past the next element.
		 * 
		 * @return the traversed element
		 */
		public Object next() {
			if (!hasNext()) {throw new NoSuchElementException();}
			previous = position; // Used so that I can remember node for remove
			isAfterNext = true;
			
			if (position == null) {
				position = first;
			} else {
				position = position.next;
			}

			return position.data;
		}

		/**
		 * Tests if there is an element after the iterator position.
		 * 
		 * @return true if there is an element after the iterator position
		 */
		public boolean hasNext() {
			if (position == null) {
				return first != null;
			} else {
				return position.next != null;
			}
		}

		/**
		 * Adds an element before the iterator position and moves the iterator past the
		 * inserted element.
		 * 
		 * @param element the element to add
		 */
		public void add(Object element) {
			if (position == null) {
				addFirst(element);
				position = first;
			} else {
				// complete code to add a new node containing element
				// in the middle of the linked list
				
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
				
			}

			isAfterNext = false;
		}

		/**
		 * Removes the last traversed element. This method may only be called after a
		 * call to the next method.
		 */
		public void remove() {	
			if (!isAfterNext) {	throw new IllegalStateException();}

			if (position == first) {
				removeFirst();
			} else {
				// complete code to delete the node at 'position'
				previous.next = position.next;
			
			}
			position = previous;
			isAfterNext = false;
		}

		/**
		 * Sets the last traversed element to a different value.
		 * 
		 * @param element the element to set
		 */
		public void set(Object element) {
			if (!isAfterNext) {throw new IllegalStateException();
			}
			// complete code to overwrite the data at position with element
			position.data = element;
			
		}
	}
}