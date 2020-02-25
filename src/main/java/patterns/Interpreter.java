package patterns;

public class Interpreter {


    //add <адрес родителя> <название ноды> <тип ноды> <приоритет>
    private void add(String str) {
        String[] address = str.split(" ");
        String name = address[2];
        String type = address[3];
        int priority = Integer.parseInt(address[3]);

    }

    //return children <тип> <Название>
    public void returnChildren(String str, Tree tree) {
        String[] address = str.split(" ");
        Node foundNode = findNodeByNameAndType(address, tree);
        if (foundNode != null) {
            System.out.println(foundNode.getChildrens().toString());
        } else {
            System.out.println("patterns.Node not found");
        }
    }

    //delete <адрес ноды>
    private void delete(String str, Tree tree) {
        String[] address = str.split(" ");
    }

    //save
    private void save(String str, Tree tree) {
        String[] addr = str.split(" ");
        SaveTreeFacade.getInstance().createJson(tree);
    }

    private Node findNodeByName(String[] address, Tree tree) {
        String name = address[1];
        BfsIterator iterator = new BfsIterator(tree);
        Node foundNode;
        while (iterator.hasNext()) {
            foundNode = iterator.next();
            if (foundNode.getName().equals(name)) {
                return foundNode;
            }
        }
        return null;
    }


    private Node findNodeByNameAndType(String[] address, Tree tree) {
        String type = address[2];
        String name = address[3];
        BfsIterator iterator = new BfsIterator(tree);
        Node foundNode;
        while (iterator.hasNext()) {
            foundNode = iterator.next();
            if (foundNode.getName().equals(name) && foundNode.getType().toString().equals(type)) {
                return foundNode;
            }
        }
        return null;
    }

    //Russia,Tatarstan,Kazan
    private Node findNodeByAddress(String[] address, Tree tree) {
        String[] addr = address[1].split(",");
        String name1 = addr[0];
        BfsIterator iterator = new BfsIterator(tree);
        for (int i = 0; i < addr.length; i++) {
            while (iterator.hasNext()) {
                Node foundNode = iterator.next();
                if (foundNode.getName().equals(name1)) {
                }
            }
        }
        return null;
    }
}
