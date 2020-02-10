package com.xxh.dp;

import com.xxh.dp.utill.dbutils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DpApplicationTests {

    @Test
    void contextLoads() {
        new dbutils();
    }

}
