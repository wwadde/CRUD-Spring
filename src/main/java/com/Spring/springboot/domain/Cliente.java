package com.Spring.springboot.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Integer id;
    private String username;
    private String password;
    private String nombre;

}
