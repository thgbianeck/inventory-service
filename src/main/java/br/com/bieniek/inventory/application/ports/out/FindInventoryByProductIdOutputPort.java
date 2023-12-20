package br.com.bieniek.inventory.application.ports.out;

import br.com.bieniek.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> findInventoryByProductId(final Integer productId);
}
