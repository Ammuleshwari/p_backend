package com.portfolio.contactservice.model;

import lombok.Data;

@Data
public class EmailRequest {
    private String name;
    private String email;
    private String message;
}
