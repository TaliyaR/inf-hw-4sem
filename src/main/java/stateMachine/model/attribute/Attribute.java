package stateMachine.model.attribute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attribute {
    private Integer developerId;
    private Integer testerId;
    private String error;
    private String text;

}
