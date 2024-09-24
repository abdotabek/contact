package com.example.contac.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
}
