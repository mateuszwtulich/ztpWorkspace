package com.company.model.dao;

import com.company.model.DbConfig;
import com.company.model.ISalesModel;
import com.company.model.SalesModel;
import com.company.model.entity.Commodity;
import com.company.model.entity.Receipt;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReceiptDaoDb implements Dao<Receipt> {
    private Connection connection;

    public ReceiptDaoDb(){
        this.connection = DbConfig.getConn();
    }

    @Override
    public Optional<Receipt> get(long id) {
        String sql = "SELECT * FROM Receipts WHERE id = " + id;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            Timestamp dateTime = resultSet.getTimestamp("dateTime");
            String taxpayerName = resultSet.getString("taxpayerName");
            String address = resultSet.getString("address");
            String taxpayerID = resultSet.getString("taxpayerID");
            Float commoditiesSum = resultSet.getFloat("commoditiesSum");
            Float taxSum = resultSet.getFloat("taxSum");

            Receipt receipt = new Receipt(id, dateTime.toLocalDateTime(), taxpayerName, address, taxpayerID, commoditiesSum, taxSum);

            return Optional.of(receipt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Receipt> getAll() {
        List<Receipt> resultList = new ArrayList<Receipt>();
        String sql = "SELECT * FROM Receipts";

        try {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            Long id = result.getLong("id");
            Timestamp dateTime = result.getTimestamp("dateTime");
            String taxpayerName = result.getString("taxpayerName");
            String address = result.getString("address");
            String taxpayerID = result.getString("taxpayerID");
            Float commoditiesSum = result.getFloat("commoditiesSum");
            Float taxSum = result.getFloat("taxSum");

            Receipt receipt = new Receipt(id, dateTime.toLocalDateTime(), taxpayerName, address, taxpayerID, commoditiesSum, taxSum);
            resultList.add(receipt);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public Optional<Receipt> save(Receipt receipt) {
        String sql = "INSERT INTO Receipts (id, dateTime, taxpayerName, address, taxpayerID," +
                "commoditiesSum, taxSum) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, receipt.getId());
            statement.setString(2, receipt.getDateTime().toString());
            statement.setString(3, receipt.getTaxpayerName());
            statement.setString(4, receipt.getAddress());
            statement.setString(5, receipt.getTaxpayerID());
            statement.setFloat(6, receipt.getCommoditiesSum());
            statement.setFloat(7, receipt.getTaxSum());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                //System.out.println("A new receipt was inserted successfully!");
            }

        }catch (SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(receipt);
    }

    @Override
    public Optional<Receipt> update(Receipt receipt) {
        String sql = "UPDATE Receipts SET taxpayerName=?, address=?, taxpayerId=?, commoditiesSum=?," +
                "taxSum=? WHERE id=?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, receipt.getTaxpayerName());
            statement.setString(2, receipt.getAddress());
            statement.setString(3, receipt.getTaxpayerID());
            statement.setFloat(4, receipt.getCommoditiesSum());
            statement.setFloat(5, receipt.getTaxSum());
            statement.setLong(6, receipt.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                //System.out.println("An existing receipt "+ receipt.getId() + " was updated successfully!");
            }
        }catch (SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(receipt);
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM Receipts WHERE id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                //System.out.println("A receipt " + id + " was deleted successfully!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
