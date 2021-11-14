import java.util.ArrayList;

public class ArrayStack implements IStackable {
    ArrayList<Integer> List;

    public ArrayStack() {
        this.List = new ArrayList<Integer>();
    }

    public int size() {
        return this.List.size();
    }

    public void push(int v) {
        this.List.add(v);
    }
    public int pop() {
        return this.List.remove(this.List.size() - 1);
    }
}
