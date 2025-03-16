
package sonaremettakwine.commercial.dao.security;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
    @Query("select u from AppUser u order by u.userName" )
    List<AppUser> findAllUserOrderBySocialeRaison();
    @Query("select u from AppUser u where  not(u=:us) order by u.userName  " )
    List<AppUser> findUsersByEntrepriseOrderByUserName(@RequestParam AppUser us);
    AppUser findAppUserById(Long id);
    @Query("select u from AppUser u where u.userName =:name and u.mailActive=true and u.valide=true")
    AppUser findActiveUserByName(String name);

    AppUser findAppUserByEmail(String email);
    AppUser findAppUserByTelephoneNumber(String telephoneNumber);
}
