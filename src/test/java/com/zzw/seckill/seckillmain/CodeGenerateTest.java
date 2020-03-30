package com.zzw.seckill.seckillmain;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.util.*;

public class CodeGenerateTest {

    public static void main(String[] args) {

//        System.out.println(new Date().getTime()) ;
        GenerateParams generateParams = new GenerateParams();
        generateParams.setOutputDirectory("/src/main/java");
        //generateParams.setOutputDirectory("H:/meinv");
        generateParams.setAuthor("zzw");
        generateParams.setJdbcUrl("jdbc:mysql://localhost:3306/seckill?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=UTC");
        generateParams.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        generateParams.setJdbcUserName("root");
        generateParams.setJdbcPassword("123456");

        generateParams.setParentPackage("com.zzw.seckill.seckillmain");
        generateParams.setIncludeTables(new String[]{"pay_order","seckill"});

        SimpleGenerator.doGeneration(generateParams);
    }

    @Data
    private static class GenerateParams {

        //生成代码里，注释的作者
        private String author;

        //代码生成输出的目录，可为项目路径的相对路径
        private String outputDirectory;

        //jdbc驱动
        private String jdbcDriver;

        //数据库连接地址
        private String jdbcUrl;

        //数据库账号
        private String jdbcUserName;

        //数据库密码
        private String jdbcPassword;

        //代码生成包含的表，可为空，为空默认生成所有
        private String[] includeTables;

        //代码生成的类的父包名称
        private String parentPackage;
    }

    private static class SimpleGenerator {

        private static void doGeneration(GenerateParams generateParams) {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();

            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            final String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath + generateParams.getOutputDirectory());
            gc.setActiveRecord(true);
            gc.setEnableCache(false);
            gc.setBaseResultMap(true);
            gc.setBaseColumnList(false);
            gc.setFileOverride(false);
            gc.setAuthor(generateParams.getAuthor());
            gc.setOpen(false);
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl(generateParams.getJdbcUrl());
            // dsc.setSchemaName("public");
            dsc.setDriverName(generateParams.getJdbcDriver());
            dsc.setUsername(generateParams.getJdbcUserName());
            dsc.setPassword(generateParams.getJdbcPassword());
            mpg.setDataSource(dsc);

            // 包配置
            final PackageConfig pc = new PackageConfig();
            //pc.setModuleName("info");
            pc.setParent(generateParams.getParentPackage());
            mpg.setPackageInfo(pc);

            // 自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };

//                 如果模板引擎是 freemarker
            String templatePath = "/templates/mapper.xml.ftl";
//                // 如果模板引擎是 velocity
//                 String templatePath = "/templates/mapper.media.calendar.xml.vm";

            // 自定义输出配置
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return projectPath + "/src/main/java/com/zzw/seckill/seckillmain/mapper/mapping/" +
                            tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });

            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);

            // 配置模板
            TemplateConfig templateConfig = new TemplateConfig();

            // 配置自定义输出模板
            //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
            // templateConfig.setEntity("templates/entity2.java");
            // templateConfig.setService();
            // templateConfig.setController();

            templateConfig.setXml(null);
            mpg.setTemplate(templateConfig);

            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setEntityLombokModel(true);
            strategy.setRestControllerStyle(true);
            strategy.setInclude(generateParams.getIncludeTables());
            //strategy.setSuperEntityColumns("id");
            strategy.setControllerMappingHyphenStyle(true);
            strategy.setTablePrefix(pc.getModuleName() + "_");
            strategy.setLogicDeleteFieldName("DEL_FLAG");
//            strategy.setSuperServiceClass("com.supone.database.service.BaseService");
//            strategy.setSuperMapperClass("com.supone.database.mapper.BaseMapper");
//            strategy.setSuperServiceImplClass("com.supone.database.service.impl.BaseServiceImpl");
//            strategy.setSuperEntityClass("com.lxzh.wh.modular.info.entity.WhBaseEntity");

            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();
        }

    }


}
