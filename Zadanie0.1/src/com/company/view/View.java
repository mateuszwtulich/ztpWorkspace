package com.company.view;

import com.company.controller.IController;
import com.company.model.ISalesModel;
import com.company.model.entity.Commodity;
import java.util.List;
import java.util.Scanner;

public class View implements IView{
    ISalesModel model;
    IController controller;
    boolean isMenuEnabled = true;

    public View(ISalesModel model, IController controller){
        this.model = model;
        this.controller = controller;
    }

    public void createView(){
        do {
            displayMenu();
            Scanner scan = new Scanner(System.in);
            chooseAction(scan.nextLine());
        }while(isMenuEnabled);
    }

    private void chooseAction(String option){
        controller.selectOption(option, this);
    }

    public void showingReceipts(){
        model.getAllReceipts().stream().forEach(
                receipt -> System.out.print(receipt.toString() + '\n'));
    }

    public void addingReceipt(){
        controller.generateReceipt(getReceiptParams());
    }

    public void updatingReceipt() throws Exception{
        Long id = selectReceipt(model);
        String[] params = getReceiptParams();
        controller.modifyReceipt(id, params);
    }


    public void deletingReceipt() throws Exception{
        controller.removeReceipt(selectReceipt(model));
        System.out.println();
        System.out.println("Receipt has been deleted!");
    }

    public void showingCommodities() throws Exception{
        Long receiptId = selectReceipt(model);
        List<Commodity> commodities = model.getAllCommodities(receiptId);

        if(commodities != null && commodities.size() > 0) {
            commodities.stream().forEach(
                    commodity -> System.out.print(commodity.toString() + '\n')
            );
        }
        else{
            System.out.println("\nNo commodities in " + receiptId + " receipt!");
        }
    }

    public void addingCommodity() throws Exception{
        Long receiptId = selectReceipt(model);
        String[] params = getCommodityParams();

        System.out.println(controller.addCommodityToReceipt(receiptId, params).toString());
    }

    public void updatingCommodity() throws Exception{
        Long receiptId = selectReceipt(model);
        Long commodityId = selectCommodity(receiptId, model);
        String[] params = getCommodityParams();

        controller.modifyCommodityInReceipt(receiptId, commodityId, params);
    }

    public void deletingCommodity() throws Exception{
        Long receiptId = selectReceipt(model);
        controller.removeCommodityFromReceipt(receiptId, selectCommodity(receiptId, model));
        System.out.println();
        System.out.println("Commodity has been deleted!");
    }

    public void exit(){
        this.isMenuEnabled = false;
    }
}
