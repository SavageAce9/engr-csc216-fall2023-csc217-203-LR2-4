/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.util;

import java.util.AbstractList;
import java.util.Objects;

/**
 * ArrayList class has many methods to add, remove, and more for handling an array better.
 * It also extends AbstractList and has a few fields such as its own list with type E and
 * its size. It has a constant as well which determines the maximum capacity of the list.
 * @param <E> Parameter of type E in the ArrayList.
 * @author David Mond
 */
public class ArrayList<E> extends AbstractList<E> {
	/**
	 * Maximum capacity of list.
	 */
	private static final int INIT_SIZE = 10;
	/**
	 * List of type E for ArrayList.
	 */
	private E[] list;
	/**
	 * Size of list.
	 */
	private int size;
	
	/**
	 * ArrayList constructor, creates a new list of type E and sets the size to 0.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		list = (E[]) new Object[INIT_SIZE];
		size = 0;
	}
	/**
	 * Adds an element at a specific index.
	 * @param idx index to add at.
	 * @param ele element being added.
	 */
	@SuppressWarnings("unchecked")
	public void add(int idx, E ele) {
		if(ele == null) {
			throw new NullPointerException("Element cannot be null.");
		}
		if(idx < 0 || idx > size()) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		for(int i = 0; i < list.length; i++) {
			E temp = list[i];
			if (temp != null && temp.equals(ele)) {
				throw new IllegalArgumentException("Duplicate element not allowed.");
			}
		}
		// Increase list length if needed
		if(size == list.length) {
			int newCapacity = list.length * 2;
			E[] newList = (E[]) new Object[newCapacity];
			for (int i = 0; i < size; i++) {
				newList[i] = list[i];
			}
			list = newList;
		}

		// Front of the list - shift all elements to the right
		if (idx == 0) {
			for (int i = size(); i > 0; i--) {
				E temp = list[i - 1];
				list[i] = temp;
				
			}	
			this.list[idx] = ele;
		}
		// Middle of the list - shift elements to right after index
		if (idx > 0 && idx < size()) {
			for (int i = size(); i > idx; i--) {
				E temp = list[i - 1];
				list[i] = temp;
			}
			this.list[idx] = ele;
		}
		// End of list
		if (idx == size()) {
			this.list[idx] = ele;
		}

		this.size += 1;
	}
	/**
	 * Removes an element at a specific index.
	 * @param idx index to remove at.
	 * @return E element being removed.
	 */
	public E remove(int idx) {
		if(idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		
		E removedElement = (E)list[idx];
		
		// Remove element from front
		if (idx == 0) {
			for (int i = 0; i < size(); i++) {
				E temp = list[i + 1];
				list[i] = temp;
			}
		}
		// Remove element from middle
		if (idx > 0 && idx < size()) {
			for (int i = idx; i < size(); i++) {
				E temp = list[i + 1];
				list[i] = temp;
			}
		}
		// Remove element from back
		if (idx == size() - 1) {
			list[idx] = null;
		}
//		if(idx < size - 1) {
//			System.arraycopy(list, idx + 1, list, idx, size - idx - 1);
//		}
//		
//		list[size - 1] = null;
        size--;
		return removedElement;
	}
	/**
	 * Sets an element at a specific index.
	 * @param idx index to set at
	 * @param ele element to set
	 * @return E the element after being set.
	 */
	public E set(int idx, E ele) {
		if(ele == null) {
			throw new NullPointerException("Element cannot be null.");
		}
		if(idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		for(int i = 0; i < size; i++) {
			if(i != idx && Objects.equals(list[i], ele)) {
				throw new IllegalArgumentException("Duplicate element not allowed.");
			}
		}
		
		
		E temp = (E) list[idx];
		list[idx] = ele;
		
		return temp;
	}
	/**
	 * Gets the element at a specific index.
	 * @param idx index to get from
	 * @return E element to return.
	 */
	public E get(int idx) {
		if(idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		return (E)list[idx];
	}
	/**
	 * Gets the size of list.
	 * @return int size of list.
	 */
	public int size() {
		return size;
	}

}