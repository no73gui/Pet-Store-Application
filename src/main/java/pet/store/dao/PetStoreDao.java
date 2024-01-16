// data layer interface.
package pet.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.PetStore;
// 2b. create new interface PetStoreDao that extends JpaRepository<PetStore, Long>. Name altered
public interface PetStoreDao extends JpaRepository<PetStore, Long> {

}
