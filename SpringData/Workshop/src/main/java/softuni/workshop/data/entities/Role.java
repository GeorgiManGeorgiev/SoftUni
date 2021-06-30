package softuni.workshop.data.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "roles")
public class Role extends BaseEntity implements GrantedAuthority {

   public Role() {
   }

   public Role(String authority) {
      this.authority = authority;
   }

   private String authority;

   @Override
   public String getAuthority() {
      return this.authority;
   }

   public void setAuthority(String authority) {
      this.authority = authority;
   }

}
