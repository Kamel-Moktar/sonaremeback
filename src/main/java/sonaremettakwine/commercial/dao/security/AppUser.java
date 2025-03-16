package sonaremettakwine.commercial.dao.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.ArrayList;
import java.util.Collection;



@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length =50)
    private String userName;
    @Column(length = 50,unique = true)
    String email;
    @Column(length = 15,unique = true)
    String telephoneNumber;
    @Column(length = 100)
    String password;
    Boolean mailActive=false;
    Boolean valide=false;
    Long codeActive;
    Boolean passwordExpired=false;
    @ManyToMany(fetch=FetchType.EAGER)
    Collection<AppRole> roles=new ArrayList<AppRole>();




}


