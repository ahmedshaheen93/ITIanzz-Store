/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.config.ConnectionToDB;
import eg.gov.iti.jets.repository.Crud;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author lts
 */
public abstract class CrudImpl<T> implements Crud<T> {

    private final EntityManager entityManager = ConnectionToDB.getInstance().getEntityManager();

    private final String typeName = getTypeName();

    @Override
    public List<T> findAll() {
        List<T> resultList = entityManager.createQuery("from " + typeName).getResultList();
        return resultList;
    }

    @Override
    public T findById(Long id) {
        try {
            return (T) entityManager.find(Class.forName(typeName), id);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T save(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public void delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }

    private String getTypeName() {
        try {
            Type sooper = getClass().getGenericSuperclass();
            Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
            return t.getTypeName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
