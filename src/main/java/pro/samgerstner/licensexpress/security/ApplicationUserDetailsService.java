package pro.samgerstner.licensexpress.security;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ApplicationUserDetailsService implements UserDetailsService
{
   @Autowired
   private ApplicationUserRepository userRepo;

   @Override
   public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException
   {
      //Get user from the database
      ApplicationUser user = userRepo.findById(username).orElseThrow(() ->
            new UsernameNotFoundException("Username " + username + " not found!"));

      //Verify that user is active
      if(!user.isAccountActivated()) { throw new UsernameNotFoundException("Account with the username " + username + " has not been activated!"); }

      //Return user information
      return new User(user.getUsername(), user.getPassword(), user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getId())).toList());
   }
}