package pro.samgerstner.licensexpress.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pro.samgerstner.licensexpress.entities.ApplicationRole;
import pro.samgerstner.licensexpress.entities.ApplicationUser;
import pro.samgerstner.licensexpress.entities.repositories.ApplicationRoleRepository;
import pro.samgerstner.licensexpress.entities.repositories.ApplicationUserRepository;
import java.util.Arrays;

@Component
public class ApplicationStartupRunner implements CommandLineRunner
{
   @Autowired
   private ApplicationUserRepository applicationUserRepository;

   @Autowired
   private ApplicationRoleRepository applicationRoleRepository;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @Value("${application.startup.adminUsername}")
   private String adminUsername;

   @Value("${application.startup.adminEmail}")
   private String adminEmail;

   @Value("${application.startup.adminPassword}")
   private String adminPassword;

   @Override
   public void run(String...args) throws Exception
   {
      if(applicationRoleRepository.count() == 0)
      {
         ApplicationRole role1 = new ApplicationRole("ROLE_SUPER_ADMIN", "Super Admin");
         ApplicationRole role2 = new ApplicationRole("ROLE_ADMIN", "Admin");
         ApplicationRole role3 = new ApplicationRole("ROLE_CLIENT", "Client");
         ApplicationRole role4 = new ApplicationRole("ROLE_CLIENT_MANAGER", "Client Manager");
         ApplicationRole role5 = new ApplicationRole("ROLE_PRODUCT_MANAGER", "Product Manager");
         ApplicationRole role6 = new ApplicationRole("ROLE_KEY_MANAGER", "Product Key Manager");
         ApplicationRole[] roles = {role1, role2, role3, role4, role5, role6};
         applicationRoleRepository.saveAll(Arrays.asList(roles));

         ApplicationUser user = new ApplicationUser(adminUsername, "Admin", "User",
               adminEmail, passwordEncoder.encode(adminPassword), true);
         ApplicationRole[] adminRoles = {role1};
         user.setRoles(Arrays.asList(adminRoles));
         applicationUserRepository.save(user);
      }
   }
}