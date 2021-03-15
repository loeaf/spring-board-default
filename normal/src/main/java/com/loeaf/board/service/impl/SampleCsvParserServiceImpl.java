package com.loeaf.board.service.impl;

import com.loeaf.board.model.SampleCsv;
import com.loeaf.board.service.SampleCsvParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleCsvParserServiceImpl extends SampleCsvParserService {
    @Override
    protected List procCsvDataObj(ArrayList<List<String>> parseDatas) {
        List<SampleCsv> cprds = new ArrayList<>();
        parseDatas.forEach(p -> constructCPRD(p, cprds));
        return cprds;
    }
    /**
     * 수정 예정
     * @param p
     * @param cprds
     */
    @Deprecated
    private void constructCPRD(List<String> p, List<SampleCsv> cprds) {
        SampleCsv csv = new SampleCsv();
        var row0 = parseRawReturn(p.get(0));
        var row1 = parseRawReturn(p.get(1));
        csv.setCol0(row0);
        csv.setCol1(row1);
        cprds.add(csv);
    }

    /**
     * 허용용도
     * @param s
     * @return
     */
    private String parseRawReturn(String s) {
        return s;
    }
}
