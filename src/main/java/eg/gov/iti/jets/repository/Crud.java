/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.gov.iti.jets.repository;

import java.util.List;

/**
 * @param <T> as Entity class
 * @author lts
 */
public interface Crud<T> {

    List<T> findAll();

    T findById(Long id);

    T save(T t);

    void delete(T t);
}
