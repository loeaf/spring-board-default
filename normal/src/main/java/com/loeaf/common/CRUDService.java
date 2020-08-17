package com.loeaf.common;


import com.loeaf.siginin.exception.DuplicateDataException;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 응용 CRUD 인터페이스
 * @author break8524@daumsoft.com
 * @param <T>
 */
public abstract class CRUDService<T extends Domain> implements CRUDInterface<T> {
    /**
     *  식별자가 존재하는지 확인 후 저장합니다
     * @param vo
     * @return
     */
    public T registByUk(T vo) {
        if(existVoByUk(vo)) {
            return null;
        } else {
            return save(vo);
        }
    }

    /**
     * Paging을 위한 FindAll
     * @param startPage
     * @return
     */
    public Page<T> findAllPgByStartPg(Integer startPage, Integer contentsSize) {
        PageRequest pageRequest =
                PageRequest.of(startPage,
                        contentsSize, Sort.Direction.DESC, "id");
        return this.findAllByPage(pageRequest);
    }

    /**
     *  식별자가 존재하는지 확인 후 저장합니다
     * @param vo
     * @return
     */
    public List<T> registAllByUk(List<T> vo) {
        List<T> result = new ArrayList<>();
        vo.forEach(p -> {
            if(existVoByUk(p)) {
                throw new DuplicateDataException();
            } else {
                result.add(save(p));
            }
        });
        return result;
    }

    /**
     * UK 조건에 부합하는 모든 데이터를 삭제합니다
     * @param id
     */
    public void deleteAllById(Long id) {
        var vos = findAllById(id);
        vos.forEach(p -> deleteByVo(p));
    }

    /**
     * UK 조건에 부합하는 모든 데이터를 삭제합니다
     * @param vo
     */
    public void deleteAllByUk(T vo) {
        var vos = findAllByUk(vo);
        vos.forEach(p -> deleteByVo(p));
    }

    /**
     *
     * @param vo
     * @return
     */
    public T update(T vo) {
        return save(vo);
    }

    /**
     *
     * @param vos
     * @return
     */
    public List<T> updateAll(List<T> vos) {
        vos.forEach(p -> save(p));
        return vos;
    }

    /**
     * Id를 통해 VO를 가져옵니다
     * @param id
     * @return
     */
    public T findOneById(Long id) {
        return findAllById(id).get(0);
    }
}