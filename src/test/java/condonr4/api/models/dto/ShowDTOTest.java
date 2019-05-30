package condonr4.api.models.dto;

import condonr4.api.model.dto.CueDTO;
import condonr4.api.model.dto.ShowDTO;
import condonr4.api.model.dto.ShowQBoxDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowDTOTest {

    private ShowDTO showDTO;
    private ShowQBoxDTO showQBoxDTO = new ShowQBoxDTO();
    private CueDTO cueDTO = new CueDTO();

    @Before
    public void setUp() {
        showDTO = new ShowDTO();
        showDTO.setId("1");
        showDTO.setName("test");
        showDTO.setLastUpdated("test");
        showDTO.setOwner("test");
        showQBoxDTO.setName("test");
        showDTO.setQBoxes(new ArrayList<ShowQBoxDTO>(){{add(showQBoxDTO);}});
        cueDTO.setId(1);
        showDTO.setCues(new ArrayList<CueDTO>(){{add(cueDTO);}});
    }

    @Test
    public void testCueDTO() {
        assertThat(showDTO.getId()).isEqualTo("1");
        assertThat(showDTO.getCues().get(0).getId()).isEqualTo(cueDTO.getId());
        assertThat(showDTO.getLastUpdated()).isEqualTo("test");
        assertThat(showDTO.getName()).isEqualTo("test");
        assertThat(showDTO.getOwner()).isEqualTo("test");
        assertThat(showDTO.getQBoxes().get(0).getName()).isEqualTo(showQBoxDTO.getName());
    }
}
