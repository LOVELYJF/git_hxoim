package com.hxoim.full.search.entity;

/**
 * 索引的人员信息实体类
 *
 * @author sunqian
 * @date 2019/11/4 17:52
 */
public class PersonInfoIndex {
    /**
     * 人员id（可以根据业务需要是否为空）
     */
    private String personId;
    /**
     * 文本信息(被分词索引的信息)
     */
    private String content;
    /**
     * 列的编码(可以为空，具体需要可以考虑业务需求)
     */
    private String columnCode;
    /**
     * 列的描述(例如:姓名、籍贯、现任职务、简历等等，可以为空，具体需要可以考虑业务需求)
     */
    private String description;

    /**
     * 权重得分
     */
    private Float score;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PersonInfoIndex{" +
                "personId='" + personId + '\'' +
                ", content='" + content + '\'' +
                ", columnCode='" + columnCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
