package com.appsdeveloperblog.estore.OrdersService.query;

import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.estore.OrdersService.core.data.OrderEntity;
import com.appsdeveloperblog.estore.OrdersService.core.data.OrdersRepository;
import com.appsdeveloperblog.estore.OrdersService.core.model.OrderSummary;


@Component
public class OrderQueriesHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderQueriesHandler.class);
	
	OrdersRepository ordersRepository;

	public OrderQueriesHandler(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}

	@QueryHandler
	public OrderSummary findOrder(FindOrderQuery findOrderQuery) {
		OrderEntity orderEntity = ordersRepository.findByOrderId(findOrderQuery.getOrderId());
		
		LOGGER.info("&&& Retrieving Order finished : "+findOrderQuery.getOrderId());
		return new OrderSummary(orderEntity.getOrderId(), 
				orderEntity.getOrderStatus(), "");
	}

}
