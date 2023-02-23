package Mk.JD2_95_22.fitness.core.dto.products;

import java.time.LocalDateTime;
import java.util.UUID;

public class Recipe {
    private UUID uuid;
    private LocalDateTime dt_create;
    private LocalDateTime dt_update;
    private String title;
    private Product composition;
    private double weight;
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;
}
