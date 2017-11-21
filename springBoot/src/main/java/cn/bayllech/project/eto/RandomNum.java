package cn.bayllech.project.eto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-21 14:26
 */
@Component
public class RandomNum {
    @Value("${rand.intOrign}")
    int intOrigin;
    @Value("${rand.longOrign}")
    long longOrigin;
    @Value("${rand.uuidOrign}")
    String uuidOrigin;
    @Value("${rand.intLessthan}")
    int intLessthan;
    @Value("${rand.intRange}")
    String intRange;
    @Value("${rand.randomstr}")
    String randomstr;
    
    public int getIntOrigin() {
        return intOrigin;
    }
    
    public void setIntOrigin(int intOrigin) {
        this.intOrigin = intOrigin;
    }
    
    public long getLongOrigin() {
        return longOrigin;
    }
    
    public void setLongOrigin(long longOrigin) {
        this.longOrigin = longOrigin;
    }
    
    public String getUuidOrigin() {
        return uuidOrigin;
    }
    
    public void setUuidOrigin(String uuidOrigin) {
        this.uuidOrigin = uuidOrigin;
    }
    
    public int getIntLessthan() {
        return intLessthan;
    }
    
    public void setIntLessthan(int intLessthan) {
        this.intLessthan = intLessthan;
    }
    
    public String getIntRange() {
        return intRange;
    }
    
    public void setIntRange(String intRange) {
        this.intRange = intRange;
    }
    
    public String getRandomstr() {
        return randomstr;
    }
    
    public void setRandomstr(String randomstr) {
        this.randomstr = randomstr;
    }
}
