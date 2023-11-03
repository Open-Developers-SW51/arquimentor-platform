package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import java.util.List;

public record UpdatePublicationResource(
        String title,
        String description,
        List<String> images
) {
}
