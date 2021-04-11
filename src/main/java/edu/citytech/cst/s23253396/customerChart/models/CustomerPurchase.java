package edu.citytech.cst.s23253396.customerChart.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerPurchase {
    private Float _id;
    private String customerId;
    private Float totalItems;
    private Float totalPrice;
    private Location location;
    private ShortDate shortDate;

    public String getLocationCode() {
        return this.location.getCode();
    }

    public String getShortDateDayName() {
        return this.shortDate.getDayName();
    }
}
