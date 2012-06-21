package dao;

import entity.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class DateDao {
    
    /*
     * Persist and Validation functions
     * TODO: Add this functions to a father class. and the validation of Entity Manager
     */
    public void checkEntityManager(EntityManager entityManager) throws Exception{
            if(entityManager == null)
                throw new Exception("Entity Manager is null");
    }
    
    public void create(EntityManager entityManager, Date entity){
            entityManager.persist(entity);
    }
    
    public Date update(EntityManager entityManager, Date entity)throws Exception {
        checkEntityManager(entityManager);
        try {
            return entityManager.merge(entity);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
    
    public void delete(EntityManager entityManager, Date entity) throws Exception {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }
            
    
    /**
     * Functions of DateDao
     */
    
    public Date getByDateId(EntityManager entityManager, Long Id) throws Exception{

        checkEntityManager(entityManager);
        try{
            return entityManager.createNamedQuery("getDateById", Date.class).setParameter("DateId", Id).getSingleResult();
        }
        catch(Exception e){
            throw new Exception(e.getMessage(),e.getCause());
        }
    }
    
    public List<Date> getAllDates(EntityManager entityManager) throws Exception{
        
        checkEntityManager(entityManager);
        try{
            return entityManager.createNamedQuery("getAllCompanies", Date.class).getResultList();
        }
        catch(Exception e){
            throw new Exception(e.getMessage(),e.getCause());
        }
        
    }   
}
