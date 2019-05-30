package condonr4.api.repositories;

import condonr4.api.Config;
import condonr4.api.model.Shows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Config.class})
public class ShowRepositoryTest {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShowRepository showRepository;

    @Before
    public void setUp() {
        Shows show1 = new Shows("testShow1", "testShow1", "riain", "0", null, null);
        Shows show2 = new Shows("testShow2", "testShow2", "riain", "0", null, null);
        this.showRepository.save(show1);
        this.showRepository.save(show2);
    }

    @Test
    public void testDeleteById() {
        LOGGER.info("testDeleteById");
        this.showRepository.deleteById("testShow1");
        assertNull(this.showRepository.findByName("testShow1"));
    }

    @Test
    public void testFindByName() {
        LOGGER.info("testFindByName");
        Shows show = this.showRepository.findByName("testShow2");
        assertEquals(show.getId(), "testShow2");
    }

    @Test
    public void testFindAll() {
        LOGGER.info("testFindAll");
        List<Shows> shows = this.showRepository.findAll();
        assertThat(shows.size()).isEqualTo(3);
    }

    @Test
    public void testSaveShow() {
        LOGGER.info("testSaveShow");
        Shows show3 = new Shows("3", "3", "riain", "0", null, null);
        this.showRepository.save(show3);
        assertEquals(this.showRepository.findByName("3"), show3);
    }
}
