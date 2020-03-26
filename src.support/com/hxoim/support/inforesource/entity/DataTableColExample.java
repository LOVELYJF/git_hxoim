package com.hxoim.support.inforesource.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataTableColExample {
    /**
     * data_table_col
     */
    protected String orderByClause;

    /**
     * data_table_col
     */
    protected boolean distinct;

    /**
     * data_table_col
     */
    protected List<Criteria> oredCriteria;

    public DataTableColExample() {
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
     * data_table_col 2019-09-03
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

        public Criteria andColCodeIsNull() {
            addCriterion("COL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andColCodeIsNotNull() {
            addCriterion("COL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andColCodeEqualTo(String value) {
            addCriterion("COL_CODE =", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeNotEqualTo(String value) {
            addCriterion("COL_CODE <>", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeGreaterThan(String value) {
            addCriterion("COL_CODE >", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COL_CODE >=", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeLessThan(String value) {
            addCriterion("COL_CODE <", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeLessThanOrEqualTo(String value) {
            addCriterion("COL_CODE <=", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeLike(String value) {
            addCriterion("COL_CODE like", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeNotLike(String value) {
            addCriterion("COL_CODE not like", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeIn(List<String> values) {
            addCriterion("COL_CODE in", values, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeNotIn(List<String> values) {
            addCriterion("COL_CODE not in", values, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeBetween(String value1, String value2) {
            addCriterion("COL_CODE between", value1, value2, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeNotBetween(String value1, String value2) {
            addCriterion("COL_CODE not between", value1, value2, "colCode");
            return (Criteria) this;
        }

        public Criteria andColNameIsNull() {
            addCriterion("COL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andColNameIsNotNull() {
            addCriterion("COL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andColNameEqualTo(String value) {
            addCriterion("COL_NAME =", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotEqualTo(String value) {
            addCriterion("COL_NAME <>", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameGreaterThan(String value) {
            addCriterion("COL_NAME >", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameGreaterThanOrEqualTo(String value) {
            addCriterion("COL_NAME >=", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLessThan(String value) {
            addCriterion("COL_NAME <", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLessThanOrEqualTo(String value) {
            addCriterion("COL_NAME <=", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLike(String value) {
            addCriterion("COL_NAME like", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotLike(String value) {
            addCriterion("COL_NAME not like", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameIn(List<String> values) {
            addCriterion("COL_NAME in", values, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotIn(List<String> values) {
            addCriterion("COL_NAME not in", values, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameBetween(String value1, String value2) {
            addCriterion("COL_NAME between", value1, value2, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotBetween(String value1, String value2) {
            addCriterion("COL_NAME not between", value1, value2, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameShowIsNull() {
            addCriterion("COL_NAME_SHOW is null");
            return (Criteria) this;
        }

        public Criteria andColNameShowIsNotNull() {
            addCriterion("COL_NAME_SHOW is not null");
            return (Criteria) this;
        }

        public Criteria andColNameShowEqualTo(String value) {
            addCriterion("COL_NAME_SHOW =", value, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowNotEqualTo(String value) {
            addCriterion("COL_NAME_SHOW <>", value, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowGreaterThan(String value) {
            addCriterion("COL_NAME_SHOW >", value, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowGreaterThanOrEqualTo(String value) {
            addCriterion("COL_NAME_SHOW >=", value, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowLessThan(String value) {
            addCriterion("COL_NAME_SHOW <", value, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowLessThanOrEqualTo(String value) {
            addCriterion("COL_NAME_SHOW <=", value, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowLike(String value) {
            addCriterion("COL_NAME_SHOW like", value, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowNotLike(String value) {
            addCriterion("COL_NAME_SHOW not like", value, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowIn(List<String> values) {
            addCriterion("COL_NAME_SHOW in", values, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowNotIn(List<String> values) {
            addCriterion("COL_NAME_SHOW not in", values, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowBetween(String value1, String value2) {
            addCriterion("COL_NAME_SHOW between", value1, value2, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andColNameShowNotBetween(String value1, String value2) {
            addCriterion("COL_NAME_SHOW not between", value1, value2, "colNameShow");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldIsNull() {
            addCriterion("IS_SYSTEM_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldIsNotNull() {
            addCriterion("IS_SYSTEM_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldEqualTo(String value) {
            addCriterion("IS_SYSTEM_FIELD =", value, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldNotEqualTo(String value) {
            addCriterion("IS_SYSTEM_FIELD <>", value, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldGreaterThan(String value) {
            addCriterion("IS_SYSTEM_FIELD >", value, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SYSTEM_FIELD >=", value, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldLessThan(String value) {
            addCriterion("IS_SYSTEM_FIELD <", value, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldLessThanOrEqualTo(String value) {
            addCriterion("IS_SYSTEM_FIELD <=", value, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldLike(String value) {
            addCriterion("IS_SYSTEM_FIELD like", value, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldNotLike(String value) {
            addCriterion("IS_SYSTEM_FIELD not like", value, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldIn(List<String> values) {
            addCriterion("IS_SYSTEM_FIELD in", values, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldNotIn(List<String> values) {
            addCriterion("IS_SYSTEM_FIELD not in", values, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldBetween(String value1, String value2) {
            addCriterion("IS_SYSTEM_FIELD between", value1, value2, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldNotBetween(String value1, String value2) {
            addCriterion("IS_SYSTEM_FIELD not between", value1, value2, "isSystemField");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyIsNull() {
            addCriterion("IS_SYSTEM_FIELD_READONLY is null");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyIsNotNull() {
            addCriterion("IS_SYSTEM_FIELD_READONLY is not null");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyEqualTo(String value) {
            addCriterion("IS_SYSTEM_FIELD_READONLY =", value, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyNotEqualTo(String value) {
            addCriterion("IS_SYSTEM_FIELD_READONLY <>", value, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyGreaterThan(String value) {
            addCriterion("IS_SYSTEM_FIELD_READONLY >", value, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SYSTEM_FIELD_READONLY >=", value, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyLessThan(String value) {
            addCriterion("IS_SYSTEM_FIELD_READONLY <", value, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyLessThanOrEqualTo(String value) {
            addCriterion("IS_SYSTEM_FIELD_READONLY <=", value, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyLike(String value) {
            addCriterion("IS_SYSTEM_FIELD_READONLY like", value, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyNotLike(String value) {
            addCriterion("IS_SYSTEM_FIELD_READONLY not like", value, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyIn(List<String> values) {
            addCriterion("IS_SYSTEM_FIELD_READONLY in", values, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyNotIn(List<String> values) {
            addCriterion("IS_SYSTEM_FIELD_READONLY not in", values, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyBetween(String value1, String value2) {
            addCriterion("IS_SYSTEM_FIELD_READONLY between", value1, value2, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andIsSystemFieldReadonlyNotBetween(String value1, String value2) {
            addCriterion("IS_SYSTEM_FIELD_READONLY not between", value1, value2, "isSystemFieldReadonly");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("DATA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("DATA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("DATA_TYPE =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("DATA_TYPE <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("DATA_TYPE >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("DATA_TYPE <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("DATA_TYPE like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("DATA_TYPE not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("DATA_TYPE in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("DATA_TYPE not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("DATA_TYPE between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("DATA_TYPE not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceIsNull() {
            addCriterion("DECIMAL_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceIsNotNull() {
            addCriterion("DECIMAL_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceEqualTo(String value) {
            addCriterion("DECIMAL_PLACE =", value, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceNotEqualTo(String value) {
            addCriterion("DECIMAL_PLACE <>", value, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceGreaterThan(String value) {
            addCriterion("DECIMAL_PLACE >", value, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("DECIMAL_PLACE >=", value, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceLessThan(String value) {
            addCriterion("DECIMAL_PLACE <", value, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceLessThanOrEqualTo(String value) {
            addCriterion("DECIMAL_PLACE <=", value, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceLike(String value) {
            addCriterion("DECIMAL_PLACE like", value, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceNotLike(String value) {
            addCriterion("DECIMAL_PLACE not like", value, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceIn(List<String> values) {
            addCriterion("DECIMAL_PLACE in", values, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceNotIn(List<String> values) {
            addCriterion("DECIMAL_PLACE not in", values, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceBetween(String value1, String value2) {
            addCriterion("DECIMAL_PLACE between", value1, value2, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andDecimalPlaceNotBetween(String value1, String value2) {
            addCriterion("DECIMAL_PLACE not between", value1, value2, "decimalPlace");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldIsNull() {
            addCriterion("IS_CALCULATE_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldIsNotNull() {
            addCriterion("IS_CALCULATE_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldEqualTo(String value) {
            addCriterion("IS_CALCULATE_FIELD =", value, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldNotEqualTo(String value) {
            addCriterion("IS_CALCULATE_FIELD <>", value, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldGreaterThan(String value) {
            addCriterion("IS_CALCULATE_FIELD >", value, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldGreaterThanOrEqualTo(String value) {
            addCriterion("IS_CALCULATE_FIELD >=", value, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldLessThan(String value) {
            addCriterion("IS_CALCULATE_FIELD <", value, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldLessThanOrEqualTo(String value) {
            addCriterion("IS_CALCULATE_FIELD <=", value, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldLike(String value) {
            addCriterion("IS_CALCULATE_FIELD like", value, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldNotLike(String value) {
            addCriterion("IS_CALCULATE_FIELD not like", value, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldIn(List<String> values) {
            addCriterion("IS_CALCULATE_FIELD in", values, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldNotIn(List<String> values) {
            addCriterion("IS_CALCULATE_FIELD not in", values, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldBetween(String value1, String value2) {
            addCriterion("IS_CALCULATE_FIELD between", value1, value2, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andIsCalculateFieldNotBetween(String value1, String value2) {
            addCriterion("IS_CALCULATE_FIELD not between", value1, value2, "isCalculateField");
            return (Criteria) this;
        }

        public Criteria andFormulasIsNull() {
            addCriterion("FORMULAS is null");
            return (Criteria) this;
        }

        public Criteria andFormulasIsNotNull() {
            addCriterion("FORMULAS is not null");
            return (Criteria) this;
        }

        public Criteria andFormulasEqualTo(String value) {
            addCriterion("FORMULAS =", value, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasNotEqualTo(String value) {
            addCriterion("FORMULAS <>", value, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasGreaterThan(String value) {
            addCriterion("FORMULAS >", value, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasGreaterThanOrEqualTo(String value) {
            addCriterion("FORMULAS >=", value, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasLessThan(String value) {
            addCriterion("FORMULAS <", value, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasLessThanOrEqualTo(String value) {
            addCriterion("FORMULAS <=", value, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasLike(String value) {
            addCriterion("FORMULAS like", value, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasNotLike(String value) {
            addCriterion("FORMULAS not like", value, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasIn(List<String> values) {
            addCriterion("FORMULAS in", values, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasNotIn(List<String> values) {
            addCriterion("FORMULAS not in", values, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasBetween(String value1, String value2) {
            addCriterion("FORMULAS between", value1, value2, "formulas");
            return (Criteria) this;
        }

        public Criteria andFormulasNotBetween(String value1, String value2) {
            addCriterion("FORMULAS not between", value1, value2, "formulas");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("IS_SHOW is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("IS_SHOW is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(String value) {
            addCriterion("IS_SHOW =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(String value) {
            addCriterion("IS_SHOW <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(String value) {
            addCriterion("IS_SHOW >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SHOW >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(String value) {
            addCriterion("IS_SHOW <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(String value) {
            addCriterion("IS_SHOW <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLike(String value) {
            addCriterion("IS_SHOW like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotLike(String value) {
            addCriterion("IS_SHOW not like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<String> values) {
            addCriterion("IS_SHOW in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<String> values) {
            addCriterion("IS_SHOW not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(String value1, String value2) {
            addCriterion("IS_SHOW between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(String value1, String value2) {
            addCriterion("IS_SHOW not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andControlTypeIsNull() {
            addCriterion("CONTROL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andControlTypeIsNotNull() {
            addCriterion("CONTROL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andControlTypeEqualTo(String value) {
            addCriterion("CONTROL_TYPE =", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotEqualTo(String value) {
            addCriterion("CONTROL_TYPE <>", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeGreaterThan(String value) {
            addCriterion("CONTROL_TYPE >", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTROL_TYPE >=", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLessThan(String value) {
            addCriterion("CONTROL_TYPE <", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLessThanOrEqualTo(String value) {
            addCriterion("CONTROL_TYPE <=", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeLike(String value) {
            addCriterion("CONTROL_TYPE like", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotLike(String value) {
            addCriterion("CONTROL_TYPE not like", value, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeIn(List<String> values) {
            addCriterion("CONTROL_TYPE in", values, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotIn(List<String> values) {
            addCriterion("CONTROL_TYPE not in", values, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeBetween(String value1, String value2) {
            addCriterion("CONTROL_TYPE between", value1, value2, "controlType");
            return (Criteria) this;
        }

        public Criteria andControlTypeNotBetween(String value1, String value2) {
            addCriterion("CONTROL_TYPE not between", value1, value2, "controlType");
            return (Criteria) this;
        }

        public Criteria andShowFormatIsNull() {
            addCriterion("SHOW_FORMAT is null");
            return (Criteria) this;
        }

        public Criteria andShowFormatIsNotNull() {
            addCriterion("SHOW_FORMAT is not null");
            return (Criteria) this;
        }

        public Criteria andShowFormatEqualTo(String value) {
            addCriterion("SHOW_FORMAT =", value, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatNotEqualTo(String value) {
            addCriterion("SHOW_FORMAT <>", value, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatGreaterThan(String value) {
            addCriterion("SHOW_FORMAT >", value, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatGreaterThanOrEqualTo(String value) {
            addCriterion("SHOW_FORMAT >=", value, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatLessThan(String value) {
            addCriterion("SHOW_FORMAT <", value, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatLessThanOrEqualTo(String value) {
            addCriterion("SHOW_FORMAT <=", value, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatLike(String value) {
            addCriterion("SHOW_FORMAT like", value, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatNotLike(String value) {
            addCriterion("SHOW_FORMAT not like", value, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatIn(List<String> values) {
            addCriterion("SHOW_FORMAT in", values, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatNotIn(List<String> values) {
            addCriterion("SHOW_FORMAT not in", values, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatBetween(String value1, String value2) {
            addCriterion("SHOW_FORMAT between", value1, value2, "showFormat");
            return (Criteria) this;
        }

        public Criteria andShowFormatNotBetween(String value1, String value2) {
            addCriterion("SHOW_FORMAT not between", value1, value2, "showFormat");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNull() {
            addCriterion("DIC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNotNull() {
            addCriterion("DIC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDicCodeEqualTo(String value) {
            addCriterion("DIC_CODE =", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotEqualTo(String value) {
            addCriterion("DIC_CODE <>", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThan(String value) {
            addCriterion("DIC_CODE >", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DIC_CODE >=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThan(String value) {
            addCriterion("DIC_CODE <", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThanOrEqualTo(String value) {
            addCriterion("DIC_CODE <=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLike(String value) {
            addCriterion("DIC_CODE like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotLike(String value) {
            addCriterion("DIC_CODE not like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeIn(List<String> values) {
            addCriterion("DIC_CODE in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotIn(List<String> values) {
            addCriterion("DIC_CODE not in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeBetween(String value1, String value2) {
            addCriterion("DIC_CODE between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotBetween(String value1, String value2) {
            addCriterion("DIC_CODE not between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNull() {
            addCriterion("DEFAULT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("DEFAULT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(String value) {
            addCriterion("DEFAULT_VALUE =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(String value) {
            addCriterion("DEFAULT_VALUE <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(String value) {
            addCriterion("DEFAULT_VALUE >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("DEFAULT_VALUE >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(String value) {
            addCriterion("DEFAULT_VALUE <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("DEFAULT_VALUE <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLike(String value) {
            addCriterion("DEFAULT_VALUE like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotLike(String value) {
            addCriterion("DEFAULT_VALUE not like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(List<String> values) {
            addCriterion("DEFAULT_VALUE in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(List<String> values) {
            addCriterion("DEFAULT_VALUE not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("DEFAULT_VALUE between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("DEFAULT_VALUE not between", value1, value2, "defaultValue");
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

        public Criteria andA01MappingIsNull() {
            addCriterion("A01_MAPPING is null");
            return (Criteria) this;
        }

        public Criteria andA01MappingIsNotNull() {
            addCriterion("A01_MAPPING is not null");
            return (Criteria) this;
        }

        public Criteria andA01MappingEqualTo(String value) {
            addCriterion("A01_MAPPING =", value, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingNotEqualTo(String value) {
            addCriterion("A01_MAPPING <>", value, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingGreaterThan(String value) {
            addCriterion("A01_MAPPING >", value, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingGreaterThanOrEqualTo(String value) {
            addCriterion("A01_MAPPING >=", value, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingLessThan(String value) {
            addCriterion("A01_MAPPING <", value, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingLessThanOrEqualTo(String value) {
            addCriterion("A01_MAPPING <=", value, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingLike(String value) {
            addCriterion("A01_MAPPING like", value, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingNotLike(String value) {
            addCriterion("A01_MAPPING not like", value, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingIn(List<String> values) {
            addCriterion("A01_MAPPING in", values, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingNotIn(List<String> values) {
            addCriterion("A01_MAPPING not in", values, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingBetween(String value1, String value2) {
            addCriterion("A01_MAPPING between", value1, value2, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andA01MappingNotBetween(String value1, String value2) {
            addCriterion("A01_MAPPING not between", value1, value2, "a01Mapping");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormIsNull() {
            addCriterion("IS_SHOW_AT_FORM is null");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormIsNotNull() {
            addCriterion("IS_SHOW_AT_FORM is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormEqualTo(String value) {
            addCriterion("IS_SHOW_AT_FORM =", value, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormNotEqualTo(String value) {
            addCriterion("IS_SHOW_AT_FORM <>", value, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormGreaterThan(String value) {
            addCriterion("IS_SHOW_AT_FORM >", value, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SHOW_AT_FORM >=", value, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormLessThan(String value) {
            addCriterion("IS_SHOW_AT_FORM <", value, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormLessThanOrEqualTo(String value) {
            addCriterion("IS_SHOW_AT_FORM <=", value, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormLike(String value) {
            addCriterion("IS_SHOW_AT_FORM like", value, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormNotLike(String value) {
            addCriterion("IS_SHOW_AT_FORM not like", value, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormIn(List<String> values) {
            addCriterion("IS_SHOW_AT_FORM in", values, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormNotIn(List<String> values) {
            addCriterion("IS_SHOW_AT_FORM not in", values, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormBetween(String value1, String value2) {
            addCriterion("IS_SHOW_AT_FORM between", value1, value2, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andIsShowAtFormNotBetween(String value1, String value2) {
            addCriterion("IS_SHOW_AT_FORM not between", value1, value2, "isShowAtForm");
            return (Criteria) this;
        }

        public Criteria andColspanIsNull() {
            addCriterion("COLSPAN is null");
            return (Criteria) this;
        }

        public Criteria andColspanIsNotNull() {
            addCriterion("COLSPAN is not null");
            return (Criteria) this;
        }

        public Criteria andColspanEqualTo(String value) {
            addCriterion("COLSPAN =", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotEqualTo(String value) {
            addCriterion("COLSPAN <>", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanGreaterThan(String value) {
            addCriterion("COLSPAN >", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanGreaterThanOrEqualTo(String value) {
            addCriterion("COLSPAN >=", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLessThan(String value) {
            addCriterion("COLSPAN <", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLessThanOrEqualTo(String value) {
            addCriterion("COLSPAN <=", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanLike(String value) {
            addCriterion("COLSPAN like", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotLike(String value) {
            addCriterion("COLSPAN not like", value, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanIn(List<String> values) {
            addCriterion("COLSPAN in", values, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotIn(List<String> values) {
            addCriterion("COLSPAN not in", values, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanBetween(String value1, String value2) {
            addCriterion("COLSPAN between", value1, value2, "colspan");
            return (Criteria) this;
        }

        public Criteria andColspanNotBetween(String value1, String value2) {
            addCriterion("COLSPAN not between", value1, value2, "colspan");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListIsNull() {
            addCriterion("IS_SHOW_AT_LIST is null");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListIsNotNull() {
            addCriterion("IS_SHOW_AT_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListEqualTo(String value) {
            addCriterion("IS_SHOW_AT_LIST =", value, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListNotEqualTo(String value) {
            addCriterion("IS_SHOW_AT_LIST <>", value, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListGreaterThan(String value) {
            addCriterion("IS_SHOW_AT_LIST >", value, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SHOW_AT_LIST >=", value, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListLessThan(String value) {
            addCriterion("IS_SHOW_AT_LIST <", value, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListLessThanOrEqualTo(String value) {
            addCriterion("IS_SHOW_AT_LIST <=", value, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListLike(String value) {
            addCriterion("IS_SHOW_AT_LIST like", value, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListNotLike(String value) {
            addCriterion("IS_SHOW_AT_LIST not like", value, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListIn(List<String> values) {
            addCriterion("IS_SHOW_AT_LIST in", values, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListNotIn(List<String> values) {
            addCriterion("IS_SHOW_AT_LIST not in", values, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListBetween(String value1, String value2) {
            addCriterion("IS_SHOW_AT_LIST between", value1, value2, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andIsShowAtListNotBetween(String value1, String value2) {
            addCriterion("IS_SHOW_AT_LIST not between", value1, value2, "isShowAtList");
            return (Criteria) this;
        }

        public Criteria andAlignIsNull() {
            addCriterion("ALIGN is null");
            return (Criteria) this;
        }

        public Criteria andAlignIsNotNull() {
            addCriterion("ALIGN is not null");
            return (Criteria) this;
        }

        public Criteria andAlignEqualTo(String value) {
            addCriterion("ALIGN =", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotEqualTo(String value) {
            addCriterion("ALIGN <>", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignGreaterThan(String value) {
            addCriterion("ALIGN >", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignGreaterThanOrEqualTo(String value) {
            addCriterion("ALIGN >=", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLessThan(String value) {
            addCriterion("ALIGN <", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLessThanOrEqualTo(String value) {
            addCriterion("ALIGN <=", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLike(String value) {
            addCriterion("ALIGN like", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotLike(String value) {
            addCriterion("ALIGN not like", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignIn(List<String> values) {
            addCriterion("ALIGN in", values, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotIn(List<String> values) {
            addCriterion("ALIGN not in", values, "align");
            return (Criteria) this;
        }

        public Criteria andAlignBetween(String value1, String value2) {
            addCriterion("ALIGN between", value1, value2, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotBetween(String value1, String value2) {
            addCriterion("ALIGN not between", value1, value2, "align");
            return (Criteria) this;
        }

        public Criteria andSortAbleIsNull() {
            addCriterion("SORT_ABLE is null");
            return (Criteria) this;
        }

        public Criteria andSortAbleIsNotNull() {
            addCriterion("SORT_ABLE is not null");
            return (Criteria) this;
        }

        public Criteria andSortAbleEqualTo(String value) {
            addCriterion("SORT_ABLE =", value, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleNotEqualTo(String value) {
            addCriterion("SORT_ABLE <>", value, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleGreaterThan(String value) {
            addCriterion("SORT_ABLE >", value, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleGreaterThanOrEqualTo(String value) {
            addCriterion("SORT_ABLE >=", value, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleLessThan(String value) {
            addCriterion("SORT_ABLE <", value, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleLessThanOrEqualTo(String value) {
            addCriterion("SORT_ABLE <=", value, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleLike(String value) {
            addCriterion("SORT_ABLE like", value, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleNotLike(String value) {
            addCriterion("SORT_ABLE not like", value, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleIn(List<String> values) {
            addCriterion("SORT_ABLE in", values, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleNotIn(List<String> values) {
            addCriterion("SORT_ABLE not in", values, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleBetween(String value1, String value2) {
            addCriterion("SORT_ABLE between", value1, value2, "sortAble");
            return (Criteria) this;
        }

        public Criteria andSortAbleNotBetween(String value1, String value2) {
            addCriterion("SORT_ABLE not between", value1, value2, "sortAble");
            return (Criteria) this;
        }

        public Criteria andIsSystemIsNull() {
            addCriterion("IS_SYSTEM is null");
            return (Criteria) this;
        }

        public Criteria andIsSystemIsNotNull() {
            addCriterion("IS_SYSTEM is not null");
            return (Criteria) this;
        }

        public Criteria andIsSystemEqualTo(String value) {
            addCriterion("IS_SYSTEM =", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotEqualTo(String value) {
            addCriterion("IS_SYSTEM <>", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemGreaterThan(String value) {
            addCriterion("IS_SYSTEM >", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SYSTEM >=", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLessThan(String value) {
            addCriterion("IS_SYSTEM <", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLessThanOrEqualTo(String value) {
            addCriterion("IS_SYSTEM <=", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLike(String value) {
            addCriterion("IS_SYSTEM like", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotLike(String value) {
            addCriterion("IS_SYSTEM not like", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemIn(List<String> values) {
            addCriterion("IS_SYSTEM in", values, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotIn(List<String> values) {
            addCriterion("IS_SYSTEM not in", values, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemBetween(String value1, String value2) {
            addCriterion("IS_SYSTEM between", value1, value2, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotBetween(String value1, String value2) {
            addCriterion("IS_SYSTEM not between", value1, value2, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryIsNull() {
            addCriterion("IS_NECESSARY is null");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryIsNotNull() {
            addCriterion("IS_NECESSARY is not null");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryEqualTo(String value) {
            addCriterion("IS_NECESSARY =", value, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryNotEqualTo(String value) {
            addCriterion("IS_NECESSARY <>", value, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryGreaterThan(String value) {
            addCriterion("IS_NECESSARY >", value, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryGreaterThanOrEqualTo(String value) {
            addCriterion("IS_NECESSARY >=", value, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryLessThan(String value) {
            addCriterion("IS_NECESSARY <", value, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryLessThanOrEqualTo(String value) {
            addCriterion("IS_NECESSARY <=", value, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryLike(String value) {
            addCriterion("IS_NECESSARY like", value, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryNotLike(String value) {
            addCriterion("IS_NECESSARY not like", value, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryIn(List<String> values) {
            addCriterion("IS_NECESSARY in", values, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryNotIn(List<String> values) {
            addCriterion("IS_NECESSARY not in", values, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryBetween(String value1, String value2) {
            addCriterion("IS_NECESSARY between", value1, value2, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andIsNecessaryNotBetween(String value1, String value2) {
            addCriterion("IS_NECESSARY not between", value1, value2, "isNecessary");
            return (Criteria) this;
        }

        public Criteria andLength1IsNull() {
            addCriterion("LENGTH_1 is null");
            return (Criteria) this;
        }

        public Criteria andLength1IsNotNull() {
            addCriterion("LENGTH_1 is not null");
            return (Criteria) this;
        }

        public Criteria andLength1EqualTo(Integer value) {
            addCriterion("LENGTH_1 =", value, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1NotEqualTo(Integer value) {
            addCriterion("LENGTH_1 <>", value, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1GreaterThan(Integer value) {
            addCriterion("LENGTH_1 >", value, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1GreaterThanOrEqualTo(Integer value) {
            addCriterion("LENGTH_1 >=", value, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1LessThan(Integer value) {
            addCriterion("LENGTH_1 <", value, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1LessThanOrEqualTo(Integer value) {
            addCriterion("LENGTH_1 <=", value, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1In(List<Integer> values) {
            addCriterion("LENGTH_1 in", values, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1NotIn(List<Integer> values) {
            addCriterion("LENGTH_1 not in", values, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1Between(Integer value1, Integer value2) {
            addCriterion("LENGTH_1 between", value1, value2, "length1");
            return (Criteria) this;
        }

        public Criteria andLength1NotBetween(Integer value1, Integer value2) {
            addCriterion("LENGTH_1 not between", value1, value2, "length1");
            return (Criteria) this;
        }

        public Criteria andWidth1IsNull() {
            addCriterion("WIDTH_1 is null");
            return (Criteria) this;
        }

        public Criteria andWidth1IsNotNull() {
            addCriterion("WIDTH_1 is not null");
            return (Criteria) this;
        }

        public Criteria andWidth1EqualTo(Integer value) {
            addCriterion("WIDTH_1 =", value, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1NotEqualTo(Integer value) {
            addCriterion("WIDTH_1 <>", value, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1GreaterThan(Integer value) {
            addCriterion("WIDTH_1 >", value, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1GreaterThanOrEqualTo(Integer value) {
            addCriterion("WIDTH_1 >=", value, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1LessThan(Integer value) {
            addCriterion("WIDTH_1 <", value, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1LessThanOrEqualTo(Integer value) {
            addCriterion("WIDTH_1 <=", value, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1In(List<Integer> values) {
            addCriterion("WIDTH_1 in", values, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1NotIn(List<Integer> values) {
            addCriterion("WIDTH_1 not in", values, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1Between(Integer value1, Integer value2) {
            addCriterion("WIDTH_1 between", value1, value2, "width1");
            return (Criteria) this;
        }

        public Criteria andWidth1NotBetween(Integer value1, Integer value2) {
            addCriterion("WIDTH_1 not between", value1, value2, "width1");
            return (Criteria) this;
        }

        public Criteria andIsPkIsNull() {
            addCriterion("IS_PK is null");
            return (Criteria) this;
        }

        public Criteria andIsPkIsNotNull() {
            addCriterion("IS_PK is not null");
            return (Criteria) this;
        }

        public Criteria andIsPkEqualTo(String value) {
            addCriterion("IS_PK =", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkNotEqualTo(String value) {
            addCriterion("IS_PK <>", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkGreaterThan(String value) {
            addCriterion("IS_PK >", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PK >=", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkLessThan(String value) {
            addCriterion("IS_PK <", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkLessThanOrEqualTo(String value) {
            addCriterion("IS_PK <=", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkLike(String value) {
            addCriterion("IS_PK like", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkNotLike(String value) {
            addCriterion("IS_PK not like", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkIn(List<String> values) {
            addCriterion("IS_PK in", values, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkNotIn(List<String> values) {
            addCriterion("IS_PK not in", values, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkBetween(String value1, String value2) {
            addCriterion("IS_PK between", value1, value2, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkNotBetween(String value1, String value2) {
            addCriterion("IS_PK not between", value1, value2, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutIsNull() {
            addCriterion("IS_RMB_OUT is null");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutIsNotNull() {
            addCriterion("IS_RMB_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutEqualTo(String value) {
            addCriterion("IS_RMB_OUT =", value, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutNotEqualTo(String value) {
            addCriterion("IS_RMB_OUT <>", value, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutGreaterThan(String value) {
            addCriterion("IS_RMB_OUT >", value, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutGreaterThanOrEqualTo(String value) {
            addCriterion("IS_RMB_OUT >=", value, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutLessThan(String value) {
            addCriterion("IS_RMB_OUT <", value, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutLessThanOrEqualTo(String value) {
            addCriterion("IS_RMB_OUT <=", value, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutLike(String value) {
            addCriterion("IS_RMB_OUT like", value, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutNotLike(String value) {
            addCriterion("IS_RMB_OUT not like", value, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutIn(List<String> values) {
            addCriterion("IS_RMB_OUT in", values, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutNotIn(List<String> values) {
            addCriterion("IS_RMB_OUT not in", values, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutBetween(String value1, String value2) {
            addCriterion("IS_RMB_OUT between", value1, value2, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andIsRmbOutNotBetween(String value1, String value2) {
            addCriterion("IS_RMB_OUT not between", value1, value2, "isRmbOut");
            return (Criteria) this;
        }

        public Criteria andLinkItemIsNull() {
            addCriterion("LINK_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andLinkItemIsNotNull() {
            addCriterion("LINK_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andLinkItemEqualTo(String value) {
            addCriterion("LINK_ITEM =", value, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemNotEqualTo(String value) {
            addCriterion("LINK_ITEM <>", value, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemGreaterThan(String value) {
            addCriterion("LINK_ITEM >", value, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_ITEM >=", value, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemLessThan(String value) {
            addCriterion("LINK_ITEM <", value, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemLessThanOrEqualTo(String value) {
            addCriterion("LINK_ITEM <=", value, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemLike(String value) {
            addCriterion("LINK_ITEM like", value, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemNotLike(String value) {
            addCriterion("LINK_ITEM not like", value, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemIn(List<String> values) {
            addCriterion("LINK_ITEM in", values, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemNotIn(List<String> values) {
            addCriterion("LINK_ITEM not in", values, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemBetween(String value1, String value2) {
            addCriterion("LINK_ITEM between", value1, value2, "linkItem");
            return (Criteria) this;
        }

        public Criteria andLinkItemNotBetween(String value1, String value2) {
            addCriterion("LINK_ITEM not between", value1, value2, "linkItem");
            return (Criteria) this;
        }

        public Criteria andIsBatchIsNull() {
            addCriterion("IS_BATCH is null");
            return (Criteria) this;
        }

        public Criteria andIsBatchIsNotNull() {
            addCriterion("IS_BATCH is not null");
            return (Criteria) this;
        }

        public Criteria andIsBatchEqualTo(String value) {
            addCriterion("IS_BATCH =", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchNotEqualTo(String value) {
            addCriterion("IS_BATCH <>", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchGreaterThan(String value) {
            addCriterion("IS_BATCH >", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchGreaterThanOrEqualTo(String value) {
            addCriterion("IS_BATCH >=", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchLessThan(String value) {
            addCriterion("IS_BATCH <", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchLessThanOrEqualTo(String value) {
            addCriterion("IS_BATCH <=", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchLike(String value) {
            addCriterion("IS_BATCH like", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchNotLike(String value) {
            addCriterion("IS_BATCH not like", value, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchIn(List<String> values) {
            addCriterion("IS_BATCH in", values, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchNotIn(List<String> values) {
            addCriterion("IS_BATCH not in", values, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchBetween(String value1, String value2) {
            addCriterion("IS_BATCH between", value1, value2, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsBatchNotBetween(String value1, String value2) {
            addCriterion("IS_BATCH not between", value1, value2, "isBatch");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemIsNull() {
            addCriterion("IS_SHOW_AT_PERSONITEM is null");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemIsNotNull() {
            addCriterion("IS_SHOW_AT_PERSONITEM is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemEqualTo(String value) {
            addCriterion("IS_SHOW_AT_PERSONITEM =", value, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemNotEqualTo(String value) {
            addCriterion("IS_SHOW_AT_PERSONITEM <>", value, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemGreaterThan(String value) {
            addCriterion("IS_SHOW_AT_PERSONITEM >", value, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SHOW_AT_PERSONITEM >=", value, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemLessThan(String value) {
            addCriterion("IS_SHOW_AT_PERSONITEM <", value, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemLessThanOrEqualTo(String value) {
            addCriterion("IS_SHOW_AT_PERSONITEM <=", value, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemLike(String value) {
            addCriterion("IS_SHOW_AT_PERSONITEM like", value, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemNotLike(String value) {
            addCriterion("IS_SHOW_AT_PERSONITEM not like", value, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemIn(List<String> values) {
            addCriterion("IS_SHOW_AT_PERSONITEM in", values, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemNotIn(List<String> values) {
            addCriterion("IS_SHOW_AT_PERSONITEM not in", values, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemBetween(String value1, String value2) {
            addCriterion("IS_SHOW_AT_PERSONITEM between", value1, value2, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andIsShowAtPersonitemNotBetween(String value1, String value2) {
            addCriterion("IS_SHOW_AT_PERSONITEM not between", value1, value2, "isShowAtPersonitem");
            return (Criteria) this;
        }

        public Criteria andLinkTableIsNull() {
            addCriterion("LINK_TABLE is null");
            return (Criteria) this;
        }

        public Criteria andLinkTableIsNotNull() {
            addCriterion("LINK_TABLE is not null");
            return (Criteria) this;
        }

        public Criteria andLinkTableEqualTo(String value) {
            addCriterion("LINK_TABLE =", value, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableNotEqualTo(String value) {
            addCriterion("LINK_TABLE <>", value, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableGreaterThan(String value) {
            addCriterion("LINK_TABLE >", value, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_TABLE >=", value, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableLessThan(String value) {
            addCriterion("LINK_TABLE <", value, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableLessThanOrEqualTo(String value) {
            addCriterion("LINK_TABLE <=", value, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableLike(String value) {
            addCriterion("LINK_TABLE like", value, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableNotLike(String value) {
            addCriterion("LINK_TABLE not like", value, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableIn(List<String> values) {
            addCriterion("LINK_TABLE in", values, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableNotIn(List<String> values) {
            addCriterion("LINK_TABLE not in", values, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableBetween(String value1, String value2) {
            addCriterion("LINK_TABLE between", value1, value2, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkTableNotBetween(String value1, String value2) {
            addCriterion("LINK_TABLE not between", value1, value2, "linkTable");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnIsNull() {
            addCriterion("LINK_VALUECOLUMN is null");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnIsNotNull() {
            addCriterion("LINK_VALUECOLUMN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnEqualTo(String value) {
            addCriterion("LINK_VALUECOLUMN =", value, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnNotEqualTo(String value) {
            addCriterion("LINK_VALUECOLUMN <>", value, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnGreaterThan(String value) {
            addCriterion("LINK_VALUECOLUMN >", value, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_VALUECOLUMN >=", value, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnLessThan(String value) {
            addCriterion("LINK_VALUECOLUMN <", value, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnLessThanOrEqualTo(String value) {
            addCriterion("LINK_VALUECOLUMN <=", value, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnLike(String value) {
            addCriterion("LINK_VALUECOLUMN like", value, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnNotLike(String value) {
            addCriterion("LINK_VALUECOLUMN not like", value, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnIn(List<String> values) {
            addCriterion("LINK_VALUECOLUMN in", values, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnNotIn(List<String> values) {
            addCriterion("LINK_VALUECOLUMN not in", values, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnBetween(String value1, String value2) {
            addCriterion("LINK_VALUECOLUMN between", value1, value2, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkValuecolumnNotBetween(String value1, String value2) {
            addCriterion("LINK_VALUECOLUMN not between", value1, value2, "linkValuecolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnIsNull() {
            addCriterion("LINK_LABELCOLUMN is null");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnIsNotNull() {
            addCriterion("LINK_LABELCOLUMN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnEqualTo(String value) {
            addCriterion("LINK_LABELCOLUMN =", value, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnNotEqualTo(String value) {
            addCriterion("LINK_LABELCOLUMN <>", value, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnGreaterThan(String value) {
            addCriterion("LINK_LABELCOLUMN >", value, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_LABELCOLUMN >=", value, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnLessThan(String value) {
            addCriterion("LINK_LABELCOLUMN <", value, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnLessThanOrEqualTo(String value) {
            addCriterion("LINK_LABELCOLUMN <=", value, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnLike(String value) {
            addCriterion("LINK_LABELCOLUMN like", value, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnNotLike(String value) {
            addCriterion("LINK_LABELCOLUMN not like", value, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnIn(List<String> values) {
            addCriterion("LINK_LABELCOLUMN in", values, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnNotIn(List<String> values) {
            addCriterion("LINK_LABELCOLUMN not in", values, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnBetween(String value1, String value2) {
            addCriterion("LINK_LABELCOLUMN between", value1, value2, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkLabelcolumnNotBetween(String value1, String value2) {
            addCriterion("LINK_LABELCOLUMN not between", value1, value2, "linkLabelcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnIsNull() {
            addCriterion("LINK_PARENTCOLUMN is null");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnIsNotNull() {
            addCriterion("LINK_PARENTCOLUMN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnEqualTo(String value) {
            addCriterion("LINK_PARENTCOLUMN =", value, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnNotEqualTo(String value) {
            addCriterion("LINK_PARENTCOLUMN <>", value, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnGreaterThan(String value) {
            addCriterion("LINK_PARENTCOLUMN >", value, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_PARENTCOLUMN >=", value, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnLessThan(String value) {
            addCriterion("LINK_PARENTCOLUMN <", value, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnLessThanOrEqualTo(String value) {
            addCriterion("LINK_PARENTCOLUMN <=", value, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnLike(String value) {
            addCriterion("LINK_PARENTCOLUMN like", value, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnNotLike(String value) {
            addCriterion("LINK_PARENTCOLUMN not like", value, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnIn(List<String> values) {
            addCriterion("LINK_PARENTCOLUMN in", values, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnNotIn(List<String> values) {
            addCriterion("LINK_PARENTCOLUMN not in", values, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnBetween(String value1, String value2) {
            addCriterion("LINK_PARENTCOLUMN between", value1, value2, "linkParentcolumn");
            return (Criteria) this;
        }

        public Criteria andLinkParentcolumnNotBetween(String value1, String value2) {
            addCriterion("LINK_PARENTCOLUMN not between", value1, value2, "linkParentcolumn");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * data_table_col 2019-09-03
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