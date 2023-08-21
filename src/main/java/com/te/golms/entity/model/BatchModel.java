package com.te.golms.entity.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.te.golms.enums.BatchStatus;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchModel {
	private String batchName;
	private String mentorId;
	@Enumerated(EnumType.STRING)
	private Set<TechnologyModel> technologies;
	private LocalDate batchStartDate;
	private LocalDate batchEndDate;
	@Enumerated(EnumType.STRING)
	private BatchStatus batchStatus;
}
