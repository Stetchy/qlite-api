package condonr4.api.models;

import condonr4.api.model.ShowQBox;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowQBoxTest {

    private ShowQBox showQBox;

    @Before
    public void setUp() {
        showQBox = new ShowQBox("1", "test", "test", "0");
        showQBox = new ShowQBox();
        showQBox = ShowQBox.builder()
            .id("1")
            .ipAddress("0")
            .name("test")
            .type("test").build();
    }

    @Test
    public void testCueDTO() {
        assertThat(showQBox.getId()).isEqualTo("1");
        assertThat(showQBox.getType()).isEqualTo("test");
        assertThat(showQBox.getIpAddress()).isEqualTo("0");
        assertThat(showQBox.getName()).isEqualTo("test");
    }
}
