package co.kr.lim;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

import co.kr.lim.biz.member.bean.Member;
import co.kr.lim.biz.member.bean.MemberDto;
import co.kr.lim.config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {/*WebInitializer.class, */ApplicationConfig.class} )
@WebAppConfiguration
@Transactional
public class MemberControllerTest {
	
	@Autowired
	WebApplicationContext wac;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private ModelMapper modelMapper;

	MockMvc mockMvc;

//	@Autowired
//	private FilterChainProxy springSecurityFilterChain;
	
	private static Logger logger = LoggerFactory.getLogger(MemberControllerTest.class);
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void createMember() throws JsonProcessingException, Exception {
		logger.debug("test");
		MemberDto.Create createDto = memberCreateDto();

		ResultActions result = mockMvc
				.perform(post("/member").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(createDto)));

		result.andDo(print());
		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.username", is("limyoungjin")));
		

		result = mockMvc.perform(post("/member").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(createDto)));

		result.andDo(print());
		result.andExpect(status().isBadRequest());
		result.andExpect((ResultMatcher) jsonPath("$.code", is("duplicated.username.exception")));
	}
	
	private MemberDto.Create memberCreateDto() {
		MemberDto.Create dto = new MemberDto.Create();
		dto.setUsername("limyoungjin");
		dto.setPassword("password");
		return dto;
	}
	@Test
	public void test() {
//		ApplicationContext applicationContext;
//		applicationContext.getMessage(code, args, locale);
	}
	
	
}
