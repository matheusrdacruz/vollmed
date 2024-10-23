package br.com.dars.api_vollmed.repository;

import br.com.dars.api_vollmed.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
