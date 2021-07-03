package com.sarfraz.task.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Represents an offer with type and value (if any)
 */
@ApiModel(description = "Represents an offer with type and value (if any)")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-03T16:26:22.933846+05:30[Asia/Calcutta]")
public class Offer   {
  /**
   * Gets or Sets offerType
   */
  public enum OfferTypeEnum {
    FLAT("FLAT"),
    
    DELIVERY("DELIVERY");

    private String value;

    OfferTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OfferTypeEnum fromValue(String value) {
      for (OfferTypeEnum b : OfferTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("offer_type")
  private OfferTypeEnum offerType;

  @JsonProperty("offer_val")
  private Integer offerVal;

  public Offer offerType(OfferTypeEnum offerType) {
    this.offerType = offerType;
    return this;
  }

  /**
   * Get offerType
   * @return offerType
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public OfferTypeEnum getOfferType() {
    return offerType;
  }

  public void setOfferType(OfferTypeEnum offerType) {
    this.offerType = offerType;
  }

  public Offer offerVal(Integer offerVal) {
    this.offerVal = offerVal;
    return this;
  }

  /**
   * Get offerVal
   * minimum: 1
   * @return offerVal
  */
  @ApiModelProperty(value = "")

@Min(1)
  public Integer getOfferVal() {
    return offerVal;
  }

  public void setOfferVal(Integer offerVal) {
    this.offerVal = offerVal;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Offer offer = (Offer) o;
    return Objects.equals(this.offerType, offer.offerType) &&
        Objects.equals(this.offerVal, offer.offerVal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offerType, offerVal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Offer {\n");
    
    sb.append("    offerType: ").append(toIndentedString(offerType)).append("\n");
    sb.append("    offerVal: ").append(toIndentedString(offerVal)).append("\n");
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

