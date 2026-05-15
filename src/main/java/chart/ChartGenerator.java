package chart;

import db.DatabaseManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChartGenerator {

    public static void createChart() {

        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        String sql = """
            SELECT country,
                   SUM(worth) as total
            FROM billionaires
            GROUP BY country
        """;

        try (Connection conn =
                     DatabaseManager.connect();

             Statement stmt =
                     conn.createStatement();

             ResultSet rs =
                     stmt.executeQuery(sql)) {

            while (rs.next()) {

                dataset.addValue(
                        rs.getDouble("total"),
                        "Capital",
                        rs.getString("country")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JFreeChart chart =
                ChartFactory.createBarChart(
                        "Общий капитал по странам",
                        "Страна",
                        "Капитал",
                        dataset
                );

        ChartFrame frame =
                new ChartFrame("Forbes", chart);

        frame.pack();
        frame.setVisible(true);
    }
}