package com.angela.zodiac.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@Document(collection = "knights") 
public class Knights {
    @Id    private String id;

    @NotBlank(message = "El Nombre obligatorio")
    @Field("name")
    private String name;

    @NotBlank(message = "Constellation is mandatory")
    @Field("constellation")
    private String constellation;

    @Min(value = 1, message = "Rank must be at least 1")
    @Field("rank")
    private String rank;

    // Constructors
    public Knights() {}

    public Knights(String name, String constellation, String rank) {
        this.name = name;
        this.constellation = constellation;
        this.rank = rank;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
