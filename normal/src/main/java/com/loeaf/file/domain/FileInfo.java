package com.loeaf.file.domain;

import com.loeaf.common.domain.Domain;
import com.loeaf.common.misc.Action;
import com.loeaf.file.domain.listener.FileInfoListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 지구계획보고상세
 * UK
 * id, cityPlanId
 */
@Entity
@EntityListeners(FileInfoListener.class)
@Table(name="file_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo extends Domain implements Action {
    /**
     * 파일명
     */
    @NotNull
    @Column(name = "file_name")
    private String fileName;

    /**
     * 파일경로
     */
    @NotNull
    @Column(name = "file_path")
    private String filePath;

    /**
     * 파일경로
     */
    @NotNull
    @Column(name = "origin_file_name")
    private String originFileName;

    /**
     * 확장자
     */
    @NotNull
    @Column(name = "file_ext")
    private String fileExtention;

    @Override
    public String toString() {
        return this.getFilePath() + "/" + this.getFileName() + "." + this.getFileExtention();
    }

    @Override
    public void delete() {
    }
}
