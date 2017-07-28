package by.ecp.telephone.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@NoArgsConstructor
public class Person {
	@Setter
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Setter
	@Getter
	private String firstName;
	@Setter
	@Getter
	@NotEmpty(message = "Last Name is required.")
	private String lastName;
	@Getter
	@Setter
	private String numberMobil;
	@Getter
	@Setter
	private String numberShot;
	@Getter
	@Setter
	private String numberCity;

	public Person(
			String firstName,
			String lastName,
			String numberMobil,
			String numberShot,
			String numberCity) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberMobil = numberMobil;
		this.numberMobil = numberShot;
		this.numberMobil = numberCity;
	}
}
