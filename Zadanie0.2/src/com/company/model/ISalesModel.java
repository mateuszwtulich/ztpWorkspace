package com.company.model;

import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;

import java.util.List;

public interface ISalesModel {

    Receipt createReceipt(Receipt newReceipt);
    List<Receipt> getAllReceipts();
    Receipt getReceipt(long id);
    Receipt updateReceipt(Receipt updatedReceipt);
    void deleteReceipt(long id);

    Commodity createCommodity(long receiptId, Commodity newCommodity);
    List<Commodity> getAllCommodities(long receiptId);
    Commodity getCommodity(long receiptId, long id);
    Commodity updateCommodity(long receiptId, Commodity updatedCommodity);
    void deleteCommodity(long receiptId, long id);
}
