package com.company.controller;

import com.company.model.DbConfig;
import com.company.model.ISalesModel;
import com.company.model.SalesModel;
import com.company.model.dao.CommodityDao;
import com.company.model.dao.CommodityDaoDb;
import com.company.model.dao.ReceiptDao;
import com.company.model.dao.ReceiptDaoDb;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;
import com.company.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller implements IController {
    private static String FILE_DATA_SOURCE = "FILE";
    private static String DB_DATA_SOURCE = "DB";
    private ISalesModel model;
    private View view;

    public Controller(ISalesModel model){
        this.model = model;
        view = new View(model, this);
        view.createView();
    }

    @Override
    public Receipt generateReceipt(String params[]) {
        Receipt receipt = new Receipt();
        receipt.setAddress(params[0]);
        receipt.setTaxpayerID(params[1]);
        receipt.setTaxpayerName(params[2]);

        return model.createReceipt(receipt);
    }

    @Override
    public Receipt modifyReceipt(Long id, String[] params) {
        Receipt receipt = model.getReceipt(id);

        receipt.setAddress(params[0]);
        receipt.setTaxpayerID(params[1]);
        receipt.setTaxpayerName(params[2]);

        return model.updateReceipt(receipt);
    }

    @Override
    public void removeReceipt(long id) {
        model.deleteReceipt(id);
    }

    @Override
    public Commodity addCommodityToReceipt(Long receiptId, String[] params) {
        Commodity commodity = new Commodity();
        try {
            commodity.setName(params[0]);
            commodity.setAmount(Integer.parseInt(params[1]));
            commodity.setValue(Float.parseFloat(params[2]));
            commodity.setTaxRate(Float.parseFloat(params[3]));
        }catch(Exception ex){
            System.out.println("Data format is incorrect!");
        }
        return model.createCommodity(receiptId, commodity);
    }

    @Override
    public Commodity modifyCommodityInReceipt(Long receiptId, Long commodityId, String[] params) {
        Commodity commodity = model.getCommodity(receiptId, commodityId);
        try {
            commodity.setName(params[0]);
            commodity.setAmount(Integer.parseInt(params[1]));
            commodity.setValue(Float.parseFloat(params[2]));
            commodity.setTaxRate(Float.parseFloat(params[3]));
        }catch(Exception ex){
            System.out.println("Data format is incorrect!");
        }
        return model.updateCommodity(receiptId, commodity);
    }

    @Override
    public void removeCommodityFromReceipt(Long receiptId, long id) {
        model.deleteCommodity(receiptId, id);
    }

    @Override
    public void selectOption(String option) {
        if(option.equals(view.getDataSource())){
            if(FILE_DATA_SOURCE.equals(option)){
                switchDataSourceToFile();
            }
            if(DB_DATA_SOURCE.equals(option)){
                switchDataSourceToDb();
            }
            option = "DS";
        }

        switch (option){
            case "SR": {
                view.showingReceipts();
                break;
            }
            case "AR": {
                view.addingReceipt();
                break;
            }
            case "UR": {
                view.updatingReceipt();
                break;
            }
            case "DR": {
                view.deletingReceipt();
                break;
            }
            case "SC": {
                view.showingCommodities();
                break;
            }
            case "AC": {
                view.addingCommodity();
                break;
            }
            case "UC": {
                view.updatingCommodity();
                break;
            }
            case "DC": {
                view.deletingCommodity();
                break;
            }
            case "DS": {
                view.showingReceipts();
                break;
            }
            case "EXIT": {
                view.exit();
                if(view.getDataSource() == FILE_DATA_SOURCE){
                    switchDataSourceToFile();
                }
                else if (view.getDataSource() == DB_DATA_SOURCE){
                    switchDataSourceToDb();
                }

                DbConfig.disconnectFromDb();
                break;
            } default: {
                System.out.println();
                System.out.println("Not an option. Try again!");
                break;
            }
        }
    }

    private void switchDataSourceToDb() {
        DbConfig.connectToDb();
        List<Receipt> receipts = this.model.getAllReceipts();

        if(DbConfig.getConn() != null) {
            this.model = new SalesModel(new CommodityDaoDb(), new ReceiptDaoDb());
            this.view.setModel(this.model);
        }
        synchronizeDataSourcesWithFile(receipts);
        System.out.println("\nDatasource switched and synchronized with " + DB_DATA_SOURCE);
        view.setDataSource(FILE_DATA_SOURCE);
    }

    private void switchDataSourceToFile() {
        List<Receipt> receipts = this.model.getAllReceipts();
        this.model = new SalesModel(new CommodityDao(), new ReceiptDao());
        this.view.setModel(this.model);
        synchronizeDataSourcesWithDb(receipts);
        System.out.println("\nDatasource switched and synchronized with " + FILE_DATA_SOURCE);
        DbConfig.disconnectFromDb();
        view.setDataSource(DB_DATA_SOURCE);
    }

    private void synchronizeDataSourcesWithFile(List<Receipt> receipts){
        this.model.getAllReceipts().stream().forEach(receipt -> this.model.deleteReceipt(receipt.getId()));

        receipts.stream().forEach(receipt -> this.model.createReceipt(receipt));
        receipts.stream().forEach(receipt -> {
            if(receipt.getCommodityList()!=null)
            receipt.getCommodityList().forEach( commodity ->{
                this.model.createCommodity(receipt.getId(), commodity);
            });
        });
    }

    private void synchronizeDataSourcesWithDb(List<Receipt> receipts) {
        this.model.getAllReceipts().stream().forEach(receipt -> this.model.deleteReceipt(receipt.getId()));
        receipts.stream().forEach(receipt -> this.model.createReceipt(receipt));
    }
}
