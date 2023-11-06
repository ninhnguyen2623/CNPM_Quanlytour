/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */ 
package DAO;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DAO<T> {
    
    public ArrayList<T> getAll ();
    public T getById (int id);
    public boolean add(T t) ;
    public boolean update(T t);
    public boolean delete (int id);
    public boolean checkExistById (int id);
}
