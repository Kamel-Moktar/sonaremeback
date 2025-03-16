package sonaremettakwine.commercial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {
@Autowired
    RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }
    public Role getRoleById(Long id){
        return    roleRepository.getReferenceById(id);
    }
}
