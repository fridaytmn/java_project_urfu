package parser;

import com.opencsv.CSVReader;

import model.Billionaire;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public static List<Billionaire> parse(String fileName) {

        List<Billionaire> list = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

            String[] data;
            reader.readNext();

            while ((data = reader.readNext()) != null) {

                int rank = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double worth = Double.parseDouble(data[2].trim());
                int age = Integer.parseInt(data[3].trim());
                String country = data[4].trim();
                String company = data[5].trim();
                String industry = data[6].trim();

                list.add(new Billionaire(
                        name,
                        age,
                        country,
                        company,
                        industry,
                        worth
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}