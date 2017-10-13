package com.example.zhangbing.love.java;

/**
 * 创建时间: 2017/10/11.
 * 编写人: 章冰
 * 功能描述:  练习枚举
 */

public class EnumTest {


    /**
     * 季节枚举(不带参数的枚举常量)这个是最简单的枚举使用实例
     * 顺序排列
     */
    private enum SimpleEnum {
        SPRING, SUMMER, AUTUMN, WINTER
    }

    /**
     * 带参数的枚举
     */
    private enum TypeEnum {
        FIREWALL("firewall"),
        SECRET("secretMac"),
        BALANCE("f5");

        //构造方法
        TypeEnum(String typeName) {
            this.typeName = typeName;
        }

        //成员变量
        private String typeName;

        //成员方法
        public String getTypeName() {
            return this.typeName;
        }

    }

    public static void main(String[] args) {

        for (SimpleEnum simpleEnum : SimpleEnum.values()) {
            System.out.println(simpleEnum + "      ordinal     " + simpleEnum.ordinal());
        }

        System.out.println("--------------------------------");

        for (TypeEnum typeEnum : TypeEnum.values()) {
            System.out.println("typeEnum=" + typeEnum + "    typeEnumName= " + typeEnum.getTypeName() + "     typeName=" + typeEnum.name());
        }

    }
}
