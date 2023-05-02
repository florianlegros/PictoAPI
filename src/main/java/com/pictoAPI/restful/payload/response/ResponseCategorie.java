package com.pictoAPI.restful.payload.response;

import com.pictoAPI.restful.model.Categorie;
import com.pictoAPI.restful.model.Pictogramme;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.rest.core.config.Projection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Projection(name = "ResponseCategorie", types = { Categorie.class })
public
interface ResponseCategorie {
    Long getId();
    String getNom();
    String getImgfile();
    List<Pictogramme> getPictogrammes();
}