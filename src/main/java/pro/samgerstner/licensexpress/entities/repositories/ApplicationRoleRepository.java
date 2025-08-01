package pro.samgerstner.licensexpress.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.samgerstner.licensexpress.entities.ApplicationRole;

public interface ApplicationRoleRepository extends JpaRepository<ApplicationRole, String>
{
}