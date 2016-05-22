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
import java.util.List;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author joshua
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(schema = "ofm", name = "data", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"device_id"})})
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
    @NamedQuery(name = "Data.findByDataId", query = "SELECT d FROM Data d WHERE d.dataId = :dataId"),
    @NamedQuery(name = "Data.findBySampleFrequency", query = "SELECT d FROM Data d WHERE d.sampleFrequency = :sampleFrequency"),
    @NamedQuery(name = "Data.findByRangeOfTest", query = "SELECT d FROM Data d WHERE d.rangeOfTest = :rangeOfTest"),
    @NamedQuery(name = "Data.findByPulseWidth", query = "SELECT d FROM Data d WHERE d.pulseWidth = :pulseWidth"),
    @NamedQuery(name = "Data.findByWaveLength", query = "SELECT d FROM Data d WHERE d.waveLength = :waveLength"),
    @NamedQuery(name = "Data.findByTestTime", query = "SELECT d FROM Data d WHERE d.testTime = :testTime"),
    @NamedQuery(name = "Data.findByGroupRefractiveIndex", query = "SELECT d FROM Data d WHERE d.groupRefractiveIndex = :groupRefractiveIndex"),
    @NamedQuery(name = "Data.findByLinkLength", query = "SELECT d FROM Data d WHERE d.linkLength = :linkLength"),
    @NamedQuery(name = "Data.findByLinkLoss", query = "SELECT d FROM Data d WHERE d.linkLoss = :linkLoss"),
    @NamedQuery(name = "Data.findByLinkAttenuation", query = "SELECT d FROM Data d WHERE d.linkAttenuation = :linkAttenuation"),
    @NamedQuery(name = "Data.findByNonReflectingThreshold", query = "SELECT d FROM Data d WHERE d.nonReflectingThreshold = :nonReflectingThreshold"),
    @NamedQuery(name = "Data.findByEndThreshold", query = "SELECT d FROM Data d WHERE d.endThreshold = :endThreshold"),
    @NamedQuery(name = "Data.findByTestMode", query = "SELECT d FROM Data d WHERE d.testMode = :testMode"),
    @NamedQuery(name = "Data.findByTestWay", query = "SELECT d FROM Data d WHERE d.testWay = :testWay")})
public class Data implements Externalizable {

    private static final long serialVersionUID = 1L;
    
    public Data() {
    }

    public Data(Integer dataId) {
        this._dataId = dataId;
    }

    public Data(Integer dataId, Integer sampleFrequency, Integer rangeOfTest, Integer pulseWidth, Integer waveLength, Integer testTime, Float groupRefractiveIndex, Float linkLength, Float linkLoss, Float linkAttenuation, Float nonReflectingThreshold, Float endThreshold, Float testMode, Integer testWay) {
        this._dataId = dataId;
        this._sampleFrequency = sampleFrequency;
        this._rangeOfTest = rangeOfTest;
        this._pulseWidth = pulseWidth;
        this._waveLength = waveLength;
        this._testTime = testTime;
        this._groupRefractiveIndex = groupRefractiveIndex;
        this._linkLength = linkLength;
        this._linkLoss = linkLoss;
        this._linkAttenuation = linkAttenuation;
        this._nonReflectingThreshold = nonReflectingThreshold;
        this._endThreshold = endThreshold;
        this._testMode = testMode;
        this._testWay = testWay;
    }

    public Data(Integer sampleFrequency, Integer rangeOfTest, Integer pulseWidth, Integer waveLength, Integer testTime, Float groupRefractiveIndex, Float linkLength, Float linkLoss, Float linkAttenuation, Float nonReflectingThreshold, Float endThreshold, Float testMode, Integer testWay) {
        this._sampleFrequency = sampleFrequency;
        this._rangeOfTest = rangeOfTest;
        this._pulseWidth = pulseWidth;
        this._waveLength = waveLength;
        this._testTime = testTime;
        this._groupRefractiveIndex = groupRefractiveIndex;
        this._linkLength = linkLength;
        this._linkLoss = linkLoss;
        this._linkAttenuation = linkAttenuation;
        this._nonReflectingThreshold = nonReflectingThreshold;
        this._endThreshold = endThreshold;
        this._testMode = testMode;
        this._testWay = testWay;
    }

