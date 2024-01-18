
package pet.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;
import pet.store.service.mapper.PetStoreMapper;

@Slf4j
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

	@Transactional(readOnly = false)
	public PetStoreData save() {
		// 5a. This method call will return a DTOPetStoreData if the pet store id is
		// null.
		// if the petStoreId is not null, the method should call findPetStoreById, which
		// will return a PetStoreDAO object if PetStore has has a matching id.

		// retrieve the id of petStoreData
		PetStore ps = new PetStore();
		dao.save(ps);
		log.info("POST request recieved. New Pet Store Object created in datasource with ID: {}", ps.getPetStoreId());
		return mapper.petStoreToPetStoreData(ps);
	}

	public PetStoreData find(Long petStoreId) {
		if (dao.existsById(petStoreId)) {
			PetStore ps = dao.getReferenceById(petStoreId);
			log.info("GET request recvieved for existing Pet Store with ID : {} ", petStoreId);
			return mapper.petStoreToPetStoreData(ps);
		} else {
			log.warn("GET request recieved for Pet Store with ID {} could not be processed.", petStoreId);
			throw new EntityNotFoundException();
		}

	}

	@Transactional
	public PetStoreData update(Long petStoreId, String petStoreName, String phone) {
		if(petStoreId != null) {
			if(dao.existsById(petStoreId)) {
			PetStore ps = dao.getReferenceById(petStoreId);
			// Entity with petStoreId exists in the database
			ps.setPetStoreName(petStoreName);
			ps.setPetStorePhone(phone);
			dao.save(ps);
			
			log.info("Pet Store {} updated in datasource.");

			return mapper.petStoreToPetStoreData(ps);
			} else {
				throw new EntityNotFoundException("Pet Store With ID : " + petStoreId + " was not found in the datasource.");
			}
		
		} else {
			throw new IllegalArgumentException("ID Must not be null!");
		}

	}

	@Transactional
	public PetStoreData delete(Long petStoreId) {

		if (petStoreId != null) {
			PetStore ps = dao.findById(petStoreId).orElseThrow();
			dao.delete(ps);
			dao.save(ps);
			log.info("Pet Store {} deleted from datasource.", ps);
		}
		return mapper.petStoreToPetStoreData(dao.findById(petStoreId).orElseThrow());

	}

}
