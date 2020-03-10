package memento.page;

import java.util.ArrayList;

public class VideoAdvPage extends Page {
    private String name;
    private ArrayList<Page> links;
    private Integer curPos = 0;

    @Override
    public Page goToAd() {
        return null;
    }

    @Override
    public String toString() {
        return "VideoAdvPage{" +
                "name='" + name + '\'' +
                '}';
    }
}
