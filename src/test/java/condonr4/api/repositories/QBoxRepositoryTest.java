package condonr4.api.repositories;

import condonr4.api.Config;
import condonr4.api.model.QBox;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Config.class})
public class QBoxRepositoryTest {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QBoxRepository qBoxRepository;

    @Before
    public void setUp() {
        QBox qbox1 = new QBox("1", "1", "1", false);
        QBox qbox2 = new QBox("2", "2", "2", true);
        this.qBoxRepository.save(qbox1);
        this.qBoxRepository.save(qbox2);
    }

    @Test
    public void testSaveQBox() {
        LOGGER.info("testSaveQBox");
        QBox qbox3 = new QBox("3", "3", "3", false);
        this.qBoxRepository.save(qbox3);
        assertEquals(this.qBoxRepository.getByIpAddress("3"), qbox3);
    }

    @Test
    public void testGetAllQBoxes() {
        LOGGER.info("testGetAllQBoxes");
        List<QBox> qboxes = this.qBoxRepository.findAll();
        assertEquals(qboxes.size(), 3);
    }

    @Test
    public void testGetByIpAddress() {
        LOGGER.info("testGetByIpAddress");
        QBox qbox = this.qBoxRepository.getByIpAddress("2");
        assertNotNull(qbox);
    }

    @Test
    public void testDeleteQBox() {
        LOGGER.info("testDeleteQBox");
        this.qBoxRepository.deleteById("1");
        assertNull(this.qBoxRepository.getByIpAddress("1"));
    }

}
