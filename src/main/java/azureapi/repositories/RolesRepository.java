package azureapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import azureapi.Models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
	public Optional<Roles> findByNombre(String nombre);
	public Optional<Roles> findById(int id); //add today 03/31/22
	public Boolean existsById(int id); //add today 03/31/22
	public List<Roles> findByNombreLike(String name);
	boolean  deleteById(Integer id);
	
}