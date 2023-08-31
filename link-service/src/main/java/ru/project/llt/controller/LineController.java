package ru.project.llt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.project.llt.dto.LinkDto;
import ru.project.llt.service.LineService;

import java.util.List;

@RestController
@RequestMapping("/llt")
@RequiredArgsConstructor
public class LineController {
    private final LineService lineService;

    @PostMapping
    public LinkDto addLink(@RequestBody LinkDto linkDto) {
        return lineService.addLink(linkDto);
    }

    @DeleteMapping("/{id}")
    public void deleteLink(@PathVariable long id) {
        lineService.deleteLink(id);
    }

    @GetMapping("/{id}")
    public LinkDto getLink(@PathVariable long id) {
        return lineService.getLink(id);
    }

    @GetMapping
    public List<LinkDto> getLinks() {
        return lineService.getLinks();
    }
}
