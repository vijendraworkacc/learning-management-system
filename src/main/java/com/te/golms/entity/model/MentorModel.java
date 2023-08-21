package com.te.golms.entity.model;

import java.util.Set;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MentorModel {
	private String mentorId;
	private String mentorName;
	private String email;
	private Set<TechnologyModel> technologies;
}
