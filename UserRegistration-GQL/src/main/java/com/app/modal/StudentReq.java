package com.app.modal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentReq {
    private String name;
    private Integer age;
    private String email;
}
