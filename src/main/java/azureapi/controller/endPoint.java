package azureapi.controller;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import azureapi.Models.Roles;
import azureapi.repositories.RolesRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/modulo")
public class endPoint {
	
	@Autowired
	RolesRepository entityService;
	
	@GetMapping("/endpoint")
	public String getEndPoint() {
		return "The first api in azure...!! hawk";
	}

	@PostMapping("/roles")
	@Transactional
	List<Roles> listaRoles(@RequestBody Roles pEntity){
		List<Roles> lstEntityRet = new ArrayList<Roles>();
		Roles entityInterno = new Roles();
		
		if(pEntity.get_opcionDML()== 1 || pEntity.get_opcionDML() == 3 ) {
			entityInterno = entityService.save(pEntity);
			entityInterno.set_message("the register was inserted successfully...");			
			entityInterno.set_opcionDML(pEntity.get_opcionDML());
			lstEntityRet.add(entityInterno);
		}else if(pEntity.get_opcionDML()== 2) {
			
			if(entityService.deleteById(pEntity.getId())) {
				entityInterno.set_message("the register was deleted successfully..." + pEntity.getId());
				entityInterno.set_opcionDML(pEntity.get_opcionDML());
			}else {
				entityInterno.set_message("something was wrong chek all parameters..." + pEntity.getId());
				entityInterno.set_opcionDML(pEntity.get_opcionDML());
			}
			lstEntityRet.add(entityInterno);
		}else if(pEntity.get_opcionDML() == 4) {
			
			List<Roles> lstEntityB =  entityService.findByNombreLike(pEntity.getNombre());

			lstEntityRet= lstEntityB;
		};
		

		return lstEntityRet;
	}
		
}
