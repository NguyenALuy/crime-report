package com.example.crimereport.entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@Id
	@UuidGenerator
	private UUID id;
	@CreatedDate
    @Column(updatable = false, nullable = false)
	private Instant createdAt;
	@LastModifiedDate
	@Column(nullable = true)
	private Instant updatedAt;
	@Column(nullable = true)
	private Instant deletedAt;
}
