package dev.gui.supermarket.repository;

import dev.gui.supermarket.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
