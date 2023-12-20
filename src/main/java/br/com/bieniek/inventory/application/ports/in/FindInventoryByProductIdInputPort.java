package br.com.bieniek.inventory.application.ports.in;

import br.com.bieniek.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory findInventoryByProductId(final Integer productId);
}
