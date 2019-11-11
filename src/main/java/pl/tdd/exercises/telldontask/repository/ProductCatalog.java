package pl.tdd.exercises.telldontask.repository;

import it.gabrieletondi.telldontaskkata.domain.Product;

public interface ProductCatalog {
    Product getByName(String name);
}
