package com.company.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Receipt implements Serializable {

    private static long serialVersionUID = 1L;
    private long id;
    private LocalDateTime dateTime;
    private String taxpayerName;
    private String address;
    private String taxpayerID;
    private ArrayList<Commodity> commodityList;
    private float commoditiesSum;
    private float taxSum;

    public Receipt(){
        id = (long) (Math.random()*10000);
        dateTime = LocalDateTime.now();
    }

    public long getId() { return id; }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public float getCommoditiesSum() {
        return commoditiesSum;
    }

    public float getTaxSum() {
        return taxSum;
    }

    public String getTaxpayerName() {
        return taxpayerName;
    }

    public void setTaxpayerName(String taxpayerName) {
        this.taxpayerName = taxpayerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxpayerID() {
        return taxpayerID;
    }

    public void setTaxpayerID(String taxpayerID) {
        this.taxpayerID = taxpayerID;
    }

    public ArrayList<Commodity> getCommodityList() { return commodityList; }

    public void setCommodityList(ArrayList<Commodity> commodityList) {
        this.commodityList = commodityList;
        if(commodityList != null) {
            actualizeSums();
        }
    }

    private void actualizeSums(){
        actualizeCommoditiesSum();
        actualizeTaxSum();
    }

    private void actualizeCommoditiesSum(){
        commoditiesSum = 0;
        commodityList.stream().forEach( commodity -> this.commoditiesSum += (commodity.getAmount() * commodity.getValue()));
    }

    private void actualizeTaxSum(){
        taxSum = 0;
        commodityList.stream().forEach( commodity -> taxSum += ((commodity.getTaxRate()/100) * (commodity.getValue()
            * commodity.getAmount())));
    }

    @Override
    public String toString() {
        String result = "#########################################" + '\n' + "RECEIPT ID: "+ Long.toString(id) + " " + DateTimeFormatter.ISO_DATE_TIME.format(dateTime) + '\n' +
                taxpayerName + " " + taxpayerID + " " + address + '\n' + '\n' + "COMMODITIES:";

        if(commodityList != null) {
            for (Commodity commodity : commodityList) {
                result += commodity.toString() + '\n';
            }
        }

        result += "\n" + "Tax sum: " + taxSum + '\n' + "Sum: " + commoditiesSum  + '\n' + "#########################################";
        return result;
    }
}
