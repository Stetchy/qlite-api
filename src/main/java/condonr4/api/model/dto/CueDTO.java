package condonr4.api.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CueDTO {
    private int id;
    private String description;
    private int length;
    private int prewait;
    private int postwait;
    private List<String> type;
}
