package condonr4.api.models.dto;

import condonr4.api.model.dto.CueDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CueDTOTest {

   private CueDTO cueDTO;

    @Before
    public void setUp() {
        cueDTO = new CueDTO();
        cueDTO.setDescription("test");
        cueDTO.setId(1);
        cueDTO.setLength(0);
        cueDTO.setPostwait(0);
        cueDTO.setPrewait(0);
        cueDTO.setType(new ArrayList<String>(){{add("test");}});
    }

    @Test
    public void testCueDTO() {
        assertThat(cueDTO.getDescription()).isEqualTo("test");
        assertThat(cueDTO.getId()).isEqualTo(1);
        assertThat(cueDTO.getLength()).isEqualTo(0);
        assertThat(cueDTO.getPostwait()).isEqualTo(0);
        assertThat(cueDTO.getPrewait()).isEqualTo(0);
        assertThat(cueDTO.getType().get(0)).isEqualTo("test");
    }
}
