package pet.store.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.store.controller.model.DTOPetStoreData;
import pet.store.entity.PetStoreDAO;

// class-level annotations @Service to denote service class/
@Service
public class PetStoreService {
	
	// 3d. create new PetStoreDAO object. Annotate instance with @Autowired so that Spring can inject DAO object into a variable.
	@Autowired
	private PetStoreDAO petStoreDao;// annotate field.
	
	// 5. create savePetStoreData method that takes a PetStoreData object. Names modified
	public DTOPetStoreData savePetStore(DTOPetStoreData petStoreData) throws NoSuchElementException{
		// 5a. This method call will return a DTOPetStoreData if the pet store id is null.
		// if the petStoreId is not null, the method should call findPetStoreById, which will return a PetStoreDAO object if PetStore has has a matching id.
		
		// retrieve the id of petStoreData
		Long pSId = petStoreDao.getPetStoreId();
		PetStoreDAO petStoreDAO = findOrCreatePetStoreDAO(pSId);
		
		
		if(pSId == null) {
			
		}
		
		
	}
	
	public PetStoreDAO findOrCreatePetStoreDAO(Long petStoreId){
		PetStoreDAO newPetStoreDAO = new PetStoreDAO();
		if(petStoreId == null) {
			
			catch NoSuchElementException;
			
		}
		
	}
	
}
