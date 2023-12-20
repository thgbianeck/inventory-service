package br.com.bieniek.inventory.application.core.usecase;

import br.com.bieniek.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.bieniek.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import br.com.bieniek.inventory.application.core.domain.Inventory;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(
            FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory findInventoryByProductId(final Integer productId) {
        return findInventoryByProductIdOutputPort.findInventoryByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Inventory not found for product id: " + productId));
    }
}
