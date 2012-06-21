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
@Entity
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String symbol;
    private String description;
    @ManyToOne
    private Company comp;
    @OneToMany(mappedBy = "stock",cascade = CascadeType.ALL)
    private List<Quote> quote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    @Override
    public String toString() {
        return "entity.Stock[ id=" + id + " ]";
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
     * @return the comp
     */
    public Company getComp() {
        return comp;
    }

    /**
     * @param comp the comp to set
     */
    public void setComp(Company comp) {
        this.comp = comp;
    }

    /**
     * @return the quote
     */
    public List<Quote> getQuote() {
        return quote;
    }

    /**
     * @param quote the quote to set
     */
    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }
    
}
