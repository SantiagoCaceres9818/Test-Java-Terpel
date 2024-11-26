package com.test.terpel.app.test_terpel.dto;

public class AverageDto {
    
    private long quantityClients;
    private double averageAge;

    
    public AverageDto(long quantityClients, double averageAge) {
        this.quantityClients = quantityClients;
        this.averageAge = averageAge;
    }

    public long getQuantityClients() {
        return quantityClients;
    }
    public void setQuantityClients(long quantityClients) {
        this.quantityClients = quantityClients;
    }
    public double getAverageAge() {
        return averageAge;
    }
    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }

    

}
