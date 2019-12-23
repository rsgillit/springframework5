package com.gill.sfgpetclinic.services;

import com.gill.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findNyLastName(String lastName);


}
