package com.ua.mapper;

import com.ua.dto.OrderStatusDto;
import com.ua.entity.OrderStatus;

public interface OrderStatusMapper {
    public static OrderStatus dtoToOrderStatus(OrderStatusDto orderStatusDto){
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setTitle(orderStatusDto.getTitle());
        return orderStatus;
    }

    public static OrderStatusDto orderStatusDto (OrderStatus orderStatus) {
        OrderStatusDto orderStatusDto = new OrderStatusDto();
        orderStatusDto.setTitle(orderStatus.getTitle());
        return orderStatusDto;
    }
}
