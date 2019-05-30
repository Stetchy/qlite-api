package condonr4.api.controller;

import condonr4.api.model.QBox;
import condonr4.api.model.dto.QBoxDTO;
import condonr4.api.service.QBoxService.QBoxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "QBox", description = "Endpoint for managing QBoxes")
@RequestMapping(value = "/qbox")
public class QBoxController {

    private QBoxService qBoxService;

    @Autowired
    public QBoxController(QBoxService qBoxService) {
        this.qBoxService = qBoxService;
    }

    @ApiOperation(value = "createQBox")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createQBox(@RequestBody @Valid QBoxDTO qboxDTO) {
        qBoxService.createQBox(qboxDTO);
        return qboxDTO.getId();
    }

    @ApiOperation(value = "getQBoxes")
    @RequestMapping(value = "/getAllQBoxes", method = RequestMethod.GET)
    public ResponseEntity<List<QBox>> getQBoxes() {
        return new ResponseEntity<>(qBoxService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "getQBox")
    @RequestMapping(value = "/get/{mac}", method = RequestMethod.GET)
    public QBox getQBox(@PathVariable("mac") String mac) {
        return qBoxService.getQBox(mac);
    }

    @ApiOperation(value = "assignQBox")
    @RequestMapping(value = "/assign/{mac}", method = RequestMethod.POST)
    public String assignQBox(@PathVariable("mac") String mac) {
        qBoxService.assignQBox(mac);
        return mac + " assigned.";
    }

    @ApiOperation(value = "deleteQBox")
    @RequestMapping(value = "/deleteQBox/{id}", method = RequestMethod.DELETE)
    public void deleteQBox(@PathVariable("id") String id) {
        qBoxService.deleteQBox(id);
    }
}
