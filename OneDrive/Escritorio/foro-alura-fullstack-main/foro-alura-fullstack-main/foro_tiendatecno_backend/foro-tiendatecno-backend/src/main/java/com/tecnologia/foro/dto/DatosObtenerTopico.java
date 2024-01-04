package com.tecnologia.foro.dto;

import com.tecnologia.foro.modelo.StatusTopico;
import com.tecnologia.foro.modelo.Topico;

import java.time.LocalDateTime;
import java.util.List;

public record DatosObtenerTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        StatusTopico statusTopico,
        String autor,
        Long autor_id,
        String curso,
        List<DatosObtenerRespuesta> respuestas
        ) {
    public DatosObtenerTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getAutor().getId(),
                topico.getProducto().getNombre(),
                // obtiene la lista de respuestas y las mapea como DatosObtenerRespuestas
                topico.getRespuestas().stream().map(DatosObtenerRespuesta::new).toList()
        );
    }
}
