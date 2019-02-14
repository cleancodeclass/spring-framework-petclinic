package org.springframework.samples.petclinic.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/mvc-core-config.xml", "classpath:spring/mvc-test-config.xml"})
@WebAppConfiguration
public class PetControllerTests {
	@Autowired
    private MyPetController myPetController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(myPetController).build();
    }
    
    /*
     * PetList 화면으로 이동하는 테스트
     * 호출 URL : /petListRequest (get)
     * 점검 : status ok, view name 확인 
     */
    @Test
    public void testPetListPageInitCreationForm() throws Exception {
    	mockMvc.perform(get("/petListRequest"))
    		.andExpect(status().isOk())
    		.andExpect(model().attributeExists("pets"))
    		.andExpect(view().name("pets/petList"));
    }
}
