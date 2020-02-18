import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        return tree;
    }


    public void createXml(Tree tree){
        try {
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream("tree.xml"));
            encoder.writeObject(tree.getRoot());
            encoder.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }

    }
    public Tree decodeXml(){
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new FileInputStream("tree.xml"));
            decoder.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }
        return new Tree((Node) decoder.readObject());
    }
}