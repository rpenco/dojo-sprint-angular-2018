package com.foo.storage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "technos")
@NoArgsConstructor
@RequiredArgsConstructor
public class TechnoEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(updatable = false, nullable = false)
    private String id;


    @NonNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @NonNull
    @Column()
    private String version;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "Europe/Paris"),
                    @org.hibernate.annotations.Parameter(name = "javaZone", value = "Europe/Paris")})
    @CreatedDate
    private ZonedDateTime createdDate;


}
