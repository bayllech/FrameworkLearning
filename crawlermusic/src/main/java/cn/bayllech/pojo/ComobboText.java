package cn.bayllech.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by bayllech on 2017/9/21.
 */
@Data
@AllArgsConstructor
public class ComobboText implements Serializable {
    private static final long serialVersionUID = -8449480105528947135L;
    private String id;
    private String text;
}
