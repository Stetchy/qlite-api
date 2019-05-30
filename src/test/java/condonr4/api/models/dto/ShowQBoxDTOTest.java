package condonr4.api.models.dto;

import condonr4.api.model.dto.ShowQBoxDTO;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowQBoxDTOTest {

    private ShowQBoxDTO showQBoxDTO;

    @Before
    public void setUp() {
        showQBoxDTO = new ShowQBoxDTO();
        showQBoxDTO.setId("1");
        showQBoxDTO.setIpAddress("0");
        showQBoxDTO.setName("test");
        showQBoxDTO.setType("test");
    }

    @Test
    public void testCueDTO() {
        assertThat(showQBoxDTO.getId()).isEqualTo("1");
        assertThat(showQBoxDTO.getType()).isEqualTo("test");
        assertThat(showQBoxDTO.getIpAddress()).isEqualTo("0");
        assertThat(showQBoxDTO.getName()).isEqualTo("test");
    }
}
