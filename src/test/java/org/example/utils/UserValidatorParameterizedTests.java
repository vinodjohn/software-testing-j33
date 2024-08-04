package org.example.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Parameterized tests using JUnit
 *
 * @author Vinod John
 * @Date 04.08.2024
 */
public class UserValidatorParameterizedTests {
    @ParameterizedTest
    @ValueSource(strings = {"Tony12345", "Mark28393", "akansoaösfki"})
    public void givenUserPassword_whenEncodePasswordCalled_shouldReturnEncodedPassword(String password) {
        String expectedValue = password.substring(0, password.length()/2) + "#sda_java#" + password.substring(password.length()/2);
        Assertions.assertEquals(expectedValue, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @MethodSource("getPasswords")
    public void givenUserPassword_whenEncodePasswordCalled_shouldReturnEncodedPasswords(String password) {
        String expectedValue = password.substring(0, password.length()/2) + "#sda_java#" + password.substring(password.length()/2);
        Assertions.assertEquals(expectedValue, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @ArgumentsSource(Parameters.class)
    public void givenUserPasswordFromProvider_whenEncodePasswordCalled_shouldReturnEncodedPasswords(String password) {
        String expectedValue = password.substring(0, password.length()/2) + "#sda_java#" + password.substring(password.length()/2);
        Assertions.assertEquals(expectedValue, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @CsvSource({"Vinod123456, Vinod#sda_java#123456", "John123456, John1#sda_java#23456"})
    public void givenUserPasswordFromCsv_whenEncodePasswordCalled_shouldReturnEncodedPasswords(String password, String encodedPassword) {
        Assertions.assertEquals(encodedPassword, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataSource.csv")
    public void givenUserPasswordFromCsvFile_whenEncodePasswordCalled_shouldReturnEncodedPasswords(String password, String encodedPassword) {
        Assertions.assertEquals(encodedPassword, new UserValidator().encodePassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tony12345", "Mark28393", "akansoaösfki"})
    public void givenUserPasswordConverted_whenEncodePasswordCalled_shouldReturnEncodedPassword(@ConvertWith(PasswordConverter.class) String password) {
        String expectedValue = password.substring(0, password.length()/2) + "#sda_java#" + password.substring(password.length()/2);
        Assertions.assertEquals(expectedValue, new UserValidator().encodePassword(password));
    }

    //For Method Source
    static Stream<Arguments> getPasswords() {
        return Stream.of(Arguments.of("UBu382242"), Arguments.of("Tony12345"), Arguments.of("Mark28393"));
    }

    //For Arguments Source
    static class Parameters implements ArgumentsProvider {
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(Arguments.of("UBu382242"), Arguments.of("Tony12345"), Arguments.of("Mark28393"));
        }
    }

    //For Argument Converter
    static class PasswordConverter implements ArgumentConverter {
        @Override
        public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
            if(source instanceof String) {
                return ((String) source).replaceAll("12345", "67890");
            }

            fail("Cannot replace string");

            return null;
        }
    }
}
