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
        return receiptDao.save(receipt).get();
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receiptDao.getAll();
    }

    @Override
    public Receipt getReceipt(long id) {
        return receiptDao.get(id).get();
    }

    @Override
    public Receipt updateReceipt(Receipt receipt) {
        return receiptDao.update(receipt).get();
    }

    @Override
    public void deleteReceipt(long id) {
        receiptDao.delete(id);
    }

    @Override
    public Commodity createCommodity(long receiptId, Commodity commodity) {
        return commodityDao.save(receiptId, commodity).get();
    }

    @Override
    public List<Commodity> getAllCommodities(long receiptId) {
        return commodityDao.getAll(receiptId);
    }

    @Override
    public Commodity getCommodity(long receiptId, long id) {
        return commodityDao.get(receiptId, id).get();
    }

    @Override
    public Commodity updateCommodity(long receiptId, Commodity commodity) {
        return commodityDao.update(receiptId, commodity).get();
    }

    @Override
    public void deleteCommodity(long receiptId, long id) {
        commodityDao.delete(receiptId, id);
    }
}
