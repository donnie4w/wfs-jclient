/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.wfs.protocol;

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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * 文件对象
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-04-06")
public class WfsFile implements org.apache.thrift.TBase<WfsFile, WfsFile._Fields>, java.io.Serializable, Cloneable, Comparable<WfsFile> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WfsFile");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FILE_BODY_FIELD_DESC = new org.apache.thrift.protocol.TField("fileBody", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField FILE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("fileType", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WfsFileStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WfsFileTupleSchemeFactory());
  }

  /**
   * 名称
   */
  public String name; // optional
  /**
   * 对象
   */
  public ByteBuffer fileBody; // optional
  /**
   * 类型
   */
  public String fileType; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 名称
     */
    NAME((short)1, "name"),
    /**
     * 对象
     */
    FILE_BODY((short)2, "fileBody"),
    /**
     * 类型
     */
    FILE_TYPE((short)3, "fileType");

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
        case 1: // NAME
          return NAME;
        case 2: // FILE_BODY
          return FILE_BODY;
        case 3: // FILE_TYPE
          return FILE_TYPE;
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
  private static final _Fields optionals[] = {_Fields.NAME,_Fields.FILE_BODY,_Fields.FILE_TYPE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FILE_BODY, new org.apache.thrift.meta_data.FieldMetaData("fileBody", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.FILE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("fileType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WfsFile.class, metaDataMap);
  }

  public WfsFile() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WfsFile(WfsFile other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetFileBody()) {
      this.fileBody = org.apache.thrift.TBaseHelper.copyBinary(other.fileBody);
    }
    if (other.isSetFileType()) {
      this.fileType = other.fileType;
    }
  }

  public WfsFile deepCopy() {
    return new WfsFile(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.fileBody = null;
    this.fileType = null;
  }

  /**
   * 名称
   */
  public String getName() {
    return this.name;
  }

  /**
   * 名称
   */
  public WfsFile setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  /**
   * 对象
   */
  public byte[] getFileBody() {
    setFileBody(org.apache.thrift.TBaseHelper.rightSize(fileBody));
    return fileBody == null ? null : fileBody.array();
  }

  public ByteBuffer bufferForFileBody() {
    return org.apache.thrift.TBaseHelper.copyBinary(fileBody);
  }

  /**
   * 对象
   */
  public WfsFile setFileBody(byte[] fileBody) {
    this.fileBody = fileBody == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(fileBody, fileBody.length));
    return this;
  }

  public WfsFile setFileBody(ByteBuffer fileBody) {
    this.fileBody = org.apache.thrift.TBaseHelper.copyBinary(fileBody);
    return this;
  }

  public void unsetFileBody() {
    this.fileBody = null;
  }

  /** Returns true if field fileBody is set (has been assigned a value) and false otherwise */
  public boolean isSetFileBody() {
    return this.fileBody != null;
  }

  public void setFileBodyIsSet(boolean value) {
    if (!value) {
      this.fileBody = null;
    }
  }

  /**
   * 类型
   */
  public String getFileType() {
    return this.fileType;
  }

  /**
   * 类型
   */
  public WfsFile setFileType(String fileType) {
    this.fileType = fileType;
    return this;
  }

  public void unsetFileType() {
    this.fileType = null;
  }

  /** Returns true if field fileType is set (has been assigned a value) and false otherwise */
  public boolean isSetFileType() {
    return this.fileType != null;
  }

  public void setFileTypeIsSet(boolean value) {
    if (!value) {
      this.fileType = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case FILE_BODY:
      if (value == null) {
        unsetFileBody();
      } else {
        setFileBody((ByteBuffer)value);
      }
      break;

    case FILE_TYPE:
      if (value == null) {
        unsetFileType();
      } else {
        setFileType((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case FILE_BODY:
      return getFileBody();

    case FILE_TYPE:
      return getFileType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case FILE_BODY:
      return isSetFileBody();
    case FILE_TYPE:
      return isSetFileType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WfsFile)
      return this.equals((WfsFile)that);
    return false;
  }

  public boolean equals(WfsFile that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_fileBody = true && this.isSetFileBody();
    boolean that_present_fileBody = true && that.isSetFileBody();
    if (this_present_fileBody || that_present_fileBody) {
      if (!(this_present_fileBody && that_present_fileBody))
        return false;
      if (!this.fileBody.equals(that.fileBody))
        return false;
    }

    boolean this_present_fileType = true && this.isSetFileType();
    boolean that_present_fileType = true && that.isSetFileType();
    if (this_present_fileType || that_present_fileType) {
      if (!(this_present_fileType && that_present_fileType))
        return false;
      if (!this.fileType.equals(that.fileType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_fileBody = true && (isSetFileBody());
    list.add(present_fileBody);
    if (present_fileBody)
      list.add(fileBody);

    boolean present_fileType = true && (isSetFileType());
    list.add(present_fileType);
    if (present_fileType)
      list.add(fileType);

    return list.hashCode();
  }

  @Override
  public int compareTo(WfsFile other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFileBody()).compareTo(other.isSetFileBody());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFileBody()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fileBody, other.fileBody);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFileType()).compareTo(other.isSetFileType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFileType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fileType, other.fileType);
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
    StringBuilder sb = new StringBuilder("WfsFile(");
    boolean first = true;

    if (isSetName()) {
      sb.append("name:");
      if (this.name == null) {
        sb.append("null");
      } else {
        sb.append(this.name);
      }
      first = false;
    }
    if (isSetFileBody()) {
      if (!first) sb.append(", ");
      sb.append("fileBody:");
      if (this.fileBody == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.fileBody, sb);
      }
      first = false;
    }
    if (isSetFileType()) {
      if (!first) sb.append(", ");
      sb.append("fileType:");
      if (this.fileType == null) {
        sb.append("null");
      } else {
        sb.append(this.fileType);
      }
      first = false;
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WfsFileStandardSchemeFactory implements SchemeFactory {
    public WfsFileStandardScheme getScheme() {
      return new WfsFileStandardScheme();
    }
  }

  private static class WfsFileStandardScheme extends StandardScheme<WfsFile> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WfsFile struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FILE_BODY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fileBody = iprot.readBinary();
              struct.setFileBodyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FILE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fileType = iprot.readString();
              struct.setFileTypeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, WfsFile struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        if (struct.isSetName()) {
          oprot.writeFieldBegin(NAME_FIELD_DESC);
          oprot.writeString(struct.name);
          oprot.writeFieldEnd();
        }
      }
      if (struct.fileBody != null) {
        if (struct.isSetFileBody()) {
          oprot.writeFieldBegin(FILE_BODY_FIELD_DESC);
          oprot.writeBinary(struct.fileBody);
          oprot.writeFieldEnd();
        }
      }
      if (struct.fileType != null) {
        if (struct.isSetFileType()) {
          oprot.writeFieldBegin(FILE_TYPE_FIELD_DESC);
          oprot.writeString(struct.fileType);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WfsFileTupleSchemeFactory implements SchemeFactory {
    public WfsFileTupleScheme getScheme() {
      return new WfsFileTupleScheme();
    }
  }

  private static class WfsFileTupleScheme extends TupleScheme<WfsFile> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WfsFile struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetFileBody()) {
        optionals.set(1);
      }
      if (struct.isSetFileType()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetFileBody()) {
        oprot.writeBinary(struct.fileBody);
      }
      if (struct.isSetFileType()) {
        oprot.writeString(struct.fileType);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WfsFile struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.fileBody = iprot.readBinary();
        struct.setFileBodyIsSet(true);
      }
      if (incoming.get(2)) {
        struct.fileType = iprot.readString();
        struct.setFileTypeIsSet(true);
      }
    }
  }

}

