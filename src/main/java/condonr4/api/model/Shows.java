package condonr4.api.model;

import condonr4.api.model.dto.CueDTO;
import condonr4.api.model.dto.ShowQBoxDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shows {
    @Id
    private String id;
    private String name;
    private String owner;
    private String lastUpdated;
    private List<CueDTO> cues;
    private List<ShowQBoxDTO> qBoxes;
}
