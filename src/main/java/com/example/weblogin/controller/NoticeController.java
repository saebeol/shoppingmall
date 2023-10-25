package com.example.weblogin.controller;

import com.example.weblogin.domain.notice.NoticeDto;
import com.example.weblogin.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping
    public String noticeForm(Model model) {
        List<NoticeDto> noticeDtoList = noticeService.getNoticeList();

        model.addAttribute("noticeList",noticeDtoList);
        return "notice/noticeHome";
    }

    @GetMapping("/add")
    public String noticeAddForm() {
        return "notice/addNotice";
    }

    @PostMapping("/add")
    public String noticeAdd(NoticeDto noticeDto) {
        noticeService.saveNotice(noticeDto);
        return "redirect:/notice";
    }

    @GetMapping("/{id}")
    public String noticeDetailForm(@PathVariable("id") Long id, Model model) {
        NoticeDto noticeDto = noticeService.getNotice(id);
        model.addAttribute("notice",noticeDto);
        return "notice/noticeDetailForm";
    }

    @GetMapping("/edit/{id}")
    public String noticeEditForm(@PathVariable("id") Long id, Model model) {
        NoticeDto noticeDto = noticeService.getNotice(id);
        model.addAttribute("notice",noticeDto);
        return "notice/noticeEditForm";
    }

    @PutMapping("/edit/{id}")
    public String noticeEdit(NoticeDto noticeDto) {
        noticeService.saveNotice(noticeDto);
        return "redirect:/notice";
    }

    @DeleteMapping("/{id}")
    public String noticeDelete(@PathVariable("id") Long id){
        noticeService.deleteNotice(id);
        return "redirect:/notice";
    }
}
