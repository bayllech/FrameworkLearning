package cn.bayllech.project;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.junit.Test;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-20 10:19
 */
public class MybatisTest {
    
    public ClassPool pool = ClassPool.getDefault();
    
    @Test
    public void test() throws NotFoundException {
        pool.insertClassPath("\"C:\\Program Files\\JetBrains\\javassist\\iMybatis-3.42.jar\"");
        CtClass m = pool.get("com.s7.mybatis.e.m");
        CtClass ar = pool.get("com.s7.mybatis.e.ar");
        CtClass h = pool.get("com.s7.mybatis.e.h");
        CtClass S = pool.get("com.s7.mybatis.e.S");
        CtClass an = pool.get("com.s7.mybatis.e.an");
        CtClass ao = pool.get("com.s7.mybatis.e.ao");
        pool.importPackage("com.google.gson.JsonObject;");
        pool.importPackage("com.intellij.openapi.diagnostic.Logger;");
        pool.importPackage("com.intellij.openapi.project.Project;");
        
        try {
            // productId
            // productVersion
            // sha
            // valid
            CtMethod ct = m.getDeclaredMethod("a", new CtClass[]{pool.get("java.lang.String")});
            ct.setBody("{" +
                    "       com.google.gson.JsonObject var3 = new com.google.gson.JsonObject();\n" +
                    "       var3.addProperty(\"productId\", Integer.valueOf(1));\n" +
                    "       var3.addProperty(\"productVersion\", \"3.42\");\n" +
                    "       return true;\n" +
                    "   }");
            
            ct = ar.getDeclaredMethod("a", new CtClass[]{pool.get("com.google.gson.JsonObject")});
            ct.setBody("{" +
                    "       com.google.gson.JsonObject v3 = new com.google.gson.JsonObject();\n" +
                    "       v3.addProperty(\"valid\", \"true\");\n" +
                    "       return v3;\n" +
                    "   }");
            
            
            ct = h.getDeclaredMethod("onSuccess");
            ct.setBody("{com.s7.mybatis.e.ao.h(\"Success\");}");
            
            ct = h.getDeclaredMethod("onThrowable");
            ct.setBody("{ }");
            
            ct = S.getDeclaredMethod("a");
            ct.setBody("{ return com.s7.mybatis.e.ao.g(\"1111111\"); }");
            
            ct = an.getDeclaredMethod("l");
            ct.setBody("{" +
                    "       com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();\n" +
                    "       jsonObject.addProperty(\"pid\", com.s7.mybatis.e.an.d());\n" +
                    "       jsonObject.addProperty(\"userId\", com.s7.mybatis.e.an.e());\n" +
                    "       jsonObject.addProperty(\"version\", com.s7.mybatis.e.ac.b());\n" +
                    "       return jsonObject;" +
                    "   }");
            
            ct = ao.getDeclaredMethod("d");
            ct.setBody("{" +
                    "       com.google.gson.JsonObject jsonObject = com.s7.mybatis.e.an.l();\n" +
                    "       jsonObject.addProperty(\"license\", \"Cracked_By_Freeway\");\n" +
                    "       return new com.s7.mybatis.e.j(true, \"Freeway\");" +
                    "   }");
            
            ct = ao.getDeclaredMethod("b", new CtClass[]{});
            ct.setBody("{" +
                    "       return new com.s7.mybatis.e.ai(false, 365, true, true);" +
                    "   }");
            
            
            ct = ao.getDeclaredMethod("a", new CtClass[]{});
            ct.setBody("{" +
                    "       if (com.s7.mybatis.e.an.c().compareAndSet(false, true)) {\n" +
                    "           new Thread(new com.s7.mybatis.e.af()).start();" +
                    "       }" +
                    "   }");
            
            m.writeFile("/Users/Administrator/Desktop/");
            ar.writeFile("/Users/Administrator/Desktop/");
            h.writeFile("/Users/Administrator/Desktop/");
            S.writeFile("/Users/Administrator/Desktop/");
            an.writeFile("/Users/Administrator/Desktop/");
            ao.writeFile("/Users/Administrator/Desktop/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
