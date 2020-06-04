package com.company.model.dao;

import com.company.model.entity.Receipt;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<Receipt> receiptList = (ArrayList<Receipt>) getAll().get();
        return  receiptList.stream().filter(receipt -> receipt.getId() == id).findFirst();
    }

    @Override
    public Optional<List<Receipt>> getAll() {
        try {
            fileIn = new FileInputStream(filepath);
            objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();
            List<Receipt> receiptList = (ArrayList<Receipt>) obj;
            objectIn.close();

            return Optional.of(receiptList);

        } catch (Exception ex) {
            System.out.println();
            return Optional.of(new ArrayList<>());
        }
    }

    @Override
    public Optional<Receipt> save(Receipt receipt) {
        ArrayList<Receipt> receiptList = (ArrayList<Receipt>) getAll().get();
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
        ArrayList<Receipt> receiptList = (ArrayList<Receipt>) getAll().get();

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
        List<Receipt> receiptList = getAll().get();

        receiptList = Collections.unmodifiableList(receiptList.stream()
                .filter(receipt -> receipt.getId() != id).collect(Collectors.toList()));

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
