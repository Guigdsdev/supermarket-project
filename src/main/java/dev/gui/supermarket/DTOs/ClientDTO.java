package dev.gui.supermarket.DTOs;

import dev.gui.supermarket.model.ProductModel;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String image;
    private String address;
    private List<ProductModel> products;
}
