package com.hxoim.full.search.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 全文检索返回
 *
 * @author sunqian
 * @date 2019/11/11 9:31
 */
public class PersonInfoResult implements Comparable<PersonInfoResult> {
    private String personId;
    private Float score;
    private List<String> searchInfos = new ArrayList<>();

    private String name;
    private String birthday;
    private String introduction;
    private String photoURL;

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<String> getSearchInfos() {
        return searchInfos;
    }

    @Override
    public int compareTo(PersonInfoResult o) {
        float a = this.getScore() / searchInfos.size();
        float b = o.getScore() / o.getSearchInfos().size();
        return -(Float.valueOf(a).compareTo(b));
    }
}
