/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofm.model.entities;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.persistence.Access;
import javax.persistence.AccessType;
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
@Access(AccessType.PROPERTY)
@Table(schema = "ofm", name = "data_event")
@NamedQueries({
    @NamedQuery(name = "DataEvent.findAll", query = "SELECT d FROM DataEvent d"),
    @NamedQuery(name = "DataEvent.findByDataEventId", query = "SELECT d FROM DataEvent d WHERE d.dataEventId = :dataEventId"),
    @NamedQuery(name = "DataEvent.findByDistance", query = "SELECT d FROM DataEvent d WHERE d.distance = :distance"),
    @NamedQuery(name = "DataEvent.findByType", query = "SELECT d FROM DataEvent d WHERE d.type = :type"),
    @NamedQuery(name = "DataEvent.findByEchoLoss", query = "SELECT d FROM DataEvent d WHERE d.echoLoss = :echoLoss"),
    @NamedQuery(name = "DataEvent.findByInsertionLoss", query = "SELECT d FROM DataEvent d WHERE d.insertionLoss = :insertionLoss"),
    @NamedQuery(name = "DataEvent.findByAverageAttenuationCoefficient", query = "SELECT d FROM DataEvent d WHERE d.averageAttenuationCoefficient = :averageAttenuationCoefficient"),
    @NamedQuery(name = "DataEvent.findByAcumulativeLoss", query = "SELECT d FROM DataEvent d WHERE d.acumulativeLoss = :acumulativeLoss")})
public class DataEvent implements Externalizable {

    private static final long serialVersionUID = 1L;

    public DataEvent() {
    }

    public DataEvent(Integer dataEventId) {
        this._dataEventId = dataEventId;
    }

    public DataEvent(Integer dataEventId, Float distance, Integer type, Float echoLoss, Float insertionLoss, Float averageAttenuationCoefficient, Float acumulativeLoss) {
        this._dataEventId = dataEventId;
        this._distance = distance;
        this._type = type;
        this._echoLoss = echoLoss;
        this._insertionLoss = insertionLoss;
        this._averageAttenuationCoefficient = averageAttenuationCoefficient;
        this._acumulativeLoss = acumulativeLoss;
    }

    public DataEvent(Float distance, Integer type, Float echoLoss, Float insertionLoss, Float averageAttenuationCoefficient, Float acumulativeLoss) {
        this._distance = distance;
        this._type = type;
        this._echoLoss = echoLoss;
        this._insertionLoss = insertionLoss;
        this._averageAttenuationCoefficient = averageAttenuationCoefficient;
        this._acumulativeLoss = acumulativeLoss;
    }

