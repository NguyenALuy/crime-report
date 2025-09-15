package com.example.crimereport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_report_file")
public class ReportFile extends BaseEntity {
	/** The report this file is associated with */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "report_id", nullable = false, foreignKey = @ForeignKey(name = "fk_file_report"))
	private Report report;

	/** URL or path where the file is stored */
	@Column(name = "file_url", nullable = false)
	private String fileUrl;

	/** MIME type of the file (e.g., image/jpeg, application/pdf) */
	@Column(name = "mime_type", nullable = false)
	private String mimeType;

	/** Size of the file in bytes */
	@Column(name = "file_size", nullable = false)
	private Long fileSize;

}
