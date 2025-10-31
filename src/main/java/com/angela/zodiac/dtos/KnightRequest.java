package com.angela.zodiac.dtos;

// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;
// import org.springframework.data.mongodb.core.mapping.Field;

// Importaciones CORRECTAS para validación con MongoDB
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
// import java.time.LocalDateTime;

public class KnightRequest {
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotBlank(message = "La constelación es obligatoria")
    private String constellation;

    @NotBlank(message = "El rango es obligatorio")
    private String rank;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
