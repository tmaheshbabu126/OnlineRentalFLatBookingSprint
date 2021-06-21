package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
// org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//(SpringRunner.class)
@SpringBootTest
class FlatBookingServiceApplicationTests {
	///@Mockbean
	private MockMvc mockMvc;
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//	
//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//	
@Test
public void contextLoads() {
}

@Test
public void testGetFlatBooking() throws Exception {
	System.out.println("----------------------------------------------");
	mockMvc.perform(get("/api/viewAllFlatBookig")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"));
			
//			.andExpect(jsonPath("$.bookingId").value("emp1")).andExpect(jsonPath("$.designation").value("manager"))
//			.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));

}

}
