package br.com.bieniek.inventory.adapters.out;

import br.com.bieniek.inventory.adapters.out.message.SaleMessage;
import br.com.bieniek.inventory.application.core.domain.Sale;
import br.com.bieniek.inventory.application.core.domain.enums.SaleEvent;
import br.com.bieniek.inventory.application.ports.out.SendUpdatedInventoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendUpdatedInventoryAdapter implements SendUpdatedInventoryOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
