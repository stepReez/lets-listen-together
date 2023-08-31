package ru.project.llt.service;

import ru.project.llt.dto.LinkDto;

import java.util.List;

public interface LineService {

    LinkDto addLink(LinkDto linkDto);

    List<LinkDto> getLinks();

    void deleteLink(long id);

    LinkDto getLink(long id);
}
