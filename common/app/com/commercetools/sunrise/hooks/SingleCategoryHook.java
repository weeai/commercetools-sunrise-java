package com.commercetools.sunrise.hooks;

import com.commercetools.sunrise.hooks.Hook;
import io.sphere.sdk.categories.Category;

import java.util.concurrent.CompletionStage;

public interface SingleCategoryHook extends Hook {
    CompletionStage<?> onSingleCategoryLoaded(final Category category);
}

