package com.commercetools.sunrise.hooks;

import io.sphere.sdk.carts.Cart;

import java.util.concurrent.CompletionStage;

public interface PrimaryCartLoadedHook extends Hook {
    CompletionStage<Object> onUserCartLoaded(final Cart cart);
}
