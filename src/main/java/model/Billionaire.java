package model;

public class Billionaire {

    private String name;
    private int age;
    private String country;
    private String company;
    private String industry;
    private double worth;

    public Billionaire(String name, int age, String country,
                       String company, String industry, double worth) {

        this.name = name;
        this.age = age;
        this.country = country;
        this.company = company;
        this.industry = industry;
        this.worth = worth;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public String getIndustry() {
        return industry;
    }

    public double getWorth() {
        return worth;
    }
}