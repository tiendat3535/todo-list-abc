package com.pyco.webservice.cloud.springcloudcontractconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyco.webservice.WebServiceApplication;
import dto.TaskDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebServiceApplication.class)
@AutoConfigureMockMvc
@EnableWebMvc
@AutoConfigureJsonTesters
//@AutoConfigureStubRunner(
//        workOffline = true,
//        ids = "com.pyco:core-application:+:stubs:8002")
public class CreateTodoTest {

    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.pyco", "core-application", "0.0.1-SNAPSHOT", "stubs")
            .withPort(7777)
            .workOffline(true);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void given_WhenPassEvenNumberInQueryParam_ThenReturnEven()
            throws Exception {

//        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8002/v1/private/todos/")
//                .content(objectMapper.writeValueAsString(new TaskDto("fromWebservice")))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(content().contentType(TaskDto.class.getTypeName()));

        ResponseEntity<TaskDto> afda = restTemplate.postForEntity("http://localhost:7777/v1/private/todos", new TaskDto("afda"), TaskDto.class);
    }

}
