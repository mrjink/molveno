package com.molvenolakeresort.controllers.restaurant;

import com.molvenolakeresort.models.restaurant.enums.SupplierOrderStatus;
import com.molvenolakeresort.models.restaurant.stock.Ingredient;
import com.molvenolakeresort.models.restaurant.stock.Supplier;
import com.molvenolakeresort.models.restaurant.stock.SupplyOrder;
import com.molvenolakeresort.models.restaurant.stock.SupplyOrderSupplierIngredient;
import com.molvenolakeresort.repositories.restaurant.stock.IngredientRepository;
import com.molvenolakeresort.repositories.restaurant.stock.SupplierRepository;
import com.molvenolakeresort.repositories.restaurant.stock.SupplyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/restaurant/supplyorder")
public class SupplyOrderController {

    @Autowired
    private final SupplyOrderRepository supplyOrderRepository;

    @Autowired
    private final IngredientRepository ingredientRepository;

    @Autowired
    private final SupplierRepository supplierRepository;

    public SupplyOrderController(SupplyOrderRepository supplyOrderRepository, IngredientRepository ingredientRepository, SupplierRepository supplierRepository) {
        this.supplyOrderRepository = supplyOrderRepository;
        this.ingredientRepository = ingredientRepository;
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/all")
    List<SupplyOrder> all() {
        return supplyOrderRepository.findAll();
    }

    @PostMapping("/add")
    public SupplyOrder addSupplyOrder(@RequestBody SupplyOrder supplyOrder) {
        Date deliveryDate = supplyOrder.getDeliveryDate();
        Date orderDate = supplyOrder.getOrderDate();
        SupplierOrderStatus supplierOrderStatus = supplyOrder.getSupplierOrderStatus();

        List<SupplyOrderSupplierIngredient> supplyOrderSupplierIngredients = new ArrayList<>();

        for (SupplyOrderSupplierIngredient supplyOrderSupplierIngredient : supplyOrder.getSupplyOrderSupplierIngredients()) {
            Long idIngredient = supplyOrder.getSupplyOrderSupplierIngredients().get(0).getIngredient().getId();
            Long idSupplier = supplyOrder.getSupplyOrderSupplierIngredients().get(0).getSupplier().getId();
            double quantity = supplyOrder.getSupplyOrderSupplierIngredients().get(0).getQuantity();

            //debug
            System.out.println(idIngredient); //Geeft CORRECT het idIngredient terug.
            System.out.println(idSupplier); //DIT is null. WAAROM? HIER VERDER GAAN

            Ingredient ingredient = ingredientRepository.findById(idIngredient).get();
            Supplier supplier = supplierRepository.findById(idSupplier).get();

            supplyOrderSupplierIngredients.add(new SupplyOrderSupplierIngredient(ingredient, supplier, quantity));
        }

        supplyOrder.setDeliveryDate(deliveryDate);
        supplyOrder.setOrderDate(orderDate);
        supplyOrder.setSupplierOrderStatus(supplierOrderStatus);
        supplyOrder.setSupplyOrderSupplierIngredients(supplyOrderSupplierIngredients);

        return supplyOrderRepository.save(supplyOrder);
    }

    @PostMapping(value = "/test", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public String TestPOSTJson(HttpEntity<String> httpEntity) {
        String json = httpEntity.getBody();
        // json contains the plain json string

        System.out.println(json);

        return null;
    }

    @GetMapping("/get/{id}")
    public SupplyOrder getSupplyOrder(@PathVariable Long id) throws EntityNotFoundException {

        return supplyOrderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    //
    @PutMapping("/update/{id}")
    public SupplyOrder updateSupplyOrder(@RequestBody SupplyOrder updatedSupplyOrder, @PathVariable Long id) {
        return supplyOrderRepository.save(updatedSupplyOrder);
    }

    //
    @DeleteMapping("/delete/{id}")
    public void deleteSupplyOrder(@PathVariable Long id) {
        supplyOrderRepository.deleteById(id);
    }
}
