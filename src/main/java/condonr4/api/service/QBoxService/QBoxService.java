package condonr4.api.service.QBoxService;

import condonr4.api.model.QBox;
import condonr4.api.model.dto.QBoxDTO;

import java.util.List;

public interface QBoxService {
    QBox getQBox(String ipAddress);
    List<QBox> getAll();
    boolean isAssigned(String ipAddress);
    void createQBox(QBoxDTO qBoxDTO);
    void assignQBox(String ip);
    void deleteQBox(String id);
}
