package patterns;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@JsonIgnoreProperties(value = {"parent"})
public class Node {
    private String name;
    private Node parent;
    private int priority;
    private Type type;
    private List<Node> childrens = new ArrayList<>();

    public Node() {}

    public Node(String name, Node parent, int priority, Type type) {
        this.name = name;
        this.parent = parent;
        this.priority = priority;
        this.type = type;
        this.childrens = new ArrayList<>();
    }

    public void addChild(Node node){
        childrens.add(node);
    }

    public String getName() {
        return name;
    }

    public Node getParent() {
        return parent;
    }

    public int getPriority() {
        return priority;
    }

    public Type getType() {
        return type;
    }

    public List<Node> getChildrens() {
        return childrens;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }

    @Override
    public String toString() {
        return name + " " + priority + ", ";
    }

    public static class Buider {
        private Node newNode;

        public Buider() {
            newNode = new Node();
        }


        public Buider setName(String name){
            newNode.name = name;
            return this;
        }

        public Buider setParent(Node node){
            newNode.parent = node;
            return this;
        }

        public Buider setPriority(int priority){
            newNode.priority = priority;
            return this;
        }

        public Buider setType(Type type){
            newNode.type = type;
            return this;
        }

        public Node build(){
            return newNode;
        }
    }
}

class SortByPriority implements Comparator<Node> {

    @Override
    public int compare(Node a, Node b) {
        return a.getPriority() - b.getPriority();
    }
}
