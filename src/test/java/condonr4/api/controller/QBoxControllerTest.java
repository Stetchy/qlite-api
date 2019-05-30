package condonr4.api.controller;

import condonr4.api.model.QBox;
import condonr4.api.model.dto.QBoxDTO;
import condonr4.api.service.QBoxService.QBoxService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QBoxControllerTest {

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    QBoxController qBoxController;

    @MockBean
    QBoxService qBoxService;

    private List<QBox> qboxes;

    @Before
    public void setUp() {
        this.mockMvc = standaloneSetup(this.qBoxController).build();
        QBox qBox1 = QBox.builder()
                .id("id")
                .ipAddress("ip")
                .name("name")
                .isAssigned(false)
                .build();
        QBox qBox2 = QBox.builder()
                .id("id1")
                .ipAddress("ip1")
                .name("name1")
                .isAssigned(false)
                .build();
        qBoxService.createQBox(new QBoxDTO(qBox1.getId(), qBox1.getName(), qBox1.getIpAddress(), qBox1.isAssigned()));
        qBoxService.createQBox(new QBoxDTO(qBox2.getId(), qBox2.getName(), qBox2.getIpAddress(), qBox2.isAssigned()));
        qboxes = new ArrayList<>();
        qboxes.add(qBox1);
        qboxes.add(qBox2);
    }

    @Test
    public void testGetQBoxes() throws Exception {
        when(qBoxService.getAll()).thenReturn(qboxes);

        MvcResult result = mockMvc.perform(get("/qbox/getAllQBoxes").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals(content,
                "[{\"id\":\"id\",\"name\":\"name\",\"ipAddress\":\"ip\",\"assigned\":false},{\"id\":\"id1\",\"name\":\"name1\",\"ipAddress\":\"ip1\",\"assigned\":false}]");
    }

    @Test
    public void testDeleteQBox() throws Exception {
        QBox qBox1 = QBox.builder()
                .id("id")
                .ipAddress("ip")
                .name("name")
                .isAssigned(false)
                .build();
        qBoxService.createQBox(new QBoxDTO(qBox1.getId(), qBox1.getName(), qBox1.getIpAddress(), qBox1.isAssigned()));
        mockMvc.perform(delete("/qbox/deleteQBox/id").contentType(MediaType.ALL))
                .andDo(print())
                .andReturn();
        assertNull(qBoxService.getQBox("mac"));
    }

    @Test
    public void testGetQBox() throws Exception {
        when(qBoxService.getQBox("ip1")).thenReturn(qboxes.get(1));
        MvcResult result = mockMvc.perform(get("/qbox/get/ip1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals(content, "{\"id\":\"id1\",\"name\":\"name1\",\"ipAddress\":\"ip1\",\"assigned\":false}");

    }

    @Test
    public void testAssignQBox() throws Exception {
        when(qBoxService.isAssigned("mac1")).thenReturn(true);
        mockMvc.perform(post("/qbox/assign/mac1"))
                .andDo(print())
                .andReturn();
        assertTrue(qBoxService.isAssigned("mac1"));
    }

    @Test
    public void testQBoxCreated() throws Exception {
        when(qBoxService.getQBox("3")).thenReturn(new QBox("3", "3", "3", false));
        mockMvc.perform(post("/qbox/create").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content("{\"id\":\"3\",\"name\":\"3\",\"macAddress\":\"3\",\"assigned\":false}"))
                .andDo(print())
                .andReturn();
        assertNotNull(qBoxService.getQBox("3"));
    }
}
