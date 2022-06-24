package com.example.buildingownerdemo.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "building")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id", nullable = false)
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private String house;

}
