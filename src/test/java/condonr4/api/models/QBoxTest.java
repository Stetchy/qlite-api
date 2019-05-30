package condonr4.api.models;

import condonr4.api.model.QBox;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QBoxTest {

    private QBox qbox;

    @Before
    public void setUp() {
        qbox = new QBox();
        qbox.setAssigned(true);
        qbox.setId("1");
        qbox.setIpAddress("0");
        qbox.setName("test");
    }

    @Test
    public void testCueDTO() {
        assertThat(qbox.getId()).isEqualTo("1");
        assertThat(qbox.isAssigned()).isEqualTo(true);
        assertThat(qbox.getIpAddress()).isEqualTo("0");
        assertThat(qbox.getName()).isEqualTo("test");
    }
}
