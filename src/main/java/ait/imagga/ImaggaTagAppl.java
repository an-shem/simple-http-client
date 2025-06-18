package ait.imagga;

import ait.imagga.dto.TagsResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ImaggaTagAppl {
    public static void main(String[] args) {

        String imgUrl ="https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        String lang = "uk";
        int threshold =30;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjXzQzMGQ2ODhmZDRlYmU4MzphNzJmNTUyYThlMWNhNGNkMDYwNWE5MDU4YmE2MDhiMg==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/tags")
                .queryParam("image_url", imgUrl)
                .queryParam("language", lang)
                .queryParam("threshold", threshold);
        URI url = builder.build().encode().toUri();
        RequestEntity<String> reguest = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<TagsResponseDto> response = restTemplate.exchange(reguest, TagsResponseDto.class);
        response.getBody().getResult().getTags().forEach(System.out::println);

    }
}
