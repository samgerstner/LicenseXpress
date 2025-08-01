package pro.samgerstner.licensexpress.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "application_roles")
public class ApplicationRole
{
   @Id
   private String id;

   @Column(unique = true, nullable = false)
   private String name;

   @ManyToMany
   private List<ApplicationUser> users;

   public ApplicationRole() {}

   public ApplicationRole(String id, String name)
   {
      this.id = id;
      this.name = name;
   }

   public String getId ()
   {
      return id;
   }

   public void setId (String id)
   {
      this.id = id;
   }

   public String getName ()
   {
      return name;
   }

   public void setName (String name)
   {
      this.name = name;
   }

   public List<ApplicationUser> getUsers ()
   {
      return users;
   }

   public void setUsers (List<ApplicationUser> users)
   {
      this.users = users;
   }
}