package br.com.bieniek.inventory.adapters.out;

import br.com.bieniek.inventory.adapters.out.repository.InventoryRepository;
import br.com.bieniek.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import br.com.bieniek.inventory.application.core.domain.Inventory;
import br.com.bieniek.inventory.application.ports.out.UpdateInventoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
