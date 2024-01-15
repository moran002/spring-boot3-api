package com.moran.conf.plus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.util.Collections;

/**
 * @author : moran
 * @date : 2024/1/15 14:39
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
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
                .templateEngine(new FreemarkerTemplateEngine())
               .execute();
    }

    private static DataSourceConfig.Builder dataSourceConfig() {
        return new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull", "root", "xiyang")
                .schema("mybatis-plus")
                .keyWordsHandler(new MySqlKeyWordsHandler());
    }
}
