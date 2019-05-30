package condonr4.api.service;

import condonr4.api.model.dto.QBoxDTO;
import condonr4.api.repositories.QBoxRepository;
import condonr4.api.service.QBoxService.QBoxService;
import condonr4.api.service.QBoxService.QBoxServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class QBoxServiceTest {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private QBoxService qBoxService;

    private QBoxRepository qBoxRepository;

    @Before
    public void setUp() {
        qBoxRepository = mock(QBoxRepository.class);
        qBoxService = new QBoxServiceImpl(qBoxRepository);
    }

    @Test
    public void testCreateQBox() {
        LOGGER.info("testCreateQBox");
        QBoxDTO dto = new QBoxDTO("1", "1", "1", false);
        qBoxService.createQBox(dto);
        verify(qBoxRepository, times(1)).save(any());
    }

    @Test
    public void testGetQBoxes() {
        LOGGER.info("testGetQBoxes");
        qBoxService.getAll();
        verify(qBoxRepository, times(1)).findAll();
    }

    @Test
    public void testGetQBox() {
        LOGGER.info("testGetQBox");
        qBoxService.getQBox("1");
        verify(qBoxRepository, times(1)).getByIpAddress(any());
    }

    @Test
    public void testDeleteQBox() {
        LOGGER.info("testDeleteQBox");
        qBoxService.deleteQBox("1");
        verify(qBoxRepository, times(1)).deleteById(any());
    }

    @Test
    public void testGetAllQBox() {
        LOGGER.info("testGetAllQBox");
        qBoxService.getAll();
        verify(qBoxRepository, times(1)).findAll();
    }
}
