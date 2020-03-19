package com.company.controller;

import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;

import java.util.List;

public interface IController {
    Receipt generateReceipt(String params[]);
    Receipt modifyReceipt(Long id, String params[]);
    void removeReceipt(long id);

    Commodity addCommodityToReceipt(Long receiptId, String params[]);
    Commodity modifyCommodityInReceipt(Long receiptId, Long commodityId, String params[]);
    void removeCommodityFromReceipt(Long receiptId, long id);

    void selectOption(String option);
}
