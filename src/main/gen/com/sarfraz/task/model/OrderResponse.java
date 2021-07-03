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
 * OrderResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-03T16:26:22.933846+05:30[Asia/Calcutta]")
public class OrderResponse   {
  @JsonProperty("order_total")
  private Integer orderTotal;

  public OrderResponse orderTotal(Integer orderTotal) {
    this.orderTotal = orderTotal;
    return this;
  }

  /**
   * Get orderTotal
   * @return orderTotal
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getOrderTotal() {
    return orderTotal;
  }

  public void setOrderTotal(Integer orderTotal) {
    this.orderTotal = orderTotal;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderResponse orderResponse = (OrderResponse) o;
    return Objects.equals(this.orderTotal, orderResponse.orderTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderTotal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderResponse {\n");
    
    sb.append("    orderTotal: ").append(toIndentedString(orderTotal)).append("\n");
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

