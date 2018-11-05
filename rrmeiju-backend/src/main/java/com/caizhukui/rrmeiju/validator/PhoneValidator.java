package com.caizhukui.rrmeiju.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Phone Validator
 * 
 * @author caizhukui
 * @date 2017年1月17日
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone phone) {
		// initialize resource(e.g. DataSource) here
	}

	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext context) {
		if (phoneNo == null) {
			return false;
		}
		// validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
        // validating phone number with -, . or spaces
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        // validating phone number with extension length from 3 to 5
        else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
        // validating phone number where area code is in braces ()
        else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
        // return false if nothing matches the input
        else return false;
	}

}
