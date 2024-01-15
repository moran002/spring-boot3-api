package com.moran;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class SpringBoot3ApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void createTable() {
        String property = System.getProperty("user.dir") + "/src/main";
        FastAutoGenerator.create(dataSourceConfig())
                .globalConfig(builder -> {
                    builder.outputDir(property + "/java")
                            .author("moran")
                            .dateType(DateType.TIME_PACK)
                            .disableOpenDir()
                            .commentDate("yyyy-MM-dd HH:mm:ss");
                })
                .packageConfig(builder -> {
                    builder.parent("com.moran")
                            .entity("model.entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, property + "/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("test");
                })
                .execute();


    }

    private DataSourceConfig.Builder dataSourceConfig() {
        return new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull", "root", "xiyang")
                .schema("mybatis-plus")
                .keyWordsHandler(new MySqlKeyWordsHandler());
    }
}
