package com.flights.path.controller;


import com.flights.path.services.FindCitiesPathService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class CitiesPathControllerTest {


    private MockMvc mockmvc;

    @InjectMocks
    private CitiesPathController controller;


    @Mock
    private FindCitiesPathService service;


    @Before
    public void setUp() throws Exception {
        mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
      //  customer = new Customer("Hello","World");

    }


    @Test
    public void testFindCitiesPathPass_Yes() throws Exception{

        when(service.findCitiesPath("Boston", "New York")).thenReturn("Yes");

        mockmvc.perform(get("/connected?origin=Boston&destination=New York"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Yes"));

    }

    @Test
    public void testFindCitiesPathPass_blank() throws Exception{

        when(service.findCitiesPath("Boston", "")).thenReturn("No");

        mockmvc.perform(get("/connected?origin=Boston&destination="))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("No"));

    }

    @Test
    public void testFindCitiesPathPass_invalid_input() throws Exception{

        when(service.findCitiesPath("Boston", "FGIUGJHGJ")).thenReturn("No");

        mockmvc.perform(get("/connected?origin=Boston&destination=FGIUGJHGJ"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("No"));

    }
}
