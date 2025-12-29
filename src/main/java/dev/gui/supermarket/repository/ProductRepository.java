package dev.gui.supermarket.repository;

import dev.gui.supermarket.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
