package azureapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import azureapi.Models.Roles;
import azureapi.repositories.RolesRepository;

@Service
public class RolServiceImpl implements RoleService {

	@Autowired
	RolesRepository	entityRepository;
	
	@Override
	public List<Roles> findByNameLike(String name) {
		return entityRepository.findByNombreLike(name);
	}

	@Override
	public Optional<Roles> findByName(String nombre) {
		return Optional.ofNullable(entityRepository.findByNombre(nombre).get());
	}

	@Override
	public Roles save(Roles pRoles) {
		return entityRepository.save(pRoles);
	}

	@Override
	public boolean deleteById(int id) {
		boolean blnDeleted = false;
		try {
			entityRepository.deleteById(id);
			blnDeleted = true;
		} catch (Exception e) {
			blnDeleted = false;
		}
		return blnDeleted;
	}

}
