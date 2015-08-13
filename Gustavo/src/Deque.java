import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    public Deque() {// construct an empty deque
    }

    public static void main(String[] args) {
    }   // unit testing

    public boolean isEmpty() {// is the deque empty?
        return false;
    }

    public int size() { // return the number of items on the deque
        return 0;
    }

    public void addFirst(Item item) {  // add the item to the front
    }

    public void addLast(Item item) { // add the item to the end
    }

    public Item removeFirst() {// remove and return the item from the front
        return null;
    }

    public Item removeLast() {// remove and return the item from the end

        return null;
    }

    public Iterator<Item> iterator() { // return an iterator over items in
    // order from front to end
        return null;
    }

    private class Node{
        Item item;
        Node previous;
        Node next;
        Node(Item item){
            this.item = item;
            if(previous!=null){
                previous.next= this;
            }
        }
    }
}