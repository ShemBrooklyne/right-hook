package org.geekwys.righthooks.models;

import java.util.List;

public record MediaDetails(
        String dateCreated,
        String lastUpdated,
        String uploadedBy,
        String description,
        List<String> comments,
        int likesCount,
        String size
) {
}
