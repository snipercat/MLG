package dao;

import entity.Company;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class Companydao {
    
    public Company getByCompanyId(EntityManager entityManager, Long Id){
        //TODO: Change this validation by a Try Catch Block throwing a DtaBase Exception
        if (entityManager != null)
            return entityManager.createNamedQuery("getCompanyById", Company.class).setParameter("companyId", Id).getSingleResult();
        return null;
    }
    
    public List<Company> getAllCompanies(EntityManager entityManager){
        return entityManager.createNamedQuery("getAllCompanies", Company.class).getResultList();
    }
    
    public List<Company> getCompaniesByMarketId(EntityManager entityManager, Long MarketId){
        return entityManager.createNamedQuery("getAllCompanies", Company.class).setParameter("MarketId", MarketId).getResultList();
    }
        
}
