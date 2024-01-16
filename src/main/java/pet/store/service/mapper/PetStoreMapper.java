package pet.store.service.mapper;

import java.util.Set;

import pet.store.controller.model.PetStoreData;
import pet.store.entity.PetStore;

public interface PetStoreMapper {

	PetStore petStoreDataToPetStore(PetStoreData petStoreData);
	PetStoreData petStoreToPetStoreData(PetStore petStore);
	Set<PetStore> listPetStoreDataToListPetStore(PetStoreData petStoreData);
	Set<PetStoreData> listPetStoreToListPetStoreData(PetStore petStore);

}
