import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class SaveTreeFacade {
    private static SaveTreeFacade instance;
    public static SaveTreeFacade getInstance() {
        if (instance == null) {
            instance = new SaveTreeFacade();
        }
        return instance;
    }

    private SaveTreeFacade() {
    }

    ObjectMapper mapper = new ObjectMapper();
    public String createJson(Tree tree) {
        String result = null;
        try {
            result = mapper.writeValueAsString(tree.getRoot());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Tree decodeJson(String json) {
        Tree tree = null;
        try {
            tree = new Tree(mapper.readValue(json, Node.class));
            BfsIterator iterator = new BfsIterator(tree);
            while (iterator.hasNext()) {
                Node current = iterator.next();
                for (Node node : current.getChildrens()) {
                    node.setParent(current);
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return tree;
    }
    /*public File writeTree(Tree tree) {
        Node root = tree.getRoot();
        try {
            DocumentBuilderFactory factory = new DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("Root");
            doc.appendChild(rootElement);

            rootElement.appendChild(getNode(doc, root));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static Node getNode(Document doc, Node node){
        Element element = doc.createElement(node.getType().toString());
        element.appendChild(getElements(doc, "name", node.getName()));
        element.appendChild(getElements(doc,"parent", );
        element.appendChild(getElements(doc, "priority", String.valueOf(node.getPriority())));
        element.appendChild(get))
        return element;
    }

    private static Node getElements(Document doc, String name, String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
*/

//    public Tree readTree(File file) {
//    }
}
