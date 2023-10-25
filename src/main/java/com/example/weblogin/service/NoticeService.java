package com.example.weblogin.service;

import com.example.weblogin.domain.notice.Notice;
import com.example.weblogin.domain.notice.NoticeDto;
import com.example.weblogin.domain.notice.NoticeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {

    private NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Transactional
    public Long saveNotice(NoticeDto noticeDto) {
        return noticeRepository.save(noticeDto.toEntity()).getId();
    }

    @Transactional
    public List<NoticeDto> getNoticeList() {
        List<Notice> noticeList = noticeRepository.findAll();
        List<NoticeDto> noticeDtoList = new ArrayList<>();

        for(Notice notice : noticeList) {
            NoticeDto noticeDto = NoticeDto.builder()
                    .id(notice.getId())
                    .author(notice.getAuthor())
                    .title(notice.getTitle())
                    .content(notice.getContent())
                    .createdDate(notice.getCreatedDate())
                    .build();
            noticeDtoList.add(noticeDto);
        }
        return noticeDtoList;
    }

    @Transactional
    public NoticeDto getNotice(Long id) {
        Notice notice = noticeRepository.findById(id).get();

        NoticeDto noticeDto = NoticeDto.builder()
                .id(notice.getId())
                .author(notice.getAuthor())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdDate(notice.getCreatedDate())
                .build();
        return noticeDto;
    }

    @Transactional
    public void deleteNotice(Long id) {

        noticeRepository.deleteById(id);
    }

}
