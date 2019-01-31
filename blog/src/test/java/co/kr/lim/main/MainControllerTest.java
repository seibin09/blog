package co.kr.lim.main;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.kr.lim.biz.member.bean.MemberDto;
import co.kr.lim.config.ApplicationConfig;

/**
 * author : YoungBoss since : 2019. 1. 29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { /* WebInitializer.class, */ApplicationConfig.class })
@WebAppConfiguration
@Transactional
public class MainControllerTest {
	@Autowired
	WebApplicationContext wac;

	@Autowired
	ObjectMapper objectMapper;

	// @Autowired
	// private ModelMapper modelMapper;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void main() throws JsonProcessingException, Exception {

		ResultActions result = mockMvc.perform(get("/main"));

		result.andDo(print());
		result.andExpect(status().is2xxSuccessful());
	}
}
