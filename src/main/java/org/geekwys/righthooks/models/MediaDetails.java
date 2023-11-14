package org.geekwys.righthooks.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MediaDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_created")
    private String dateCreated;

    @Column(name = "last_updated")
    private String lastUpdated;

    @Column(name = "uploaded_by")
    private String uploadedBy;

    private String description;

    @Column(name = "likes_count")
    private int likesCount;

    private String size;
}
