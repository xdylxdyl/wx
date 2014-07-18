package com.qding.framework.publis.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.qding.framework.publics.model.MultiMessageRelation;
import com.qding.framework.publics.util.MessageComparator;

public class CollectionUtilTest {
	private static final Log log = LogFactory.getLog(CollectionUtilTest.class);

	@Test
	public void testNull() {
		List<MultiMessageRelation> ls = new ArrayList();

		MultiMessageRelation mr = new MultiMessageRelation();
		mr.setLevel(1L);

		MultiMessageRelation mr2 = new MultiMessageRelation();
		mr2.setLevel(2L);

		MultiMessageRelation mr3 = new MultiMessageRelation();
		mr3.setLevel(3L);

		ls.add(mr2);
		ls.add(mr);
		ls.add(mr3);
		log.info(ls);

		MessageComparator comparator = new MessageComparator();
		Collections.sort(ls, comparator);
		log.info(ls);

	}
}
