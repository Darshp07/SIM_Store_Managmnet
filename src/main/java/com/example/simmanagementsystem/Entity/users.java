package com.example.simmanagementsystem.Entity;

import com.example.simmanagementsystem.Utility.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class users {


    private Long id;

    @Column(name = "staff_id")
    private String staffId;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String store_id;
}
