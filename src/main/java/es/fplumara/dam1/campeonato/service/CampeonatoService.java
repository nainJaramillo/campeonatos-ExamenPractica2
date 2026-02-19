package es.fplumara.dam1.campeonato.service;

import es.fplumara.dam1.campeonato.exception.DuplicadoException;
import es.fplumara.dam1.campeonato.exception.NoEncontradoException;
import es.fplumara.dam1.campeonato.exception.OperacionNoPermitidaException;
import es.fplumara.dam1.campeonato.model.Deportista;
import es.fplumara.dam1.campeonato.model.LineaRanking;
import es.fplumara.dam1.campeonato.model.Resultado;
import es.fplumara.dam1.campeonato.repository.DeportistaRepository;
import es.fplumara.dam1.campeonato.repository.ResultadoRepository;

import java.util.List;

public class CampeonatoService {
    private DeportistaRepository deportistaRepository;
    private ResultadoRepository resultadoRepository;

    public CampeonatoService(DeportistaRepository deportistaRepository, ResultadoRepository resultadoRepository) {
        this.deportistaRepository = deportistaRepository;
        this.resultadoRepository = resultadoRepository;
    }
    public void registrarDeportista(Deportista d){
        if (d == null ||
                d.getId() == null || d.getId().trim().isEmpty() ||
                d.getNombre() == null || d.getNombre().trim().isEmpty() ||
                d.getPais() == null || d.getPais().trim().isEmpty()){
            throw new IllegalArgumentException("Datos Invalidos");
        }
       if (deportistaRepository.findById(d.getId()).isPresent()){
           throw new DuplicadoException("Ya hay un deporstista registrado"+ d.getId());
       }
       deportistaRepository.save(d);
    }

    public void registrarResultado(Resultado r){
        if (r == null ||
                r.getId() == null || r.getId().trim().isEmpty() ||
                r.getIdPrueba() == null || r.getIdPrueba().trim().isEmpty() ||
                r.getIdDeportista() == null || r.getIdDeportista().trim().isEmpty()){
            throw new IllegalArgumentException("Datos invalidos");
        }
        if (r.getTipoPrueba()== null){
            throw new IllegalArgumentException("Es obligatorio");
        }
        if (r.getPosicion() <= 0){
            throw new IllegalArgumentException("Debe ser un num mayor a 0");
        }
        if (resultadoRepository.findById(r.getId()).isPresent()){
            throw new DuplicadoException("Ya existe");
        }
        if (deportistaRepository.findById(r.getIdDeportista()).isEmpty()){
            throw new NoEncontradoException("No se registra porque el deportista no existe");
        }
        if (resultadoRepository.existsByPruebaYDeportista(r.getIdPrueba(), r.getIdDeportista())){
            throw new OperacionNoPermitidaException("Operacion no permitida");
        }
        resultadoRepository.save(r);
    }

    public DeportistaRepository getDeportistaRepository() {
        return deportistaRepository;
    }

    public void setDeportistaRepository(DeportistaRepository deportistaRepository) {
        this.deportistaRepository = deportistaRepository;
    }

    public ResultadoRepository getResultadoRepository() {
        return resultadoRepository;
    }

    public void setResultadoRepository(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }
}
