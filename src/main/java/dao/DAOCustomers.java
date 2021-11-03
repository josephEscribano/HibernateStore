/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Customer;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

/**
 *
 */
public interface DAOCustomers {
     
    Customer get(int id);
     
    List<Customer> getAll() ;
     
    boolean save(Customer t);
     
    boolean update(Customer t);
     
    boolean delete(Customer t);

    Customer findCustomerByID(int id);
}
