package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A utility to iterate through elements in an array without knowing the
 * structure of the array.
 * 
 * @author Kongpon Charanwattanakit
 *
 * @param <T>
 *            the type of elements returned by this iterator
 */
public class ArrayIterator<T> implements Iterator<T> {
	/** whether this ArrayIterator can call .remove() */
	private boolean legal;
	/** index of the next element to return */
	private int cursor;
	/** attribute for the array we want to iterate over */
	private T[] array;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.legal = false;
		// TODO: initialize any other variables you need
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (this.hasNext()) {
			T next = array[cursor];
			this.cursor++;
			this.legal = true;
			return next;
		} else
			throw new NoSuchElementException();
	}

	/**
	 * Return {@code true} if the iteration has more non-null elements.
	 * 
	 * @return {@code true} if the iteration has more non-null elements,
	 *         {@code false} otherwise
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < this.array.length; i++) {
			if (this.array[i] != null) {
				cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove last element returned by this ArrayIterator. This method can be
	 * called only once per call to {@link #next}.
	 * 
	 * @throws IllegalStateException
	 *             if the {@code next} method has not yet been called, or the
	 *             {@code remove} method has already been called after the last
	 *             call to the {@code next} method
	 */
	@Override
	public void remove() {
		if (legal) {
			array[cursor - 1] = null;
			legal = false;
		} else
			throw new IllegalStateException();
	}

}
