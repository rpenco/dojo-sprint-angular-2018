package com.foo.storage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * @author J.GROCH
 */
@Data
@Entity
@Table(name = "foo")
@NoArgsConstructor
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class FooEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(updatable = false, nullable = false)
    private String id;

    @Column(name = "createdAt", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "Europe/Paris"),
                    @org.hibernate.annotations.Parameter(name = "javaZone", value = "Europe/Paris")})
    @CreatedDate
    private ZonedDateTime createdDate;

    @Column(name = "updatedAt")
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "Europe/Paris"),
                    @org.hibernate.annotations.Parameter(name = "javaZone", value = "Europe/Paris")})
    @LastModifiedDate
    private ZonedDateTime updatedDate;

    @NonNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String a;

    @NonNull
    @Column()
    private Integer b;
}