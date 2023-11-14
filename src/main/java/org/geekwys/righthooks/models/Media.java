package org.geekwys.righthooks.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
