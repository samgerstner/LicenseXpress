package pro.samgerstner.licensexpress.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.samgerstner.licensexpress.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String>
{
}