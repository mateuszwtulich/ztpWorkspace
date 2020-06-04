package com.company.view;

import com.company.model.ISalesModel;

import java.util.Scanner;

public interface IView {
    void createView();
    void showingReceipts();
    void addingReceipt();
    void updatingReceipt() throws Exception;
    void deletingReceipt() throws Exception;
    void showingCommodities() throws Exception;
    void addingCommodity() throws Exception;
    void updatingCommodity() throws Exception;
    void deletingCommodity() throws Exception;
    void exit();

    default void displayMenu(){
        System.out.println("\n----------------MENU----------------");
        System.out.println("Show all receipts [SR]");
        System.out.println("Add receipt [AR]");
        System.out.println("Update receipt [UR]");
        System.out.println("Delete receipt [DR]");
        System.out.println("\nShow all commodities [SC]");
        System.out.println("Add commodity to receipt [AC]");
        System.out.println("Update commodity from receipt [UC]");
        System.out.println("Delete commodity [DC]");
        System.out.println("\nExit [EXIT]");
        System.out.println("----------------MENU----------------");
        System.out.print("Choose an option: ");
    }

    default String[] getReceiptParams(){
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

    default String[] getCommodityParams(){
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

    default Long selectReceipt(ISalesModel model) throws Exception{
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
                logError("It is not an existing receipt id!");
                throw new IllegalArgumentException();
            }
        }catch (Exception ex) {
            logError("It is not correct receipt id format!");
            throw new Exception();
        }
        return id;
    }

    default Long selectCommodity(Long receiptId, ISalesModel model) throws Exception {
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
                logError("It is not an existing commodity id!");
                throw new IllegalArgumentException();
            }
        }catch (Exception ex) {
            logError("It is not correct receipt id format!");
            throw new Exception();
        }
        return id;
    }

    private void logError(String message){
        System.out.println(message);
    }
}
