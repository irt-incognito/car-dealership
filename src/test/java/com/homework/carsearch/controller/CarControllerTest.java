package com.homework.CarSearch.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.carsearch.builder.CarBuilder;
import com.homework.carsearch.controller.CarController;
import com.homework.carsearch.model.Car;
import com.homework.carsearch.model.Color;
import com.homework.carsearch.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
public class CarControllerTest {
    private final ObjectMapper MAPPER = new ObjectMapper();
    private MockMvc mockmvc;

    @Mock
    CarRepository mockCarRepository;
    @InjectMocks
    CarController carController;

    @Before
    public void setup(){
        mockmvc = MockMvcBuilders
                .standaloneSetup(carController)
                .build();
    }
//    Get Method Tests
    @Test
    public void findCarDelegates() throws Exception {
        MockHttpServletResponse response = mockmvc.perform(
                get("/car?color=Red")
        ).andReturn()
                .getResponse();

        verify(mockCarRepository, times(1))
                .findAllByFilters(Color.Red,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    @Test
    //Happy Path
    public void findCarReturnsAllCarsWhenNoFiltersGiven() throws Exception {
        Car car = new CarBuilder().build();
        Car car2 = new CarBuilder().withColor(Color.Black).build();
        Car car3 = new CarBuilder().withColor(Color.White).withHasNavigation(false).build();
        List<Car> carList = Arrays.asList( car,car2,car3 );

        given(mockCarRepository.findAllByFilters(null,
                null,
                null,
                null,
                null,
                null,
                null))
                .willReturn(carList);

        MockHttpServletResponse response = mockmvc.perform(
                get("/car")
        ).andReturn()
                .getResponse();

        System.out.println("Message body: " + response.getContentAsString());
        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        assertThat(MAPPER.readValue(response.getContentAsString(), new TypeReference<List<Car>>() {}), containsInAnyOrder(car, car2, car3));
    }

    @Test
    public void createThrowsBadRequestError() throws Exception {
        String badRequest = "{}";
        MockHttpServletResponse response = mockmvc.perform(
                post(URI.create("/car"))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(badRequest)
        ).andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void createCarDelegatesToRepository() throws Exception {
        Car car1 =  new CarBuilder()
                .withHasHeatedSeats(false)
                .withIsFourWheelDrive(false)
                .build();
        Car car2 =  new CarBuilder()
                .withMake("Chevy")
                .withColor(Color.Black)
                .withHasLowMiles(false)
                .withHasNavigation(false)
                .build();
        List<Car> expectedCars = Arrays.asList(car1, car2);

        MockHttpServletResponse response = mockmvc.perform(
                post(URI.create("/car"))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(MAPPER.writeValueAsString(expectedCars))
        ).andReturn()
         .getResponse();

        assertThat(response.getStatus(), is(HttpStatus.OK.value()));
        verify(mockCarRepository, times(1)).saveAll(expectedCars);
    }
}