package com.example.crimereport.entity;

import java.time.Instant;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "tb_notification"
)
public class Notification extends BaseEntity {
	/** Sender (user who triggered the notification, e.g., admin/officer) */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_notification_sender"))
    private User sender;
    
	/** Recipient (user) */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipient_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_notification_recipient"))
    private User recipient;

    /** Related report */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "report_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_notification_report"))
    private Report report;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private NotificationType type;

    @Builder.Default
    @Column(name = "is_read", nullable = false)
    private boolean read = false;

    /** When the notification was sent (can be used in ordering) */
    @Column(name = "sent_at", nullable = false, updatable = false)
    private Instant sentAt;
}
