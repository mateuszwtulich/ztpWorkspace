package com.company.model.dao;

import com.company.model.entity.Commodity;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommodityDao implements ICommodityDao<Commodity> {

    private ReceiptDao receiptDao;

    public CommodityDao(){
        receiptDao = new ReceiptDao();
    }

    @Override
    public Optional<Commodity> get(long receiptId, long id) {
        return receiptDao.get(receiptId).get().getCommodityList().stream()
                .filter(commodity -> commodity.getId() == id).findFirst();
    }

    @Override
    public Optional<List<Commodity>> getAll(long receiptId) {
        return Optional.of(Collections.unmodifiableList(receiptDao.get(receiptId).get().getCommodityList()));
    }

    @Override
    public Optional<Commodity> save(long receiptId, Commodity commodity) {
        Receipt receipt = receiptDao.get(receiptId).get();
        if(receipt.getCommodityList() == null){
            ArrayList<Commodity> commodities = new ArrayList<>();
            commodities.add(commodity);
            receipt.setCommodityList(commodities);
        }else{
            receipt.getCommodityList().add(commodity);
        }
        receiptDao.update(receipt);
        return Optional.of(commodity);
    }

    @Override
    public Optional<Commodity> update(long receiptId, Commodity commodity) {
        Receipt receipt = receiptDao.get(receiptId).get();
        List<Commodity> updatedList = receipt.getCommodityList().stream().filter(commodity1 -> commodity1.getId() != commodity.getId()).collect(Collectors.toList());
        updatedList.add(commodity);
        receipt.setCommodityList((ArrayList<Commodity>) updatedList);
        receiptDao.update(receipt);
        return Optional.of(commodity);
    }

    @Override
    public void delete(long receiptId, long id) {
        Receipt receipt = receiptDao.get(receiptId).get();
        List<Commodity> updatedList = Collections.unmodifiableList(receipt.getCommodityList().stream().filter(commodity -> commodity.getId() != id).collect(Collectors.toList()));
        receipt.setCommodityList((ArrayList<Commodity>) updatedList);
        receiptDao.update(receipt);
    }
}
