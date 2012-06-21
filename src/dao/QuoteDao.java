package dao;

import entity.Quote;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class QuoteDao {
    
    /*
     * Persist and Validation functions
     * TODO: Add this functions to a father class. and the validation of Entity Manager
     */
    public void checkEntityManager(EntityManager entityManager) throws Exception{
            if(entityManager == null)
                throw new Exception("Entity Manager is null");
    }
    
    public void create(EntityManager entityManager, Quote entity){
            entityManager.persist(entity);
    }
    
    public Quote update(EntityManager entityManager, Quote entity)throws Exception {
        checkEntityManager(entityManager);
        try {
            return entityManager.merge(entity);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
    
    public void delete(EntityManager entityManager, Quote entity) throws Exception {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }
            
    
    /**
     * Functions of QuoteDao
     */
    
    public Quote getByQuoteId(EntityManager entityManager, Long Id) throws Exception{

        checkEntityManager(entityManager);
        try{
            return entityManager.createNamedQuery("getQuoteById", Quote.class).setParameter("QuoteId", Id).getSingleResult();
        }
        catch(Exception e){
            throw new Exception(e.getMessage(),e.getCause());
        }
    }
    
    public List<Quote> getAllQuotes(EntityManager entityManager) throws Exception{
        checkEntityManager(entityManager);
        try{
            return entityManager.createNamedQuery("getAllCompanies", Quote.class).getResultList();
        }
        catch(Exception e){
            throw new Exception(e.getMessage(),e.getCause());
        }
        
    }
    
    public List<Quote> getAllQuotes(EntityManager entityManager){
        return entityManager.createNamedQuery("getAllCompanies", Quote.class).getResultList();
    }
}
