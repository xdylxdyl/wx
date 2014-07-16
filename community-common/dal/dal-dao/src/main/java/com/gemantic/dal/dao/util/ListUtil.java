package com.gemantic.dal.dao.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static long readLong(byte[] buffer, int[] outpos) {
        if (buffer == null || buffer.length == 0)
            return 0;
        int pos = outpos[0];
        byte b = buffer[pos++];
        long i = b & 0x7F;
        for (int shift = 7; (b & 0x80) != 0; shift += 7) {
            b = buffer[pos++];
            i |= (b & 0x7FL) << shift;
        }
        outpos[0] = pos;
        return i;
    }

    public static byte[] writeLong(long i) {
        byte[] buffer = new byte[10];
        int pos = 0;
        while ((i & ~0x7F) != 0) {
            buffer[pos++] = (byte) ((i & 0x7f) | 0x80);
            i >>>= 7;
        }
        buffer[pos++] = (byte) i;

        byte[] result = new byte[pos];
        System.arraycopy(buffer, 0, result, 0, pos);
        return result;
    }

    public static byte[] insertLong(byte[] buffer, long num) {
        byte[] numbyte = writeLong(num);
        byte[] output = new byte[buffer.length + numbyte.length];
        System.arraycopy(buffer, 0, output, 0, buffer.length);
        System.arraycopy(numbyte, 0, output, buffer.length, numbyte.length);
        return output;
    }

    public static long getLastLong(byte[] buffer) {
        if (buffer == null || buffer.length == 0)
            return -1;

        int pos;
        for (pos = buffer.length - 2; pos >= 0; --pos) {
            int value = buffer[pos];
            if ((value & 0x80) == 0) {
                break;
            }
        }

        int[] outPos = new int[1];
        if (pos >= 0)
            outPos[0] = pos + 1;
        return readLong(buffer, outPos);
    }

    public static byte[] removeLong(byte[] buffer) {
        int pos;
        for (pos = buffer.length - 2; pos >= 0; --pos) {
            int value = buffer[pos];
            if ((value & 0x80) == 0) {
                break;
            }
        }
        if (pos < 0) {
            return new byte[0];
        }

        byte[] result = new byte[pos + 1];
        System.arraycopy(buffer, 0, result, 0, pos + 1);
        return result;
    }

    public static byte[] removeLong(byte[] buffer, int startPosInBuffer,long num, boolean[] outFound) {
        
        int[] outpos = new int[1];
        if(startPosInBuffer<0)
            startPosInBuffer=0;
        outpos[0]=startPosInBuffer;
        int prePos = 0;
        while (outpos[0] < buffer.length) {
            prePos = outpos[0];
            long value=readLong(buffer, outpos);
            //System.out.println("value[" + prePos + "]=" + prePos + ", buffer.length=" + buffer.length);
            if (value == num) {
                byte[] comIdByte = writeLong(value);
                byte[] output = new byte[buffer.length - comIdByte.length];
                System.arraycopy(buffer, 0, output, 0, prePos);
                System.arraycopy(buffer, prePos + comIdByte.length, output, 
                        prePos, buffer.length - prePos - comIdByte.length);
                if (outFound != null)
                    outFound[0] = true;
                //System.out.println("value[" + prePos + "]=" + prePos + ", output.length=" + output.length);
                return output;
            }
        }
        
        if (outFound != null)
            outFound[0] = false;
        return buffer;
    }

    public static void main(String[] args) {
        byte[] buffer = writeLong(123L);
        byte[] res = null;
        long result = readLong(buffer, new int[] { 0 });
        for (int i = 0; i < 10; i++) {
            if (null == res) {
                res = insertLong(buffer, i * 1000L);
            } else {
                res = insertLong(res, i * 1000L);
            }
            System.out.println(i + " 's last long " + getLastLong(res));
        }
        System.out.println("==============Deleting ================");
        res = removeLong(res);
        while(res.length >0 ){
            System.out.println(" last long " + getLastLong(res));
            res = removeLong(res);
        }
        System.out.println(result);
    }

}
