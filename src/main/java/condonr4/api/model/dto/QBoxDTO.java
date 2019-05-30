package condonr4.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QBoxDTO {
    private String id;
    private String name;
    private String ipAddress;
    private boolean assigned;
}
