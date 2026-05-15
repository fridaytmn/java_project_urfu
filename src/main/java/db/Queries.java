package db;

import java.sql.*;

public class Queries {

    public static void youngestFrenchBillionaire() {

        String sql = """
            SELECT name, age, worth
            FROM billionaires
            WHERE country = 'France'
              AND worth > 10
            ORDER BY age ASC
            LIMIT 1
        """;

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        "Самый молодой миллиардер Франции:"
                );

                System.out.println(
                        rs.getString("name")
                                + " | возраст: "
                                + rs.getInt("age")
                                + " | капитал: "
                                + rs.getDouble("worth")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void richestUSAEnergy() {

        String sql = """
            SELECT name, company, worth
            FROM billionaires
            WHERE country = 'United States'
              AND industry = 'Energy'
            ORDER BY worth DESC
            LIMIT 1
        """;

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        "Самый богатый бизнесмен США в Energy:"
                );

                System.out.println(
                        rs.getString("name")
                                + " | компания: "
                                + rs.getString("company")
                                + " | капитал: "
                                + rs.getDouble("worth")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}