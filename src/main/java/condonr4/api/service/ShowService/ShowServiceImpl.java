package condonr4.api.service.ShowService;

import condonr4.api.repositories.ShowRepository;
import condonr4.api.model.Shows;
import condonr4.api.model.dto.ShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private ShowRepository showRepository;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public void createShow(ShowDTO showDTO) {
        Shows show = Shows.builder()
                .id(showDTO.getId())
                .name(showDTO.getName())
                .owner(showDTO.getOwner())
                .lastUpdated(showDTO.getLastUpdated())
                .cues(showDTO.getCues())
                .qBoxes(showDTO.getQBoxes())
                .build();
        showRepository.save(show);
    }

    @Override
    public Shows getShow(String name) {
        return showRepository.findByName(name);
    }

    @Override
    public List<Shows> getShows() {
        return showRepository.findAll();
    }

    @Override
    public void saveShow(ShowDTO showDTO) {
        Shows show = Shows.builder()
                .id(showDTO.getId())
                .name(showDTO.getName())
                .owner(showDTO.getOwner())
                .lastUpdated(showDTO.getLastUpdated())
                .cues(showDTO.getCues())
                .qBoxes(showDTO.getQBoxes())
                .build();
        showRepository.save(show);
    }

    @Override
    public void deleteShow(String id) {
        showRepository.deleteById(id);
    }
}
