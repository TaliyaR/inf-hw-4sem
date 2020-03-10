package memento.factory;

import memento.adv.Adv;
import memento.adv.VideoAdv;

public class VideoAdvFactory implements AdvFactory {
    private static VideoAdvFactory videoAdFactory;

    public static VideoAdvFactory getInstance() {
        if (videoAdFactory == null) {
            videoAdFactory = new VideoAdvFactory();
        }
        return videoAdFactory;
    }

    @Override
    public Adv createAdv(String url) {
        return new VideoAdv(false, url);
    }
}
