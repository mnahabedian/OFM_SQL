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
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author joshua
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(schema = "ofm", name = "parameter", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"device_id"})})
@NamedQueries({
    @NamedQuery(name = "Parameter.findAll", query = "SELECT p FROM Parameter p"),
    @NamedQuery(name = "Parameter.findByParameterId", query = "SELECT p FROM Parameter p WHERE p.parameterId = :parameterId"),
    @NamedQuery(name = "Parameter.findByMeasuringRangeOfTest", query = "SELECT p FROM Parameter p WHERE p.measuringRangeOfTest = :measuringRangeOfTest"),
    @NamedQuery(name = "Parameter.findByTestPulseWidth", query = "SELECT p FROM Parameter p WHERE p.testPulseWidth = :testPulseWidth"),
    @NamedQuery(name = "Parameter.findByMeasuringTime", query = "SELECT p FROM Parameter p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "Parameter.findByTestWaveLength", query = "SELECT p FROM Parameter p WHERE p.testWaveLength = :testWaveLength"),
    @NamedQuery(name = "Parameter.findByMeasureMode", query = "SELECT p FROM Parameter p WHERE p.measureMode = :measureMode"),
    @NamedQuery(name = "Parameter.findByRefractiveIndex", query = "SELECT p FROM Parameter p WHERE p.refractiveIndex = :refractiveIndex"),
    @NamedQuery(name = "Parameter.findByNonReflactionThreshold", query = "SELECT p FROM Parameter p WHERE p.nonReflactionThreshold = :nonReflactionThreshold"),
    @NamedQuery(name = "Parameter.findByEndThreshold", query = "SELECT p FROM Parameter p WHERE p.endThreshold = :endThreshold"),
    @NamedQuery(name = "Parameter.findByReflectionThreshold", query = "SELECT p FROM Parameter p WHERE p.reflectionThreshold = :reflectionThreshold"),
    @NamedQuery(name = "Parameter.findByOptimizeMode", query = "SELECT p FROM Parameter p WHERE p.optimizeMode = :optimizeMode"),
    @NamedQuery(name = "Parameter.findByEnabledRefresh", query = "SELECT p FROM Parameter p WHERE p.enabledRefresh = :enabledRefresh"),
    @NamedQuery(name = "Parameter.findByRefreshCycle", query = "SELECT p FROM Parameter p WHERE p.refreshCycle = :refreshCycle"),
    @NamedQuery(name = "Parameter.findByCycleTime", query = "SELECT p FROM Parameter p WHERE p.cycleTime = :cycleTime"),
    @NamedQuery(name = "Parameter.findByCreateTime", query = "SELECT p FROM Parameter p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "Parameter.findByUpdateTime", query = "SELECT p FROM Parameter p WHERE p.updateTime = :updateTime")})
public class Parameter implements Externalizable {

    private static final long serialVersionUID = 1L;
    
    public Parameter() {
    }

    public Parameter(Integer parameterId) {
        this._parameterId = parameterId;
    }

    public Parameter(Integer parameterId, Integer measuringRangeOfTest, Integer testPulseWidth, Integer measuringTime, Integer testWaveLength, Integer measureMode, Float refractiveIndex, Float nonReflactionThreshold, Float endThreshold, Float reflectionThreshold, Integer optimizeMode, Integer enabledRefresh, Integer refreshCycle, Integer cycleTime, Date createTime) {
        this._parameterId = parameterId;
        this._measuringRangeOfTest = measuringRangeOfTest;
        this._testPulseWidth = testPulseWidth;
        this._measuringTime = measuringTime;
        this._testWaveLength = testWaveLength;
        this._measureMode = measureMode;
        this._refractiveIndex = refractiveIndex;
        this._nonReflactionThreshold = nonReflactionThreshold;
        this._endThreshold = endThreshold;
        this._reflectionThreshold = reflectionThreshold;
        this._optimizeMode = optimizeMode;
        this._enabledRefresh = enabledRefresh;
        this._refreshCycle = refreshCycle;
        this._cycleTime = cycleTime;
        this._createTime = createTime;
    }

    public Parameter(Integer measuringRangeOfTest, Integer testPulseWidth, Integer measuringTime, Integer testWaveLength, Integer measureMode, Float refractiveIndex, Float nonReflactionThreshold, Float endThreshold, Float reflectionThreshold, Integer optimizeMode, Integer enabledRefresh, Integer refreshCycle, Integer cycleTime, Date createTime) {
        this._measuringRangeOfTest = measuringRangeOfTest;
        this._testPulseWidth = testPulseWidth;
        this._measuringTime = measuringTime;
        this._testWaveLength = testWaveLength;
        this._measureMode = measureMode;
        this._refractiveIndex = refractiveIndex;
        this._nonReflactionThreshold = nonReflactionThreshold;
        this._endThreshold = endThreshold;
        this._reflectionThreshold = reflectionThreshold;
        this._optimizeMode = optimizeMode;
        this._enabledRefresh = enabledRefresh;
        this._refreshCycle = refreshCycle;
        this._cycleTime = cycleTime;
        this._createTime = createTime;
    }

    private IntegerProperty parameterId;
    private Integer _parameterId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "parameter_id", nullable = false)
    public Integer getParameterId() {
        if (parameterId == null) {
            return _parameterId;
        }
        else {
            return parameterId.get();
        }
    }

    public void setParameterId(Integer parameterId) {
        if (this.parameterId == null) {
            this._parameterId = parameterId;
        }
        else {
            this.parameterId.set(parameterId);
        }
    }
    
    public IntegerProperty parameterIdProperty() {
        if (parameterId == null) {
            parameterId = new SimpleIntegerProperty(this, "parameterId", _parameterId);
        }
        return parameterId;
    }

    private IntegerProperty measuringRangeOfTest;
    private Integer _measuringRangeOfTest;
    @Basic(optional = false)
    @Column(name = "measuring_range_of_test", nullable = false)
    public Integer getMeasuringRangeOfTest() {
        if (measuringRangeOfTest == null) {
            return _measuringRangeOfTest;
        }
        else {
            return measuringRangeOfTest.get();
        }
    }

    public void setMeasuringRangeOfTest(Integer measuringRangeOfTest) {
        if (this.measuringRangeOfTest == null) {
            this._measuringRangeOfTest = measuringRangeOfTest;
        }
        else {
            this.measuringRangeOfTest.set(measuringRangeOfTest);
        }
    }
    
    public IntegerProperty measuringRangeOfTestProperty() {
        if (measuringRangeOfTest == null) {
            measuringRangeOfTest = new SimpleIntegerProperty(this, "measuringRangeOfTest", _measuringRangeOfTest);
        }
        return measuringRangeOfTest;
    }    

    private IntegerProperty testPulseWidth;
    private Integer _testPulseWidth;
    @Basic(optional = false)
    @Column(name = "test_pulse_width", nullable = false)
    public Integer getTestPulseWidth() {
        if (testPulseWidth == null) {
            return _testPulseWidth;
        }
        else {
            return testPulseWidth.get();
        }
    }

    public void setTestPulseWidth(Integer testPulseWidth) {
        if (this.testPulseWidth == null) {
            this._testPulseWidth = testPulseWidth;
        }
        else {
            this.testPulseWidth.set(testPulseWidth);
        }
    }
    
    public IntegerProperty testPulseWidthProperty() {
        if (testPulseWidth == null) {
            testPulseWidth = new SimpleIntegerProperty(this, "testPulseWidth", _testPulseWidth);
        }
        return testPulseWidth;
    }     

    private IntegerProperty measuringTime;
    private Integer _measuringTime;
    @Basic(optional = false)
    @Column(name = "measuring_time", nullable = false)
    public Integer getMeasuringTime() {
        if (measuringTime == null) {
            return _measuringTime;
        }
        else {
            return measuringTime.get();
        }
    }

    public void setMeasuringTime(Integer measuringTime) {
        if (this.measuringTime == null) {
            this._measuringTime = measuringTime;
        }
        else {
            this.measuringTime.set(measuringTime);
        }
    }
    
    public IntegerProperty measuringTimeProperty() {
        if (measuringTime == null) {
            measuringTime = new SimpleIntegerProperty(this, "measuringTime", _measuringTime);
        }
        return measuringTime;
    }      

    private IntegerProperty testWaveLength;
    private Integer _testWaveLength;
    @Basic(optional = false)
    @Column(name = "test_wave_length", nullable = false)
    public Integer getTestWaveLength() {
        if (testWaveLength == null) {
            return _testWaveLength;
        }
        else {
            return testWaveLength.get();
        }
    }

    public void setTestWaveLength(Integer testWaveLength) {
        if (this.testWaveLength == null) {
            this._testWaveLength = testWaveLength;
        }
        else {
            this.testWaveLength.set(testWaveLength);
        }
    }
    
    public IntegerProperty testWaveLengthProperty() {
        if (testWaveLength == null) {
            testWaveLength = new SimpleIntegerProperty(this, "testWaveLength", _testWaveLength);
        }
        return testWaveLength;
    }
    
    private IntegerProperty measureMode;
    private Integer _measureMode;
    @Basic(optional = false)
    @Column(name = "measure_mode", nullable = false)
    public Integer getMeasureMode() {
        if (measureMode == null) {
            return _measureMode;
        }
        else {
            return measureMode.get();
        }
    }

    public void setMeasureMode(Integer measureMode) {
        if (this.measureMode == null) {
            this._measureMode = measureMode;
        }
        else {
            this.measureMode.set(measureMode);
        }
    }
    
    public IntegerProperty measureModeProperty() {
        if (measureMode == null) {
            measureMode = new SimpleIntegerProperty(this, "measureMode", _measureMode);
        }
        return measureMode;
    }
    
    private FloatProperty refractiveIndex;
    private Float _refractiveIndex;
    @Basic(optional = false)
    @Column(name = "refractive_index", nullable = false)
    public Float getRefractiveIndex() {
        if (refractiveIndex == null) {
            return _refractiveIndex;
        }
        else {
            return refractiveIndex.get();
        }
    }

    public void setRefractiveIndex(Float refractiveIndex) {
        if (this.refractiveIndex == null) {
            this._refractiveIndex = refractiveIndex;
        }
        else {
            this.refractiveIndex.set(refractiveIndex);
        }
    }
    
    public FloatProperty refractiveIndexProperty() {
        if (refractiveIndex == null) {
            refractiveIndex = new SimpleFloatProperty(this, "refractiveIndex", _refractiveIndex);
        }
        return refractiveIndex;
    }

    private FloatProperty nonReflactionThreshold;
    private Float _nonReflactionThreshold;
    @Basic(optional = false)
    @Column(name = "non_reflaction_threshold", nullable = false)
    public Float getNonReflactionThreshold() {
        if (nonReflactionThreshold == null) {
            return _nonReflactionThreshold;
        }
        else {
            return nonReflactionThreshold.get();
        }
    }

    public void setNonReflactionThreshold(Float nonReflactionThreshold) {
        if (this.nonReflactionThreshold == null) {
            this._nonReflactionThreshold = nonReflactionThreshold;
        }
        else {
            this.nonReflactionThreshold.set(nonReflactionThreshold);
        }
    }

    public FloatProperty nonReflactionThresholdProperty() {
        if (nonReflactionThreshold == null) {
            nonReflactionThreshold = new SimpleFloatProperty(this, "nonReflactionThreshold", _nonReflactionThreshold);
        }
        return nonReflactionThreshold;
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

    private FloatProperty reflectionThreshold;
    private Float _reflectionThreshold;
    @Basic(optional = false)
    @Column(name = "reflection_threshold", nullable = false)
    public Float getReflectionThreshold() {
        if (reflectionThreshold == null) {
            return _reflectionThreshold;
        }
        else {
            return reflectionThreshold.get();
        }
    }

    public void setReflectionThreshold(Float reflectionThreshold) {
        if (this.reflectionThreshold == null) {
            this._reflectionThreshold = reflectionThreshold;
        }
        else {
            this.reflectionThreshold.set(reflectionThreshold);
        }
    }

    public FloatProperty reflectionThresholdProperty() {
        if (reflectionThreshold == null) {
            reflectionThreshold = new SimpleFloatProperty(this, "reflectionThreshold", _reflectionThreshold);
        }
        return reflectionThreshold;
    }

    private IntegerProperty optimizeMode;
    private Integer _optimizeMode;
    @Basic(optional = false)
    @Column(name = "optimize_mode", nullable = false)
    public Integer getOptimizeMode() {
        if (optimizeMode == null) {
            return _optimizeMode;
        }
        else {
            return optimizeMode.get();
        }
    }

    public void setOptimizeMode(Integer optimizeMode) {
        if (this.optimizeMode == null) {
            this._optimizeMode = optimizeMode;
        }
        else {
            this.optimizeMode.set(optimizeMode);
        }
    }

    public IntegerProperty optimizeModeProperty() {
        if (optimizeMode == null) {
            optimizeMode = new SimpleIntegerProperty(this, "optimizeMode", _optimizeMode);
        }
        return optimizeMode;
    }
    
    private IntegerProperty enabledRefresh;
    private Integer _enabledRefresh;
    @Basic(optional = false)
    @Column(name = "enabled_refresh", nullable = false)
    public Integer getEnabledRefresh() {
        if (enabledRefresh == null) {
            return _enabledRefresh;
        }
        else {
            return enabledRefresh.get();
        }
    }

    public void setEnabledRefresh(Integer enabledRefresh) {
        if (this.enabledRefresh == null) {
            this._enabledRefresh = enabledRefresh;
        }
        else {
            this.enabledRefresh.set(enabledRefresh);
        }
    }

    public IntegerProperty enabledRefreshProperty() {
        if (enabledRefresh == null) {
            enabledRefresh = new SimpleIntegerProperty(this, "enabledRefresh", _enabledRefresh);
        }
        return enabledRefresh;
    }
    
    private IntegerProperty refreshCycle;
    private Integer _refreshCycle;
    @Basic(optional = false)
    @Column(name = "refresh_cycle", nullable = false)
    public Integer getRefreshCycle() {
        if (refreshCycle == null) {
            return _refreshCycle;
        }
        else {
            return refreshCycle.get();
        }
    }

    public void setRefreshCycle(Integer refreshCycle) {
        if (this.refreshCycle == null) {
            this._refreshCycle = refreshCycle;
        }
        else {
            this.refreshCycle.set(refreshCycle);
        }
    }

    public IntegerProperty refreshCycleProperty() {
        if (refreshCycle == null) {
            refreshCycle = new SimpleIntegerProperty(this, "refreshCycle", _refreshCycle);
        }
        return refreshCycle;
    }
    
    private IntegerProperty cycleTime;
    private Integer _cycleTime;
    @Basic(optional = false)
    @Column(name = "cycle_time", nullable = false)
    public Integer getCycleTime() {
        if (cycleTime == null) {
            return _cycleTime;
        }
        else {
            return cycleTime.get();
        }
    }

    public void setCycleTime(Integer cycleTime) {
        if (this.cycleTime == null) {
            this._cycleTime = cycleTime;
        }
        else {
            this.cycleTime.set(cycleTime);
        }
    }

    public IntegerProperty cycleTimeProperty() {
        if (cycleTime == null) {
            cycleTime = new SimpleIntegerProperty(this, "cycleTime", _cycleTime);
        }
        return cycleTime;
    }
    
    private ObjectProperty<Date> createTime;
    private Date _createTime;
    @Basic(optional = false)
    @Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        if (createTime == null) {
            return _createTime;
        }
        else {
            return createTime.get();
        }
    }

    public void setCreateTime(Date createTime) {
        if (this.createTime == null) {
            this._createTime = createTime;
        }
        else {
            this.createTime.set(createTime);
        }
    }
    
    public ObjectProperty<Date> createTimeProperty() {
        if (createTime == null) {
            createTime = new SimpleObjectProperty<>(this, "createTime", _createTime);
        }
        return createTime;
    }

    private ObjectProperty<Date> updateTime;
    private Date _updateTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdateTime() {
        if (updateTime == null) {
            return _updateTime;
        }
        else {
            return updateTime.get();
        }
    }

    public void setUpdateTime(Date updateTime) {
        if (this.updateTime == null) {
            this._updateTime = updateTime;
        }
        else {
            this.updateTime.set(updateTime);
        }
    }

    public ObjectProperty<Date> updateTimeProperty() {
        if (updateTime == null) {
            updateTime = new SimpleObjectProperty<>(this, "updateTime", _updateTime);
        }
        return updateTime;
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

    private ObjectProperty<User> user;
    private User _user;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false)
    public User getUser() {
        if (user == null) {
            return _user;
        }
        else {
            return user.get();
        }
    }

    public void setUser(User user) {
        if (this.user == null) {
            this._user = user;
        }
        else {
            this.user.set(user);
        }
    }

    public ObjectProperty<User> userProperty() {
        if (user == null) {
            user = new SimpleObjectProperty<>(this, "user", _user);
        }
        return user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_parameterId != null ? _parameterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
        if ((this._parameterId == null && other._parameterId != null) || (this._parameterId != null && !this._parameterId.equals(other._parameterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofm.model.entities.Parameter[ parameterId=" + _parameterId + " - device=" + _device.toString() + " ]";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getParameterId());
        out.writeObject(getMeasuringRangeOfTest());
        out.writeObject(getTestPulseWidth());
        out.writeObject(getMeasuringTime());
        out.writeObject(getTestWaveLength());
        out.writeObject(getMeasureMode());
        out.writeObject(getRefractiveIndex());
        out.writeObject(getNonReflactionThreshold());
        out.writeObject(getEndThreshold());
        out.writeObject(getReflectionThreshold());
        out.writeObject(getOptimizeMode());
        out.writeObject(getEnabledRefresh());
        out.writeObject(getRefreshCycle());
        out.writeObject(getCycleTime());
        out.writeObject(getCreateTime());
        out.writeObject(getUpdateTime());
        out.writeObject(getDevice());
        out.writeObject(getUser());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setParameterId((Integer)in.readObject());
        setMeasuringRangeOfTest((Integer)in.readObject());
        setTestPulseWidth((Integer)in.readObject());
        setMeasuringTime((Integer)in.readObject());
        setTestWaveLength((Integer)in.readObject());
        setMeasureMode((Integer)in.readObject());
        setRefractiveIndex((Float)in.readObject());
        setNonReflactionThreshold((Float)in.readObject());
        setEndThreshold((Float)in.readObject());
        setReflectionThreshold((Float)in.readObject());
        setOptimizeMode((Integer)in.readObject());
        setEnabledRefresh((Integer)in.readObject());
        setRefreshCycle((Integer)in.readObject());
        setCycleTime((Integer)in.readObject());
        setCreateTime((Date)in.readObject());
        setUpdateTime((Date)in.readObject());
        setDevice((Device)in.readObject());
        setUser((User)in.readObject());                
    }
    
}
