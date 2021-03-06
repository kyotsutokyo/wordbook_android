/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.kyotsu.wordbook.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TDateTime implements org.apache.thrift.TBase<TDateTime, TDateTime._Fields>, java.io.Serializable, Cloneable, Comparable<TDateTime> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDateTime");

  private static final org.apache.thrift.protocol.TField YEAR_FIELD_DESC = new org.apache.thrift.protocol.TField("year", org.apache.thrift.protocol.TType.I16, (short)1);
  private static final org.apache.thrift.protocol.TField MONTH_FIELD_DESC = new org.apache.thrift.protocol.TField("month", org.apache.thrift.protocol.TType.I16, (short)2);
  private static final org.apache.thrift.protocol.TField DAY_FIELD_DESC = new org.apache.thrift.protocol.TField("day", org.apache.thrift.protocol.TType.I16, (short)3);
  private static final org.apache.thrift.protocol.TField HOUR_FIELD_DESC = new org.apache.thrift.protocol.TField("hour", org.apache.thrift.protocol.TType.I16, (short)4);
  private static final org.apache.thrift.protocol.TField MINUTE_FIELD_DESC = new org.apache.thrift.protocol.TField("minute", org.apache.thrift.protocol.TType.I16, (short)5);
  private static final org.apache.thrift.protocol.TField SECOND_FIELD_DESC = new org.apache.thrift.protocol.TField("second", org.apache.thrift.protocol.TType.I16, (short)6);
  private static final org.apache.thrift.protocol.TField MILLISECOND_FIELD_DESC = new org.apache.thrift.protocol.TField("millisecond", org.apache.thrift.protocol.TType.I16, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDateTimeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDateTimeTupleSchemeFactory());
  }

  public short year; // required
  public short month; // required
  public short day; // required
  public short hour; // required
  public short minute; // required
  public short second; // required
  public short millisecond; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    YEAR((short)1, "year"),
    MONTH((short)2, "month"),
    DAY((short)3, "day"),
    HOUR((short)4, "hour"),
    MINUTE((short)5, "minute"),
    SECOND((short)6, "second"),
    MILLISECOND((short)7, "millisecond");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // YEAR
          return YEAR;
        case 2: // MONTH
          return MONTH;
        case 3: // DAY
          return DAY;
        case 4: // HOUR
          return HOUR;
        case 5: // MINUTE
          return MINUTE;
        case 6: // SECOND
          return SECOND;
        case 7: // MILLISECOND
          return MILLISECOND;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __YEAR_ISSET_ID = 0;
  private static final int __MONTH_ISSET_ID = 1;
  private static final int __DAY_ISSET_ID = 2;
  private static final int __HOUR_ISSET_ID = 3;
  private static final int __MINUTE_ISSET_ID = 4;
  private static final int __SECOND_ISSET_ID = 5;
  private static final int __MILLISECOND_ISSET_ID = 6;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.YEAR, new org.apache.thrift.meta_data.FieldMetaData("year", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.MONTH, new org.apache.thrift.meta_data.FieldMetaData("month", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.DAY, new org.apache.thrift.meta_data.FieldMetaData("day", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.HOUR, new org.apache.thrift.meta_data.FieldMetaData("hour", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.MINUTE, new org.apache.thrift.meta_data.FieldMetaData("minute", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.SECOND, new org.apache.thrift.meta_data.FieldMetaData("second", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.MILLISECOND, new org.apache.thrift.meta_data.FieldMetaData("millisecond", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDateTime.class, metaDataMap);
  }

  public TDateTime() {
  }

  public TDateTime(
    short year,
    short month,
    short day,
    short hour,
    short minute,
    short second,
    short millisecond)
  {
    this();
    this.year = year;
    setYearIsSet(true);
    this.month = month;
    setMonthIsSet(true);
    this.day = day;
    setDayIsSet(true);
    this.hour = hour;
    setHourIsSet(true);
    this.minute = minute;
    setMinuteIsSet(true);
    this.second = second;
    setSecondIsSet(true);
    this.millisecond = millisecond;
    setMillisecondIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDateTime(TDateTime other) {
    __isset_bitfield = other.__isset_bitfield;
    this.year = other.year;
    this.month = other.month;
    this.day = other.day;
    this.hour = other.hour;
    this.minute = other.minute;
    this.second = other.second;
    this.millisecond = other.millisecond;
  }

  public TDateTime deepCopy() {
    return new TDateTime(this);
  }

  @Override
  public void clear() {
    setYearIsSet(false);
    this.year = 0;
    setMonthIsSet(false);
    this.month = 0;
    setDayIsSet(false);
    this.day = 0;
    setHourIsSet(false);
    this.hour = 0;
    setMinuteIsSet(false);
    this.minute = 0;
    setSecondIsSet(false);
    this.second = 0;
    setMillisecondIsSet(false);
    this.millisecond = 0;
  }

  public short getYear() {
    return this.year;
  }

  public TDateTime setYear(short year) {
    this.year = year;
    setYearIsSet(true);
    return this;
  }

  public void unsetYear() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __YEAR_ISSET_ID);
  }

  /** Returns true if field year is set (has been assigned a value) and false otherwise */
  public boolean isSetYear() {
    return EncodingUtils.testBit(__isset_bitfield, __YEAR_ISSET_ID);
  }

  public void setYearIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __YEAR_ISSET_ID, value);
  }

  public short getMonth() {
    return this.month;
  }

  public TDateTime setMonth(short month) {
    this.month = month;
    setMonthIsSet(true);
    return this;
  }

  public void unsetMonth() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MONTH_ISSET_ID);
  }

  /** Returns true if field month is set (has been assigned a value) and false otherwise */
  public boolean isSetMonth() {
    return EncodingUtils.testBit(__isset_bitfield, __MONTH_ISSET_ID);
  }

  public void setMonthIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MONTH_ISSET_ID, value);
  }

  public short getDay() {
    return this.day;
  }

  public TDateTime setDay(short day) {
    this.day = day;
    setDayIsSet(true);
    return this;
  }

  public void unsetDay() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DAY_ISSET_ID);
  }

  /** Returns true if field day is set (has been assigned a value) and false otherwise */
  public boolean isSetDay() {
    return EncodingUtils.testBit(__isset_bitfield, __DAY_ISSET_ID);
  }

  public void setDayIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DAY_ISSET_ID, value);
  }

  public short getHour() {
    return this.hour;
  }

  public TDateTime setHour(short hour) {
    this.hour = hour;
    setHourIsSet(true);
    return this;
  }

  public void unsetHour() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HOUR_ISSET_ID);
  }

  /** Returns true if field hour is set (has been assigned a value) and false otherwise */
  public boolean isSetHour() {
    return EncodingUtils.testBit(__isset_bitfield, __HOUR_ISSET_ID);
  }

  public void setHourIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HOUR_ISSET_ID, value);
  }

  public short getMinute() {
    return this.minute;
  }

  public TDateTime setMinute(short minute) {
    this.minute = minute;
    setMinuteIsSet(true);
    return this;
  }

  public void unsetMinute() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MINUTE_ISSET_ID);
  }

  /** Returns true if field minute is set (has been assigned a value) and false otherwise */
  public boolean isSetMinute() {
    return EncodingUtils.testBit(__isset_bitfield, __MINUTE_ISSET_ID);
  }

  public void setMinuteIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MINUTE_ISSET_ID, value);
  }

  public short getSecond() {
    return this.second;
  }

  public TDateTime setSecond(short second) {
    this.second = second;
    setSecondIsSet(true);
    return this;
  }

  public void unsetSecond() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SECOND_ISSET_ID);
  }

  /** Returns true if field second is set (has been assigned a value) and false otherwise */
  public boolean isSetSecond() {
    return EncodingUtils.testBit(__isset_bitfield, __SECOND_ISSET_ID);
  }

  public void setSecondIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SECOND_ISSET_ID, value);
  }

  public short getMillisecond() {
    return this.millisecond;
  }

  public TDateTime setMillisecond(short millisecond) {
    this.millisecond = millisecond;
    setMillisecondIsSet(true);
    return this;
  }

  public void unsetMillisecond() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MILLISECOND_ISSET_ID);
  }

  /** Returns true if field millisecond is set (has been assigned a value) and false otherwise */
  public boolean isSetMillisecond() {
    return EncodingUtils.testBit(__isset_bitfield, __MILLISECOND_ISSET_ID);
  }

  public void setMillisecondIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MILLISECOND_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case YEAR:
      if (value == null) {
        unsetYear();
      } else {
        setYear((Short)value);
      }
      break;

    case MONTH:
      if (value == null) {
        unsetMonth();
      } else {
        setMonth((Short)value);
      }
      break;

    case DAY:
      if (value == null) {
        unsetDay();
      } else {
        setDay((Short)value);
      }
      break;

    case HOUR:
      if (value == null) {
        unsetHour();
      } else {
        setHour((Short)value);
      }
      break;

    case MINUTE:
      if (value == null) {
        unsetMinute();
      } else {
        setMinute((Short)value);
      }
      break;

    case SECOND:
      if (value == null) {
        unsetSecond();
      } else {
        setSecond((Short)value);
      }
      break;

    case MILLISECOND:
      if (value == null) {
        unsetMillisecond();
      } else {
        setMillisecond((Short)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case YEAR:
      return Short.valueOf(getYear());

    case MONTH:
      return Short.valueOf(getMonth());

    case DAY:
      return Short.valueOf(getDay());

    case HOUR:
      return Short.valueOf(getHour());

    case MINUTE:
      return Short.valueOf(getMinute());

    case SECOND:
      return Short.valueOf(getSecond());

    case MILLISECOND:
      return Short.valueOf(getMillisecond());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case YEAR:
      return isSetYear();
    case MONTH:
      return isSetMonth();
    case DAY:
      return isSetDay();
    case HOUR:
      return isSetHour();
    case MINUTE:
      return isSetMinute();
    case SECOND:
      return isSetSecond();
    case MILLISECOND:
      return isSetMillisecond();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDateTime)
      return this.equals((TDateTime)that);
    return false;
  }

  public boolean equals(TDateTime that) {
    if (that == null)
      return false;

    boolean this_present_year = true;
    boolean that_present_year = true;
    if (this_present_year || that_present_year) {
      if (!(this_present_year && that_present_year))
        return false;
      if (this.year != that.year)
        return false;
    }

    boolean this_present_month = true;
    boolean that_present_month = true;
    if (this_present_month || that_present_month) {
      if (!(this_present_month && that_present_month))
        return false;
      if (this.month != that.month)
        return false;
    }

    boolean this_present_day = true;
    boolean that_present_day = true;
    if (this_present_day || that_present_day) {
      if (!(this_present_day && that_present_day))
        return false;
      if (this.day != that.day)
        return false;
    }

    boolean this_present_hour = true;
    boolean that_present_hour = true;
    if (this_present_hour || that_present_hour) {
      if (!(this_present_hour && that_present_hour))
        return false;
      if (this.hour != that.hour)
        return false;
    }

    boolean this_present_minute = true;
    boolean that_present_minute = true;
    if (this_present_minute || that_present_minute) {
      if (!(this_present_minute && that_present_minute))
        return false;
      if (this.minute != that.minute)
        return false;
    }

    boolean this_present_second = true;
    boolean that_present_second = true;
    if (this_present_second || that_present_second) {
      if (!(this_present_second && that_present_second))
        return false;
      if (this.second != that.second)
        return false;
    }

    boolean this_present_millisecond = true;
    boolean that_present_millisecond = true;
    if (this_present_millisecond || that_present_millisecond) {
      if (!(this_present_millisecond && that_present_millisecond))
        return false;
      if (this.millisecond != that.millisecond)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDateTime other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetYear()).compareTo(other.isSetYear());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetYear()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.year, other.year);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMonth()).compareTo(other.isSetMonth());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMonth()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.month, other.month);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDay()).compareTo(other.isSetDay());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDay()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.day, other.day);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHour()).compareTo(other.isSetHour());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHour()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hour, other.hour);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMinute()).compareTo(other.isSetMinute());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMinute()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.minute, other.minute);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSecond()).compareTo(other.isSetSecond());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSecond()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.second, other.second);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMillisecond()).compareTo(other.isSetMillisecond());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMillisecond()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.millisecond, other.millisecond);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TDateTime(");
    boolean first = true;

    sb.append("year:");
    sb.append(this.year);
    first = false;
    if (!first) sb.append(", ");
    sb.append("month:");
    sb.append(this.month);
    first = false;
    if (!first) sb.append(", ");
    sb.append("day:");
    sb.append(this.day);
    first = false;
    if (!first) sb.append(", ");
    sb.append("hour:");
    sb.append(this.hour);
    first = false;
    if (!first) sb.append(", ");
    sb.append("minute:");
    sb.append(this.minute);
    first = false;
    if (!first) sb.append(", ");
    sb.append("second:");
    sb.append(this.second);
    first = false;
    if (!first) sb.append(", ");
    sb.append("millisecond:");
    sb.append(this.millisecond);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TDateTimeStandardSchemeFactory implements SchemeFactory {
    public TDateTimeStandardScheme getScheme() {
      return new TDateTimeStandardScheme();
    }
  }

  private static class TDateTimeStandardScheme extends StandardScheme<TDateTime> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDateTime struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // YEAR
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.year = iprot.readI16();
              struct.setYearIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MONTH
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.month = iprot.readI16();
              struct.setMonthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DAY
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.day = iprot.readI16();
              struct.setDayIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // HOUR
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.hour = iprot.readI16();
              struct.setHourIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MINUTE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.minute = iprot.readI16();
              struct.setMinuteIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // SECOND
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.second = iprot.readI16();
              struct.setSecondIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // MILLISECOND
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.millisecond = iprot.readI16();
              struct.setMillisecondIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDateTime struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(YEAR_FIELD_DESC);
      oprot.writeI16(struct.year);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MONTH_FIELD_DESC);
      oprot.writeI16(struct.month);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DAY_FIELD_DESC);
      oprot.writeI16(struct.day);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(HOUR_FIELD_DESC);
      oprot.writeI16(struct.hour);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MINUTE_FIELD_DESC);
      oprot.writeI16(struct.minute);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(SECOND_FIELD_DESC);
      oprot.writeI16(struct.second);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MILLISECOND_FIELD_DESC);
      oprot.writeI16(struct.millisecond);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDateTimeTupleSchemeFactory implements SchemeFactory {
    public TDateTimeTupleScheme getScheme() {
      return new TDateTimeTupleScheme();
    }
  }

  private static class TDateTimeTupleScheme extends TupleScheme<TDateTime> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDateTime struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetYear()) {
        optionals.set(0);
      }
      if (struct.isSetMonth()) {
        optionals.set(1);
      }
      if (struct.isSetDay()) {
        optionals.set(2);
      }
      if (struct.isSetHour()) {
        optionals.set(3);
      }
      if (struct.isSetMinute()) {
        optionals.set(4);
      }
      if (struct.isSetSecond()) {
        optionals.set(5);
      }
      if (struct.isSetMillisecond()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetYear()) {
        oprot.writeI16(struct.year);
      }
      if (struct.isSetMonth()) {
        oprot.writeI16(struct.month);
      }
      if (struct.isSetDay()) {
        oprot.writeI16(struct.day);
      }
      if (struct.isSetHour()) {
        oprot.writeI16(struct.hour);
      }
      if (struct.isSetMinute()) {
        oprot.writeI16(struct.minute);
      }
      if (struct.isSetSecond()) {
        oprot.writeI16(struct.second);
      }
      if (struct.isSetMillisecond()) {
        oprot.writeI16(struct.millisecond);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDateTime struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.year = iprot.readI16();
        struct.setYearIsSet(true);
      }
      if (incoming.get(1)) {
        struct.month = iprot.readI16();
        struct.setMonthIsSet(true);
      }
      if (incoming.get(2)) {
        struct.day = iprot.readI16();
        struct.setDayIsSet(true);
      }
      if (incoming.get(3)) {
        struct.hour = iprot.readI16();
        struct.setHourIsSet(true);
      }
      if (incoming.get(4)) {
        struct.minute = iprot.readI16();
        struct.setMinuteIsSet(true);
      }
      if (incoming.get(5)) {
        struct.second = iprot.readI16();
        struct.setSecondIsSet(true);
      }
      if (incoming.get(6)) {
        struct.millisecond = iprot.readI16();
        struct.setMillisecondIsSet(true);
      }
    }
  }

}

