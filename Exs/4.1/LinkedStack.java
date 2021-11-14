import java.util.LinkedList;

public class LinkedStack implements IStackable {
    LinkedList<Integer> List;

    public LinkedStack() {
        this.List = new LinkedList<Integer>();
    }

    public int size() {
        return this.List.size();
    }

    public void push(int v) {
        this.List.addLast(v);
    }

    public int pop() {
        return this.List.removeLast();
    }
