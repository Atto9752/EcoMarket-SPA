package com.ecomarket.servicio_pedidos.model;
import com.ecomarket.servicio_productos.model;

@Entity
@Table(name = "items_carrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muchos items pertenecen a un carrito
    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    // Un producto por item
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private int cantidad;
}
