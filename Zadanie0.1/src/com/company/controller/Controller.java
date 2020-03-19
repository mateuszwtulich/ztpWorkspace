package com.company.controller;

import com.company.model.ISalesModel;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;
import com.company.view.View;

public class Controller implements IController {
    ISalesModel model;
    View view;

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
        commodity.setName(params[0]);
        commodity.setAmount(Integer.parseInt(params[1]));
        commodity.setValue(Float.parseFloat(params[2]));
        commodity.setTaxRate(Float.parseFloat(params[3]));
        return model.createCommodity(receiptId, commodity);
    }

    @Override
    public Commodity modifyCommodityInReceipt(Long receiptId, Long commodityId, String[] params) {
        Commodity commodity = model.getCommodity(receiptId, commodityId);
        commodity.setName(params[0]);
        commodity.setAmount(Integer.parseInt(params[1]));
        commodity.setValue(Float.parseFloat(params[2]));
        commodity.setTaxRate(Float.parseFloat(params[3]));
        return model.updateCommodity(receiptId, commodity);
    }

    @Override
    public void removeCommodityFromReceipt(Long receiptId, long id) {
        model.deleteCommodity(receiptId, id);
    }

    @Override
    public void selectOption(String option) {
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
            case "EXIT": {
                view.exit();
                break;
            } default: {
                System.out.println();
                System.out.println("Not an option. Try again!");
                break;
            }
        }
    }
}
