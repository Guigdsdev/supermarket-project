package dev.gui.supermarket.model;

import jakarta.persistence.*;

@Table(name = "TB_CLIENTE")
@Entity
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private Integer age;

    private String email;

    private String image;

    private String address;

    
}
