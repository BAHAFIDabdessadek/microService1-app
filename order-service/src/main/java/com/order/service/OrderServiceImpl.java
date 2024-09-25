package com.order.service;

import com.order.dtos.InventoryResponse;
import com.order.dtos.OrderLineItemsDto;
import com.order.dtos.OrderRequest;
import com.order.repository.OrderRepository;
import com.order.service.model.Order;
import com.order.service.model.OrderLineItems;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderServiceImpl implements IOrderService{

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems=  orderRequest.getOrderLineItemsDtos().stream()
                .map(this::mapToEntity)
                .toList();

        order.setOrderLineItems(orderLineItems);
    List<String> skucodes =  order.getOrderLineItems().stream().map(OrderLineItems::getSkuCode).toList();
       InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-micro-service/api/inventory/r",
                        uriBuilder -> uriBuilder.queryParam(
                        "sku-codes",skucodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
for (InventoryResponse inventoryResponse:inventoryResponses){
    System.out.println(inventoryResponse.isInStock());
}
     boolean AllProductInStock =  Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

       if (AllProductInStock){
           orderRepository.save(order);
           log.info("Order {} sent with success",order.getOrderNumber());
       }else {
           throw new IllegalArgumentException("Product not in stock please try again,");
       }

    }

    private OrderLineItems mapToEntity(OrderLineItemsDto  orderLineItemsDto) {
         OrderLineItems  orderLineItems= new OrderLineItems();
                orderLineItems.setId(orderLineItemsDto.getId());
                orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
                orderLineItems.setQuantite(orderLineItemsDto.getQuantite());
                orderLineItemsDto.setPrice(orderLineItemsDto.getPrice());
                return orderLineItems;

    }
}
