package condonr4.api.controller;

import condonr4.api.model.Shows;
import condonr4.api.model.dto.CueDTO;
import condonr4.api.model.dto.ShowDTO;
import condonr4.api.model.dto.ShowQBoxDTO;
import condonr4.api.service.ShowService.ShowService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShowControllerTest {

    private MockMvc mockMvc;

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private List<CueDTO> cueDTOs = new ArrayList<>();
    private List<ShowQBoxDTO> showQBoxDTOs = new ArrayList<>();
    private ShowDTO showDTO1 = new ShowDTO("1", "1", "1", "1", cueDTOs, showQBoxDTOs);
    private Shows show1 = Shows.builder()
            .id(showDTO1.getId())
            .name(showDTO1.getName())
            .owner(showDTO1.getOwner())
            .lastUpdated(showDTO1.getLastUpdated())
            .cues(showDTO1.getCues())
            .qBoxes(showDTO1.getQBoxes())
            .build();

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    ShowController showController;

    @MockBean
    ShowService showService;

    @Before
    public void setUp() {
        this.mockMvc = standaloneSetup(this.showController).build();
    }

    @Test
    public void testCreateShow() throws Exception {
        MvcResult res = mockMvc.perform(post("/show/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content("{ \"cues\": [ { \"description\": \"string\", \"id\": 0, \"length\": 0, \"postwait\": 0, \"prewait\": 0, \"type\": [ \"string\" ] } ], \"id\": \"string\", \"lastUpdated\": \"string\", \"name\": \"string\", \"owner\": \"string\", \"qboxes\": [ { \"id\": \"string\", \"macAddress\": \"string\", \"name\": \"string\", \"type\": \"string\" } ] }"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        assertEquals("Created string", res.getResponse().getContentAsString());
    }

    @Test
    public void testGetShow() throws Exception {
        when(showService.getShow("1")).thenReturn(show1);
        MvcResult res = mockMvc.perform(get("/show/get/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        assertEquals(res.getResponse().getContentAsString(), "{\"id\":\"1\",\"name\":\"1\",\"owner\":\"1\",\"lastUpdated\":\"1\",\"cues\":[],\"qboxes\":[]}");
    }

    @Test
    public void testGetShows() throws Exception {
        List<Shows> shows = new ArrayList<>();
        shows.add(show1);
        when(showService.getShows()).thenReturn(shows);
        MvcResult res = mockMvc.perform(get("/show/getAllShows").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        assertEquals(res.getResponse().getContentAsString(), "[{\"id\":\"1\",\"name\":\"1\",\"owner\":\"1\",\"lastUpdated\":\"1\",\"cues\":[],\"qboxes\":[]}]");
    }

    @Test
    public void testDeleteShow() throws Exception {
        MvcResult res = mockMvc.perform(delete("/show/delete/id").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        assertEquals("Deleted id", res.getResponse().getContentAsString());
    }

    @Test
    public void testSaveShow() throws Exception {
        MvcResult res = mockMvc.perform(put("/show/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content("{ \"cues\": [ { \"description\": \"string\", \"id\": 0, \"length\": 0, \"postwait\": 0, \"prewait\": 0, \"type\": [ \"string\" ] } ], \"id\": \"id\", \"lastUpdated\": \"string\", \"name\": \"string\", \"owner\": \"string\", \"qboxes\": [ { \"id\": \"string\", \"macAddress\": \"string\", \"name\": \"string\", \"type\": \"string\" } ] }"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        assertEquals("Saved id", res.getResponse().getContentAsString());
    }
}
