package com.example.simmanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sim_details")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Simdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String simNo;
    private String accountNumber;
    private String mobileNumber;

    @ManyToOne
    private Store store;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private users created_by;
}

