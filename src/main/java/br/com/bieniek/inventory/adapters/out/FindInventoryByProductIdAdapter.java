package br.com.bieniek.inventory.adapters.out;

import br.com.bieniek.inventory.adapters.out.repository.InventoryRepository;
import br.com.bieniek.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import br.com.bieniek.inventory.application.core.domain.Inventory;
import br.com.bieniek.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;
    @Override
    public Optional<Inventory> findInventoryByProductId(Integer productId) {

        var inventoryEntity = inventoryRepository.findByProductId(productId);

        return inventoryEntity.map(inventoryEntityMapper::toInventory);
    }
}
