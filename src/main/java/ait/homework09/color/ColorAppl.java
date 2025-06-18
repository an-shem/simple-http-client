package ait.homework09.color;

import ait.homework09.color.dto.ColorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ColorAppl {

    public static void main(String[] args) {

        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjXzQzMGQ2ODhmZDRlYmU4MzphNzJmNTUyYThlMWNhNGNkMDYwNWE5MDU4YmE2MDhiMg==");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl);
        URI url = builder.build().encode().toUri();

        RequestEntity<String> reguest = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ColorResponseDto> response = restTemplate.exchange(reguest, ColorResponseDto.class);

        System.out.printf("%-30s %-30s %-30s%n", "color name", "parent color name", "coverage percent");
        System.out.println();

        response.getBody().getResult().getColors().getAllColorDto().forEach(colorDto -> {
            String color_name = colorDto.getClosest_palette_color();
            String parent_color_name = colorDto.getClosest_palette_color_parent();
            double coverage_percent = colorDto.getPercent();
            System.out.printf("%-30s %-30s %-30s%n", color_name, parent_color_name, coverage_percent);
        });

    }
}
