package com.pictoAPI.restful.payload.response;

import com.pictoAPI.restful.model.Pictogramme;
import com.pictoAPI.restful.model.Tag;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "ResponsePictogramme", types = {Pictogramme.class})
public
interface ResponsePictogramme {
    Long getId();

    String getNom();

    String getImgfile();
     
    ResponseIrregulier getIrregulier();

    List<Tag> getTags();
}