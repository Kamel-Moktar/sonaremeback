package sonaremettakwine.commercial.dao.module;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ModuleRepository extends JpaRepository<Module, Long> {

    List<Module> findAllByOrderByIdDesc();

  List<Module> findByNameLikeAndDomaineNameLikeOrderByIdDesc(String name,String domaineName);
}
