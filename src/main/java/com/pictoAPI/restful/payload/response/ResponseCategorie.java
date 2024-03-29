package com.pictoAPI.restful.payload.response;

import com.pictoAPI.restful.model.Categorie;
import com.pictoAPI.restful.model.Pictogramme;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "ResponseCategorie", types = {Categorie.class})
public
interface ResponseCategorie {
    Long getId();

    String getNom();

    String getImgfile();

    List<Pictogramme> getPictogrammes();
}