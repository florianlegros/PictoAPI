package com.pictoAPI.restful.payload.response;

import com.pictoAPI.restful.model.Conjugaison;
import com.pictoAPI.restful.model.Irregulier;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "ResponseIrregulier", types = {Irregulier.class})
public interface ResponseIrregulier {
    Long getId();

    String getFeminin();

    String getParticipePasse();

    String getPluriel();

    List<Conjugaison> getConjugaisons();
}