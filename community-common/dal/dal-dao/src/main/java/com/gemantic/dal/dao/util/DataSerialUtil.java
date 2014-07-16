/**
 * 
 */
package com.gemantic.dal.dao.util;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.sql.Timestamp;
import java.util.*;
import java.net.*;

public class DataSerialUtil {
    private static long nullLong = -1L;
    private static int nullInt = -1;
    private static short nullShort = (short) -1;
    private static byte nullByte = (byte) -1;

    public static void writeLong(Long num, ObjectOutput out) throws IOException {
        if (num != null) {
            out.writeLong(num.longValue());
        } else {
            out.writeLong(nullLong);
        }
    }

    public static Long readLong(ObjectInput in) throws ClassNotFoundException, IOException {
        Long num = null;
        long value = in.readLong();
        if (value != nullLong) {
            num = new Long(value);
        }
        return num;
    }

    public static void writeInt(Integer num, ObjectOutput out) throws IOException {
        if (num != null) {
            out.writeInt(num.intValue());
        } else {
            out.writeInt(nullInt);
        }
    }

    public static Integer readInt(ObjectInput in) throws ClassNotFoundException, IOException {
        Integer num = null;
        int value = in.readInt();
        if (value != nullInt) {
            num = new Integer(value);
        }
        return num;
    }

    public static void writeShort(Short num, ObjectOutput out) throws IOException {
        if (num != null) {
            out.writeShort(num.shortValue());
        } else {
            out.writeShort(nullShort);
        }
    }

    public static Short readShort(ObjectInput in) throws ClassNotFoundException, IOException {
        Short num = null;
        short value = in.readShort();
        if (value != nullShort) {
            num = new Short(value);
        }
        return num;
    }

    public static void writeByte(Byte num, ObjectOutput out) throws IOException {
        if (num != null) {
            out.writeByte(num.byteValue());
        } else {
            out.writeByte(nullByte);
        }
    }

    public static Byte readByte(ObjectInput in) throws ClassNotFoundException, IOException {
        Byte num = null;
        byte value = in.readByte();
        if (value != nullByte) {
            num = new Byte(value);
        }
        return num;
    }

    public static void writeTimestamp(Timestamp stamp, ObjectOutput out) throws IOException {
        if (stamp != null) {
            long value = stamp.getTime();
            out.writeLong(value);
        } else {
            out.writeLong(nullLong);
        }
    }

    public static Timestamp readTimestamp(ObjectInput in) throws ClassNotFoundException, IOException {
        Timestamp stamp = null;
        long value = in.readLong();
        if (value != nullLong) {
            stamp = new Timestamp(value);
        }
        return stamp;
    }

    public static void writeString(String string, ObjectOutput out) throws IOException {
        byte[] bytes = null;
        if (string != null) {
            bytes = string.getBytes("gbk");
        }
        out.writeObject(bytes);
    }

    public static String readString(ObjectInput in) throws ClassNotFoundException, IOException {
        String str = null;
        byte[] bytes = (byte[]) in.readObject();
        if (bytes != null) {
            str = new String(bytes, "gbk");
        }
        return str;
    }

    public static void writeStringArray(Set set, ObjectOutput out) throws IOException {
        StringBuffer sb = new StringBuffer();
        byte[] bytes = null;
        Object strArray[] = set.toArray();
        if (set != null && set.size() > 0) {
            for (int i = 0; i < strArray.length; i++) {
                sb.append((String) strArray[i]).append("@@@");
            }
            bytes = URLEncoder.encode(sb.toString()).getBytes();
        }
        out.writeObject(bytes);
    }

    public static Set readStringArray(ObjectInput in) throws ClassNotFoundException, IOException {
        if (in == null) {
            return null;
        }
        byte[] bytes = (byte[]) in.readObject();
        Set set = null;
        if (bytes != null && bytes.length > 0) {
            String str = URLDecoder.decode(new String(bytes));
            String[] strs = str.split("@@@");
            set = new LinkedHashSet();
            for (int i = 0; i < strs.length; i++)
                set.add(strs[i]);
        }
        return set;
    }
}
