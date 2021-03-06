package com.commercetools.sunrise.productcatalog.productdetail;

import io.sphere.sdk.client.SphereClient;
import io.sphere.sdk.products.ByIdVariantIdentifier;
import io.sphere.sdk.products.ProductProjection;
import io.sphere.sdk.products.ProductVariant;
import io.sphere.sdk.products.search.ProductProjectionSearch;
import io.sphere.sdk.search.PagedSearchResult;
import play.libs.concurrent.HttpExecution;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.function.UnaryOperator;

public final class ProductFinderByProductIdAndVariantId implements ProductFinder<String, Integer> {
    @Inject
    private SphereClient sphereClient;

    @Override
    public CompletionStage<ProductFinderResult> findProduct(final String productId,
                                                            final Integer variantId,
                                                            final UnaryOperator<ProductProjectionSearch> runHookOnProductSearch) {
        final ProductProjectionSearch request = ProductProjectionSearch.ofCurrent().withQueryFilters(m -> m.id().is(productId));
        return sphereClient.execute(runHookOnProductSearch.apply(request))
                .thenApplyAsync(PagedSearchResult::head, HttpExecution.defaultContext())
                .thenApplyAsync(productOptional -> {
                    final ProductProjection product = productOptional.orElse(null);
                    final ProductVariant productVariant = productOptional
                            .flatMap(p -> p.findVariant(ByIdVariantIdentifier.of(productId, variantId)))
                            .orElse(null);
                    return ProductFinderResult.of(product, productVariant);
                }, HttpExecution.defaultContext());
    }
}
