package patterns;

import java.util.Iterator;
import java.util.Stack;

//Перечисляет итераторы как поиск в глубину. Уходит сначала в детей, а потом в братьев
public class DfsIterator implements Iterator {
    private Stack<Node> stack = new Stack<>();
    private Node currentNode;

    public DfsIterator(Tree tree) {
        this.currentNode = tree.getRoot();
        this.stack.add(currentNode);
    }

    @Override
    public Node next() {
        currentNode = stack.pop();
        stack.addAll(currentNode.getChildrens());
        return currentNode;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
