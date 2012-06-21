/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Joanna 8a
 */
@javax.persistence.Entity(name = "Market")
@NamedQueries({
    @NamedQuery(name = "getMarketById",
    query = "SELECT c FROM Market c WHERE c.id = :MarketId"),
    @NamedQuery(name = "getAllMarkets",
    query = "SELECT c FROM Date c")
})
public class Market implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nemo;
    private String description;
    @OneToMany(mappedBy = "calendar",cascade = CascadeType.ALL)
    private List<Company> companies;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

 

    @Override
    public String toString() {
        return "entity.Market[ id=" + id + " ]";
    }

    /**
     * @return the nemo
     */
    public String getNemo() {
        return nemo;
    }

    /**
     * @param nemo the nemo to set
     */
    public void setNemo(String nemo) {
        this.nemo = nemo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the companies
     */
    public List<Company> getCompanies() {
        return companies;
    }

    /**
     * @param companies the companies to set
     */
    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
    
}
