package nl.rabobank.online.service

import kotlinx.coroutines.flow.Flow
import nl.rabobank.online.model.Cake
import nl.rabobank.online.repository.CakeRepository
import org.springframework.stereotype.Component

@Component
class CakeService(val cakeRepository: CakeRepository) {

    suspend fun getCakeById(id: Int) : Cake? {
        return cakeRepository.findById(id)
    }

    suspend fun storeCake(cake: Cake) : Cake? {
        return cakeRepository.save(cake)
    }

    suspend fun updateCake(cake: Cake) : Cake? {
        return cakeRepository.save(cake)
    }

    suspend fun deleteCake(cake: Cake) : Unit {
        return cakeRepository.delete(cake)
    }

    suspend fun findAllCakesOfAFlavour(flavour: String) : Flow<Cake> {
        return cakeRepository.findByFlavour(flavour)
    }
}