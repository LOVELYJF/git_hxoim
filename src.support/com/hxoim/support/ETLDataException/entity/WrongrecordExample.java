package com.hxoim.support.ETLDataException.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WrongrecordExample {
    /**
     * wrongrecord
     */
    protected String orderByClause;

    /**
     * wrongrecord
     */
    protected boolean distinct;

    /**
     * wrongrecord
     */
    protected List<Criteria> oredCriteria;

    public WrongrecordExample() {
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
     * wrongrecord 2019-07-17
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSystemnameIsNull() {
            addCriterion("SystemName is null");
            return (Criteria) this;
        }

        public Criteria andSystemnameIsNotNull() {
            addCriterion("SystemName is not null");
            return (Criteria) this;
        }

        public Criteria andSystemnameEqualTo(String value) {
            addCriterion("SystemName =", value, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameNotEqualTo(String value) {
            addCriterion("SystemName <>", value, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameGreaterThan(String value) {
            addCriterion("SystemName >", value, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameGreaterThanOrEqualTo(String value) {
            addCriterion("SystemName >=", value, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameLessThan(String value) {
            addCriterion("SystemName <", value, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameLessThanOrEqualTo(String value) {
            addCriterion("SystemName <=", value, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameLike(String value) {
            addCriterion("SystemName like", value, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameNotLike(String value) {
            addCriterion("SystemName not like", value, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameIn(List<String> values) {
            addCriterion("SystemName in", values, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameNotIn(List<String> values) {
            addCriterion("SystemName not in", values, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameBetween(String value1, String value2) {
            addCriterion("SystemName between", value1, value2, "systemname");
            return (Criteria) this;
        }

        public Criteria andSystemnameNotBetween(String value1, String value2) {
            addCriterion("SystemName not between", value1, value2, "systemname");
            return (Criteria) this;
        }

        public Criteria andApplicationidIsNull() {
            addCriterion("ApplicationId is null");
            return (Criteria) this;
        }

        public Criteria andApplicationidIsNotNull() {
            addCriterion("ApplicationId is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationidEqualTo(String value) {
            addCriterion("ApplicationId =", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotEqualTo(String value) {
            addCriterion("ApplicationId <>", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidGreaterThan(String value) {
            addCriterion("ApplicationId >", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidGreaterThanOrEqualTo(String value) {
            addCriterion("ApplicationId >=", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLessThan(String value) {
            addCriterion("ApplicationId <", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLessThanOrEqualTo(String value) {
            addCriterion("ApplicationId <=", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLike(String value) {
            addCriterion("ApplicationId like", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotLike(String value) {
            addCriterion("ApplicationId not like", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidIn(List<String> values) {
            addCriterion("ApplicationId in", values, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotIn(List<String> values) {
            addCriterion("ApplicationId not in", values, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidBetween(String value1, String value2) {
            addCriterion("ApplicationId between", value1, value2, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotBetween(String value1, String value2) {
            addCriterion("ApplicationId not between", value1, value2, "applicationid");
            return (Criteria) this;
        }

        public Criteria andTableidIsNull() {
            addCriterion("TableId is null");
            return (Criteria) this;
        }

        public Criteria andTableidIsNotNull() {
            addCriterion("TableId is not null");
            return (Criteria) this;
        }

        public Criteria andTableidEqualTo(String value) {
            addCriterion("TableId =", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotEqualTo(String value) {
            addCriterion("TableId <>", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidGreaterThan(String value) {
            addCriterion("TableId >", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidGreaterThanOrEqualTo(String value) {
            addCriterion("TableId >=", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLessThan(String value) {
            addCriterion("TableId <", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLessThanOrEqualTo(String value) {
            addCriterion("TableId <=", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidLike(String value) {
            addCriterion("TableId like", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotLike(String value) {
            addCriterion("TableId not like", value, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidIn(List<String> values) {
            addCriterion("TableId in", values, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotIn(List<String> values) {
            addCriterion("TableId not in", values, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidBetween(String value1, String value2) {
            addCriterion("TableId between", value1, value2, "tableid");
            return (Criteria) this;
        }

        public Criteria andTableidNotBetween(String value1, String value2) {
            addCriterion("TableId not between", value1, value2, "tableid");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("TableName is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("TableName is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("TableName =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("TableName <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("TableName >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("TableName >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("TableName <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("TableName <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("TableName like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("TableName not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("TableName in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("TableName not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("TableName between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("TableName not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andFieldnameIsNull() {
            addCriterion("FieldName is null");
            return (Criteria) this;
        }

        public Criteria andFieldnameIsNotNull() {
            addCriterion("FieldName is not null");
            return (Criteria) this;
        }

        public Criteria andFieldnameEqualTo(String value) {
            addCriterion("FieldName =", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotEqualTo(String value) {
            addCriterion("FieldName <>", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameGreaterThan(String value) {
            addCriterion("FieldName >", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameGreaterThanOrEqualTo(String value) {
            addCriterion("FieldName >=", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLessThan(String value) {
            addCriterion("FieldName <", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLessThanOrEqualTo(String value) {
            addCriterion("FieldName <=", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameLike(String value) {
            addCriterion("FieldName like", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotLike(String value) {
            addCriterion("FieldName not like", value, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameIn(List<String> values) {
            addCriterion("FieldName in", values, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotIn(List<String> values) {
            addCriterion("FieldName not in", values, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameBetween(String value1, String value2) {
            addCriterion("FieldName between", value1, value2, "fieldname");
            return (Criteria) this;
        }

        public Criteria andFieldnameNotBetween(String value1, String value2) {
            addCriterion("FieldName not between", value1, value2, "fieldname");
            return (Criteria) this;
        }

        public Criteria andOccurdateIsNull() {
            addCriterion("OccurDate is null");
            return (Criteria) this;
        }

        public Criteria andOccurdateIsNotNull() {
            addCriterion("OccurDate is not null");
            return (Criteria) this;
        }

        public Criteria andOccurdateEqualTo(Date value) {
            addCriterion("OccurDate =", value, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateNotEqualTo(Date value) {
            addCriterion("OccurDate <>", value, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateGreaterThan(Date value) {
            addCriterion("OccurDate >", value, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateGreaterThanOrEqualTo(Date value) {
            addCriterion("OccurDate >=", value, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateLessThan(Date value) {
            addCriterion("OccurDate <", value, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateLessThanOrEqualTo(Date value) {
            addCriterion("OccurDate <=", value, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateIn(List<Date> values) {
            addCriterion("OccurDate in", values, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateNotIn(List<Date> values) {
            addCriterion("OccurDate not in", values, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateBetween(Date value1, Date value2) {
            addCriterion("OccurDate between", value1, value2, "occurdate");
            return (Criteria) this;
        }

        public Criteria andOccurdateNotBetween(Date value1, Date value2) {
            addCriterion("OccurDate not between", value1, value2, "occurdate");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("State is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("State is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("State =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("State <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("State >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("State >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("State <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("State <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("State in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("State not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("State between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("State not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentIsNull() {
            addCriterion("DealDepartment is null");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentIsNotNull() {
            addCriterion("DealDepartment is not null");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentEqualTo(String value) {
            addCriterion("DealDepartment =", value, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentNotEqualTo(String value) {
            addCriterion("DealDepartment <>", value, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentGreaterThan(String value) {
            addCriterion("DealDepartment >", value, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("DealDepartment >=", value, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentLessThan(String value) {
            addCriterion("DealDepartment <", value, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentLessThanOrEqualTo(String value) {
            addCriterion("DealDepartment <=", value, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentLike(String value) {
            addCriterion("DealDepartment like", value, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentNotLike(String value) {
            addCriterion("DealDepartment not like", value, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentIn(List<String> values) {
            addCriterion("DealDepartment in", values, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentNotIn(List<String> values) {
            addCriterion("DealDepartment not in", values, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentBetween(String value1, String value2) {
            addCriterion("DealDepartment between", value1, value2, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealdepartmentNotBetween(String value1, String value2) {
            addCriterion("DealDepartment not between", value1, value2, "dealdepartment");
            return (Criteria) this;
        }

        public Criteria andDealstaffIsNull() {
            addCriterion("DealStaff is null");
            return (Criteria) this;
        }

        public Criteria andDealstaffIsNotNull() {
            addCriterion("DealStaff is not null");
            return (Criteria) this;
        }

        public Criteria andDealstaffEqualTo(String value) {
            addCriterion("DealStaff =", value, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffNotEqualTo(String value) {
            addCriterion("DealStaff <>", value, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffGreaterThan(String value) {
            addCriterion("DealStaff >", value, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffGreaterThanOrEqualTo(String value) {
            addCriterion("DealStaff >=", value, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffLessThan(String value) {
            addCriterion("DealStaff <", value, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffLessThanOrEqualTo(String value) {
            addCriterion("DealStaff <=", value, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffLike(String value) {
            addCriterion("DealStaff like", value, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffNotLike(String value) {
            addCriterion("DealStaff not like", value, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffIn(List<String> values) {
            addCriterion("DealStaff in", values, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffNotIn(List<String> values) {
            addCriterion("DealStaff not in", values, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffBetween(String value1, String value2) {
            addCriterion("DealStaff between", value1, value2, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealstaffNotBetween(String value1, String value2) {
            addCriterion("DealStaff not between", value1, value2, "dealstaff");
            return (Criteria) this;
        }

        public Criteria andDealdateIsNull() {
            addCriterion("DealDate is null");
            return (Criteria) this;
        }

        public Criteria andDealdateIsNotNull() {
            addCriterion("DealDate is not null");
            return (Criteria) this;
        }

        public Criteria andDealdateEqualTo(Date value) {
            addCriterion("DealDate =", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotEqualTo(Date value) {
            addCriterion("DealDate <>", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateGreaterThan(Date value) {
            addCriterion("DealDate >", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateGreaterThanOrEqualTo(Date value) {
            addCriterion("DealDate >=", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateLessThan(Date value) {
            addCriterion("DealDate <", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateLessThanOrEqualTo(Date value) {
            addCriterion("DealDate <=", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateIn(List<Date> values) {
            addCriterion("DealDate in", values, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotIn(List<Date> values) {
            addCriterion("DealDate not in", values, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateBetween(Date value1, Date value2) {
            addCriterion("DealDate between", value1, value2, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotBetween(Date value1, Date value2) {
            addCriterion("DealDate not between", value1, value2, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealinfoIsNull() {
            addCriterion("DealInfo is null");
            return (Criteria) this;
        }

        public Criteria andDealinfoIsNotNull() {
            addCriterion("DealInfo is not null");
            return (Criteria) this;
        }

        public Criteria andDealinfoEqualTo(String value) {
            addCriterion("DealInfo =", value, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoNotEqualTo(String value) {
            addCriterion("DealInfo <>", value, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoGreaterThan(String value) {
            addCriterion("DealInfo >", value, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoGreaterThanOrEqualTo(String value) {
            addCriterion("DealInfo >=", value, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoLessThan(String value) {
            addCriterion("DealInfo <", value, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoLessThanOrEqualTo(String value) {
            addCriterion("DealInfo <=", value, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoLike(String value) {
            addCriterion("DealInfo like", value, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoNotLike(String value) {
            addCriterion("DealInfo not like", value, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoIn(List<String> values) {
            addCriterion("DealInfo in", values, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoNotIn(List<String> values) {
            addCriterion("DealInfo not in", values, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoBetween(String value1, String value2) {
            addCriterion("DealInfo between", value1, value2, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andDealinfoNotBetween(String value1, String value2) {
            addCriterion("DealInfo not between", value1, value2, "dealinfo");
            return (Criteria) this;
        }

        public Criteria andErrorstepIsNull() {
            addCriterion("ErrorStep is null");
            return (Criteria) this;
        }

        public Criteria andErrorstepIsNotNull() {
            addCriterion("ErrorStep is not null");
            return (Criteria) this;
        }

        public Criteria andErrorstepEqualTo(String value) {
            addCriterion("ErrorStep =", value, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepNotEqualTo(String value) {
            addCriterion("ErrorStep <>", value, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepGreaterThan(String value) {
            addCriterion("ErrorStep >", value, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepGreaterThanOrEqualTo(String value) {
            addCriterion("ErrorStep >=", value, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepLessThan(String value) {
            addCriterion("ErrorStep <", value, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepLessThanOrEqualTo(String value) {
            addCriterion("ErrorStep <=", value, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepLike(String value) {
            addCriterion("ErrorStep like", value, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepNotLike(String value) {
            addCriterion("ErrorStep not like", value, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepIn(List<String> values) {
            addCriterion("ErrorStep in", values, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepNotIn(List<String> values) {
            addCriterion("ErrorStep not in", values, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepBetween(String value1, String value2) {
            addCriterion("ErrorStep between", value1, value2, "errorstep");
            return (Criteria) this;
        }

        public Criteria andErrorstepNotBetween(String value1, String value2) {
            addCriterion("ErrorStep not between", value1, value2, "errorstep");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * wrongrecord 2019-07-17
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