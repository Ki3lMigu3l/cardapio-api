package com.github.ki3lmigu3l.food.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ki3lmigu3l.food.dto.FoodRequest;
import com.github.ki3lmigu3l.food.model.Food;
import com.github.ki3lmigu3l.food.service.FoodServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FoodController.class)
class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodServiceImpl service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnListOfFoods() throws Exception {
        List<Food> foods = Arrays.asList(
                new Food(1L, "Pizza", "img1", "description" ,new BigDecimal("50.00")),
                new Food(2L, "Burger", "img2","description" , new BigDecimal("30.00"))
        );

        Mockito.when(service.listAll()).thenReturn(foods);
        mockMvc.perform(get("/api/foods"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Pizza"));
    }
    @Test
    void shouldReturnFoodByIdWhenFound() throws Exception {
        var food = new Food(1L, "Pizza", "img1","description" , new BigDecimal("50.00"));

        Mockito.when(service.searchByID(1L)).thenReturn(Optional.of(food));

        mockMvc.perform(get("/api/foods/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pizza"));
    }

    @Test
    void shouldReturnNotFoundWhenFoodDoesNotExist() throws Exception {
        Mockito.when(service.searchByID(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/foods/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateFood() throws Exception {
        var request = new FoodRequest("Sushi", "img.sushi", "description" ,new BigDecimal("60.0"));
        var created = new Food(1L, request.name(), request.image(), request.description(), request.price());

        Mockito.when(service.create(any(FoodRequest.class))).thenReturn(created);

        mockMvc.perform(post("/api/foods")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Sushi"));
    }

    @Test
    void shouldUpdateFoodWhenExists() throws Exception {
        var request = new FoodRequest("NewName", "new.img", "description" ,new BigDecimal("70.00"));
        var updated = new Food(1L, request.name(), request.image(), request.description(), request.price());

        Mockito.when(service.update(Mockito.eq(1L), any(FoodRequest.class)))
                .thenReturn(Optional.of(updated));

        mockMvc.perform(put("/api/foods/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("NewName"));
    }

    @Test
    void shouldReturnNotFoundWhenUpdatingNonExistentFood() throws Exception {
        var request = new FoodRequest("name", "img.url", "description", new BigDecimal("10.00"));

        Mockito.when(service.update(Mockito.eq(99L), any(FoodRequest.class)))
                .thenReturn(Optional.empty());

        mockMvc.perform(put("/api/foods/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldDeleteFood() throws Exception {
        mockMvc.perform(delete("/api/foods/1"))
                .andExpect(status().isNoContent());

        Mockito.verify(service).delete(1L);
    }
}