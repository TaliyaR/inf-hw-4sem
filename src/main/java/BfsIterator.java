import java.util.*;

//Перечисляет элементы как поиск в ширину.  По уровням сверху вниз
public class BfsIterator implements Iterator {
    private Queue<Node> queue = new LinkedList<>();
    private Node node;
    private Node currentNode;

    public BfsIterator(Tree tree) {
        this.currentNode = tree.getRoot();
        this.queue.add(currentNode);
//        this.node = currentNode;
    }

//    @Override
//    public Node next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        } else {
//            if (!node.getChildrens().isEmpty()) {
//                queue.addAll(node.getChildrens());
//                currentNode = queue.remove();
//                node = queue.element();
//                return currentNode;
//            } else {
//                currentNode = queue.remove();
//                if (!queue.isEmpty()) {
//                    node = queue.element();
//                }
//                return currentNode;
//            }
//        }
//    }

    @Override
    public Node next(){
        currentNode = queue.poll();
        queue.addAll(currentNode.getChildrens());
        return currentNode;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
//        return ((currentNode != null && !queue.isEmpty())
//                || (!queue.isEmpty() && !queue.element().getChildrens().isEmpty()));
    }

}
