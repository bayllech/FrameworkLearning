package cn.bayllech.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author bei.qi
 * @Description 歌曲信息
 * @Date 2017-09-08 14:20
 */
@Data
@AllArgsConstructor
public class Song {
    private String url;
    private String title;
    private Long commentCount;
}
