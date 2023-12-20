package br.com.bieniek.inventory.adapters.out.repository.mapper;

import br.com.bieniek.inventory.adapters.out.repository.entity.InventoryEntity;
import br.com.bieniek.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    InventoryEntity toInventoryEntity(final Inventory inventory);

    Inventory toInventory(final InventoryEntity inventoryEntity);
}
