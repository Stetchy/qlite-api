package condonr4.api.service;

import condonr4.api.model.dto.ShowDTO;
import condonr4.api.repositories.ShowRepository;
import condonr4.api.service.ShowService.ShowService;
import condonr4.api.service.ShowService.ShowServiceImpl;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShowServiceTest {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private ShowService showService;
    private ShowRepository showRepository;

    @Before
    public void setUp() {
        showRepository = mock(ShowRepository.class);
        showService = new ShowServiceImpl(showRepository);
    }

    @Test
    public void testCreateShow() {
        LOGGER.info("testCreateShow");
        ShowDTO dto = new ShowDTO("1", "1", "1", "1", null, null);
        showService.createShow(dto);
        verify(showRepository, times(1)).save(any());
    }

    @Test
    public void testGetShow() {
        LOGGER.info("testGetShow");
        showService.getShow("1");
        verify(showRepository, times(1)).findByName(any());
    }

    @Test
    public void testGetShows() {
        LOGGER.info("testGetShows");
        showService.getShows();
        verify(showRepository, times(1)).findAll();
    }

    @Test
    public void testSaveShow() {
        LOGGER.info("testSaveShow");
        ShowDTO dto = new ShowDTO("1", "1", "1", "1", null, null);
        showService.saveShow(dto);
        verify(showRepository, times(1)).save(any());
    }

    @Test
    public void testDeleteShow() {
        LOGGER.info("testDeleteShow");
        showService.deleteShow("1");
        verify(showRepository, times(1)).deleteById(any());
    }
}
