package com.example.crimereport.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Table(name = "tb_report_history")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReportHistory extends BaseEntity{
	 /** The report this history entry belongs to */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "report_id", nullable = false,
        foreignKey = @ForeignKey(name = "fk_history_report"))
    private Report report;

    /** Status before change */
    @Column(name = "previous_status")
    private String previousStatus;

    /** Status after change */
    @Column(name = "new_status")
    private String newStatus;

    /** Comment before change */
    @Column(name = "previous_comment", columnDefinition = "TEXT")
    private String previousComment;

    /** Comment after change */
    @Column(name = "new_comment", columnDefinition = "TEXT")
    private String newComment;

    /** Who made the change (must be an ADMIN) */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "changed_by", nullable = false,
        foreignKey = @ForeignKey(name = "fk_history_changed_by"))
    private User changedBy;
}
