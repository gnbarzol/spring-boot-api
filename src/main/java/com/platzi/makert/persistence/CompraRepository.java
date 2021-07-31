package com.platzi.makert.persistence;

import com.platzi.makert.domain.Purchase;
import com.platzi.makert.domain.repository.PurchaseRepository;
import com.platzi.makert.persistence.crud.CompraCrudRepository;
import com.platzi.makert.persistence.entity.Compra;
import com.platzi.makert.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
//        Ahora seteamos la compra en cada producto para que sepan a cual pertenecen
        compra.getProductos().forEach(productos -> productos.setCompra(compra));
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
