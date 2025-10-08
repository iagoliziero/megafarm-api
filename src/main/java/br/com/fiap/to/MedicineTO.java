package br.com.fiap.to;

import java.time.LocalDate;

public class MedicineTO {
    private Long cod;
    private String name;
    private Double price;
    private LocalDate dataManufacturing ;
    private LocalDate dateValidity;

    public MedicineTO(Long cod, String name, Double price, LocalDate dataManufacturing, LocalDate dateValidity) {
        this.cod = cod;
        this.name = name;
        this.price = price;
        this.dataManufacturing  = dataManufacturing;
        this.dateValidity = dateValidity;
    }

    public MedicineTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDataManufacturing() {
        return dataManufacturing;
    }

    public void setDataFactoring(LocalDate dataFactoring) {
        this.dataManufacturing = dataFactoring;
    }

    public LocalDate getDateValidity() {
        return dateValidity;
    }

    public void setDateValidity(LocalDate dateValidity) {
        this.dateValidity = dateValidity;
    }
}
