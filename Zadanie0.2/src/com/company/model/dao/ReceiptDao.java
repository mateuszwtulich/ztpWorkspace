package com.company.model.dao;

import com.company.model.entity.Receipt;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReceiptDao implements Dao<Receipt> {

    private FileOutputStream fileOut;
    private ObjectOutputStream objectOut;
    private FileInputStream fileIn;
    private ObjectInputStream objectIn;

    @Override
    public Optional<Receipt> get(long id) {
        ArrayList<Receipt> receiptList = (ArrayList<Receipt>) getAll();
        return  receiptList.stream().filter(receipt -> receipt.getId() == id).findFirst();
    }

    @Override
    public List<Receipt> getAll() {
        try {
            fileIn = new FileInputStream(filepath);
            objectIn = new ObjectInputStream(fileIn);
            ArrayList<Receipt> receiptList = new ArrayList<>();
            Object obj = null;

            obj = objectIn.readObject();
            receiptList = (ArrayList<Receipt>) obj;

            objectIn.close();

            return receiptList;

        } catch (Exception ex) {
            System.out.println();
//            System.out.println("NO RECEIPTS!");
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Receipt> save(Receipt receipt) {
        ArrayList<Receipt> receiptList = (ArrayList<Receipt>) getAll();
        receiptList.add(receipt);

        try {
            File file = new File("test");
            file.createNewFile();

            fileOut = new FileOutputStream(filepath);
            objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(receiptList);

            objectOut.close();
            return Optional.of(receipt);
        } catch (Exception ex){
            ex.printStackTrace();
            return Optional.of(null);
        }
    }

    @Override
    public Optional<Receipt> update(Receipt modifiedReceipt) {
        ArrayList<Receipt> receiptList = (ArrayList<Receipt>) getAll();

        receiptList.stream().forEach(receipt -> {
            if(receipt.getId() == modifiedReceipt.getId()) {
                receipt.setTaxpayerName(modifiedReceipt.getTaxpayerName());
                receipt.setAddress(modifiedReceipt.getAddress());
                receipt.setCommodityList(modifiedReceipt.getCommodityList());
                receipt.setTaxpayerID(modifiedReceipt.getTaxpayerID());            }
        });

        try{
            File file = new File("test");
            file.createNewFile();

            fileOut = new FileOutputStream(filepath);
            objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(receiptList);

            objectOut.close();
            return Optional.of(modifiedReceipt);

        }catch (Exception ex) {
            ex.printStackTrace();
            return Optional.of(null);
        }
    }

    @Override
    public void delete(long id) {
        ArrayList<Receipt> receiptList = (ArrayList<Receipt>) getAll();

        receiptList = (ArrayList<Receipt>) receiptList.stream().filter(receipt -> receipt.getId() != id).collect(Collectors.toList());

        try{
            File file = new File("test");
            file.createNewFile();

            fileOut = new FileOutputStream(filepath);
            objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(receiptList);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
