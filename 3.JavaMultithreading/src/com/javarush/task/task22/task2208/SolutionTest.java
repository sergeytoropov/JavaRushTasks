package com.javarush.task.task22.task2208;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 24.07.17
 */
public class SolutionTest {
    Map<String, String> params = new HashMap<>();
    String expectedValue = "country = 'Ukraine' and city = 'Kiev' and name = 'Ivanov'";

    @Before
    public void init() {
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
    }

    @Test
    public void getQuery() {
        assertThat(expectedValue, equalTo(Solution.getQuery(params)));
    }
}