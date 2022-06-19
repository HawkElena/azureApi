package azureapi.Services;

import java.util.List;
import java.util.Optional;

import azureapi.Models.Roles;

public interface RoleService {

	
	public List<Roles> findByNameLike(String name);
	public Optional<Roles> findByName(String nombre);
	Roles save(Roles pRoles);
	boolean deleteById(int  id);
}
