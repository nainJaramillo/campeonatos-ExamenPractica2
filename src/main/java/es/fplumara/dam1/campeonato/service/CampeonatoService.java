package es.fplumara.dam1.campeonato.service;

import es.fplumara.dam1.campeonato.model.Deportista;
import es.fplumara.dam1.campeonato.repository.DeportistaRepository;
import es.fplumara.dam1.campeonato.repository.ResultadoRepository;

public class CampeonatoService {
    private DeportistaRepository deportistaRepository;
    private ResultadoRepository resultadoRepository;

    public CampeonatoService(DeportistaRepository deportistaRepository, ResultadoRepository resultadoRepository) {
        this.deportistaRepository = deportistaRepository;
        this.resultadoRepository = resultadoRepository;
    }
    public void registrarDeportista(Deportista d){

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
