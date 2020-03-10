package memento.page;


import java.util.ArrayList;


public class Page {
    private String name;
    private ArrayList<Page> links;

    public Page(String name) {
        this.name = name;
    }

    public Page(String name, ArrayList<Page> links) {
        this.name = name;
        this.links = links;
    }

    public Boolean hasLink(String name) {
        if (!(links == null)) {
            for (Page p : links) {
                if ((p.name).equals(name)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                '}';
    }
}
