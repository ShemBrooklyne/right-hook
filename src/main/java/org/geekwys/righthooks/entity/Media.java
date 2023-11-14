package org.geekwys.righthooks.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "media_name")
    private String mediaName;
    @Column(name = "media_type")
    private String mediaType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "media_details_id")
    private MediaDetails mediaDetails;
    @Lob
    private byte[] media;
}
