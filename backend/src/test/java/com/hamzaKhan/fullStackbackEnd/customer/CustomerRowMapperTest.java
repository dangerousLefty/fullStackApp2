package com.hamzaKhan.fullStackbackEnd.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerRowMapperTest {

    @Test
    void mapRow() throws SQLException {
        //Given
        CustomerRowMapper customerRowMapper = new CustomerRowMapper();

        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.getInt("id")).thenReturn(1);
        Mockito.when(resultSet.getString("name")).thenReturn("Ezio");
        Mockito.when(resultSet.getString("email")).thenReturn("ezio@ubisoft.com");
        Mockito.when(resultSet.getInt("age")).thenReturn(21);

        //When
        Customer actual = customerRowMapper.mapRow(resultSet, 1);

        //Then
        Customer expected = new Customer(
                1, "Ezio", "ezio@ubisoft.com", 21
        );
        assertThat(actual).isEqualTo(expected);
    }
}