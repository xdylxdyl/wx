package com.gemantic.dal.dao.model;

import java.util.List;

import com.gemantic.dal.dao.helper.ListInfoHelper;
import com.gemantic.dal.dao.helper.LsCacheInfoHelper;

public class SectionInfo {

    private Long sectionNo;
    private LsCacheInfoHelper lsHelper;
    private ListInfoHelper infoHelper;
    private List idList;
    private Number[] minMax;
    private Object latestId;

    public SectionInfo( Long no, ListInfoHelper helper, List list,LsCacheInfoHelper lshepler,Number[] minMaxs) {
        sectionNo = no;
        infoHelper = helper;
        idList = list;
        lsHelper = lshepler;
        minMax = minMaxs;
    }

    public Long getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(Long sectionNo) {
        this.sectionNo = sectionNo;
    }

    public ListInfoHelper getInfoHelper() {
        return infoHelper;
    }

    public void setInfoHelper(ListInfoHelper infoHelper) {
        this.infoHelper = infoHelper;
    }

    public List getIdList() {
        return idList;
    }

    public void setIdList(List idList) {
        this.idList = idList;
    }

	public LsCacheInfoHelper getLsHelper() {
		return lsHelper;
	}

	public void setLsHelper(LsCacheInfoHelper lsHelper) {
		this.lsHelper = lsHelper;
	}

	public Number[] getMinMax() {
		return minMax;
	}

	public void setMinMax(Number[] minMax) {
		this.minMax = minMax;
	}

	public Object getLatestId() {
		return latestId;
	}

	public void setLatestId(Object latestId) {
		this.latestId = latestId;
	}



}
