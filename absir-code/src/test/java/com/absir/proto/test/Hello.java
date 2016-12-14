/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.absir.proto.test;

import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import javax.annotation.Generated;
import java.util.*;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-12-12")
public class Hello implements org.apache.thrift.TBase<Hello, Hello._Fields>, java.io.Serializable, Cloneable, Comparable<Hello> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Hello");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ID2_FIELD_DESC = new org.apache.thrift.protocol.TField("id2", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField ID3_FIELD_DESC = new org.apache.thrift.protocol.TField("id3", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField ID4_FIELD_DESC = new org.apache.thrift.protocol.TField("id4", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField ID5_FIELD_DESC = new org.apache.thrift.protocol.TField("id5", org.apache.thrift.protocol.TType.I64, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HelloStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HelloTupleSchemeFactory());
  }

  public int id; // required
  public long id2; // required
  public long id3; // required
  public long id4; // required
  public long id5; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    ID2((short)2, "id2"),
    ID3((short)3, "id3"),
    ID4((short)4, "id4"),
    ID5((short)5, "id5");

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
        case 1: // ID
          return ID;
        case 2: // ID2
          return ID2;
        case 3: // ID3
          return ID3;
        case 4: // ID4
          return ID4;
        case 5: // ID5
          return ID5;
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __ID2_ISSET_ID = 1;
  private static final int __ID3_ISSET_ID = 2;
  private static final int __ID4_ISSET_ID = 3;
  private static final int __ID5_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ID2, new org.apache.thrift.meta_data.FieldMetaData("id2", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ID3, new org.apache.thrift.meta_data.FieldMetaData("id3", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ID4, new org.apache.thrift.meta_data.FieldMetaData("id4", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ID5, new org.apache.thrift.meta_data.FieldMetaData("id5", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Hello.class, metaDataMap);
  }

  public Hello() {
    this.id = -1;

    this.id2 = -1L;

    this.id3 = -1L;

    this.id4 = -1L;

    this.id5 = -1L;

  }

  public Hello(
    int id,
    long id2,
    long id3,
    long id4,
    long id5)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.id2 = id2;
    setId2IsSet(true);
    this.id3 = id3;
    setId3IsSet(true);
    this.id4 = id4;
    setId4IsSet(true);
    this.id5 = id5;
    setId5IsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Hello(Hello other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.id2 = other.id2;
    this.id3 = other.id3;
    this.id4 = other.id4;
    this.id5 = other.id5;
  }

  public Hello deepCopy() {
    return new Hello(this);
  }

  @Override
  public void clear() {
    this.id = -1;

    this.id2 = -1L;

    this.id3 = -1L;

    this.id4 = -1L;

    this.id5 = -1L;

  }

  public int getId() {
    return this.id;
  }

  public Hello setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public long getId2() {
    return this.id2;
  }

  public Hello setId2(long id2) {
    this.id2 = id2;
    setId2IsSet(true);
    return this;
  }

  public void unsetId2() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID2_ISSET_ID);
  }

  /** Returns true if field id2 is set (has been assigned a value) and false otherwise */
  public boolean isSetId2() {
    return EncodingUtils.testBit(__isset_bitfield, __ID2_ISSET_ID);
  }

  public void setId2IsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID2_ISSET_ID, value);
  }

  public long getId3() {
    return this.id3;
  }

  public Hello setId3(long id3) {
    this.id3 = id3;
    setId3IsSet(true);
    return this;
  }

  public void unsetId3() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID3_ISSET_ID);
  }

  /** Returns true if field id3 is set (has been assigned a value) and false otherwise */
  public boolean isSetId3() {
    return EncodingUtils.testBit(__isset_bitfield, __ID3_ISSET_ID);
  }

  public void setId3IsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID3_ISSET_ID, value);
  }

  public long getId4() {
    return this.id4;
  }

  public Hello setId4(long id4) {
    this.id4 = id4;
    setId4IsSet(true);
    return this;
  }

  public void unsetId4() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID4_ISSET_ID);
  }

  /** Returns true if field id4 is set (has been assigned a value) and false otherwise */
  public boolean isSetId4() {
    return EncodingUtils.testBit(__isset_bitfield, __ID4_ISSET_ID);
  }

  public void setId4IsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID4_ISSET_ID, value);
  }

  public long getId5() {
    return this.id5;
  }

  public Hello setId5(long id5) {
    this.id5 = id5;
    setId5IsSet(true);
    return this;
  }

  public void unsetId5() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID5_ISSET_ID);
  }

  /** Returns true if field id5 is set (has been assigned a value) and false otherwise */
  public boolean isSetId5() {
    return EncodingUtils.testBit(__isset_bitfield, __ID5_ISSET_ID);
  }

  public void setId5IsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID5_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case ID2:
      if (value == null) {
        unsetId2();
      } else {
        setId2((Long)value);
      }
      break;

    case ID3:
      if (value == null) {
        unsetId3();
      } else {
        setId3((Long)value);
      }
      break;

    case ID4:
      if (value == null) {
        unsetId4();
      } else {
        setId4((Long)value);
      }
      break;

    case ID5:
      if (value == null) {
        unsetId5();
      } else {
        setId5((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case ID2:
      return getId2();

    case ID3:
      return getId3();

    case ID4:
      return getId4();

    case ID5:
      return getId5();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case ID2:
      return isSetId2();
    case ID3:
      return isSetId3();
    case ID4:
      return isSetId4();
    case ID5:
      return isSetId5();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Hello)
      return this.equals((Hello)that);
    return false;
  }

  public boolean equals(Hello that) {
    if (that == null)
      return false;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_id2 = true;
    boolean that_present_id2 = true;
    if (this_present_id2 || that_present_id2) {
      if (!(this_present_id2 && that_present_id2))
        return false;
      if (this.id2 != that.id2)
        return false;
    }

    boolean this_present_id3 = true;
    boolean that_present_id3 = true;
    if (this_present_id3 || that_present_id3) {
      if (!(this_present_id3 && that_present_id3))
        return false;
      if (this.id3 != that.id3)
        return false;
    }

    boolean this_present_id4 = true;
    boolean that_present_id4 = true;
    if (this_present_id4 || that_present_id4) {
      if (!(this_present_id4 && that_present_id4))
        return false;
      if (this.id4 != that.id4)
        return false;
    }

    boolean this_present_id5 = true;
    boolean that_present_id5 = true;
    if (this_present_id5 || that_present_id5) {
      if (!(this_present_id5 && that_present_id5))
        return false;
      if (this.id5 != that.id5)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true;
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_id2 = true;
    list.add(present_id2);
    if (present_id2)
      list.add(id2);

    boolean present_id3 = true;
    list.add(present_id3);
    if (present_id3)
      list.add(id3);

    boolean present_id4 = true;
    list.add(present_id4);
    if (present_id4)
      list.add(id4);

    boolean present_id5 = true;
    list.add(present_id5);
    if (present_id5)
      list.add(id5);

    return list.hashCode();
  }

  @Override
  public int compareTo(Hello other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId2()).compareTo(other.isSetId2());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId2()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id2, other.id2);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId3()).compareTo(other.isSetId3());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId3()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id3, other.id3);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId4()).compareTo(other.isSetId4());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId4()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id4, other.id4);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId5()).compareTo(other.isSetId5());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId5()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id5, other.id5);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Hello(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("id2:");
    sb.append(this.id2);
    first = false;
    if (!first) sb.append(", ");
    sb.append("id3:");
    sb.append(this.id3);
    first = false;
    if (!first) sb.append(", ");
    sb.append("id4:");
    sb.append(this.id4);
    first = false;
    if (!first) sb.append(", ");
    sb.append("id5:");
    sb.append(this.id5);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class HelloStandardSchemeFactory implements SchemeFactory {
    public HelloStandardScheme getScheme() {
      return new HelloStandardScheme();
    }
  }

  private static class HelloStandardScheme extends StandardScheme<Hello> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Hello struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ID2
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id2 = iprot.readI64();
              struct.setId2IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ID3
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id3 = iprot.readI64();
              struct.setId3IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ID4
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id4 = iprot.readI64();
              struct.setId4IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ID5
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id5 = iprot.readI64();
              struct.setId5IsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Hello struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ID2_FIELD_DESC);
      oprot.writeI64(struct.id2);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ID3_FIELD_DESC);
      oprot.writeI64(struct.id3);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ID4_FIELD_DESC);
      oprot.writeI64(struct.id4);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ID5_FIELD_DESC);
      oprot.writeI64(struct.id5);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HelloTupleSchemeFactory implements SchemeFactory {
    public HelloTupleScheme getScheme() {
      return new HelloTupleScheme();
    }
  }

  private static class HelloTupleScheme extends TupleScheme<Hello> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Hello struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetId2()) {
        optionals.set(1);
      }
      if (struct.isSetId3()) {
        optionals.set(2);
      }
      if (struct.isSetId4()) {
        optionals.set(3);
      }
      if (struct.isSetId5()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetId2()) {
        oprot.writeI64(struct.id2);
      }
      if (struct.isSetId3()) {
        oprot.writeI64(struct.id3);
      }
      if (struct.isSetId4()) {
        oprot.writeI64(struct.id4);
      }
      if (struct.isSetId5()) {
        oprot.writeI64(struct.id5);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Hello struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.id2 = iprot.readI64();
        struct.setId2IsSet(true);
      }
      if (incoming.get(2)) {
        struct.id3 = iprot.readI64();
        struct.setId3IsSet(true);
      }
      if (incoming.get(3)) {
        struct.id4 = iprot.readI64();
        struct.setId4IsSet(true);
      }
      if (incoming.get(4)) {
        struct.id5 = iprot.readI64();
        struct.setId5IsSet(true);
      }
    }
  }

}

