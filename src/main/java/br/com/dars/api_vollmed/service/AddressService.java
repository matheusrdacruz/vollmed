package br.com.dars.api_vollmed.service;

import br.com.dars.api_vollmed.domain.Address;
import br.com.dars.api_vollmed.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(Address address) {
        return this.addressRepository.save(address);
    }
}
