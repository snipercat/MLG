/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Company;
import entity.Rol;
import javax.persistence.EntityManager;

/**
 *
 * @author Joanna 8a
 */
public class RolDao {
    
       public void checkEntityManager(EntityManager entityManager) throws Exception{
            if(entityManager == null)
                throw new Exception("Entity Manager is null");
    }
    
    public void create(EntityManager entityManager, Company entity){
            entityManager.persist(entity);
    }
    
    public Rol update(EntityManager entityManager, Rol entity)throws Exception {
        checkEntityManager(entityManager);
        try {
            return entityManager.merge(entity);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
    
    public void delete(EntityManager entityManager, Rol entity) throws Exception {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }
            
    
    /**
     * Functions of RolDao
     */
    
   
    
   
      
    
}
