/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Customer;
import model.Purchase;
import model.Review;

import java.sql.Date;
import java.util.List;

/**
 *
 */
public interface DAOPurchases {

    Purchase get(int id);

    List<Purchase> getPurchasesByItemId(int id);

    List<Purchase> getPurchasesByReviewId(int id);
     
    List<Purchase> getAll();
     
    boolean save(Purchase t);
     
    boolean update(Purchase t);

    List<Purchase> searchCustomerByid(int id );
    boolean delete(Purchase t);

    List<Purchase> findPurchaseByDate(java.util.Date date);
}
