package dev.gui.supermarket.model;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "TB_CLIENT")
@Entity
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "client")
    private List<ProductModel> products;
}
