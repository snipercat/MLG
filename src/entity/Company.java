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
@javax.persistence.Entity(name = "Company")
@NamedQueries({
    @NamedQuery(name = "getCompanyById",
    query = "SELECT c FROM Company c WHERE c.id = :companyId"),
    @NamedQuery(name = "getAllCompanies",
    query = "SELECT c FROM Company c"),
    @NamedQuery(name = "getCompanyByMarketId",
    query = "SELECT c FROM Company c WHERE c.mrkt = :MarketId")
})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String symbol;
    private String description;
    @ManyToOne
    private Market mrkt;
    @OneToMany(mappedBy = "calendar",cascade = CascadeType.ALL)
    private List<Stock> stocks;
    
    

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    @Override
    public String toString() {
        return "entity.Company[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
     * @return the mrkt
     */
    public Market getMrkt() {
        return mrkt;
    }

    /**
     * @param mrkt the mrkt to set
     */
    public void setMrkt(Market mrkt) {
        this.mrkt = mrkt;
    }

    /**
     * @return the stocks
     */
    public List<Stock> getStocks() {
        return stocks;
    }

    /**
     * @param stocks the stocks to set
     */
    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
    
}
