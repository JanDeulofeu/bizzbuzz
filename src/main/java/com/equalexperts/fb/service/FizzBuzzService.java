package com.equalexperts.fb.service;

import com.equalexperts.fb.exceptions.FizzBuzzParamException;
import com.equalexperts.fb.types.FizzBuzzTypes;

import java.util.function.IntPredicate;

/**
 * Generation of a String given the module of an input:
 * <p>
 * input: module % 3   output: fizz
 * input: module % 5   output: buzz
 * input: module % 15  output: fizzbuzz
 * input: 3            output: lucky
 * <p>
 * Throws an FizzBuzzParamException if the input parameter is null.
 */
public class FizzBuzzService {

    private final static String LUCKY_NUMBER = "3";

    public static String evaluate(final Integer value) {

        try {
            String result = FizzBuzzTypes.EMPTY.value();

            if (String.valueOf(value).contains(LUCKY_NUMBER)) {
                return FizzBuzzTypes.LUCKY.value();
            }
            result += module(3).test(value) ? FizzBuzzTypes.FIZZ.value() : FizzBuzzTypes.EMPTY.value();
            result += module(5).test(value) ? FizzBuzzTypes.BUZZ.value() : FizzBuzzTypes.EMPTY.value();

            return result.isEmpty() ? String.valueOf(value) : result;

        } catch (final NullPointerException e) {
            throw new FizzBuzzParamException("Input parameter is Null", e);
        }
    }

    /**
     * Calculation of the module for a given number.
     *
     * @param value
     * @return predicate
     */
    private static IntPredicate module(final int value) {
        return i -> i % value == 0;
    }

}
