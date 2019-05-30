package condonr4.api.service.QBoxService;

import condonr4.api.repositories.QBoxRepository;
import condonr4.api.model.QBox;
import condonr4.api.model.dto.QBoxDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class QBoxServiceImpl implements QBoxService {

    private QBoxRepository qBoxRepository;

    @Autowired
    public QBoxServiceImpl(QBoxRepository qBoxRepository) {
        this.qBoxRepository = qBoxRepository;
    }

    @Override
    public QBox getQBox(String ipAddress) {
        return qBoxRepository.getByIpAddress(ipAddress);
    }

    @Override
    public List<QBox> getAll() {
        return qBoxRepository.findAll();
    }

    @Override
    public boolean isAssigned(String ipAddress) {
        QBox qbox = qBoxRepository.getByIpAddress(ipAddress);
        return qbox.isAssigned();
    }

    @Override
    public void createQBox(QBoxDTO qBoxDTO) {
        QBox qbox = QBox.builder()
                .id(qBoxDTO.getId())
                .ipAddress(qBoxDTO.getIpAddress())
                .name(qBoxDTO.getName())
                .isAssigned(qBoxDTO.isAssigned())
                .build();
        qBoxRepository.save(qbox);
    }

    @Override
    public void assignQBox(String ipAddress) {
        QBox qbox = getQBox(ipAddress);
        qbox.setAssigned(true);
        qBoxRepository.save(qbox);
    }

    @Override
    public void deleteQBox(String id) {
        qBoxRepository.deleteById(id);
    }
}
