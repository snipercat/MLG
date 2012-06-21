package dao;

import entity.Market;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class MarketDao {
    
    /*
     * Persist and Validation functions
     * TODO: Add this functions to a father class. and the validation of Entity Manager
     */
    public void checkEntityManager(EntityManager entityManager) throws Exception{
            if(entityManager == null)
                throw new Exception("Entity Manager is null");
    }
    
    public void create(EntityManager entityManager, Market entity){
            entityManager.persist(entity);
    }
    
    public Market update(EntityManager entityManager, Market entity)throws Exception {
        checkEntityManager(entityManager);
        try {
            return entityManager.merge(entity);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
    
    public void delete(EntityManager entityManager, Market entity) throws Exception {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }
            
    
    /**
     * Functions of MarketDao
     */
    
    public Market getByMarketId(EntityManager entityManager, Long Id) throws Exception{

        checkEntityManager(entityManager);
        try{
            return entityManager.createNamedQuery("getMarketById", Market.class).setParameter("MarketId", Id).getSingleResult();
        }
        catch(Exception e){
            throw new Exception(e.getMessage(),e.getCause());
        }
    }
    
    public List<Market> getAllMarkets(EntityManager entityManager) throws Exception{
        
        checkEntityManager(entityManager);
        try{
            return entityManager.createNamedQuery("getAllCompanies", Market.class).getResultList();
        }
        catch(Exception e){
            throw new Exception(e.getMessage(),e.getCause());
        }   
    }   
}
