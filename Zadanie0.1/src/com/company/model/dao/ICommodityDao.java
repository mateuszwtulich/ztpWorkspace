package com.company.model.dao;

import java.util.List;
import java.util.Optional;

public interface ICommodityDao<Commodity> {

    Optional<Commodity> get(long receiptId, long id);
    List<Commodity> getAll(long receiptId);
    Optional<Commodity> save(long receiptId, Commodity commodity) ;
    Optional<Commodity> update(long receiptId, Commodity commodity);
    void delete(long receiptId, long id);
}
