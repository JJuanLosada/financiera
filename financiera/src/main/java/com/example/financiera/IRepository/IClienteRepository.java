package com.example.financiera.IRepository;


import com.example.financiera.entity.ClienteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteRepository extends CrudRepository<ClienteEntity,Long> {



}
