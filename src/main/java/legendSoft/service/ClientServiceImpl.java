package legendSoft.service;

import legendSoft.exception.BadCredentialsException;
import legendSoft.exception.NotFoundException;
import legendSoft.model.Client;
import legendSoft.repository.ClientRepositoryImpl;

import java.util.List;

public class ClientServiceImpl implements AutoCloseable {

    private ClientRepositoryImpl clientRepository = new ClientRepositoryImpl();


    public void register(Client newClient) {
        Boolean exists = clientRepository.existsByEmail(newClient.getEmail());
        if (exists) {
            throw new IllegalStateException(
                    String.format("client with email = %s already in use!", newClient.getEmail())
            );
        }
        clientRepository.save(newClient);
    }

    public boolean login(String email, String password) {
        Client client = clientRepository.finByEmail(email)
                .orElseThrow(() -> new NotFoundException(
                        String.format("client with email =" + email + "not found!")
                ));
        if (password.equals(client.getPassword())) {
            return true;
        }
        throw new BadCredentialsException("incorrect password");

    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void close() throws Exception {
        clientRepository.close();
    }
}
