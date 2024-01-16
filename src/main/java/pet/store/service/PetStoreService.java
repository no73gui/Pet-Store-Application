
package pet.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;
import pet.store.service.mapper.PetStoreMapper;

// class-level annotations @Service to denote service class/
@Service
public class PetStoreService {

	// 3d. create new PetStoreDAO object. Annotate instance with @Autowired so that
	// Spring can inject DAO object into a variable.
	@Autowired
	private PetStoreDao dao;// annotate field.

	@Autowired
	private PetStoreMapper mapper;
	// 5. create savePetStoreData method that takes a PetStoreData object. Names
	// modified
	public PetStoreData save(Long petStoreId, PetStore ps) {
		// 5a. This method call will return a DTOPetStoreData if the pet store id is
		// null.
		// if the petStoreId is not null, the method should call findPetStoreById, which
		// will return a PetStoreDAO object if PetStore has has a matching id.

		// retrieve the id of petStoreData
		boolean exists = dao.existsById(petStoreId);
		if (exists) {
			PetStore nps = dao.getReferenceById(petStoreId);
			dao.save(nps);
		} else {
			PetStore nps = new PetStore();
			dao.save(nps);
		}
		ResponseEntity<String> response = ResponseEntity.ok("Employee Saved Successfully.");
		System.out.println(response);
		return mapper.petStoreToPetStoreData(ps);
	}




	public PetStoreData find(Long petStoreId) {

		PetStore petStore = dao.getReferenceById(petStoreId);
		return mapper.petStoreToPetStoreData(petStore);

	}

	public PetStoreData update(Long petStoreId, String petStoreName,
			String phone) {
		if(dao.existsById(petStoreId)) {
			PetStore ps = dao.getReferenceById(petStoreId);
			ps.setPetStoreName(petStoreName);
			ps.setPetStorePhone(phone);
		dao.save(ps);
		}
		return mapper.petStoreToPetStoreData(dao.getReferenceById(petStoreId));

	}

	public PetStoreData delete(Long petStoreId) {
		if(dao.existsById(petStoreId)) {
			dao.deleteById(petStoreId);
		}
		return mapper.petStoreToPetStoreData(dao.getReferenceById(petStoreId));
	}

}
