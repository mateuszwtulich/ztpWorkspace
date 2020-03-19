package com.company.model;

import com.company.model.dao.CommodityDao;
import com.company.model.dao.Dao;
import com.company.model.dao.ICommodityDao;
import com.company.model.dao.ReceiptDao;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SalesModel implements ISalesModel {
    private ICommodityDao<Commodity> commodityDao;
    private Dao<Receipt> receiptDao;

    public SalesModel(){
        commodityDao = new CommodityDao();
        receiptDao = new ReceiptDao();
    }

    public SalesModel(ICommodityDao<Commodity> commodityDao, Dao<Receipt> receiptDao){
        this.commodityDao = commodityDao;
        this.receiptDao = receiptDao;
    }

    @Override
    public Receipt createReceipt(Receipt receipt) {
        return receiptDao.save(receipt).get();
    }

    @Override
    public List<Receipt> getAllReceipts() {
        List<Receipt> receiptList =  receiptDao.getAll().stream().map( receipt -> {
            receipt.setCommodityList((ArrayList<Commodity>) commodityDao.getAll(receipt.getId()));
            return receipt;
        }).collect(Collectors.toList());
        return receiptList;
    }

    @Override
    public Receipt getReceipt(long id) {
        Receipt receipt = receiptDao.get(id).get();
        receipt.setCommodityList((ArrayList<Commodity>) commodityDao.getAll(receipt.getId()));
        return receipt;
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
