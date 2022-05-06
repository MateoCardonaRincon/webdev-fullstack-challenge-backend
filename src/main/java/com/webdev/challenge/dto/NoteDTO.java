package com.webdev.challenge.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NoteDTO implements Serializable {

    private Long Id;

    private String title;

    private String message;

    private Boolean done;

    private Long fkCategoryId;
}
