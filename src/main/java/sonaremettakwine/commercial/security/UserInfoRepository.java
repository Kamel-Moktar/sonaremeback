package sonaremettakwine.commercial.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    Optional<UserInfo> findByName(String name);

    @Query("select u from UserInfo  u order by u.name " )
    List<UserInfo> getAllOrderByName();

    @Query("select u from  UserInfo  u where upper(u.name)= upper(:currentUserName)")
    UserInfo findUserByName(@RequestParam String currentUserName);

    UserInfo getUserById(Long id);

}
