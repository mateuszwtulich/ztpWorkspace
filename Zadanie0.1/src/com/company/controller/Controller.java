package com.company.controller;

import com.company.model.ISalesModel;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;
import com.company.view.View;

public class Controller implements IController {
    ISalesModel model;
    View view;

    public Controller(ISalesModel model) {
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
    public Commodity addCommodityToReceipt(Long receiptId, String[] params) throws Exception {
        Commodity commodity = new Commodity();
        try {
            commodity.setName(params[0]);
            commodity.setAmount(Integer.parseInt(params[1]));
            commodity.setValue(Float.parseFloat(params[2]));
            commodity.setTaxRate(Float.parseFloat(params[3]));
        } catch (Exception ex) {
            throw new Exception();
        }
        return model.createCommodity(receiptId, commodity);
    }

    @Override
    public Commodity modifyCommodityInReceipt(Long receiptId, Long commodityId, String[] params) throws Exception {
        Commodity commodity = model.getCommodity(receiptId, commodityId);
        try {
            commodity.setName(params[0]);
            commodity.setAmount(Integer.parseInt(params[1]));
            commodity.setValue(Float.parseFloat(params[2]));
            commodity.setTaxRate(Float.parseFloat(params[3]));
        } catch (Exception ex) {
            throw new Exception();
        }
        return model.updateCommodity(receiptId, commodity);
    }

    @Override
    public void removeCommodityFromReceipt(Long receiptId, long id) {
        model.deleteCommodity(receiptId, id);
    }

}
