package db;

import model.Billionaire;

import java.sql.*;
import java.util.List;

public class DatabaseManager {

    private static final String URL =
            "jdbc:sqlite:forbes.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTable() {

        String sql = """
            CREATE TABLE IF NOT EXISTS billionaires (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                age INTEGER,
                country TEXT,
                company TEXT,
                industry TEXT,
                worth REAL
            );
        """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertData(List<Billionaire> list) {

        String sql = """
            INSERT INTO billionaires
            (name, age, country, company, industry, worth)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = connect();
             PreparedStatement pstmt =
                     conn.prepareStatement(sql)) {

            for (Billionaire b : list) {

                pstmt.setString(1, b.getName());
                pstmt.setInt(2, b.getAge());
                pstmt.setString(3, b.getCountry());
                pstmt.setString(4, b.getCompany());
                pstmt.setString(5, b.getIndustry());
                pstmt.setDouble(6, b.getWorth());

                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}