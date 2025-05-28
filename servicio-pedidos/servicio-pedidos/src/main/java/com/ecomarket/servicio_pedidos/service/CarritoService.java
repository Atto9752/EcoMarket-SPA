package com.ecomarket.servicio_pedidos.service;

@Service
public class CarritoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    public Carrito agregarProductoAlCarrito(Long clienteId, Long productoId, int cantidad) {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Producto producto = productoRepository.findById(productoId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Carrito carrito = cliente.getCarrito();
        if (carrito == null) {
            carrito = new Carrito();
            carrito.setCliente(cliente);
            carrito.setItems(new ArrayList<>());
        }
            ItemCarrito nuevoItem = new ItemCarrito();
            nuevoItem.setProducto(producto);
            nuevoItem.setCantidad(cantidad);
            nuevoItem.setCarrito(carrito);
            carrito.getItems().add(nuevoItem);

        return carritoRepository.save(carrito);
    }
}
