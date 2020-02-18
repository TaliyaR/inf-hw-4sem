import java.util.*;

//Перечисляет как поиск в ширину, но при перечислении детей перечисляет их в порядке приоритета.
public class BfsPriorityIterator implements Iterator {
    private Queue<Node> queue = new LinkedList<>();
    private Node currentNode;

    public BfsPriorityIterator(Tree tree) {
        this.currentNode = tree.getRoot();
        this.queue.add(currentNode);
    }

    @Override
    public Node next(){
        currentNode = queue.poll();
        Collections.sort(currentNode.getChildrens(), new SortByPriority());
        queue.addAll(currentNode.getChildrens());
        return currentNode;

    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
