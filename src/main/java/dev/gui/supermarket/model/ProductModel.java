package dev.gui.supermarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "mark")
    private String mark;

    @Column(name = "price")
    private Double price;

    @Column(unique = true, name = "uniqueCode")
    private Integer uniqueCode;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;
}
