package condonr4.api.models;

import condonr4.api.model.Cue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CueTest {

    private Cue cue;

    @Before
    public void setUp() {
        cue = new Cue(1, "test", 0, 0, 0, new ArrayList<String>(){{add("test");}});
        cue = new Cue();
        cue = Cue.builder()
                .id(1)
                .description("test")
                .length(0)
                .postwait(0)
                .prewait(0)
                .type(new ArrayList<String>(){{add("test");}})
                .build();
    }

    @Test
    public void testCueDTO() {
        assertThat(cue.getDescription()).isEqualTo("test");
        assertThat(cue.getId()).isEqualTo(1);
        assertThat(cue.getLength()).isEqualTo(0);
        assertThat(cue.getPostwait()).isEqualTo(0);
        assertThat(cue.getPrewait()).isEqualTo(0);
        assertThat(cue.getType().get(0)).isEqualTo("test");
    }
}
