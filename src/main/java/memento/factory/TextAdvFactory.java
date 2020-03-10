package memento.factory;

import memento.adv.Adv;
import memento.adv.TextAdv;

public class TextAdvFactory implements AdvFactory{
    private static TextAdvFactory textAdv;

    public static TextAdvFactory getInstance() {
        if (textAdv == null) {
            textAdv = new TextAdvFactory();
        }
        return textAdv;
    }

    @Override
    public Adv createAdv(String url) {
        return new TextAdv(url);
    }
}
