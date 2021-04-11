package edu.citytech.cst.s23253396.customerChart;

import com.jbbwebsolutions.http.utility.JSONGet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

public class Launcher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//         experiment(stage);
        stage.setTitle("Pie Chart - Rayner Mendez - 23253396");
        String name = "/views/CustomerPurchaseView.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(name));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void experiment(Stage stage) {
        stage.setTitle("Pie Chart - Rayner Mendez - 23253396");
        PieChart pieChart = new PieChart();

        String url = "http://localhost:9215/api/reports/:year/:month/:days/:price/:location";
        url = url.replace(":year", "2012")
                .replace(":month", "1,2,4,5,6,7,8,9,10,11,12")
                .replace(":days", "SATURDAY")
                .replace(":price", "100,200")
                .replace(":location", "A,B,C,D");

        Map object = JSONGet.submitGet(url, Map.class);

        System.out.println(object);

        for (char c = 'A'; c <= 'D'; ++c) {
            var key = "row.count.code." + c;
            var data= object.get(key);
            System.out.println(data);

            PieChart.Data slice = new PieChart.Data(String.valueOf(c), Float.parseFloat(data.toString()));
            pieChart.getData().add(slice);
        }



        pieChart.setMinHeight(500);
        pieChart.setMinWidth(500);

        VBox vBox = new VBox(pieChart);

        Scene scene = new Scene(vBox, 500, 500);

        stage.setScene(scene);

        stage.show();
    }
}
