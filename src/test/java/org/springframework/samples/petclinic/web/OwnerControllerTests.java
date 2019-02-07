package org.springframework.samples.petclinic.web;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * Test class for {@link OwnerController}
 *
 * @author Colin But
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/mvc-test-config.xml", "classpath:spring/mvc-core-config.xml"})
@WebAppConfiguration
public class OwnerControllerTests {

    private static final int TEST_OWNER_ID = 1;

    @Autowired
    private OwnerController ownerController;

    @Autowired
    private ClinicService clinicService;

    private MockMvc mockMvc;

    private Owner george;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();

        george = new Owner();
        george.setId(TEST_OWNER_ID);
        george.setFirstName("George");
        george.setLastName("Franklin");
        george.setAddress("110 W. Liberty St.");
        george.setCity("Madison");
        george.setTelephone("6085551023");
        given(this.clinicService.findOwnerById(TEST_OWNER_ID)).willReturn(george);

    }
    
    
    /*
     * 1. 등록화면 이동 테스트
     * 호출 URL : /owners/new (get)
     * 점검 : status ok, view name 확인 
     */
    @Test
    public void testInitCreationForm() throws Exception {
    	mockMvc.perform(get("/owners/new"))
    		.andExpect(status().isOk())
    		.andExpect(model().attributeExists("owner"))
    		.andExpect(view().name("owners/createOrUpdateOwnerForm"));
    }
    
    
    /*
     * 2. 등록 테스트
     * 호출 URL : /owners/new (post)
     * 점검 : status 300 redirect 여부
     */
    @Test
    public void testProcessCreationFormSuccess(){
    	
    }
    
    
    /*
     * 3. Last Name 검색
     * 호출 URL : /owners (get)
     * 파라미터 : lastName=Franklin
     * 점검 : status 300 redirect, view name ("redirect:" prefix가 붙음)
     */
    @Test
    public void testProcessFindFormByLastName(){
    	
    }
    
    
    /*
     * 4. 상세 조회
     * 호출 URL : /owners/{ownerId} (get)
     * 점검 : status ok, model("owner") 속성 확인 (테스트 데이터), view name
     */
    @Test
    public void testShowOwner(){
    	
    }
}
