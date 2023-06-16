package com.pictoAPI.restful.payload.response;

import com.pictoAPI.restful.model.Categorie;
import com.pictoAPI.restful.model.Question;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "ResponseQuestion", types = {Question.class})
public
interface ResponseQuestion {
    Long getId();

    String getContenu();

    List<ResponseCategorie> getCategories();
}