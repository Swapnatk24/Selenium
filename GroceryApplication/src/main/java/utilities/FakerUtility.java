package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	Faker faker = new Faker();

	public String generateFirstName() {
		return faker.name().firstName();
	}

	public String generateLastName() {
		return faker.name().lastName();
	}

	public String generateFullName() {
		return faker.name().fullName();
	}

	public String generateAddress() {
		return faker.address().fullAddress();
	}

	public String generatePhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public String generateEmail() {
		return faker.internet().emailAddress();
	}
	public String generatePassword() {
        return faker.internet().password();
    }

	public String generateJobTitle() {
		return faker.job().title();
	}
}
