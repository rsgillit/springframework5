package com.gill.sfgpetclinic.services;

import com.gill.sfgpetclinic.model.Person;
import com.gill.sfgpetclinic.model.Vet;

public interface VetService<V extends Person, L extends Number> extends CrudService<Vet, Long> {


}
