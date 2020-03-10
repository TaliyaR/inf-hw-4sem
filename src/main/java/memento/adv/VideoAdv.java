package memento.adv;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoAdv implements Adv {
    private boolean isWatched;
    private String adUrl;
}
