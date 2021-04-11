package edu.citytech.cst.s23253396.customerChart.services.implementations;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.cst.s23253396.customerChart.models.CustomerPurchase;
import edu.citytech.cst.s23253396.customerChart.services.CustomerPurchaseService;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class CustomerPurchaseServiceImpl implements CustomerPurchaseService {

    private final String url = "http://localhost:9215/api/reports/year/month/days/price/location";

    public String getUrl() {
        return url;
    }

    private String modifyUrl(String year, String month, String days, String price, String location) {
         return this.getUrl()
                 .replace("year", year)
                 .replace("month", month)
                 .replace("days", days)
                 .replace("price", price)
                 .replace("location", location);
    }

    @Override
    public List<CustomerPurchase> getAllCustomerPurchases() {
        String url = modifyUrl("2012", "1,2,3,4,5,6,7,8,9,10,11,12",
                "SATURDAY", "100,200", "A,B,C,D");

        Map map = JSONGet.submitGet(url, Map.class);

        return (List<CustomerPurchase>) map.get("row.data");
    }

}
