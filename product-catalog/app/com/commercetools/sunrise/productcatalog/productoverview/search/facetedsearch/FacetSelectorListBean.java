package com.commercetools.sunrise.productcatalog.productoverview.search.facetedsearch;

import com.commercetools.sunrise.common.models.ModelBean;

import java.util.List;

public class FacetSelectorListBean extends ModelBean {

    private List<FacetSelectorBean> list;

    public FacetSelectorListBean() {
    }

    public List<FacetSelectorBean> getList() {
        return list;
    }

    public void setList(final List<FacetSelectorBean> list) {
        this.list = list;
    }
}
