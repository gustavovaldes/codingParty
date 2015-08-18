import java.util.Iterator;

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
        while(!d.isEmpty()){
            System.out.println(d.removeLast());
        }

        d.addLast(1);//x
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);
        while(!d.isEmpty()){
            System.out.println(d.removeFirst());
        }

        d.addFirst(4);
        d.addFirst(3);
        d.addFirst(2);
        d.addFirst(1);
        while(!d.isEmpty()){
            System.out.println(d.removeFirst());
        }
    }

    public boolean isEmpty() {// is the deque empty?
        return size == 0;
    }

    public int size() { // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item) {  // add the item to the front
        Node node = new Node(item);
        if (first != null) {
            first.previous = node;
            node.next = first;
        }
        if(last==null) last = node;

        first = node;
        size++;
    }

    public void addLast(Item item) { // add the item to the end
        Node node = new Node(item);
        if (last != null) {
            last.next = node;
            node.previous = last;
        }
        if(first==null) first = node;

        last = node;
        size++;
    }

    public Item removeFirst() {// remove and return the item from the front
        if(first!=null){
            Item item = first.item;
            first = first.next;
            size--;
            return item;
        }
        return null;
    }

    public Item removeLast() {// remove and return the item from the end
        if(last!=null){
            Item item = last.item;
            last = last.previous;
            size--;
            return item;
        }
        return null;
    }

    public Iterator<Item> iterator() { // return an iterator over items in
        return null;
    }

    private class Node {
        Item item;
        Node previous;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }
}