import chart.ChartGenerator;
import db.DatabaseManager;
import db.Queries;
import model.Billionaire;
import parser.CSVParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Billionaire> list =
                CSVParser.parse("data/forbes.csv");

        DatabaseManager.createTable();

        DatabaseManager.insertData(list);

        Queries.youngestFrenchBillionaire();

        Queries.richestUSAEnergy();

        ChartGenerator.createChart();
    }
}