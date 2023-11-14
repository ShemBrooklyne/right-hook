package org.geekwys.righthooks.models;

public record Media(
        String mediaName,
        String mediaType,
        MediaDetails mediaInfo,
        byte[] media
) {
}
