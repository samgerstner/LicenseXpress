package pro.samgerstner.licensexpress.entities;

import jakarta.persistence.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "application_users")
public class ApplicationUser
{
   @Id
   private String username;

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   private String email;

   private String password;

   @Column(name = "account_activated")
   private boolean accountActivated;

   @Column(name = "activation_token")
   private String activationToken;

   @Column(name = "activation_token_expiry")
   private String activationTokenExpiry;

   @ManyToMany
   private List<ApplicationRole> roles;

   @OneToMany
   private List<ProductKey> productKeys;

   public ApplicationUser() {}

   public ApplicationUser (String username, String firstName, String lastName, String email, String password, boolean accountActivated)
   {
      this.username = username;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
      this.accountActivated = accountActivated;
   }

   public String getUsername ()
   {
      return username;
   }

   public void setUsername (String username)
   {
      this.username = username;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getEmail ()
   {
      return email;
   }

   public void setEmail (String email)
   {
      this.email = email;
   }

   public String getPassword ()
   {
      return password;
   }

   public void setPassword (String password)
   {
      this.password = password;
   }

   public boolean isAccountActivated ()
   {
      return accountActivated;
   }

   public void setAccountActivated (boolean accountActivated)
   {
      this.accountActivated = accountActivated;
   }

   public String getActivationToken ()
   {
      return activationToken;
   }

   public void setActivationToken (String activationToken)
   {
      this.activationToken = activationToken;
   }

   public String getActivationTokenExpiry ()
   {
      return activationTokenExpiry;
   }

   public void setActivationTokenExpiry (String activationTokenExpiry)
   {
      this.activationTokenExpiry = activationTokenExpiry;
   }

   public List<ApplicationRole> getRoles ()
   {
      return roles;
   }

   public void setRoles (List<ApplicationRole> roles)
   {
      this.roles = roles;
   }

   public List<ProductKey> getProductKeys ()
   {
      return productKeys;
   }

   public void setProductKeys (List<ProductKey> productKeys)
   {
      this.productKeys = productKeys;
   }

   public void startActivation()
   {
      LocalDateTime expiration = LocalDateTime.now();
      expiration = expiration.plusHours(2);
      DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

      this.activationToken = generateActivationToken();
      this.activationTokenExpiry = format.format(expiration);
   }

   private String generateActivationToken()
   {
      String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*!";
      StringBuilder builder = new StringBuilder();
      Random random = new Random();

      for(int index = 0; index < 128; index++)
      {
         int randomIndex = random.nextInt(characters.length());
         builder.append(characters.charAt(randomIndex));
      }

      return builder.toString();
   }

   public String encodeActivationToken()
   {
      String encodedToken = null;

      try
      {
         encodedToken = URLEncoder.encode(this.activationToken, StandardCharsets.UTF_8);
         return encodedToken;
      }
      catch(Exception e)
      {
         e.printStackTrace();
         return null;
      }
   }
}