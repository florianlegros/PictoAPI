package com.pictoAPI.restful.config;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RestModel implements RepresentationModelProcessor<EntityModel<?>> {

    @Override
    public EntityModel process(EntityModel model) {
        return EntityModel.of(Objects.requireNonNull(model.getContent()));
    }
}