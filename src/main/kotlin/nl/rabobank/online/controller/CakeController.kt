package nl.rabobank.online.controller

import kotlinx.coroutines.flow.Flow
import nl.rabobank.online.model.Cake
import nl.rabobank.online.service.CakeService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cake")
class CakeController(val cakeService: CakeService) {

    @GetMapping("/{id}")
    suspend fun getCakeById(@PathVariable id: Int) : Cake? {
        return cakeService.getCakeById(id)
    }

    @GetMapping
    suspend fun getFlavourCakes(@RequestParam flavour: String) : Flow<Cake> {
        return cakeService.findAllCakesOfAFlavour(flavour)
    }

    @PostMapping
    suspend fun saveCake(@RequestBody cake: Cake) : Cake? {
        return cakeService.storeCake(cake)
    }

    @PutMapping
    suspend fun updateCake(@RequestBody cake: Cake) : Cake? {
        return cakeService.updateCake(cake)
    }

    @DeleteMapping
    suspend fun deleteCake(@RequestBody cake: Cake) : Unit {
        return cakeService.deleteCake(cake)
    }


}