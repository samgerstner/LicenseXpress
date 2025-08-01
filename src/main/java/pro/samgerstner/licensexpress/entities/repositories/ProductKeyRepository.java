package pro.samgerstner.licensexpress.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.samgerstner.licensexpress.entities.ProductKey;
import pro.samgerstner.licensexpress.entities.ProductKeyId;

public interface ProductKeyRepository extends JpaRepository<ProductKey, ProductKeyId>
{
}