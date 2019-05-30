package condonr4.api.models.dto;

import condonr4.api.model.dto.QBoxDTO;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class QBoxDTOTest {


    private QBoxDTO qBoxDTO;

    @Before
    public void setUp() {
        qBoxDTO = new QBoxDTO();
        qBoxDTO.setAssigned(true);
        qBoxDTO.setId("1");
        qBoxDTO.setIpAddress("0");
        qBoxDTO.setName("test");
    }

    @Test
    public void testCueDTO() {
        assertThat(qBoxDTO.getId()).isEqualTo("1");
        assertThat(qBoxDTO.isAssigned()).isEqualTo(true);
        assertThat(qBoxDTO.getIpAddress()).isEqualTo("0");
        assertThat(qBoxDTO.getName()).isEqualTo("test");
    }
}
