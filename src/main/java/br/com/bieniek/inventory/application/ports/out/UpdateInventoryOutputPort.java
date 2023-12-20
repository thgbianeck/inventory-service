package br.com.bieniek.inventory.application.ports.out;

import br.com.bieniek.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {
    void update(Inventory inventory);
}
