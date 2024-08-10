package com.example.financiera.IRepository;

import com.example.financiera.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IProductoRepository extends CrudRepository<ProductoEntity,Long> {

}
