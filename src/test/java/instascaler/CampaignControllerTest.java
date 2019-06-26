package instascaler;

import instascaler.Campaign;
import instascaler.CompaignController;

import instascaler.InstaScaler;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CompaignController.class)
public class CampaignControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CampaignRepository campaignRepository;
    @MockBean
    private Campaign campaign;

    @Test
    public void allTest() throws Exception {
        String uri = "http://127.0.0.1:8080/campaign/all";

        try {
            mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(status().isOk());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void groupDataTest() throws Exception {
        String uri = "http://127.0.0.1:8080/campaign/group";

        try {
            mockMvc.perform(MockMvcRequestBuilders.get(uri+"?Country=EGY&category=Automotive")).andExpect(status().isOk());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void SetDurationTest() throws Exception {
        String uri = "http://127.0.0.1:8080/campaign/duration";

        try {
            mockMvc.perform(MockMvcRequestBuilders.post(uri+"?Name=cars&startDate=9/10&endDate=10/10/2019")).andExpect(status().isOk());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void addCompaignTest() throws Exception {
        String uri = "http://127.0.0.1:8080/campaign/add";

        try {
            mockMvc.perform(MockMvcRequestBuilders.post(uri+"?Name=cars&Country=US&Budget=14000&Goal=awareness&Category=Automotive")).andExpect(status().isOk());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
