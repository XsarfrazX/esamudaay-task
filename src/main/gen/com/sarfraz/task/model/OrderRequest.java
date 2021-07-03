package com.sarfraz.task.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.sarfraz.task.model.Offer;
import com.sarfraz.task.model.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-03T16:26:22.933846+05:30[Asia/Calcutta]")
public class OrderRequest   {
  @JsonProperty("order_items")
  @Valid
  private List<OrderItem> orderItems = new ArrayList<>();

  @JsonProperty("distance")
  private Integer distance;

  @JsonProperty("offer")
  private Offer offer;

  public OrderRequest orderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
    return this;
  }

  public OrderRequest addOrderItemsItem(OrderItem orderItemsItem) {
    this.orderItems.add(orderItemsItem);
    return this;
  }

  /**
   * Get orderItems
   * @return orderItems
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public OrderRequest distance(Integer distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Distance in meters
   * minimum: 0
   * maximum: 500000
   * @return distance
  */
  @ApiModelProperty(required = true, value = "Distance in meters")
  @NotNull

@Min(0) @Max(500000) 
  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public OrderRequest offer(Offer offer) {
    this.offer = offer;
    return this;
  }

  /**
   * Get offer
   * @return offer
  */
  @ApiModelProperty(value = "")

  @Valid

  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderRequest orderRequest = (OrderRequest) o;
    return Objects.equals(this.orderItems, orderRequest.orderItems) &&
        Objects.equals(this.distance, orderRequest.distance) &&
        Objects.equals(this.offer, orderRequest.offer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderItems, distance, offer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderRequest {\n");
    
    sb.append("    orderItems: ").append(toIndentedString(orderItems)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    offer: ").append(toIndentedString(offer)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

