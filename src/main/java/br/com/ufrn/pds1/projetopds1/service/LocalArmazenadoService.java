package br.com.ufrn.pds1.projetopds1.service;

import br.com.ufrn.pds1.projetopds1.DTO.LocalArmazenadoDTO;
import br.com.ufrn.pds1.projetopds1.model.LocalArmazenado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;

@Service
public class LocalArmazenadoService {

    private final Map<Long, LocalArmazenado> locaisEmMemoria = new ConcurrentHashMap<>();
    private final AtomicLong contadorId = new AtomicLong();

    public LocalArmazenado createLocal(LocalArmazenadoDTO localDTO) {
        Long novoId = contadorId.incrementAndGet();
        LocalArmazenado novoLocal = new LocalArmazenado(
                novoId,
                localDTO.getNome(),
                localDTO.getLatitude(),
                localDTO.getLongitude(),
                localDTO.getDescricao()
        );
        locaisEmMemoria.put(novoId, novoLocal);
        return novoLocal;
    }

    public Optional<LocalArmazenado> getLocalById(Long id) {
        return Optional.ofNullable(locaisEmMemoria.get(id));
    }

    public List<LocalArmazenado> getAllLocais() {
        return new ArrayList<>(locaisEmMemoria.values());
    }

    public Optional<LocalArmazenado> updateLocal(Long id, LocalArmazenadoDTO localDTO) {
        return Optional.ofNullable(locaisEmMemoria.computeIfPresent(id, (key, localExistente) -> {
            localExistente.setNome(localDTO.getNome() != null ? localDTO.getNome() : localExistente.getNome());
            localExistente.setLatitude(localDTO.getLatitude() != null ? localDTO.getLatitude() : localExistente.getLatitude());
            localExistente.setLongitude(localDTO.getLongitude() != null ? localDTO.getLongitude() : localExistente.getLongitude());
            localExistente.setDescricao(localDTO.getDescricao() != null ? localDTO.getDescricao() : localExistente.getDescricao());
            return localExistente;
        }));
    }

    public boolean deleteLocal(Long id) {
        return locaisEmMemoria.remove(id) != null;
    }
}