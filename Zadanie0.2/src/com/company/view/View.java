package com.company.view;

import com.company.controller.IController;
import com.company.model.ISalesModel;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;

import javax.print.DocFlavor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private ISalesModel model;
    private IController controller;
    private boolean isMenuEnabled = true;
    private String dataSource = "DB";

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

    private void displayMenu(){
        System.out.println("\n------------------MENU------------------");
        System.out.println("Show all receipts [SR]");
        System.out.println("Add receipt [AR]");
        System.out.println("Update receipt [UR]");
        System.out.println("Delete receipt [DR]");
        System.out.println("\nShow all commodities [SC]");
        System.out.println("Add commodity to receipt [AC]");
        System.out.println("Update commodity from receipt [UC]");
        System.out.println("Delete commodity [DC]");
        System.out.println("\nChange datasource [" + dataSource + "]");
        System.out.println("Exit [EXIT]");
        System.out.println("------------------MENU------------------");
        System.out.print("Choose an option: ");
    }

    private void chooseAction(String option){
        controller.selectOption(option);
    }

    public void showingReceipts(){
        model.getAllReceipts().stream().forEach(
                receipt -> System.out.print(receipt.toString() + '\n'));
    }

    public void addingReceipt(){
        controller.generateReceipt(getReceiptParams());
    }

    public void updatingReceipt() throws Exception{
        Long id = selectReceipt();
        String[] params = getReceiptParams();
        controller.modifyReceipt(id, params);
    }

    private String[] getReceiptParams(){
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter taxpayer name: ");
        String taxpayerName = scan.nextLine();
        System.out.print("Enter address: ");
        String address = scan.nextLine();
        System.out.print("Enter taxpayerID: ");
        String taxpayerID = scan.nextLine();

        String[] params = new String[3];
        params[0] = address;
        params[1] = taxpayerID;
        params[2] = taxpayerName;
        return params;
    }

    public void deletingReceipt() throws Exception{
        controller.removeReceipt(selectReceipt());
        System.out.println();
        System.out.println("Receipt has been deleted!");
    }

    public void showingCommodities() throws Exception{
        Long receiptId = selectReceipt();
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

    private Long selectReceipt() throws Exception{
        Long id = 0L;
        showingReceipts();
        System.out.println();
        System.out.print("Enter receipt id: ");
        Scanner scan = new Scanner(System.in);
        try {
            id = Long.parseLong(scan.nextLine());
            final Long tmpId = id;
            boolean exists = model.getAllReceipts().stream().anyMatch(receipt -> receipt.getId() == tmpId);

            try {
                if (!exists) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println("It is not an existing receipt id!");
                throw new IllegalArgumentException();
            }
        }catch (Exception ex) {
            System.out.println("It is not correct receipt id format!");
            throw new Exception();
        }
        return id;
    }

    public void addingCommodity() throws Exception{
        Long receiptId = selectReceipt();
        String[] params = getCommodityParams();

        System.out.println(controller.addCommodityToReceipt(receiptId, params).toString());
    }

    public void updatingCommodity() throws Exception{
        Long receiptId = selectReceipt();
        Long commodityId = selectCommodity(receiptId);
        String[] params = getCommodityParams();

        controller.modifyCommodityInReceipt(receiptId, commodityId, params);
    }

    private String[] getCommodityParams(){
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scan.nextLine();
        System.out.print("Enter amount in total number: ");
        String amount = scan.nextLine();
        System.out.print("Enter price: ");
        String value = scan.nextLine();
        System.out.print("Enter tax rate in percentages: ");
        String taxRate = scan.nextLine();

        String[] params = new String[4];
        params[0] = name;
        params[1] = amount;
        params[2] = value;
        params[3] = taxRate;

        return params;
    }

    public void deletingCommodity() throws Exception{
        Long receiptId = selectReceipt();
        controller.removeCommodityFromReceipt(receiptId, selectCommodity(receiptId));
        System.out.println();
        System.out.println("Commodity has been deleted!");
    }

    private Long selectCommodity(Long receiptId) throws Exception {
        Long id = 0L;
        System.out.println();
        System.out.print("Enter commodity id: ");
        Scanner scan = new Scanner(System.in);
        try {
            id = Long.parseLong(scan.nextLine());
            final Long tmpId = id;
            boolean exists = model.getAllCommodities(receiptId).stream().anyMatch( commodity -> commodity.getId() == tmpId);

            try {
                if (!exists) {
                    throw new IllegalArgumentException();
                }
            }catch(Exception ex){
                System.out.println("It is not an existing commodity id!");
                throw new IllegalArgumentException();
            }
        }catch (Exception ex) {
            System.out.println("It is not correct receipt id format!");
            throw new Exception();
        }
        return id;
    }

    public void setModel(ISalesModel model) {
        this.model = model;
    }

    public void exit(){
        this.isMenuEnabled = false;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}
