package com.pyco.coreapplication.cloud.springcloudcontractproducer;

import com.pyco.coreapplication.CoreApplication;
import com.pyco.coreapplication.configuration.WebSecurityConfigTest;
import com.pyco.coreapplication.endpoint.TaskEndpoint;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ActiveProfiles(value = {"test"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@DirtiesContext
@EnableWebMvc
@AutoConfigureMessageVerifier
@Import(value = {WebSecurityConfigTest.class})
@WithUserDetails("person")
public class CreateTodoTest {

    @Autowired
    private TaskEndpoint taskEndpoint;

    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(taskEndpoint);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    @Test
    public void test() {

    }

}
