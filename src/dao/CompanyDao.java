package dao;

import entity.Company;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class CompanyDao {
    
    /*
     * Persist and Validation functions
     * TODO: Add this functions to a father class. and the validation of Entity Manager
     */
    public void checkEntityManager(EntityManager entityManager) throws Exception{
            if(entityManager == null)
                throw new Exception("Entity Manager is null");
    }
    
    public void create(EntityManager entityManager, Company entity){
            entityManager.persist(entity);
    }
    
    public Company update(EntityManager entityManager, Company entity)throws Exception {
        checkEntityManager(entityManager);
        try {
            return entityManager.merge(entity);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
    
    public void delete(EntityManager entityManager, Company entity) throws Exception {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e.getCause());
        }
    }
            
    
    /**
     * Functions of CompanyDao
     */
    
    public Company getByCompanyId(EntityManager entityManager, Long Id) throws Exception{

        checkEntityManager(entityManager);
        try{
            return entityManager.createNamedQuery("getCompanyById", Company.class).setParameter("companyId", Id).getSingleResult();
        }
        catch(Exception e){
            throw new Exception(e.getMessage(),e.getCause());
        }
    }
    
    public List<Company> getAllCompanies(EntityManager entityManager){
        return entityManager.createNamedQuery("getAllCompanies", Company.class).getResultList();
    }
    
    public List<Company> getCompaniesByMarketId(EntityManager entityManager, Long MarketId){
        return entityManager.createNamedQuery("getAllCompanies", Company.class).setParameter("MarketId", MarketId).getResultList();
    }
        
}
