package nl.rabobank.online.repository

import kotlinx.coroutines.flow.Flow
import nl.rabobank.online.model.Cake
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface CakeRepository : CoroutineCrudRepository<Cake, Int> {

    @Query("Select * from cakes c where c.flavour = :flavour")
    fun findByFlavour(flavour: String): Flow<Cake>

}