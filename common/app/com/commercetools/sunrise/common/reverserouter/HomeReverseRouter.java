package com.commercetools.sunrise.common.reverserouter;

import play.mvc.Call;

public interface HomeReverseRouter {

    Call homePageCall(final String languageTag);

}
