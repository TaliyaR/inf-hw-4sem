package memento.adv;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TextAdv implements Adv {
    private String adUrl;
}
