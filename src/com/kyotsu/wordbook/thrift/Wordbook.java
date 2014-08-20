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

public class Wordbook implements org.apache.thrift.TBase<Wordbook, Wordbook._Fields>, java.io.Serializable, Cloneable, Comparable<Wordbook> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Wordbook");

  private static final org.apache.thrift.protocol.TField COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("count", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField WORDS_FIELD_DESC = new org.apache.thrift.protocol.TField("words", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WordbookStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WordbookTupleSchemeFactory());
  }

  public int count; // required
  public List<Word> words; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COUNT((short)1, "count"),
    WORDS((short)2, "words");

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
        case 1: // COUNT
          return COUNT;
        case 2: // WORDS
          return WORDS;
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
  private static final int __COUNT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COUNT, new org.apache.thrift.meta_data.FieldMetaData("count", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.WORDS, new org.apache.thrift.meta_data.FieldMetaData("words", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Word.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Wordbook.class, metaDataMap);
  }

  public Wordbook() {
  }

  public Wordbook(
    int count,
    List<Word> words)
  {
    this();
    this.count = count;
    setCountIsSet(true);
    this.words = words;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Wordbook(Wordbook other) {
    __isset_bitfield = other.__isset_bitfield;
    this.count = other.count;
    if (other.isSetWords()) {
      List<Word> __this__words = new ArrayList<Word>(other.words.size());
      for (Word other_element : other.words) {
        __this__words.add(new Word(other_element));
      }
      this.words = __this__words;
    }
  }

  public Wordbook deepCopy() {
    return new Wordbook(this);
  }

  @Override
  public void clear() {
    setCountIsSet(false);
    this.count = 0;
    this.words = null;
  }

  public int getCount() {
    return this.count;
  }

  public Wordbook setCount(int count) {
    this.count = count;
    setCountIsSet(true);
    return this;
  }

  public void unsetCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  /** Returns true if field count is set (has been assigned a value) and false otherwise */
  public boolean isSetCount() {
    return EncodingUtils.testBit(__isset_bitfield, __COUNT_ISSET_ID);
  }

  public void setCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COUNT_ISSET_ID, value);
  }

  public int getWordsSize() {
    return (this.words == null) ? 0 : this.words.size();
  }

  public java.util.Iterator<Word> getWordsIterator() {
    return (this.words == null) ? null : this.words.iterator();
  }

  public void addToWords(Word elem) {
    if (this.words == null) {
      this.words = new ArrayList<Word>();
    }
    this.words.add(elem);
  }

  public List<Word> getWords() {
    return this.words;
  }

  public Wordbook setWords(List<Word> words) {
    this.words = words;
    return this;
  }

  public void unsetWords() {
    this.words = null;
  }

  /** Returns true if field words is set (has been assigned a value) and false otherwise */
  public boolean isSetWords() {
    return this.words != null;
  }

  public void setWordsIsSet(boolean value) {
    if (!value) {
      this.words = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COUNT:
      if (value == null) {
        unsetCount();
      } else {
        setCount((Integer)value);
      }
      break;

    case WORDS:
      if (value == null) {
        unsetWords();
      } else {
        setWords((List<Word>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COUNT:
      return Integer.valueOf(getCount());

    case WORDS:
      return getWords();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COUNT:
      return isSetCount();
    case WORDS:
      return isSetWords();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Wordbook)
      return this.equals((Wordbook)that);
    return false;
  }

  public boolean equals(Wordbook that) {
    if (that == null)
      return false;

    boolean this_present_count = true;
    boolean that_present_count = true;
    if (this_present_count || that_present_count) {
      if (!(this_present_count && that_present_count))
        return false;
      if (this.count != that.count)
        return false;
    }

    boolean this_present_words = true && this.isSetWords();
    boolean that_present_words = true && that.isSetWords();
    if (this_present_words || that_present_words) {
      if (!(this_present_words && that_present_words))
        return false;
      if (!this.words.equals(that.words))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Wordbook other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCount()).compareTo(other.isSetCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.count, other.count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWords()).compareTo(other.isSetWords());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWords()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.words, other.words);
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
    StringBuilder sb = new StringBuilder("Wordbook(");
    boolean first = true;

    sb.append("count:");
    sb.append(this.count);
    first = false;
    if (!first) sb.append(", ");
    sb.append("words:");
    if (this.words == null) {
      sb.append("null");
    } else {
      sb.append(this.words);
    }
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

  private static class WordbookStandardSchemeFactory implements SchemeFactory {
    public WordbookStandardScheme getScheme() {
      return new WordbookStandardScheme();
    }
  }

  private static class WordbookStandardScheme extends StandardScheme<Wordbook> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Wordbook struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.count = iprot.readI32();
              struct.setCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // WORDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.words = new ArrayList<Word>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  Word _elem2;
                  _elem2 = new Word();
                  _elem2.read(iprot);
                  struct.words.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setWordsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Wordbook struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(COUNT_FIELD_DESC);
      oprot.writeI32(struct.count);
      oprot.writeFieldEnd();
      if (struct.words != null) {
        oprot.writeFieldBegin(WORDS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.words.size()));
          for (Word _iter3 : struct.words)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WordbookTupleSchemeFactory implements SchemeFactory {
    public WordbookTupleScheme getScheme() {
      return new WordbookTupleScheme();
    }
  }

  private static class WordbookTupleScheme extends TupleScheme<Wordbook> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Wordbook struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCount()) {
        optionals.set(0);
      }
      if (struct.isSetWords()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetCount()) {
        oprot.writeI32(struct.count);
      }
      if (struct.isSetWords()) {
        {
          oprot.writeI32(struct.words.size());
          for (Word _iter4 : struct.words)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Wordbook struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.count = iprot.readI32();
        struct.setCountIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.words = new ArrayList<Word>(_list5.size);
          for (int _i6 = 0; _i6 < _list5.size; ++_i6)
          {
            Word _elem7;
            _elem7 = new Word();
            _elem7.read(iprot);
            struct.words.add(_elem7);
          }
        }
        struct.setWordsIsSet(true);
      }
    }
  }

}
