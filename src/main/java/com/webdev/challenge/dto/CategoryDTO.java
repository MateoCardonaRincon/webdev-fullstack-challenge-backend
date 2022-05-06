package com.webdev.challenge.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

    private Long id;

    private String description;

    // Here, I skip the 'notes' attribute to avoid sending the list of notes by every category
    // since the whole list of notes is sent to the client by separate in its own DTO

}
