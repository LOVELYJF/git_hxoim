package com.hxoim.support.inforesource.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataTableExample {
    /**
     * data_table
     */
    protected String orderByClause;

    /**
     * data_table
     */
    protected boolean distinct;

    /**
     * data_table
     */
    protected List<Criteria> oredCriteria;

    public DataTableExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * data_table 2019-07-18
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCatalogidIsNull() {
            addCriterion("CatalogId is null");
            return (Criteria) this;
        }

        public Criteria andCatalogidIsNotNull() {
            addCriterion("CatalogId is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogidEqualTo(String value) {
            addCriterion("CatalogId =", value, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidNotEqualTo(String value) {
            addCriterion("CatalogId <>", value, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidGreaterThan(String value) {
            addCriterion("CatalogId >", value, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidGreaterThanOrEqualTo(String value) {
            addCriterion("CatalogId >=", value, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidLessThan(String value) {
            addCriterion("CatalogId <", value, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidLessThanOrEqualTo(String value) {
            addCriterion("CatalogId <=", value, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidLike(String value) {
            addCriterion("CatalogId like", value, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidNotLike(String value) {
            addCriterion("CatalogId not like", value, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidIn(List<String> values) {
            addCriterion("CatalogId in", values, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidNotIn(List<String> values) {
            addCriterion("CatalogId not in", values, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidBetween(String value1, String value2) {
            addCriterion("CatalogId between", value1, value2, "catalogid");
            return (Criteria) this;
        }

        public Criteria andCatalogidNotBetween(String value1, String value2) {
            addCriterion("CatalogId not between", value1, value2, "catalogid");
            return (Criteria) this;
        }

        public Criteria andTabCodeIsNull() {
            addCriterion("TAB_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTabCodeIsNotNull() {
            addCriterion("TAB_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTabCodeEqualTo(String value) {
            addCriterion("TAB_CODE =", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeNotEqualTo(String value) {
            addCriterion("TAB_CODE <>", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeGreaterThan(String value) {
            addCriterion("TAB_CODE >", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TAB_CODE >=", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeLessThan(String value) {
            addCriterion("TAB_CODE <", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeLessThanOrEqualTo(String value) {
            addCriterion("TAB_CODE <=", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeLike(String value) {
            addCriterion("TAB_CODE like", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeNotLike(String value) {
            addCriterion("TAB_CODE not like", value, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeIn(List<String> values) {
            addCriterion("TAB_CODE in", values, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeNotIn(List<String> values) {
            addCriterion("TAB_CODE not in", values, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeBetween(String value1, String value2) {
            addCriterion("TAB_CODE between", value1, value2, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabCodeNotBetween(String value1, String value2) {
            addCriterion("TAB_CODE not between", value1, value2, "tabCode");
            return (Criteria) this;
        }

        public Criteria andTabNameIsNull() {
            addCriterion("TAB_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTabNameIsNotNull() {
            addCriterion("TAB_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTabNameEqualTo(String value) {
            addCriterion("TAB_NAME =", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotEqualTo(String value) {
            addCriterion("TAB_NAME <>", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameGreaterThan(String value) {
            addCriterion("TAB_NAME >", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameGreaterThanOrEqualTo(String value) {
            addCriterion("TAB_NAME >=", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLessThan(String value) {
            addCriterion("TAB_NAME <", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLessThanOrEqualTo(String value) {
            addCriterion("TAB_NAME <=", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameLike(String value) {
            addCriterion("TAB_NAME like", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotLike(String value) {
            addCriterion("TAB_NAME not like", value, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameIn(List<String> values) {
            addCriterion("TAB_NAME in", values, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotIn(List<String> values) {
            addCriterion("TAB_NAME not in", values, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameBetween(String value1, String value2) {
            addCriterion("TAB_NAME between", value1, value2, "tabName");
            return (Criteria) this;
        }

        public Criteria andTabNameNotBetween(String value1, String value2) {
            addCriterion("TAB_NAME not between", value1, value2, "tabName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIsMultilyIsNull() {
            addCriterion("IS_MULTILY is null");
            return (Criteria) this;
        }

        public Criteria andIsMultilyIsNotNull() {
            addCriterion("IS_MULTILY is not null");
            return (Criteria) this;
        }

        public Criteria andIsMultilyEqualTo(String value) {
            addCriterion("IS_MULTILY =", value, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyNotEqualTo(String value) {
            addCriterion("IS_MULTILY <>", value, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyGreaterThan(String value) {
            addCriterion("IS_MULTILY >", value, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyGreaterThanOrEqualTo(String value) {
            addCriterion("IS_MULTILY >=", value, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyLessThan(String value) {
            addCriterion("IS_MULTILY <", value, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyLessThanOrEqualTo(String value) {
            addCriterion("IS_MULTILY <=", value, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyLike(String value) {
            addCriterion("IS_MULTILY like", value, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyNotLike(String value) {
            addCriterion("IS_MULTILY not like", value, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyIn(List<String> values) {
            addCriterion("IS_MULTILY in", values, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyNotIn(List<String> values) {
            addCriterion("IS_MULTILY not in", values, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyBetween(String value1, String value2) {
            addCriterion("IS_MULTILY between", value1, value2, "isMultily");
            return (Criteria) this;
        }

        public Criteria andIsMultilyNotBetween(String value1, String value2) {
            addCriterion("IS_MULTILY not between", value1, value2, "isMultily");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodIsNull() {
            addCriterion("LOAD_PAGE_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodIsNotNull() {
            addCriterion("LOAD_PAGE_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodEqualTo(String value) {
            addCriterion("LOAD_PAGE_METHOD =", value, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodNotEqualTo(String value) {
            addCriterion("LOAD_PAGE_METHOD <>", value, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodGreaterThan(String value) {
            addCriterion("LOAD_PAGE_METHOD >", value, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodGreaterThanOrEqualTo(String value) {
            addCriterion("LOAD_PAGE_METHOD >=", value, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodLessThan(String value) {
            addCriterion("LOAD_PAGE_METHOD <", value, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodLessThanOrEqualTo(String value) {
            addCriterion("LOAD_PAGE_METHOD <=", value, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodLike(String value) {
            addCriterion("LOAD_PAGE_METHOD like", value, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodNotLike(String value) {
            addCriterion("LOAD_PAGE_METHOD not like", value, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodIn(List<String> values) {
            addCriterion("LOAD_PAGE_METHOD in", values, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodNotIn(List<String> values) {
            addCriterion("LOAD_PAGE_METHOD not in", values, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodBetween(String value1, String value2) {
            addCriterion("LOAD_PAGE_METHOD between", value1, value2, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andLoadPageMethodNotBetween(String value1, String value2) {
            addCriterion("LOAD_PAGE_METHOD not between", value1, value2, "loadPageMethod");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("PID not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("COMMENTS is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("COMMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("COMMENTS =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("COMMENTS <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("COMMENTS >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENTS >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("COMMENTS <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("COMMENTS <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("COMMENTS like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("COMMENTS not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("COMMENTS in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("COMMENTS not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("COMMENTS between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("COMMENTS not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIsNull() {
            addCriterion("ORDER_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIsNotNull() {
            addCriterion("ORDER_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIndexEqualTo(Integer value) {
            addCriterion("ORDER_INDEX =", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotEqualTo(Integer value) {
            addCriterion("ORDER_INDEX <>", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexGreaterThan(Integer value) {
            addCriterion("ORDER_INDEX >", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_INDEX >=", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLessThan(Integer value) {
            addCriterion("ORDER_INDEX <", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_INDEX <=", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIn(List<Integer> values) {
            addCriterion("ORDER_INDEX in", values, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotIn(List<Integer> values) {
            addCriterion("ORDER_INDEX not in", values, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_INDEX between", value1, value2, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_INDEX not between", value1, value2, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andRightCodeIsNull() {
            addCriterion("RIGHT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRightCodeIsNotNull() {
            addCriterion("RIGHT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRightCodeEqualTo(String value) {
            addCriterion("RIGHT_CODE =", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeNotEqualTo(String value) {
            addCriterion("RIGHT_CODE <>", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeGreaterThan(String value) {
            addCriterion("RIGHT_CODE >", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHT_CODE >=", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeLessThan(String value) {
            addCriterion("RIGHT_CODE <", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeLessThanOrEqualTo(String value) {
            addCriterion("RIGHT_CODE <=", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeLike(String value) {
            addCriterion("RIGHT_CODE like", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeNotLike(String value) {
            addCriterion("RIGHT_CODE not like", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeIn(List<String> values) {
            addCriterion("RIGHT_CODE in", values, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeNotIn(List<String> values) {
            addCriterion("RIGHT_CODE not in", values, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeBetween(String value1, String value2) {
            addCriterion("RIGHT_CODE between", value1, value2, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeNotBetween(String value1, String value2) {
            addCriterion("RIGHT_CODE not between", value1, value2, "rightCode");
            return (Criteria) this;
        }

        public Criteria andNameSpaceIsNull() {
            addCriterion("NAME_SPACE is null");
            return (Criteria) this;
        }

        public Criteria andNameSpaceIsNotNull() {
            addCriterion("NAME_SPACE is not null");
            return (Criteria) this;
        }

        public Criteria andNameSpaceEqualTo(String value) {
            addCriterion("NAME_SPACE =", value, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceNotEqualTo(String value) {
            addCriterion("NAME_SPACE <>", value, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceGreaterThan(String value) {
            addCriterion("NAME_SPACE >", value, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_SPACE >=", value, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceLessThan(String value) {
            addCriterion("NAME_SPACE <", value, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceLessThanOrEqualTo(String value) {
            addCriterion("NAME_SPACE <=", value, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceLike(String value) {
            addCriterion("NAME_SPACE like", value, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceNotLike(String value) {
            addCriterion("NAME_SPACE not like", value, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceIn(List<String> values) {
            addCriterion("NAME_SPACE in", values, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceNotIn(List<String> values) {
            addCriterion("NAME_SPACE not in", values, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceBetween(String value1, String value2) {
            addCriterion("NAME_SPACE between", value1, value2, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andNameSpaceNotBetween(String value1, String value2) {
            addCriterion("NAME_SPACE not between", value1, value2, "nameSpace");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("CLASS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("CLASS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("CLASS_NAME =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("CLASS_NAME <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("CLASS_NAME >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("CLASS_NAME <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("CLASS_NAME like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("CLASS_NAME not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("CLASS_NAME in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("CLASS_NAME not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("CLASS_NAME between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("CLASS_NAME not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andTimeStampIsNull() {
            addCriterion("TIME_STAMP is null");
            return (Criteria) this;
        }

        public Criteria andTimeStampIsNotNull() {
            addCriterion("TIME_STAMP is not null");
            return (Criteria) this;
        }

        public Criteria andTimeStampEqualTo(String value) {
            addCriterion("TIME_STAMP =", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotEqualTo(String value) {
            addCriterion("TIME_STAMP <>", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampGreaterThan(String value) {
            addCriterion("TIME_STAMP >", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampGreaterThanOrEqualTo(String value) {
            addCriterion("TIME_STAMP >=", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampLessThan(String value) {
            addCriterion("TIME_STAMP <", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampLessThanOrEqualTo(String value) {
            addCriterion("TIME_STAMP <=", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampLike(String value) {
            addCriterion("TIME_STAMP like", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotLike(String value) {
            addCriterion("TIME_STAMP not like", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampIn(List<String> values) {
            addCriterion("TIME_STAMP in", values, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotIn(List<String> values) {
            addCriterion("TIME_STAMP not in", values, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampBetween(String value1, String value2) {
            addCriterion("TIME_STAMP between", value1, value2, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotBetween(String value1, String value2) {
            addCriterion("TIME_STAMP not between", value1, value2, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("IS_DELETED is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IS_DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("IS_DELETED =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("IS_DELETED <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("IS_DELETED >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DELETED >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("IS_DELETED <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("IS_DELETED <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("IS_DELETED like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("IS_DELETED not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("IS_DELETED in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("IS_DELETED not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("IS_DELETED between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("IS_DELETED not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNull() {
            addCriterion("MODIFY_USER is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("MODIFY_USER is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(String value) {
            addCriterion("MODIFY_USER =", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(String value) {
            addCriterion("MODIFY_USER <>", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(String value) {
            addCriterion("MODIFY_USER >", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFY_USER >=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(String value) {
            addCriterion("MODIFY_USER <", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(String value) {
            addCriterion("MODIFY_USER <=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLike(String value) {
            addCriterion("MODIFY_USER like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLike(String value) {
            addCriterion("MODIFY_USER not like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserIn(List<String> values) {
            addCriterion("MODIFY_USER in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<String> values) {
            addCriterion("MODIFY_USER not in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(String value1, String value2) {
            addCriterion("MODIFY_USER between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(String value1, String value2) {
            addCriterion("MODIFY_USER not between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andListSettingIsNull() {
            addCriterion("LIST_SETTING is null");
            return (Criteria) this;
        }

        public Criteria andListSettingIsNotNull() {
            addCriterion("LIST_SETTING is not null");
            return (Criteria) this;
        }

        public Criteria andListSettingEqualTo(String value) {
            addCriterion("LIST_SETTING =", value, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingNotEqualTo(String value) {
            addCriterion("LIST_SETTING <>", value, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingGreaterThan(String value) {
            addCriterion("LIST_SETTING >", value, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingGreaterThanOrEqualTo(String value) {
            addCriterion("LIST_SETTING >=", value, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingLessThan(String value) {
            addCriterion("LIST_SETTING <", value, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingLessThanOrEqualTo(String value) {
            addCriterion("LIST_SETTING <=", value, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingLike(String value) {
            addCriterion("LIST_SETTING like", value, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingNotLike(String value) {
            addCriterion("LIST_SETTING not like", value, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingIn(List<String> values) {
            addCriterion("LIST_SETTING in", values, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingNotIn(List<String> values) {
            addCriterion("LIST_SETTING not in", values, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingBetween(String value1, String value2) {
            addCriterion("LIST_SETTING between", value1, value2, "listSetting");
            return (Criteria) this;
        }

        public Criteria andListSettingNotBetween(String value1, String value2) {
            addCriterion("LIST_SETTING not between", value1, value2, "listSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingIsNull() {
            addCriterion("FORM_SETTING is null");
            return (Criteria) this;
        }

        public Criteria andFormSettingIsNotNull() {
            addCriterion("FORM_SETTING is not null");
            return (Criteria) this;
        }

        public Criteria andFormSettingEqualTo(String value) {
            addCriterion("FORM_SETTING =", value, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingNotEqualTo(String value) {
            addCriterion("FORM_SETTING <>", value, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingGreaterThan(String value) {
            addCriterion("FORM_SETTING >", value, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingGreaterThanOrEqualTo(String value) {
            addCriterion("FORM_SETTING >=", value, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingLessThan(String value) {
            addCriterion("FORM_SETTING <", value, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingLessThanOrEqualTo(String value) {
            addCriterion("FORM_SETTING <=", value, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingLike(String value) {
            addCriterion("FORM_SETTING like", value, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingNotLike(String value) {
            addCriterion("FORM_SETTING not like", value, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingIn(List<String> values) {
            addCriterion("FORM_SETTING in", values, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingNotIn(List<String> values) {
            addCriterion("FORM_SETTING not in", values, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingBetween(String value1, String value2) {
            addCriterion("FORM_SETTING between", value1, value2, "formSetting");
            return (Criteria) this;
        }

        public Criteria andFormSettingNotBetween(String value1, String value2) {
            addCriterion("FORM_SETTING not between", value1, value2, "formSetting");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlIsNull() {
            addCriterion("TABLE_SAME_SQL is null");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlIsNotNull() {
            addCriterion("TABLE_SAME_SQL is not null");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlEqualTo(String value) {
            addCriterion("TABLE_SAME_SQL =", value, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlNotEqualTo(String value) {
            addCriterion("TABLE_SAME_SQL <>", value, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlGreaterThan(String value) {
            addCriterion("TABLE_SAME_SQL >", value, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_SAME_SQL >=", value, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlLessThan(String value) {
            addCriterion("TABLE_SAME_SQL <", value, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlLessThanOrEqualTo(String value) {
            addCriterion("TABLE_SAME_SQL <=", value, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlLike(String value) {
            addCriterion("TABLE_SAME_SQL like", value, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlNotLike(String value) {
            addCriterion("TABLE_SAME_SQL not like", value, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlIn(List<String> values) {
            addCriterion("TABLE_SAME_SQL in", values, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlNotIn(List<String> values) {
            addCriterion("TABLE_SAME_SQL not in", values, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlBetween(String value1, String value2) {
            addCriterion("TABLE_SAME_SQL between", value1, value2, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andTableSameSqlNotBetween(String value1, String value2) {
            addCriterion("TABLE_SAME_SQL not between", value1, value2, "tableSameSql");
            return (Criteria) this;
        }

        public Criteria andBatchUrlIsNull() {
            addCriterion("BATCH_URL is null");
            return (Criteria) this;
        }

        public Criteria andBatchUrlIsNotNull() {
            addCriterion("BATCH_URL is not null");
            return (Criteria) this;
        }

        public Criteria andBatchUrlEqualTo(String value) {
            addCriterion("BATCH_URL =", value, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlNotEqualTo(String value) {
            addCriterion("BATCH_URL <>", value, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlGreaterThan(String value) {
            addCriterion("BATCH_URL >", value, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_URL >=", value, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlLessThan(String value) {
            addCriterion("BATCH_URL <", value, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlLessThanOrEqualTo(String value) {
            addCriterion("BATCH_URL <=", value, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlLike(String value) {
            addCriterion("BATCH_URL like", value, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlNotLike(String value) {
            addCriterion("BATCH_URL not like", value, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlIn(List<String> values) {
            addCriterion("BATCH_URL in", values, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlNotIn(List<String> values) {
            addCriterion("BATCH_URL not in", values, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlBetween(String value1, String value2) {
            addCriterion("BATCH_URL between", value1, value2, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andBatchUrlNotBetween(String value1, String value2) {
            addCriterion("BATCH_URL not between", value1, value2, "batchUrl");
            return (Criteria) this;
        }

        public Criteria andTableTypeIsNull() {
            addCriterion("TABLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTableTypeIsNotNull() {
            addCriterion("TABLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTableTypeEqualTo(String value) {
            addCriterion("TABLE_TYPE =", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotEqualTo(String value) {
            addCriterion("TABLE_TYPE <>", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeGreaterThan(String value) {
            addCriterion("TABLE_TYPE >", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_TYPE >=", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeLessThan(String value) {
            addCriterion("TABLE_TYPE <", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeLessThanOrEqualTo(String value) {
            addCriterion("TABLE_TYPE <=", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeLike(String value) {
            addCriterion("TABLE_TYPE like", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotLike(String value) {
            addCriterion("TABLE_TYPE not like", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeIn(List<String> values) {
            addCriterion("TABLE_TYPE in", values, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotIn(List<String> values) {
            addCriterion("TABLE_TYPE not in", values, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeBetween(String value1, String value2) {
            addCriterion("TABLE_TYPE between", value1, value2, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotBetween(String value1, String value2) {
            addCriterion("TABLE_TYPE not between", value1, value2, "tableType");
            return (Criteria) this;
        }

        public Criteria andIsForQueryIsNull() {
            addCriterion("IS_FOR_QUERY is null");
            return (Criteria) this;
        }

        public Criteria andIsForQueryIsNotNull() {
            addCriterion("IS_FOR_QUERY is not null");
            return (Criteria) this;
        }

        public Criteria andIsForQueryEqualTo(String value) {
            addCriterion("IS_FOR_QUERY =", value, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryNotEqualTo(String value) {
            addCriterion("IS_FOR_QUERY <>", value, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryGreaterThan(String value) {
            addCriterion("IS_FOR_QUERY >", value, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryGreaterThanOrEqualTo(String value) {
            addCriterion("IS_FOR_QUERY >=", value, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryLessThan(String value) {
            addCriterion("IS_FOR_QUERY <", value, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryLessThanOrEqualTo(String value) {
            addCriterion("IS_FOR_QUERY <=", value, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryLike(String value) {
            addCriterion("IS_FOR_QUERY like", value, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryNotLike(String value) {
            addCriterion("IS_FOR_QUERY not like", value, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryIn(List<String> values) {
            addCriterion("IS_FOR_QUERY in", values, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryNotIn(List<String> values) {
            addCriterion("IS_FOR_QUERY not in", values, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryBetween(String value1, String value2) {
            addCriterion("IS_FOR_QUERY between", value1, value2, "isForQuery");
            return (Criteria) this;
        }

        public Criteria andIsForQueryNotBetween(String value1, String value2) {
            addCriterion("IS_FOR_QUERY not between", value1, value2, "isForQuery");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * data_table 2019-07-18
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}