/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.*;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public interface DAOInterface<T> {
    public void insert(T t);
    
    public void update(T t);
    
    public void delete(T t);
    
    public ArrayList<T> selectAll();
    
    public T selectById(String t);
    
    public ArrayList<T> selectByCondition(String condition);
}
