package memento.page;

import java.util.ArrayList;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Page {
    private String name;
    private ArrayList<Page> links;
    private Integer curPos = 0;

    public Page(String name) {
        this.name = name;
    }

    public abstract Page goToAd();

    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                '}';
    }
}
