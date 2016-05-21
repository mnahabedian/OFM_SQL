/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofm.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author joshua
 */
@Entity
@Table(schema = "ofm", name = "data_graphic")
@NamedQueries({
    @NamedQuery(name = "DataGraphic.findAll", query = "SELECT d FROM DataGraphic d"),
    @NamedQuery(name = "DataGraphic.findByDataGraphicId", query = "SELECT d FROM DataGraphic d WHERE d.dataGraphicId = :dataGraphicId"),
    @NamedQuery(name = "DataGraphic.findByPoint", query = "SELECT d FROM DataGraphic d WHERE d.point = :point")})
public class DataGraphic implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "data_graphic_id", nullable = false)
    private Long dataGraphicId;
    
    @Basic(optional = false)
    @Column(name = "point", nullable = false)
    private int point;
    
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false)
    @ManyToOne(optional = false)
    private Data data;

    public DataGraphic() {
    }

    public DataGraphic(Long dataGraphicId) {
        this.dataGraphicId = dataGraphicId;
    }

    public DataGraphic(Long dataGraphicId, int point) {
        this.dataGraphicId = dataGraphicId;
        this.point = point;
    }

    public DataGraphic(Data data, int point) {
        this.data = data;
        this.point = point;
    }

    public Long getDataGraphicId() {
        return dataGraphicId;
    }

    public void setDataGraphicId(Long dataGraphicId) {
        this.dataGraphicId = dataGraphicId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataGraphicId != null ? dataGraphicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataGraphic)) {
            return false;
        }
        DataGraphic other = (DataGraphic) object;
        if ((this.dataGraphicId == null && other.dataGraphicId != null) || (this.dataGraphicId != null && !this.dataGraphicId.equals(other.dataGraphicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofm.model.entities.DataGraphic[ dataGraphicId=" + dataGraphicId + " ]";
    }
    
}
