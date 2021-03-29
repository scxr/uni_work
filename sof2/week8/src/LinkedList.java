public class LinkedList<T> implements ISet<T> {
    private Node<T> head, tail;
    private int size;
    @Override
    public boolean add(T value) {
        if (head == null) {
            head = new Node<T>(value);
            tail = head;
            size++;
            return true;
        }
        if (this.contains(value)) {
            return false;
        }
        Node<T> node = new Node<T>(value);
        node.parent = tail;
        tail.child = node;
        tail = node;
        size++;
        return true;
    }
    @Override
    public void clear() {
        head = null;
        tail = null;
        size=0;
    }


    /* todo */
    @Override
    public boolean contains(T value) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    /* todo */
    @Override
    public boolean remove(T value) {
        return true;
    }

}

class Node<T> {
    Node<T> parent;
    Node<T> child;
    T value;

    public Node(T object) {
        value = object;
    }


    /*
    reset all values to null
    */
    public void kill() {
        parent = null;
        child = null;
        value = null;
    }

    public String toString() {
        return String.format("Value : %s \n Parent : %s \n Child : %s", value, parent.toString(), child.toString());
    }
}
