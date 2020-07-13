package com.meipingmi.domain.order.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/***
 * @Description : dao层代码自动生成
 * @Author : zhoumiaozhong
 * @Date : 2020/7/11-10:25
 */
public class GeneratorCode {
    public static void main(String[] args) {
         // 需要构建一个 代码自动生成器 对象
         AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
         GlobalConfig gc = new GlobalConfig();
         String projectPath = System.getProperty("user.dir")+"/order-domain-provider";
         gc.setOutputDir(projectPath+"/src/main/java");
         gc.setAuthor("mpm"); gc.setOpen(false);
        // 是否覆盖
         gc.setFileOverride(false);
        // 去Service的I前缀
         gc.setServiceName("%sService");
         gc.setEntityName("%sDO");

        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setEnableCache(false);
        mpg.setGlobalConfig(gc);
        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.4.10:3306/app-dev-db?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("mpm_test"); dsc.setPassword("mpm@t#");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("order");
        pc.setParent("com.meipingmi.domain");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名
        strategy.setInclude("ordercommission","orders","ordersdetail","lp_log");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("is_deleted");
        // 自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>(); tableFills.add(gmtCreate);
        tableFills.add(gmtModified); strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("lp_","tb_");
        mpg.setStrategy(strategy);
        //执行
        mpg.execute();
    }
}
