package luma.store.dto;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class Address {
    private String firsStreet;
    private String city;
    private String telephoneNumber;
    private String zipCode;

    public Address() {
        this.firsStreet = RandomStringUtils.randomAlphanumeric(8);
        this.city = RandomStringUtils.randomAlphabetic(6);
        this.telephoneNumber = RandomStringUtils.randomNumeric(10);
        this.zipCode = RandomStringUtils.randomNumeric(5);
    }
}
