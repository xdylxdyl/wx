package com.qding.framework.publics.util;

import java.util.Comparator;

import com.qding.framework.publics.model.MultiMessageRelation;

public class MessageComparator implements Comparator<MultiMessageRelation> {

	@Override
	public int compare(MultiMessageRelation o1, MultiMessageRelation o2) {

		Long v = o1.getLevel() - o2.getLevel();
		if (v > 0) {
			return 1;

		} else {
			if (v == 0) {
				return 0;
			} else {
				return -1;
			}

		}

	}

}
