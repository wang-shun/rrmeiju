package com.caizhukui.rrmeiju.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月14日
 */
public class TelevisionControllerTest extends BaseControllerTest {

    /**
     * 
     * 
     * @throws Exception
     * @author caizhukui
     * @date 2018年5月17日
     */
    @Test
    public void testGetFields() throws Exception {
        TelevisionController controller = new TelevisionController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(options("/televisions")).andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    /**
     * 
     * 
     * @throws Exception
     * @author caizhukui
     * @date 2018年5月17日
     */
    @Test
    public void testGetByUuid() throws Exception {
        TelevisionController controller = new TelevisionController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

}
