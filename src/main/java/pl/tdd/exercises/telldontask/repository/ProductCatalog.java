package pl.tdd.exercises.telldontask.repository;

import pl.tdd.exercises.telldontask.domain.Product;

public interface ProductCatalog {
    Product getByName(String name);
}
