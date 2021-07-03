package com.sarfraz.task.service;

import com.sarfraz.task.domain.DeliveryFreeUtil;
import com.sarfraz.task.model.Offer;
import com.sarfraz.task.model.OrderItem;
import com.sarfraz.task.model.OrderRequest;
import com.sarfraz.task.model.OrderResponse;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetValueService {
    private static final Logger log = LoggerFactory.getLogger(GetValueService.class);

    @Autowired
    private DeliveryFreeUtil deliveryFreeUtil;

    public ResponseEntity<?> getOrderValue(OrderRequest orderRequest) {

        OrderResponse orderResponse = new OrderResponse();

        List<OrderItem> orderItems = orderRequest.getOrderItems();

        int itemsTotal = orderItems.stream().mapToInt(item -> item.getPrice()*item.getQuantity()).sum();

        long deliveryFee = deliveryFreeUtil.getDeliveryFee(orderRequest.getDistance());

        long totalWIthDiscount = itemsTotal + deliveryFee;


        // If no offer is passed
        if(orderRequest.getOffer() == null) {
            log.info("No offer applied for order : {}", orderRequest);
            orderResponse.setOrderTotal(totalWIthDiscount);
            return new ResponseEntity<>(orderResponse, HttpStatus.OK);
        }

        // Subtract discount from total
        else {
            long discount = 0L;
            // For FLAT offer
            if(orderRequest.getOffer().getOfferType() == Offer.OfferTypeEnum.FLAT) {
                // Flat offer value cannot exceed totalWithDiscount
                if(orderRequest.getOffer().getOfferVal() > totalWIthDiscount) {
                    String errorMessage = "Discount on order cannot be more than order total with discount";
                    log.error("Error while processing order: {}\n error: {}", orderRequest.toString(), errorMessage);
                    return new ResponseEntity<String>(errorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
                }
                discount = orderRequest.getOffer().getOfferVal();
                log.info("FLAT Discount applied for order: {}\n Discount:{}", orderRequest.toString(), discount);
                totalWIthDiscount = totalWIthDiscount - discount;
                orderResponse.setOrderTotal(totalWIthDiscount);
                return new ResponseEntity<>(totalWIthDiscount, HttpStatus.OK);

            }
            // For DELIVERY OFFER
            else {
                discount = deliveryFee;
                log.info("DELIVERY Discount applied for order: {}\n Discount:{}", orderRequest.toString(), discount);
                totalWIthDiscount = totalWIthDiscount - discount;
                orderResponse.setOrderTotal(totalWIthDiscount);
                return new ResponseEntity<>(totalWIthDiscount, HttpStatus.OK);
            }
        }


    }


}
