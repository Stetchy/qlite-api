package condonr4.api.models;

import condonr4.api.model.Shows;
import condonr4.api.model.dto.CueDTO;
import condonr4.api.model.dto.ShowQBoxDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowsTest {

    private Shows shows;
    private ShowQBoxDTO showQBoxDTO = new ShowQBoxDTO();
    private CueDTO cueDTO = new CueDTO();

    @Before
    public void setUp() {
        shows = new Shows();
        shows.setId("1");
        shows.setName("test");
        shows.setLastUpdated("test");
        shows.setOwner("test");
        showQBoxDTO.setName("test");
        shows.setQBoxes(new ArrayList<ShowQBoxDTO>(){{add(showQBoxDTO);}});
        cueDTO.setId(1);
        shows.setCues(new ArrayList<CueDTO>(){{add(cueDTO);}});
    }

    @Test
    public void testCueDTO() {
        assertThat(shows.getId()).isEqualTo("1");
        assertThat(shows.getCues().get(0).getId()).isEqualTo(cueDTO.getId());
        assertThat(shows.getLastUpdated()).isEqualTo("test");
        assertThat(shows.getName()).isEqualTo("test");
        assertThat(shows.getOwner()).isEqualTo("test");
        assertThat(shows.getQBoxes().get(0).getName()).isEqualTo(showQBoxDTO.getName());
    }
}
