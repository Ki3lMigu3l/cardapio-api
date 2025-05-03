package com.github.ki3lmigu3l.food.service;

import com.github.ki3lmigu3l.food.dto.FoodRequest;
import com.github.ki3lmigu3l.food.model.Food;
import com.github.ki3lmigu3l.food.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FoodServiceImplTest {

    @Mock
    private FoodRepository repository;

    @InjectMocks
    private FoodServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnAllFoods() {
        List<Food> foods = Arrays.asList(
                new Food(1L, "Pizza", "img1", new BigDecimal("50.00")),
                new Food(2L, "Burger", "img2", new BigDecimal("30.00"))
        );

        when(repository.findAll()).thenReturn(foods);
        List<Food> result = service.listAll();

        assertEquals(2, result.size());
        assertEquals("Pizza", result.get(0).getName());
    }

    @Test
    void shouldReturnFoodWhenSearchByIdWithValidId() {
        Food food = new Food(1L, "Pizza", "image.url", new BigDecimal("49.90"));
        when(repository.findById(1L)).thenReturn(Optional.of(food));

        Optional<Food> result = service.searchByID(1L);

        assertTrue(result.isPresent());
        assertEquals("Pizza", result.get().getName());
    }

    @Test
    void shouldCreateFoodWhenValidDataIsProvided() {
        FoodRequest request = new FoodRequest("Sushi", "image.sushi", new BigDecimal("60.0"));
        Food savedFood = new Food(1L, request.name(), request.image(), request.price());

        when(repository.save(any(Food.class))).thenReturn(savedFood);

        Food result = service.create(request);

        assertNotNull(result.getId());
        assertEquals("Sushi", result.getName());
    }

    @Test
    void shouldUpdateFoodWhenExistingIdAndValidDataAreProvided() {
        Long id = 1L;
        Food existing = new Food(id, "oldName", "old.image", new BigDecimal("10.00"));
        FoodRequest request = new FoodRequest("newName", "new.image", new BigDecimal("15.00"));

        when(repository.findById(id)).thenReturn(Optional.of(existing));
        when(repository.save(any(Food.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Optional<Food> result = service.update(id, request);

        assertTrue(result.isPresent());
        assertEquals("newName", result.get().getName());
    }

    @Test
    void shouldDeleteFoodWhenValidIdIsProvided() {
        Long id = 1L;
        Food existing = new Food(id, "Taco", "taco.image", new BigDecimal("20.00"));

        when(repository.findById(id)).thenReturn(Optional.of(existing));
        service.delete(id);
        verify(repository).deleteById(id);
    }
}