import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private transient Node first;
    private transient Node last;
    private int size;

    public Deque() {// construct an empty deque

    }

    public static void main(String[] args) {// unit testing
        Deque d = new Deque<Integer>();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addFirst(4);
        while (!d.isEmpty()) {
            System.out.println(d.removeLast());
        }

        d.addLast(1);//x
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);
        while (!d.isEmpty()) {
            System.out.println(d.removeFirst());
        }


        d.addFirst(4);
        d.addFirst(3);
        d.addFirst(2);
        d.addFirst(1);
        while (!d.isEmpty()) {
            System.out.println(d.removeFirst());
        }

        d.addLast(6);
        d.addLast(7);
        d.addLast(8);
        d.addLast(9);

        while (!d.isEmpty()) {
            System.out.println(d.removeFirst());
        }
        d.addLast(6);
        d.addLast(7);
        d.addLast(8);
        d.addLast(9);

        //System.out.println("f");
        for (Iterator it = d.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        System.out.println("new itr");
        for (Iterator it = d.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        List<String> list = new ArrayList<>();
        list.add("uno");
        list.add("dos");
        list.add("tres");
        list.add("cuatro");

        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next());
        }

        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }

    public boolean isEmpty() {// is the deque empty?
        return size == 0;
    }

    public int size() { // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item) {  // add the item to the front
        validate(item);
        Node node = new Node(item);
        if (first != null) {
            first.previous = node;
            node.next = first;
        }
        if (last == null) last = node;

        first = node;
        size++;
    }

    public void addLast(Item item) { // add the item to the end
        validate(item);
        Node node = new Node(item);
        if (last != null) {
            last.next = node;
            node.previous = last;
        }
        if (first == null) first = node;

        last = node;
        size++;
    }

    public Item removeFirst() {// remove and return the item from the front
        if (first != null) {
            Item item = first.item;
            first = first.next;
            if (first != null) first.previous = null;
            size--;
            if (size == 0) last = null;
            return item;
        }
        throw new NoSuchElementException();
    }

    public Item removeLast() {// remove and return the item from the end
        if (last != null) {
            Item item = last.item;
            last = last.previous;
            if (last != null) last.next = null;
            size--;
            if (size == 0) first = null;
            return item;
        }
        throw new NoSuchElementException();
    }

    private void validate(Item item) {
        if (item == null) throw new NullPointerException();
    }

    public Iterator<Item> iterator() { // return an iterator over items in
        return new Iter();
    }

    private class Node {
        Item item;
        Node previous;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    private class Iter implements Iterator<Item> {

        private Node cursor;

        Iter() {
            cursor = first;
        }

        @Override
        public boolean hasNext() {
            return cursor!= null;
        }

        @Override
        public Item next() {
            Item item = null;
            if (cursor!= null) {
                item = cursor.item;
                cursor = cursor.next;
                return item;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();//todo implement anyway
            // (out of scope)
        }
    }
}