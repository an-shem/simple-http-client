package ait.homework09.color.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ColorDto {
    private int b;
    private String closest_palette_color;
    private String closest_palette_color_html_code;
    private String closest_palette_color_parent;
    private double closest_palette_distance;
    private int g;
    private String html_code;
    private double percent;
    private int r;
}