    private IntegerProperty dataEventId;
    private Integer _dataEventId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "data_event_id", nullable = false)
    public Integer getDataEventId() {
        if (dataEventId == null) {
            return _dataEventId;
        }
        else {
            return dataEventId.get();
        }        
    }

    public void setDataEventId(Integer dataEventId) {
        if (this.dataEventId == null) {
            this._dataEventId = dataEventId;
        }
        else {
            this.dataEventId.set(dataEventId);
        }        
    }

    public IntegerProperty dataEventIdProperty() {
        if (dataEventId == null) {
            dataEventId = new SimpleIntegerProperty(this, "dataEventId", _dataEventId);
        }
        return dataEventId;
    }

    private FloatProperty distance;
    private Float _distance;
    @Basic(optional = false)
    @Column(name = "distance", nullable = false)
    public Float getDistance() {
        if (distance == null) {
            return _distance;
        }
        else {
            return distance.get();
        }        
    }

    public void setDistance(Float distance) {
        if (this.distance == null) {
            this._distance = distance;
        }
        else {
            this.distance.set(distance);
        }        
    }

    public FloatProperty distanceProperty() {
        if (distance == null) {
            distance = new SimpleFloatProperty(this, "distance", _distance);
        }
        return distance;
    }

    private IntegerProperty type;
    private Integer _type;
    @Basic(optional = false)
    @Column(name = "type", nullable = false)
    public Integer getType() {
        if (type == null) {
            return _type;
        }
        else {
            return type.get();
        }        
    }

    public void setType(Integer type) {
        if (this.type == null) {
            this._type = type;
        }
        else {
            this.type.set(type);
        }        
    }

    public IntegerProperty typeProperty() {
        if (type == null) {
            type = new SimpleIntegerProperty(this, "type", _type);
        }
        return type;
    }

    private FloatProperty echoLoss;
    private Float _echoLoss;
    @Basic(optional = false)
    @Column(name = "echo_loss", nullable = false)
    public Float getEchoLoss() {
        if (echoLoss == null) {
            return _echoLoss;
        }
        else {
            return echoLoss.get();
        }        
    }

    public void setEchoLoss(Float echoLoss) {
        if (this.echoLoss == null) {
            this._echoLoss = echoLoss;
        }
        else {
            this.echoLoss.set(echoLoss);
        }        
    }

    public FloatProperty Property() {
        if (echoLoss == null) {
            echoLoss = new SimpleFloatProperty(this, "echoLoss", _echoLoss);
        }
        return echoLoss;
    }

    private FloatProperty insertionLoss;
    private Float _insertionLoss;
    @Basic(optional = false)
    @Column(name = "insertion_loss", nullable = false)
    public Float getInsertionLoss() {
        if (insertionLoss == null) {
            return _insertionLoss;
        }
        else {
            return insertionLoss.get();
        }        
    }

    public void setInsertionLoss(Float insertionLoss) {
        if (this.insertionLoss == null) {
            this._insertionLoss = insertionLoss;
        }
        else {
            this.insertionLoss.set(insertionLoss);
        }        
    }

    public FloatProperty insertionLossProperty() {
        if (insertionLoss == null) {
            insertionLoss = new SimpleFloatProperty(this, "insertionLoss", _insertionLoss);
        }
        return insertionLoss;
    }

    private FloatProperty averageAttenuationCoefficient;
    private Float _averageAttenuationCoefficient;
    @Basic(optional = false)
    @Column(name = "average_attenuation_coefficient", nullable = false)
    public Float getAverageAttenuationCoefficient() {
        if (averageAttenuationCoefficient == null) {
            return _averageAttenuationCoefficient;
        }
        else {
            return averageAttenuationCoefficient.get();
        }        
    }

    public void setAverageAttenuationCoefficient(Float averageAttenuationCoefficient) {
        if (this.averageAttenuationCoefficient == null) {
            this._averageAttenuationCoefficient = averageAttenuationCoefficient;
        }
        else {
            this.averageAttenuationCoefficient.set(averageAttenuationCoefficient);
        }        
    }

    public FloatProperty averageAttenuationCoefficientProperty() {
        if (averageAttenuationCoefficient == null) {
            averageAttenuationCoefficient = new SimpleFloatProperty(this, "averageAttenuationCoefficient", _averageAttenuationCoefficient);
        }
        return averageAttenuationCoefficient;
    }

    private FloatProperty acumulativeLoss;
    private Float _acumulativeLoss;
    @Basic(optional = false)
    @Column(name = "acumulative_loss", nullable = false)
    public Float getAcumulativeLoss() {
        if (acumulativeLoss == null) {
            return _acumulativeLoss;
        }
        else {
            return acumulativeLoss.get();
        }        
    }

    public void setAcumulativeLoss(Float acumulativeLoss) {
        if (this.acumulativeLoss == null) {
            this._acumulativeLoss = acumulativeLoss;
        }
        else {
            this.acumulativeLoss.set(acumulativeLoss);
        }        
    }

    public FloatProperty acumulativeLossProperty() {
        if (acumulativeLoss == null) {
            acumulativeLoss = new SimpleFloatProperty(this, "acumulativeLoss", _acumulativeLoss);
        }
        return acumulativeLoss;
    }

    private ObjectProperty<Data> data;
    private Data _data;
    @JoinColumn(name = "data_id", referencedColumnName = "data_id", nullable = false)
    @ManyToOne(optional = false)
    public Data getData() {
        if (data == null) {
            return _data;
        }
        else {
            return data.get();
        }        
    }

    public void setData(Data data) {
        if (this.data == null) {
            this._data = data;
        }
        else {
            this.data.set(data);
        }        
    }

    public ObjectProperty<Data> dataProperty() {
        if (data == null) {
            data = new SimpleObjectProperty<>(this, "data", _data);
        }
        return data;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (_dataEventId != null ? _dataEventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataEvent)) {
            return false;
        }
        DataEvent other = (DataEvent) object;
        if ((this._dataEventId == null && other._dataEventId != null) || (this._dataEventId != null && !this._dataEventId.equals(other._dataEventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofm.model.entities.DataEvent[ dataEventId=" + _dataEventId + " - data=" + _data.toString() + " ]";
    }
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getDataEventId());
        out.writeObject(getDistance());
        out.writeObject(getType());
        out.writeObject(getEchoLoss());
        out.writeObject(getInsertionLoss());
        out.writeObject(getAverageAttenuationCoefficient());
        out.writeObject(getAcumulativeLoss());
        out.writeObject(getData());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setDataEventId((Integer)in.readObject());
        setDistance((Float)in.readObject());
        setType((Integer)in.readObject());
        setEchoLoss((Float)in.readObject());
        setInsertionLoss((Float)in.readObject());
        setAverageAttenuationCoefficient((Float)in.readObject());
        setAcumulativeLoss((Float)in.readObject());
        setData((Data)in.readObject());
    }
    
}
