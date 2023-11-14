package org.geekwys.righthooks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "media_details")
public class MediaDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "uploaded_by")
    private String uploadedBy;

    private String description;

    @Column(name = "likes_count")
    private int likesCount;

    private Long size;

    @PrePersist
    public void prePersist() {
        this.dateCreated = LocalDateTime.now();
    }
}
