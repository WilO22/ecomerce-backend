package com.ecomerce.ecomerce_backend.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Imports nuevos para la relación entre tablas
import jakarta.persistence.ManyToOne; // Define que MUCHOS productos pueden pertenecer a UNA categoría
import jakarta.persistence.JoinColumn; // Define el nombre de la columna de llave foránea en la BD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;
     private BigDecimal price;
     private int stock;

     // =========================================================================
     // RELACIÓN CON LA TABLA CATEGORY
     // =========================================================================

     // @ManyToOne: Indica que MUCHOS registros de Product pueden estar
     // asociados a UN solo registro de Category.
     // En términos de base de datos: la tabla Product tendrá la llave foránea.
     @ManyToOne

     // @JoinColumn: Define cómo se llama la columna de llave foránea en la
     // tabla Product de la base de datos.
     // name = "id_category": La columna en la tabla Product se llamará "id_category"
     // y contendrá el ID de la categoría a la que pertenece este producto.
     @JoinColumn(name = "id_category")

     // Este campo almacena el objeto Category completo, no solo el ID.
     // JPA automáticamente:
     // 1. Guarda solo el ID en la columna id_category de la BD
     // 2. Al leer, carga el objeto Category completo usando ese ID
     private Category category;

}
