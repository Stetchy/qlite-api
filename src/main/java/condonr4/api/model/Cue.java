package condonr4.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cue {
    @Id
    private int id;
    private String description;
    private int length;
    private int prewait;
    private int postwait;
    private List<String> type;
}
