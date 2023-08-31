package ru.project.llt.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.project.llt.dto.LinkDto;
import ru.project.llt.exception.NotFoundException;
import ru.project.llt.model.Link;
import ru.project.llt.repository.LinkRepository;
import ru.project.llt.service.LineService;
import ru.project.llt.util.LinkMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LineServiceImpl implements LineService {

    private final LinkRepository linkRepository;

    @Override
    public LinkDto addLink(LinkDto linkDto) {
        Link link = linkRepository.save(LinkMapper.toLink(linkDto));
        log.info("Link with id = {} saved", link.getId());
        return LinkMapper.toLinkDto(link);
    }

    @Override
    public List<LinkDto> getLinks() {
        List<LinkDto> links = linkRepository.findAll().stream()
                .map(LinkMapper::toLinkDto)
                .collect(Collectors.toList());
        log.info("All links found");
        return links;
    }

    @Override
    public void deleteLink(long id) {
        linkRepository.deleteById(id);
        log.info("Link with id = {} deleted", id);
    }

    @Override
    public LinkDto getLink(long id) {
        LinkDto linkDto = LinkMapper.toLinkDto(linkRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("Link with id = %d not found", id))));
        log.info("Ling with id = {} found", id);
        return linkDto;
    }
}
