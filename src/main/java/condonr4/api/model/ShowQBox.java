package condonr4.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowQBox {
    @Id
    private String id;
    private String name;
    private String type;
    private String ipAddress;
}

