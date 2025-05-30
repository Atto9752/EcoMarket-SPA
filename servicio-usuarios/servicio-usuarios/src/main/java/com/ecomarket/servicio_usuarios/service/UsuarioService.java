package com.ecomarket.servicio_usuarios.service;

@Service
public class UsuarioService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private GerenteTiendaRepository gerenteTiendaRepository;

    @Autowired
    private LogisticaRepository logisticaRepository;

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Admin crearAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public GerenteTienda crearGerente(GerenteTienda gerente) {
        return gerenteTiendaRepository.save(gerente);
    }

    public Logistica crearLogistica(Logistica logistica) {
        return logisticaRepository.save(logistica);
    }

    Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreoUsuario(correo.trim());

    public Usuario autenticar(String correo, String contrasena) {
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if (usuario.getContrasenaUsuario().trim().equals(contrasena.trim())) {
                return usuario;
            }   
        }
        return null;
    }
}
