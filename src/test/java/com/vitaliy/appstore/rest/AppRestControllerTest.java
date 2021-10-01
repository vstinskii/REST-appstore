package com.vitaliy.appstore.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitaliy.appstore.model.entity.Application;
import com.vitaliy.appstore.model.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasToString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AppRestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wc;

    @MockBean
    private ApplicationService applicationServiceMock;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
    }

    @Test
    void saveApplication() throws Exception {
        Application application = new Application("TestApp", "220", 16);
        MvcResult result = mockMvc.perform(post("/api/applications")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(application)))
                .andExpect(status().isOk())
                .andReturn();

        Application response = mapper.readValue(result.getResponse().getContentAsString(), Application.class);

        assertThat(application.getName()).isEqualTo(response.getName());
    }

    @Test
    void getApplicationById() throws Exception {

        Application application = new Application("TestApp", "220", 16);

        when(applicationServiceMock.getApplicationById(1)).thenReturn(application);

        mockMvc.perform(get("/api/applications/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", hasToString("TestApp")));

    }

    @Test
    void getAllApplications() {

    }

    @Test
    void deleteApplicationById() throws Exception {

        mockMvc.perform(delete("/api/applications/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void compareApplications() {
    }

    @Test
    void getCountOfApplicationsByContentRate() {
    }
}