/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.sse.ustc.contract;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum DevStatus implements org.apache.thrift.TEnum {
  ONLINE(1),
  OFFLINE(2);

  private final int value;

  private DevStatus(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static DevStatus findByValue(int value) { 
    switch (value) {
      case 1:
        return ONLINE;
      case 2:
        return OFFLINE;
      default:
        return null;
    }
  }
}
