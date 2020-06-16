package com.alliconsulting.learning.springdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final UUID id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty ("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
