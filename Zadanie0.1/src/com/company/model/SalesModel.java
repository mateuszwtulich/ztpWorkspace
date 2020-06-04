package com.company.model;

import com.company.model.dao.CommodityDao;
import com.company.model.dao.Dao;
import com.company.model.dao.ICommodityDao;
import com.company.model.dao.ReceiptDao;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;

import java.util.List;

public class SalesModel implements ISalesModel {
    ICommodityDao<Commodity> commodityDao;
    Dao<Receipt> receiptDao;

    public SalesModel(){
        commodityDao = new CommodityDao();
        receiptDao = new ReceiptDao();
    }

    @Override
    public Receipt createReceipt(Receipt receipt) {
        return receiptDao.save(receipt)
                .orElseThrow(() -> new RuntimeException("Receipt has not been created"));
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receiptDao.getAll()
                .orElseThrow(() -> new RuntimeException("Receipts have not been loaded"));
    }

    @Override
    public Receipt getReceipt(long id) {
        return receiptDao.get(id)
                .orElseThrow(() -> new RuntimeException("Receipt has not been loaded"));
    }

    @Override
    public Receipt updateReceipt(Receipt receipt) {
        return receiptDao.update(receipt)
                .orElseThrow(() -> new RuntimeException("Receipt could not been updated"));
    }

    @Override
    public void deleteReceipt(long id) {
        receiptDao.delete(id);
    }

    @Override
    public Commodity createCommodity(long receiptId, Commodity commodity) {
        return commodityDao.save(receiptId, commodity)
                .orElseThrow(() -> new RuntimeException("Commodity has not been created"));
    }

    @Override
    public List<Commodity> getAllCommodities(long receiptId) {
        return commodityDao.getAll(receiptId)
                .orElseThrow(() -> new RuntimeException("Commodities have not been loaded"));
    }

    @Override
    public Commodity getCommodity(long receiptId, long id) {
        return commodityDao.get(receiptId, id)
                .orElseThrow(() -> new RuntimeException("Commodity has not been loaded"));
    }

    @Override
    public Commodity updateCommodity(long receiptId, Commodity commodity) {
        return commodityDao.update(receiptId, commodity)
                .orElseThrow(() -> new RuntimeException("Commodity could not been updated"));
    }

    @Override
    public void deleteCommodity(long receiptId, long id) {
        commodityDao.delete(receiptId, id);
    }
}
