package com.ifpe.veterinario.service;


import com.ifpe.veterinario.exceptions.TelefoneServiceException;
import com.ifpe.veterinario.models.Telefone;
import com.ifpe.veterinario.repositiry.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTelefone {

    @Autowired
    TelefoneRepository telefoneRepository;

    public List<Telefone> findByOwnerRg(String rg){

        return telefoneRepository.findByRg(rg);
    }


}
