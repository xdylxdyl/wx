package com.gemantic.dal.id.util;

/**
 * @author arthurkang
 * 
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializeUtil {

    // @todo 实现文件的名字可以定制，和通过JMX监控
    private static final String fileName = "sequenceList.dat";

    public static void writeObject(Object obj) {
        try {
            if (null != obj) {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
                out.writeObject(obj);
                out.flush();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return;
        }
    }

    public static Object readObject() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            return in.readObject();
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

}
