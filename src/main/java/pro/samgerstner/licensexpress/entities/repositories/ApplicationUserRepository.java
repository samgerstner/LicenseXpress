package pro.samgerstner.licensexpress.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.samgerstner.licensexpress.entities.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String>
{
}