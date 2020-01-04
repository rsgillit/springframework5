package com.gill.sfgpetclinic.services.springdatajpa;

import com.gill.sfgpetclinic.model.Owner;
import com.gill.sfgpetclinic.repositories.OwnerRepository;
import com.gill.sfgpetclinic.repositories.PetRepository;
import com.gill.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName("Smith");
    }

    @Test
    void findByLastName() {

        when(service.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName("Smith");
        assertEquals("Smith", smith.getLastName());

        verify(ownerRepository.findByLastName(any()));
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(1L);
        returnOwnersSet.add(owner);
        owner = new Owner();
        owner.setId(2L);
        returnOwnersSet.add(owner);
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());



    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}
