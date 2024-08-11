package com.example.financiera.IRepository;

import com.example.financiera.entity.TransaccionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionRepository extends CrudRepository<TransaccionEntity,Long> {

}
