package cn.bayllech.util;

import org.springframework.core.convert.converter.Converter;

/**
 * @Author bei.qi
 * @Date 2017-08-30 16:04
 */
public class StringTrimConverter implements Converter<String, String> {
    @Override
    public String convert(String source) {
        try {
            //去掉字符串两边的空格，如果去除后为空设置为null
            if (source != null) {
                source = source.trim();
                if (source.equals("")) {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }


}
