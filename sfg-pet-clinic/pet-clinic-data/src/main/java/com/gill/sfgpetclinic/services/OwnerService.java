package com.gill.sfgpetclinic.services;

import com.gill.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findNyLastName(String lastName);

    Owner findById(Long id) ;

    Owner save(Owner owner);

    Set<Owner> findAll();
}
