package com.liv2train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liv2train.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
