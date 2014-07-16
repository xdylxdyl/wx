package com.gemantic.dal.dao.util;

import java.util.Comparator;

public class SectionComparator implements Comparator<Integer> {

    public int compare(Integer v1, Integer v2) {
        int sec1 = v1.intValue();
        int sec2 = v2.intValue();
        return (sec1 < sec2 ? 1 : (sec1 == sec2 ? 0 : -1));
    }
}
