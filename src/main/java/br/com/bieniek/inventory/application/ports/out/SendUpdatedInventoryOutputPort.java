package br.com.bieniek.inventory.application.ports.out;

import br.com.bieniek.inventory.application.core.domain.Sale;
import br.com.bieniek.inventory.application.core.domain.enums.SaleEvent;

public interface SendUpdatedInventoryOutputPort {
    void send(Sale sale, SaleEvent event);
}
