import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int size;
    private int INITIAL_CAPACITY = 2;
    private float LOAD_FACTOR = 1f;//equal or less than 1
    private float DOWNSIZE_FACTOR = .5f;//equal or less than 1
    private float INCREMENTAL_FACTOR = 1.5f;
    private int currentCapacity;

    public RandomizedQueue() {// construct an empty randomized queue
        array = (Item[]) new Object[INITIAL_CAPACITY];
        size = 0;
        currentCapacity = INITIAL_CAPACITY;
    }

    public static void main(String[] args) {// unit testing
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println( );

        rq.enqueue(6);
        rq.enqueue(7);
        rq.enqueue(8);
        rq.enqueue(9);
        rq.enqueue(10);

        for (Integer integer : rq) {
            System.out.println(integer);
        }
        for (Integer integer : rq) {
            System.out.println(integer);
        }

        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());

    }

    public boolean isEmpty() {// is the queue empty?
        return size == 0;
    }

    public int size() { // return the number of items on the queue
        return size;
    }

    public void enqueue(Item item) {// add the item
        validate(item);
        increaseIfRequired();
        array[size] = item;
        size++;
    }

    private void increaseIfRequired() {
        if (size / (double) currentCapacity >= LOAD_FACTOR) {
            Item[] temp = array;
            int cap = currentCapacity;
            currentCapacity = currentCapacity * 2;
            array = (Item[]) new Object[currentCapacity];
            for (int i = 0; i < cap; i++) {
                array[i] = temp[i];
            }

        }
    }

    private void downSizeIfRequired(){
        if (size / (double) currentCapacity <= DOWNSIZE_FACTOR) {
            Item[] temp = array;
            int cap = currentCapacity;
            currentCapacity = currentCapacity / 2;
            array = (Item[]) new Object[currentCapacity];
            for (int i = 0; i < currentCapacity; i++) {
                array[i] = temp[i];
            }
        }
    }

    public Item dequeue() {
        downSizeIfRequired();
        if (size > 0) {
            int lastRemoved = StdRandom.uniform(size);
            Item item = array[lastRemoved];
            array[lastRemoved] = array[size - 1];
            array[size - 1] = null;
            size--;
            return item;
        }
        throw new NoSuchElementException();
    }                    // remove and return a random item

    public Item sample() { // return (but do not remove) a random item
        if (size > 0) {
            return array[StdRandom.uniform(size)];
        }
        throw new NoSuchElementException();
    }

    public Iterator<Item> iterator() {// return an independent iterator over
        // items in random order
        return new Itr();
    }

    private void validate(Item item) {
        if (item == null) throw new NullPointerException();
    }

    private class Itr implements Iterator<Item> {

        private int cursor;
        private int size;
        private Item[] local;

        Itr() {
            size = size();
            local = array.clone();
        }

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                cursor = StdRandom.uniform(size);
                int cursor = StdRandom.uniform(size);
                Item item = local[cursor];
                local[cursor] = local[size - 1];
                local[size - 1] = null;
                size--;
                return item;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}