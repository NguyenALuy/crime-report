package com.example.crimereport.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(
    name = "tb_user",
    uniqueConstraints = {@UniqueConstraint(name = "uk_tb_user_email", columnNames = "email")})
public class User extends BaseEntity{
	 @Column(nullable = false)
	    private String username;

	    @Column(nullable = false)
	    private String email;

	    @Column(nullable = false)
	    private String passwordHash;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private Role roleName;

	    @Column(nullable = false)
	    private String phone;
	    
	    @UuidGenerator 
	    private UUID refreshTokenId;

	    @UuidGenerator 
	    private UUID passwordResetTokenId;
	    
	    @Column(nullable = true)
	    private String profileImageUrl;
	    
	    @Builder.Default
	    @Column(nullable = false)
	    private Boolean isVerified = false;
}
