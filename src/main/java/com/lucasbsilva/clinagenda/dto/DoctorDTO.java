package com.lucasbsilva.clinagenda.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDTO {
    private Integer id;
    private String name;
    private Integer statusId;
}
