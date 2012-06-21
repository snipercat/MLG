/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
public class Quote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double low;
    private Double high;
    private Double openprice;
    private Double closeprice;
    private Double volume;
    @ManyToOne
    private Date date;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quote)) {
            return false;
        }
        Quote other = (Quote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Quote[ id=" + id + " ]";
    }

    /**
     * @return the low
     */
    public Double getLow() {
        return low;
    }

    /**
     * @param low the low to set
     */
    public void setLow(Double low) {
        this.low = low;
    }

    /**
     * @return the high
     */
    public Double getHigh() {
        return high;
    }

    /**
     * @param high the high to set
     */
    public void setHigh(Double high) {
        this.high = high;
    }

    /**
     * @return the openprice
     */
    public Double getOpenprice() {
        return openprice;
    }

    /**
     * @param openprice the openprice to set
     */
    public void setOpenprice(Double openprice) {
        this.openprice = openprice;
    }

    /**
     * @return the closeprice
     */
    public Double getCloseprice() {
        return closeprice;
    }

    /**
     * @param closeprice the closeprice to set
     */
    public void setCloseprice(Double closeprice) {
        this.closeprice = closeprice;
    }

    /**
     * @return the volume
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    
    
}
