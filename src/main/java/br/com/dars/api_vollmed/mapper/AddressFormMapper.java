package br.com.dars.api_vollmed.mapper;

import br.com.dars.api_vollmed.domain.Address;
import br.com.dars.api_vollmed.dto.AddressForm;
import org.springframework.stereotype.Component;

@Component
public class AddressFormMapper {

    public Address map(AddressForm addressForm) {
        Address address = new Address();
        address.setCity(addressForm.city());
        address.setState(addressForm.state());
        address.setStreet(addressForm.street());
        address.setNumber(addressForm.number());
        address.setZipcode(addressForm.zipcode());
        address.setNeighborhood(addressForm.neighborhood());
        address.setComplement(addressForm.complement());
        return address;
    }
}
