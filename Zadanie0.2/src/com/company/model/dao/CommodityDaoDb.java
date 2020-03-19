package com.company.model.dao;

import com.company.model.DbConfig;
import com.company.model.ISalesModel;
import com.company.model.SalesModel;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommodityDaoDb implements ICommodityDao<Commodity> {
    private Connection connection;
    private ReceiptDaoDb receiptDao;

    public CommodityDaoDb(){
        this.connection = DbConfig.getConn();
        this.receiptDao = new ReceiptDaoDb();
    }

    @Override
    public Optional<Commodity> get(long receiptId, long id) {
        String sql = "SELECT * FROM Commodities WHERE receiptId = " + receiptId + " AND id=" + id;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            String name = resultSet.getString("name");
            int amount = resultSet.getInt("amount");
            Float value = resultSet.getFloat("value");
            Float taxRate = resultSet.getFloat("taxRate");

            Commodity commodity = new Commodity(id, name, amount, value, taxRate);

            return Optional.of(commodity);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Commodity> getAll(long receiptId) {
        List<Commodity> resultList = new ArrayList<Commodity>();
        String sql = "SELECT * FROM Commodities WHERE receiptId = " + receiptId;

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Long id = result.getLong("id");
                String name = result.getString("name");
                int amount = result.getInt("amount");
                Float value = result.getFloat("value");
                Float taxRate = result.getFloat("taxRate");

                Commodity commodity = new Commodity(id, name, amount, value, taxRate);
                resultList.add(commodity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public Optional<Commodity> save(long receiptId, Commodity commodity) {
        String sql = "INSERT INTO Commodities (id, receiptId, name, amount, value, taxRate) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, commodity.getId());
            statement.setLong(2, receiptId);
            statement.setString(3, commodity.getName());
            statement.setInt(4, commodity.getAmount());
            statement.setFloat(5, commodity.getValue());
            statement.setFloat(6, commodity.getTaxRate());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
               // System.out.println("A new commodity was inserted successfully!");
            }
            Receipt receipt = receiptDao.get(receiptId).get();
            ArrayList<Commodity> commodityList = receipt.getCommodityList();

            if(commodityList == null){
                ArrayList<Commodity> commodities = new ArrayList<>();
                commodities.add(commodity);
                receipt.setCommodityList(commodities);
            }else{
                receipt.getCommodityList().add(commodity);
                receipt.setCommodityList(commodityList);
            }

            receiptDao.update(receipt);
        }catch (SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(commodity);
    }

    @Override
    public Optional<Commodity> update(long receiptId, Commodity commodity) {
        String sql = "UPDATE Commodities SET name=?, amount=?, value=?, taxRate=? WHERE receiptId = ? AND id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, commodity.getName());
            statement.setInt(2, commodity.getAmount());
            statement.setFloat(3, commodity.getValue());
            statement.setFloat(4, commodity.getTaxRate());
            statement.setLong(5, receiptId);
            statement.setLong(6, commodity.getId());
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
               // System.out.println("An existing commodity "+ commodity.getId() + " was updated successfully!");
            }
            Receipt receipt = receiptDao.get(receiptId).get();

            if(receipt.getCommodityList() == null){
                ArrayList<Commodity> commodities = new ArrayList<>();
                commodities.add(commodity);
                receipt.setCommodityList(commodities);
            }else{
                ArrayList<Commodity> commodityList = (ArrayList<Commodity>) receipt.getCommodityList().stream()
                        .filter(commodity1 -> commodity1.getId() != commodity.getId()).collect(Collectors.toList());
                commodityList.add(commodity);
                receipt.setCommodityList(commodityList);
            }

            receiptDao.update(receipt);
        }catch (SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(commodity);
    }

    @Override
    public void delete(long receiptId, long id) {
        String sql = "DELETE FROM Commodities WHERE receiptId = ? AND id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, receiptId);
            statement.setLong(2, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
               // System.out.println("A commodity " + id + " was deleted successfully!");
            }
            Receipt receipt = receiptDao.get(receiptId).get();

            receiptDao.update(receipt);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
