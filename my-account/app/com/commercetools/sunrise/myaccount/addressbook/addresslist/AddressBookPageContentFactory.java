package com.commercetools.sunrise.myaccount.addressbook.addresslist;

import com.commercetools.sunrise.common.contexts.UserContext;
import com.commercetools.sunrise.common.models.AddressBeanFactory;
import com.commercetools.sunrise.common.reverserouter.AddressBookReverseRouter;
import io.sphere.sdk.customers.Customer;
import io.sphere.sdk.models.Address;
import io.sphere.sdk.models.Base;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddressBookPageContentFactory extends Base {

    @Inject
    private AddressBeanFactory addressBeanFactory;
    @Inject
    private AddressBookReverseRouter addressBookReverseRouter;
    @Inject
    private UserContext userContext;

    public AddressBookPageContent create(final Customer customer) {
        final AddressBookPageContent bean = new AddressBookPageContent();
        initialize(bean, customer);
        return bean;
    }

    protected final void initialize(final AddressBookPageContent content, final Customer customer) {
        fillDefaultShippingAddress(content, customer);
        fillDefaultBillingAddress(content, customer);
        fillAddresses(content, customer);
    }

    protected void fillDefaultShippingAddress(final AddressBookPageContent bean, final Customer customer) {
        customer.findDefaultShippingAddress()
                .ifPresent(address -> bean.setDefaultShippingAddress(createAddressInfo(address)));
    }

    protected void fillDefaultBillingAddress(final AddressBookPageContent bean, final Customer customer) {
        customer.findDefaultBillingAddress()
                .ifPresent(address -> bean.setDefaultBillingAddress(createAddressInfo(address)));
    }

    protected void fillAddresses(final AddressBookPageContent bean, final Customer customer) {
        final List<AddressInfoBean> beanList = customer.getAddresses().stream()
                .filter(address -> isNotAnyDefaultAddress(customer, address))
                .map(this::createAddressInfo)
                .collect(Collectors.toList());
        bean.setAddresses(beanList);
    }

    protected AddressInfoBean createAddressInfo(final Address address) {
        final AddressInfoBean bean = new AddressInfoBean();
        bean.setAddress(addressBeanFactory.create(address));
        bean.setAddressEditUrl(addressBookReverseRouter.changeAddressInAddressBookCall(userContext.languageTag(), address.getId()).url());
        bean.setAddressDeleteUrl(addressBookReverseRouter.removeAddressFromAddressBookProcessFormCall(userContext.languageTag(), address.getId()).url());
        return bean;
    }

    protected boolean isNotAnyDefaultAddress(final Customer customer, final Address address) {
        final boolean isNotDefaultShipping = !Objects.equals(address.getId(), customer.getDefaultShippingAddressId());
        final boolean isNotDefaultBilling = !Objects.equals(address.getId(), customer.getDefaultBillingAddressId());
        return isNotDefaultShipping && isNotDefaultBilling;
    }

}