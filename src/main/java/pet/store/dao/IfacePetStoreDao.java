
// data layer interface.
package pet.store.dao;

import pet.store.entity.PetStoreDAO;

import org.springframework.data.jpa.repository.JpaRepository;
// 2b. create new interface PetStoreDao that extends JpaRepository<PetStore, Long>. Name altered 
public interface IfacePetStoreDao extends JpaRepository<PetStoreDAO, Long> {
	
	

}
