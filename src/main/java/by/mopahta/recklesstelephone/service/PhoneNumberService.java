package by.mopahta.recklesstelephone.service;

import by.mopahta.recklesstelephone.model.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    public List<String> getAvailablePhoneNumbers(List<PhoneNumber> phoneNumbers, boolean getPrivateNumbers) {
        if (getPrivateNumbers) {
            return phoneNumbers.stream().map(PhoneNumber::getNumber).collect(Collectors.toList());
        }
        return phoneNumbers.stream().filter(PhoneNumber::isPublic)
                .map(PhoneNumber::getNumber).collect(Collectors.toList());
    }
}
