package condonr4.api.controller;

import condonr4.api.model.Shows;
import condonr4.api.model.dto.ShowDTO;
import condonr4.api.service.ShowService.ShowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/show")
@Api(value = "Shows", description = "Endpoint for show management")
public class ShowController {

    private ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @ApiOperation(value = "createShow")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createShow(@RequestBody @Valid ShowDTO showDTO) {
        showService.createShow(showDTO);
        return "Created " + showDTO.getId();
    }

    @ApiOperation(value = "getShow")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Shows getShow(@PathVariable("id") String id) {
        return showService.getShow(id);
    }

    @ApiOperation(value = "deleteShow")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteShow(@PathVariable("id") String id) {
        showService.deleteShow(id);
        return "Deleted " + id;
    }

    @ApiOperation(value = "getShows")
    @RequestMapping(value = "/getAllShows", method = RequestMethod.GET)
    public List<Shows> getShows() {
        return showService.getShows();
    }

    @ApiOperation(value = "saveShow")
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public String saveShow(@RequestBody @Valid ShowDTO showDTO) {
        showService.saveShow(showDTO);
        return "Saved " + showDTO.getId();
    }
}
