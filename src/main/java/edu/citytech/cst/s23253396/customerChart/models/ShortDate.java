package edu.citytech.cst.s23253396.customerChart.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShortDate {
    private Float year;
    private Float month;
    private Float day;
    private String dayName;
}
