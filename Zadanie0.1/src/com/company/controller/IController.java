package com.company.controller;

import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;
import com.company.view.View;

import java.util.List;

public interface IController {
    Receipt generateReceipt(String params[]);
    Receipt modifyReceipt(Long id, String params[]);
    void removeReceipt(long id);

    Commodity addCommodityToReceipt(Long receiptId, String params[]) throws Exception;
    Commodity modifyCommodityInReceipt(Long receiptId, Long commodityId, String params[]) throws Exception;
    void removeCommodityFromReceipt(Long receiptId, long id);

    default void selectOption(String option, View view){
        try {

            switch (option) {
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
                }
                default: {
                    System.out.println();
                    System.out.println("Not an option. Try again!");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("\n//////////////////////////////////");
            System.out.println("Incorrect argument!");
            System.out.println("///////////////////////////////////");
        }
    }
}
