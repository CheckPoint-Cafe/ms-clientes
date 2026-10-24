package cl.checkpoint.clientes.service;

import cl.checkpoint.clientes.model.Cliente;
import cl.checkpoint.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    public Cliente crear(Cliente item) {
        return repo.save(item);
    }

    public Cliente actualizar(Long id, Cliente item) {
        Cliente actual = obtener(id);
        if (item.getNombre() != null)
            actual.setNombre(item.getNombre());
        if (item.getCorreo() != null)
            actual.setCorreo(item.getCorreo());
        if (item.getTelefono() != null)
            actual.setTelefono(item.getTelefono());
        return repo.save(actual);
    }

    public void eliminar(Long id) {
        obtener(id);
        repo.deleteById(id);
    }

}
