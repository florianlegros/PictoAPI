package com.pictoAPI.restful.payload.response;

import com.pictoAPI.restful.model.Phrase;
import com.pictoAPI.restful.model.Pictogramme;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "ResponsePhrase", types = {Phrase.class})
public
interface ResponsePhrase {
    Long getId();

    ResponseQuestion getQuestion();

    List<Pictogramme> getPictogrammes();
}