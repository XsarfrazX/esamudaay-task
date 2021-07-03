package com.sarfraz.task.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents an order item  with name, price and quantity
 */
@ApiModel(description = "Represents an order item  with name, price and quantity")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-03T16:26:22.933846+05:30[Asia/Calcutta]")
public class OrderItem   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("price")
  private Integer price;

  public OrderItem name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(min=1,max=30) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrderItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * minimum: 1
   * maximum: 10
   * @return quantity
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Min(1) @Max(10) 
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderItem price(Integer price) {
    this.price = price;
    return this;
  }

  /**
   * Price of an item in paisas
   * minimum: 1
   * maximum: 1000000
   * @return price
  */
  @ApiModelProperty(required = true, value = "Price of an item in paisas")
  @NotNull

@Min(1) @Max(1000000) 
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.name, orderItem.name) &&
        Objects.equals(this.quantity, orderItem.quantity) &&
        Objects.equals(this.price, orderItem.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, quantity, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

