package com.platzi.makert.persistence.mapper;

import com.platzi.makert.domain.Product;
import com.platzi.makert.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"), // Al definir el uses arriba en el mapper sabe que debe usar ese mapper para traducir
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos); // Automaticamente usa el mapper de arriba para traducir

    @InheritInverseConfiguration // Invirte la configuracion del mapping de arriba source <-> target
    @Mapping(target = "codigoBarras", ignore = true) // En Producto ignoramos codigoBarras porque no lo tenemos en product
    Producto toProducto(Product product);
}
