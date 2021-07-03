package com.sarfraz.task.api;

import com.sarfraz.task.model.Offer;
import com.sarfraz.task.model.OrderItem;
import com.sarfraz.task.model.OrderRequest;
import com.sarfraz.task.model.OrderResponse;
import com.sarfraz.task.service.GetValueService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-03T16:26:22.933846+05:30[Asia/Calcutta]")
@Controller
@RequestMapping("${openapi.eSamudaayAssignment.base-path:/v1}")
public class OrdersApiController implements OrdersApi {

    private static final Logger log = LoggerFactory.getLogger(OrdersApiController.class);
    private final NativeWebRequest request;

    @Autowired
    GetValueService getValueService;

    @org.springframework.beans.factory.annotation.Autowired
    public OrdersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<?> getOrderValue(@ApiParam(value = "" ,required=true )  @Valid @RequestBody OrderRequest orderRequest) {

        // validate
        Map<Boolean, String> isValid = validateRequest(orderRequest);
        if(isValid.containsKey(false)) {
            return new ResponseEntity<>(isValid.get(false), HttpStatus.BAD_REQUEST);
        }

        return getValueService.getOrderValue(orderRequest);

    }

    private Map<Boolean, String> validateRequest(OrderRequest orderRequest) {
        Map<Boolean, String> result = new HashMap<>();
        String errorMessage = "";

        // check request body is not null
        if(orderRequest == null) {
            errorMessage = "Order Request body is null or invalid";
            log.error(errorMessage);
            result.put(false, errorMessage);
            return  result;
        }
        // check distance is valid
        if(orderRequest.getDistance() == null || orderRequest.getDistance() < 0 || orderRequest.getDistance() > 500000)
        {
            errorMessage = "Distance for the order is invalid. Should be between 0-500000";
            log.error(errorMessage);
            result.put(false, errorMessage);
            return  result;

        }
        // check if atleast one item is present
        if(orderRequest.getOrderItems() == null || orderRequest.getOrderItems().size() == 0)
        {
            errorMessage = "order_items  cannot be null or empty";
            log.error(errorMessage);
            result.put(false, errorMessage);
            return  result;

        }

        if(orderRequest.getOrderItems().size() > 0 ) {
            for(OrderItem orderItem: orderRequest.getOrderItems()) {
                // check if item name is valid
                if(orderItem.getName() == null || orderItem.getName().isEmpty() || orderItem.getName().length() < 1 || orderItem.getName().length() > 30) {
                    errorMessage = "Order name cannot be empty and should be 1-30 letters";
                    log.error(errorMessage);
                    result.put(false, errorMessage);
                    return  result;
                }
                // check valid order quantity
                if(orderItem.getQuantity() == null || orderItem.getQuantity() < 1 || orderItem.getQuantity() > 10) {
                    errorMessage = "Order quantity for " + orderItem.getName() + " is invalid. Should be between 1-10";
                    log.error(errorMessage);
                    result.put(false, errorMessage);
                    return  result;
                }
                // check valid order price
                if(orderItem.getPrice() == null || orderItem.getPrice() < 1 || orderItem.getQuantity() > 1000000) {
                    errorMessage = "Order price for " + orderItem.getName() + " is invalid. Should be between 1-1000000";
                    log.error(errorMessage);
                    result.put(false, errorMessage);
                    return  result;
                }
            }
        }
        // validate offer
        if(orderRequest.getOffer() != null) {
            if(orderRequest.getOffer().getOfferType() == Offer.OfferTypeEnum.FLAT && (orderRequest.getOffer().getOfferVal() == null ||
                    orderRequest.getOffer().getOfferVal() < 1)) {
                errorMessage = "Offer value cannot be less than 1 for FLAT type";
                log.error(errorMessage);
                result.put(false, errorMessage);
                return  result;
            }
        }

        result.put(true,errorMessage);
        return result;
    }

}
