package br.com.bieniek.inventory.application.core.usecase;

import br.com.bieniek.inventory.application.core.domain.enums.SaleEvent;
import br.com.bieniek.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.bieniek.inventory.application.core.domain.Sale;
import br.com.bieniek.inventory.application.ports.out.SendUpdatedInventoryOutputPort;
import br.com.bieniek.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdOutputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdOutputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdatedInventoryOutputPort = sendUpdatedInventoryOutputPort;
    }


    public void debitInventory(Sale sale){
        var inventory = findInventoryByProductIdOutputPort
                .findInventoryByProductId(sale.getProductId());
        if (inventory.getQuantity() < sale.getQuantity()) {
            throw new RuntimeException("Insufficient inventory for product id: " + sale.getProductId());
        }
        inventory.debitQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendUpdatedInventoryOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
    }
}
