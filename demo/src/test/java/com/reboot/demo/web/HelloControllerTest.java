package com.reboot.demo.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ClassName: HelloControllerTest
 * Function:  TODO
 * Date:      2019-06-04 21:56
 * author     daguang
 * version    V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void funcIndex() throws Exception {
		mvc.perform(get("/hello")).andExpect(status().isOk());
	}
}