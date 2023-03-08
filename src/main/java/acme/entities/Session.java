
package acme.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long			id;

	@NotBlank
	@Size(max = 75)
	private String			title;

	@NotBlank
	@Size(max = 100)
	private String			abstractText;

	@Enumerated(EnumType.STRING)
	@NotNull
	private SessionType		sessionType;

	@Future
	@NotNull
	private LocalDateTime	startTime;

	@NotNull
	@Min(value = 1)
	@Max(value = 5)
	private Integer			duration;

	private String			link;

	@ManyToOne
	@JoinColumn(name = "tutorial_id")
	private Tutorial		tutorial;

}
