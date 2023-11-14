package org.geekwys.righthooks.gallery;

import lombok.extern.slf4j.Slf4j;
import org.geekwys.righthooks.entity.Media;
import org.geekwys.righthooks.entity.MediaDetails;
import org.geekwys.righthooks.repository.MediaRepository;
import org.geekwys.righthooks.util.MediaUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class StorageService {

    private final MediaRepository mediaRepository;

    public StorageService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public String uploadMedia(MultipartFile multipartFile) throws IOException {

        byte[] supercompressed = MediaUtils.supercompress(multipartFile.getBytes());

        MediaDetails mediaDetails = MediaDetails.builder()
                .uploadedBy("")
                .description("")
                .likesCount(0)
                .size(multipartFile.getSize()).build();

        Media media = Media.builder()
                .media(supercompressed)
                .mediaName(multipartFile.getOriginalFilename())
                .mediaType(multipartFile.getContentType())
                .mediaDetails(mediaDetails).build();

        if (media != null) {
            mediaRepository.save(media);
            return multipartFile.getOriginalFilename() + " uploaded successfully!";
        }
        return null;
    }

    public byte[] downloadMedia(String fileName) {
        Optional<Media> dbMedia = mediaRepository.retrieveMediaByName(fileName);
        byte[] decompressed = MediaUtils.decompress(dbMedia.get().getMedia());
        return decompressed;
    }

}
