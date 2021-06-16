package br.com.repository;

import br.com.model.Estoque;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends MongoRepository<Estoque, String> {
}
