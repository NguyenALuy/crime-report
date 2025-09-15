package com.example.crimereport.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_report")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Report extends BaseEntity{
	@Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    
    @Column(columnDefinition = "TEXT")
    private String comment;

    // Automatically set when the report is first saved
    //    @Column(nullable = false, updatable = false)
    //    private Instant reportedAt;

    // ============== Relationships =================

    /** Who submitted the report (must be a User with role=CITIZEN) */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "citizen_id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_report_citizen"))
    private User citizen;

    /** Who verified the report (role=ADMIN); null until verified */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id",
                foreignKey = @ForeignKey(name = "fk_report_admin"))
    private User admin;

    /** Who’s currently assigned (role=OFFICER); null until assigned */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officer_id",
                foreignKey = @ForeignKey(name = "fk_report_officer"))
    private User officer;
}
