package ru.project.llt.util;

import ru.project.llt.dto.LinkDto;
import ru.project.llt.model.Link;

public class LinkMapper {
    public static Link toLink(LinkDto linkDto) {
        return Link.builder()
                .id(linkDto.getId())
                .link(linkDto.getLink())
                .name(linkDto.getName())
                .build();
    }

    public static LinkDto toLinkDto(Link link) {
        return LinkDto.builder()
                .id(link.getId())
                .link(link.getLink())
                .name(link.getName())
                .build();
    }
}
