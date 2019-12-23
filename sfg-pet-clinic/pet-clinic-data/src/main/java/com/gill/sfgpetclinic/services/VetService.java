package com.gill.sfgpetclinic.services;

import com.gill.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id) ;

    Vet save(Vet Vet);

    Set<Vet> findAll();
}
