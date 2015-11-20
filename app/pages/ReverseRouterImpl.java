package pages;

import common.pages.ReverseRouter;
import io.sphere.sdk.models.Base;
import play.mvc.Call;
import purchase.routes;

public class ReverseRouterImpl extends Base implements ReverseRouter {

    @Override
    public Call category(final String language, final String slug, final int page) {
        return productcatalog.controllers.routes.ProductOverviewPageController.show(language, slug, page);
    }

    @Override
    public Call processCheckoutShippingForm(final String language) {
        return routes.CheckoutShippingController.process(language);
    }

    @Override
    public Call showCheckoutShippingForm(final String language) {
        return routes.CheckoutShippingController.show(language);
    }
    
    @Override
    public Call processCheckoutPaymentForm(final String language) {
        return routes.CheckoutPaymentController.process(language);
    }

    @Override
    public Call showCheckoutPaymentForm(final String language) {
        return routes.CheckoutPaymentController.show(language);
    }

    @Override
    public Call showCheckoutConfirmationForm(final String language) {
        return routes.CheckoutPaymentController.show(language);
    }
}