    private IntegerProperty dataId;
    private Integer _dataId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "data_id", nullable = false)
    public Integer getDataId() {
        if (dataId == null) {
            return _dataId;
        }
        else {
            return dataId.get();
        }        
    }

    public void setDataId(Integer dataId) {
        if (this.dataId == null) {
            this._dataId = dataId;
        }
        else {
            this.dataId.set(dataId);
        }        
    }

    public IntegerProperty dataIdProperty() {
        if (dataId == null) {
            dataId = new SimpleIntegerProperty(this, "dataId", _dataId);
        }
        return dataId;
    }

    private IntegerProperty sampleFrequency;
    private Integer _sampleFrequency;
    @Basic(optional = false)
    @Column(name = "sample_frequency", nullable = false)
    public Integer getSampleFrequency() {
        if (sampleFrequency == null) {
            return _sampleFrequency;
        }
        else {
            return sampleFrequency.get();
        }        
    }

    public void setSampleFrequency(Integer sampleFrequency) {
        if (this.sampleFrequency == null) {
            this._sampleFrequency = sampleFrequency;
        }
        else {
            this.sampleFrequency.set(sampleFrequency);
        }        
    }

    public IntegerProperty sampleFrequencyProperty() {
        if (sampleFrequency == null) {
            sampleFrequency = new SimpleIntegerProperty(this, "sampleFrequency", _sampleFrequency);
        }
        return sampleFrequency;
    }

    private IntegerProperty rangeOfTest;
    private Integer _rangeOfTest;
    @Basic(optional = false)
    @Column(name = "range_of_test", nullable = false)
    public Integer getRangeOfTest() {
        if (rangeOfTest == null) {
            return _rangeOfTest;
        }
        else {
            return rangeOfTest.get();
        }        
    }

    public void setRangeOfTest(Integer rangeOfTest) {
        if (this.rangeOfTest == null) {
            this._rangeOfTest = rangeOfTest;
        }
        else {
            this.rangeOfTest.set(rangeOfTest);
        }        
    }

    public IntegerProperty rangeOfTestProperty() {
        if (rangeOfTest == null) {
            rangeOfTest = new SimpleIntegerProperty(this, "rangeOfTest", _rangeOfTest);
        }
        return rangeOfTest;
    }

    private IntegerProperty pulseWidth;
    private Integer _pulseWidth;
    @Basic(optional = false)
    @Column(name = "pulse_width", nullable = false)
    public Integer getPulseWidth() {
        if (pulseWidth == null) {
            return _pulseWidth;
        }
        else {
            return pulseWidth.get();
        }        
    }

    public void setPulseWidth(Integer pulseWidth) {
        if (this.pulseWidth == null) {
            this._pulseWidth = pulseWidth;
        }
        else {
            this.pulseWidth.set(pulseWidth);
        }        
    }

    public IntegerProperty pulseWidthProperty() {
        if (pulseWidth == null) {
            pulseWidth = new SimpleIntegerProperty(this, "pulseWidth", _pulseWidth);
        }
        return pulseWidth;
    }

    private IntegerProperty waveLength;
    private Integer _waveLength;
    @Basic(optional = false)
    @Column(name = "wave_length", nullable = false)
    public Integer getWaveLength() {
        if (waveLength == null) {
            return _waveLength;
        }
        else {
            return waveLength.get();
        }        
    }

    public void setWaveLength(Integer waveLength) {
        if (this.waveLength == null) {
            this._waveLength = waveLength;
        }
        else {
            this.waveLength.set(waveLength);
        }        
    }

    public IntegerProperty waveLengthProperty() {
        if (waveLength == null) {
            waveLength = new SimpleIntegerProperty(this, "waveLength", _waveLength);
        }
        return waveLength;
    }

    private IntegerProperty testTime;
    private Integer _testTime;
    @Basic(optional = false)
    @Column(name = "test_time", nullable = false)
    public Integer getTestTime() {
        if (testTime == null) {
            return _testTime;
        }
        else {
            return testTime.get();
        }        
    }

    public void setTestTime(Integer testTime) {
        if (this.testTime == null) {
            this._testTime = testTime;
        }
        else {
            this.testTime.set(testTime);
        }        
    }

    public IntegerProperty testTimeProperty() {
        if (testTime == null) {
            testTime = new SimpleIntegerProperty(this, "testTime", _testTime);
        }
        return testTime;
    }

    private FloatProperty groupRefractiveIndex;
    private Float _groupRefractiveIndex;
    @Basic(optional = false)
    @Column(name = "group_refractive_index", nullable = false)
    public Float getGroupRefractiveIndex() {
        if (groupRefractiveIndex == null) {
            return _groupRefractiveIndex;
        }
        else {
            return groupRefractiveIndex.get();
        }        
    }

    public void setGroupRefractiveIndex(Float groupRefractiveIndex) {
        if (this.groupRefractiveIndex == null) {
            this._groupRefractiveIndex = groupRefractiveIndex;
        }
        else {
            this.groupRefractiveIndex.set(groupRefractiveIndex);
        }        
    }

    public FloatProperty groupRefractiveIndexProperty() {
        if (groupRefractiveIndex == null) {
            groupRefractiveIndex = new SimpleFloatProperty(this, "groupRefractiveIndex", _groupRefractiveIndex);
        }
        return groupRefractiveIndex;
    }

    private FloatProperty linkLength;
    private Float _linkLength;
    @Basic(optional = false)
    @Column(name = "link_length", nullable = false)
    public Float getLinkLength() {
        if (linkLength == null) {
            return _linkLength;
        }
        else {
            return linkLength.get();
        }        
    }

    public void setLinkLength(Float linkLength) {
        if (this.linkLength == null) {
            this._linkLength = linkLength;
        }
        else {
            this.linkLength.set(linkLength);
        }        
    }

    public FloatProperty linkLengthProperty() {
        if (linkLength == null) {
            linkLength = new SimpleFloatProperty(this, "linkLength", _linkLength);
        }
        return linkLength;
    }

    private FloatProperty linkLoss;
    private Float _linkLoss;
    @Basic(optional = false)
    @Column(name = "link_loss", nullable = false)
    public Float getLinkLoss() {
        if (linkLoss == null) {
            return _linkLoss;
        }
        else {
            return linkLoss.get();
        }        
    }

    public void setLinkLoss(Float linkLoss) {
        if (this.linkLoss == null) {
            this._linkLoss = linkLoss;
        }
        else {
            this.linkLoss.set(linkLoss);
        }        
    }

    public FloatProperty linkLossProperty() {
        if (linkLoss == null) {
            linkLoss = new SimpleFloatProperty(this, "linkLoss", _linkLoss);
        }
        return linkLoss;
    }

    private FloatProperty linkAttenuation;
    private Float _linkAttenuation;
    @Basic(optional = false)
    @Column(name = "link_attenuation", nullable = false)
    public Float getLinkAttenuation() {
        if (linkAttenuation == null) {
            return _linkAttenuation;
        }
        else {
            return linkAttenuation.get();
        }        
    }

    public void setLinkAttenuation(Float linkAttenuation) {
        if (this.linkAttenuation == null) {
            this._linkAttenuation = linkAttenuation;
        }
        else {
            this.linkAttenuation.set(linkAttenuation);
        }        
    }

    public FloatProperty linkAttenuationProperty() {
        if (linkAttenuation == null) {
            linkAttenuation = new SimpleFloatProperty(this, "linkAttenuation", _linkAttenuation);
        }
        return linkAttenuation;
    }

    private FloatProperty nonReflectingThreshold;
    private Float _nonReflectingThreshold;
    @Basic(optional = false)
    @Column(name = "non_reflecting_threshold", nullable = false)
    public Float getNonReflectingThreshold() {
        if (nonReflectingThreshold == null) {
            return _nonReflectingThreshold;
        }
        else {
            return nonReflectingThreshold.get();
        }        
    }

    public void setNonReflectingThreshold(Float nonReflectingThreshold) {
        if (this.nonReflectingThreshold == null) {
            this._nonReflectingThreshold = nonReflectingThreshold;
        }
        else {
            this.nonReflectingThreshold.set(nonReflectingThreshold);
        }        
    }

    public FloatProperty nonReflectingThresholdProperty() {
        if (nonReflectingThreshold == null) {
            nonReflectingThreshold = new SimpleFloatProperty(this, "nonReflectingThreshold", _nonReflectingThreshold);
        }
        return nonReflectingThreshold;
    }

    private FloatProperty endThreshold;
    private Float _endThreshold;
    @Basic(optional = false)
    @Column(name = "end_threshold", nullable = false)
    public Float getEndThreshold() {
        if (endThreshold == null) {
            return _endThreshold;
        }
        else {
            return endThreshold.get();
        }        
    }

    public void setEndThreshold(Float endThreshold) {
        if (this.endThreshold == null) {
            this._endThreshold = endThreshold;
        }
        else {
            this.endThreshold.set(endThreshold);
        }        
    }

    public FloatProperty endThresholdProperty() {
        if (endThreshold == null) {
            endThreshold = new SimpleFloatProperty(this, "endThreshold", _endThreshold);
        }
        return endThreshold;
    }

    private FloatProperty testMode;
    private Float _testMode;
    @Basic(optional = false)
    @Column(name = "test_mode", nullable = false)
    public Float getTestMode() {
        if (testMode == null) {
            return _testMode;
        }
        else {
            return testMode.get();
        }        
    }

    public void setTestMode(Float testMode) {
        if (this.testMode == null) {
            this._testMode = testMode;
        }
        else {
            this.testMode.set(testMode);
        }        
    }

    public FloatProperty testModeProperty() {
        if (testMode == null) {
            testMode = new SimpleFloatProperty(this, "testMode", _testMode);
        }
        return testMode;
    }

    private IntegerProperty testWay;
    private Integer _testWay;
    @Basic(optional = false)
    @Column(name = "test_way", nullable = false)
    public Integer getTestWay() {
        if (testWay == null) {
            return _testWay;
        }
        else {
            return testWay.get();
        }        
    }

    public void setTestWay(Integer testWay) {
        if (this.testWay == null) {
            this._testWay = testWay;
        }
        else {
            this.testWay.set(testWay);
        }        
    }

    public IntegerProperty testWayProperty() {
        if (testWay == null) {
            testWay = new SimpleIntegerProperty(this, "testWay", _testWay);
        }
        return testWay;
    }

    private ListProperty<DataEvent> dataEventList;
    private List<DataEvent> _dataEventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    public List<DataEvent> getDataEventList() {
        if (dataEventList == null) {
            return _dataEventList;
        }
        else {
            return dataEventList.get();
        }        
    }

    public void setDataEventList(List<DataEvent> dataEventList) {
        if (this.dataEventList == null) {
            this._dataEventList = dataEventList;
        }
        else {
            this.dataEventList.set(FXCollections.observableArrayList(dataEventList));
        }        
    }

    public ListProperty<DataEvent> dataEventListProperty() {
        if (dataEventList == null) {
            dataEventList = new SimpleListProperty<>(this, "dataEventList", FXCollections.observableArrayList(_dataEventList));
        }
        return dataEventList;
    }

    private ObjectProperty<Device> device;
    private Device _device;
    @JoinColumn(name = "device_id", referencedColumnName = "device_id", nullable = false)
    @OneToOne(optional = false)
    public Device getDevice() {
        if (device == null) {
            return _device;
        }
        else {
            return device.get();
        }
    }

    public void setDevice(Device device) {
        if (this.device == null) {
            this._device = device;
        }
        else {
            this.device.set(device);
        }
    }

    public ObjectProperty<Device> deviceProperty() {
        if (device == null) {
            device = new SimpleObjectProperty<>(this, "device", _device);
        }
        return device;
    }

    private ListProperty<DataGraphic> dataGraphicList;
    private List<DataGraphic> _dataGraphicList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "data")
    public List<DataGraphic> getDataGraphicList() {
        if (dataGraphicList == null) {
            return _dataGraphicList;
        }
        else {
            return dataGraphicList.get();
        }        
    }

    public void setDataGraphicList(List<DataGraphic> dataGraphicList) {
        if (this.dataGraphicList == null) {
            this._dataGraphicList = dataGraphicList;
        }
        else {
            this.dataGraphicList.set(FXCollections.observableArrayList(dataGraphicList));
        }        
    }

    public ListProperty<DataGraphic> dataGraphicListProperty() {
        if (dataGraphicList == null) {
            dataGraphicList = new SimpleListProperty<>(this, "dataGraphicList", FXCollections.observableArrayList(_dataGraphicList));
        }
        return dataGraphicList;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (_dataId != null ? _dataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this._dataId == null && other._dataId != null) || (this._dataId != null && !this._dataId.equals(other._dataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofm.model.entities.Data[ dataId=" + _dataId + " - device=" + _device.toString() + " ]";
    }
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getDataId());
        out.writeObject(getSampleFrequency());
        out.writeObject(getRangeOfTest());
        out.writeObject(getPulseWidth());
        out.writeObject(getWaveLength());
        out.writeObject(getTestTime());
        out.writeObject(getGroupRefractiveIndex());
        out.writeObject(getLinkLength());
        out.writeObject(getLinkLoss());
        out.writeObject(getLinkAttenuation());
        out.writeObject(getNonReflectingThreshold());
        out.writeObject(getEndThreshold());
        out.writeObject(getTestMode());
        out.writeObject(getTestWay());
        out.writeObject(getDataEventList());
        out.writeObject(getDevice());
        out.writeObject(getDataGraphicList());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setDataId((Integer)in.readObject());
        setSampleFrequency((Integer)in.readObject());
        setRangeOfTest((Integer)in.readObject());
        setPulseWidth((Integer)in.readObject());
        setWaveLength((Integer)in.readObject());
        setTestTime((Integer)in.readObject());
        setGroupRefractiveIndex((Float)in.readObject());
        setLinkLength((Float)in.readObject());
        setLinkLoss((Float)in.readObject());
        setLinkAttenuation((Float)in.readObject());
        setNonReflectingThreshold((Float)in.readObject());
        setEndThreshold((Float)in.readObject());
        setTestMode((Float)in.readObject());
        setTestWay((Integer)in.readObject());
        setDataEventList((List<DataEvent>)in.readObject());
        setDevice((Device)in.readObject());
        setDataGraphicList((List<DataGraphic>)in.readObject());
    }
    
}
