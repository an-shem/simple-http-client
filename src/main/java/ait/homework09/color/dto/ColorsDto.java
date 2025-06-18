package ait.homework09.color.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@ToString
public class ColorsDto {
    private List<ColorDto> background_colors;
    private List<ColorDto> foreground_colors;
    private List<ColorDto> image_colors;

    public List<ColorDto> getAllColorDto() {
        return Stream.of(background_colors, foreground_colors, image_colors)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
