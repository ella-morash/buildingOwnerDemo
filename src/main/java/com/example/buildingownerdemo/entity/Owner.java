package com.example.buildingownerdemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "owner")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

}