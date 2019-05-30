package condonr4.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowDTO {
    private String id;
    private String name;
    private String owner;
    private String lastUpdated;
    private List<CueDTO> cues;
    private List<ShowQBoxDTO> qBoxes;
}
