package io.sphere.sdk.facets;

import io.sphere.sdk.models.Base;
import io.sphere.sdk.search.TermFacetResult;
import io.sphere.sdk.search.TermStats;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FacetOption<T> extends Base {
    private final T term;
    private final long count;
    private final boolean selected;

    FacetOption(final T term, final long count, final boolean selected) {
        this.term = term;
        this.count = count;
        this.selected = selected;
    }

    public T getTerm() {
        return term;
    }

    public long getCount() {
        return count;
    }

    public boolean isSelected() {
        return selected;
    }

    public static <T> FacetOption<T> of(final T term, final long count, final boolean selected) {
        return new FacetOption<>(term, count, selected);
    }

    public static <T> FacetOption<T> ofTermStats(final TermStats<T> termStats, final List<T> selectedValues) {
        return FacetOption.of(termStats.getTerm(), termStats.getCount(), selectedValues.contains(termStats.getTerm()));
    }

    public static <T> List<FacetOption<T>> ofFacetResult(final TermFacetResult<T> facetResult, final List<T> selectedValues) {
        return facetResult.getTerms().stream()
                .map(termStats -> ofTermStats(termStats, selectedValues))
                .collect(toList());
    }
}