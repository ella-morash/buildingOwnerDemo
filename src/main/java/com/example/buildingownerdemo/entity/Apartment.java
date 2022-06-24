package com.example.buildingownerdemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id", nullable = false)
    private Long id;
    @Column(name = "apartment_number")
    private Integer apartmentNumber;
    @Column(name = "hasBalcony")
    private Boolean hasBalcony;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

}
