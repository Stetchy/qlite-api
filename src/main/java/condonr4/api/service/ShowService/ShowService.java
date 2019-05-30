package condonr4.api.service.ShowService;

import condonr4.api.model.Shows;
import condonr4.api.model.dto.ShowDTO;

import java.util.List;

public interface ShowService {
    void createShow(ShowDTO showDTO);
    Shows getShow(String id);
    List<Shows> getShows();
    void saveShow(ShowDTO showDTO);
    void deleteShow(String id);
}
