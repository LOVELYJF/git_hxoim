package com.hxoim.kettle.jobscheduler.entity;

import java.util.ArrayList;
import java.util.List;

public class KJobschedulerExample {
    /**
     * k_jobscheduler
     */
    protected String orderByClause;

    /**
     * k_jobscheduler
     */
    protected boolean distinct;

    /**
     * k_jobscheduler
     */
    protected List<Criteria> oredCriteria;

    public KJobschedulerExample() {
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
     * k_jobscheduler 2019-07-29
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andJobidIsNull() {
            addCriterion("jobId is null");
            return (Criteria) this;
        }

        public Criteria andJobidIsNotNull() {
            addCriterion("jobId is not null");
            return (Criteria) this;
        }

        public Criteria andJobidEqualTo(Long value) {
            addCriterion("jobId =", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotEqualTo(Long value) {
            addCriterion("jobId <>", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThan(Long value) {
            addCriterion("jobId >", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThanOrEqualTo(Long value) {
            addCriterion("jobId >=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThan(Long value) {
            addCriterion("jobId <", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThanOrEqualTo(Long value) {
            addCriterion("jobId <=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidIn(List<Long> values) {
            addCriterion("jobId in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotIn(List<Long> values) {
            addCriterion("jobId not in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidBetween(Long value1, Long value2) {
            addCriterion("jobId between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotBetween(Long value1, Long value2) {
            addCriterion("jobId not between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNull() {
            addCriterion("jobName is null");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNotNull() {
            addCriterion("jobName is not null");
            return (Criteria) this;
        }

        public Criteria andJobnameEqualTo(String value) {
            addCriterion("jobName =", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotEqualTo(String value) {
            addCriterion("jobName <>", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThan(String value) {
            addCriterion("jobName >", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThanOrEqualTo(String value) {
            addCriterion("jobName >=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThan(String value) {
            addCriterion("jobName <", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThanOrEqualTo(String value) {
            addCriterion("jobName <=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLike(String value) {
            addCriterion("jobName like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotLike(String value) {
            addCriterion("jobName not like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameIn(List<String> values) {
            addCriterion("jobName in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotIn(List<String> values) {
            addCriterion("jobName not in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameBetween(String value1, String value2) {
            addCriterion("jobName between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotBetween(String value1, String value2) {
            addCriterion("jobName not between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andIsrepeatIsNull() {
            addCriterion("isRepeat is null");
            return (Criteria) this;
        }

        public Criteria andIsrepeatIsNotNull() {
            addCriterion("isRepeat is not null");
            return (Criteria) this;
        }

        public Criteria andIsrepeatEqualTo(Boolean value) {
            addCriterion("isRepeat =", value, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatNotEqualTo(Boolean value) {
            addCriterion("isRepeat <>", value, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatGreaterThan(Boolean value) {
            addCriterion("isRepeat >", value, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isRepeat >=", value, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatLessThan(Boolean value) {
            addCriterion("isRepeat <", value, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatLessThanOrEqualTo(Boolean value) {
            addCriterion("isRepeat <=", value, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatIn(List<Boolean> values) {
            addCriterion("isRepeat in", values, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatNotIn(List<Boolean> values) {
            addCriterion("isRepeat not in", values, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatBetween(Boolean value1, Boolean value2) {
            addCriterion("isRepeat between", value1, value2, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andIsrepeatNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isRepeat not between", value1, value2, "isrepeat");
            return (Criteria) this;
        }

        public Criteria andScheduletypeIsNull() {
            addCriterion("scheduleType is null");
            return (Criteria) this;
        }

        public Criteria andScheduletypeIsNotNull() {
            addCriterion("scheduleType is not null");
            return (Criteria) this;
        }

        public Criteria andScheduletypeEqualTo(Integer value) {
            addCriterion("scheduleType =", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeNotEqualTo(Integer value) {
            addCriterion("scheduleType <>", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeGreaterThan(Integer value) {
            addCriterion("scheduleType >", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("scheduleType >=", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeLessThan(Integer value) {
            addCriterion("scheduleType <", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeLessThanOrEqualTo(Integer value) {
            addCriterion("scheduleType <=", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeIn(List<Integer> values) {
            addCriterion("scheduleType in", values, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeNotIn(List<Integer> values) {
            addCriterion("scheduleType not in", values, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeBetween(Integer value1, Integer value2) {
            addCriterion("scheduleType between", value1, value2, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeNotBetween(Integer value1, Integer value2) {
            addCriterion("scheduleType not between", value1, value2, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andSecondsIsNull() {
            addCriterion("seconds is null");
            return (Criteria) this;
        }

        public Criteria andSecondsIsNotNull() {
            addCriterion("seconds is not null");
            return (Criteria) this;
        }

        public Criteria andSecondsEqualTo(String value) {
            addCriterion("seconds =", value, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsNotEqualTo(String value) {
            addCriterion("seconds <>", value, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsGreaterThan(String value) {
            addCriterion("seconds >", value, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsGreaterThanOrEqualTo(String value) {
            addCriterion("seconds >=", value, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsLessThan(String value) {
            addCriterion("seconds <", value, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsLessThanOrEqualTo(String value) {
            addCriterion("seconds <=", value, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsLike(String value) {
            addCriterion("seconds like", value, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsNotLike(String value) {
            addCriterion("seconds not like", value, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsIn(List<String> values) {
            addCriterion("seconds in", values, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsNotIn(List<String> values) {
            addCriterion("seconds not in", values, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsBetween(String value1, String value2) {
            addCriterion("seconds between", value1, value2, "seconds");
            return (Criteria) this;
        }

        public Criteria andSecondsNotBetween(String value1, String value2) {
            addCriterion("seconds not between", value1, value2, "seconds");
            return (Criteria) this;
        }

        public Criteria andMinutesIsNull() {
            addCriterion("minutes is null");
            return (Criteria) this;
        }

        public Criteria andMinutesIsNotNull() {
            addCriterion("minutes is not null");
            return (Criteria) this;
        }

        public Criteria andMinutesEqualTo(String value) {
            addCriterion("minutes =", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesNotEqualTo(String value) {
            addCriterion("minutes <>", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesGreaterThan(String value) {
            addCriterion("minutes >", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesGreaterThanOrEqualTo(String value) {
            addCriterion("minutes >=", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesLessThan(String value) {
            addCriterion("minutes <", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesLessThanOrEqualTo(String value) {
            addCriterion("minutes <=", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesLike(String value) {
            addCriterion("minutes like", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesNotLike(String value) {
            addCriterion("minutes not like", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesIn(List<String> values) {
            addCriterion("minutes in", values, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesNotIn(List<String> values) {
            addCriterion("minutes not in", values, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesBetween(String value1, String value2) {
            addCriterion("minutes between", value1, value2, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesNotBetween(String value1, String value2) {
            addCriterion("minutes not between", value1, value2, "minutes");
            return (Criteria) this;
        }

        public Criteria andHoursIsNull() {
            addCriterion("hours is null");
            return (Criteria) this;
        }

        public Criteria andHoursIsNotNull() {
            addCriterion("hours is not null");
            return (Criteria) this;
        }

        public Criteria andHoursEqualTo(String value) {
            addCriterion("hours =", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotEqualTo(String value) {
            addCriterion("hours <>", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursGreaterThan(String value) {
            addCriterion("hours >", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursGreaterThanOrEqualTo(String value) {
            addCriterion("hours >=", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursLessThan(String value) {
            addCriterion("hours <", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursLessThanOrEqualTo(String value) {
            addCriterion("hours <=", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursLike(String value) {
            addCriterion("hours like", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotLike(String value) {
            addCriterion("hours not like", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursIn(List<String> values) {
            addCriterion("hours in", values, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotIn(List<String> values) {
            addCriterion("hours not in", values, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursBetween(String value1, String value2) {
            addCriterion("hours between", value1, value2, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotBetween(String value1, String value2) {
            addCriterion("hours not between", value1, value2, "hours");
            return (Criteria) this;
        }

        public Criteria andWeekdayIsNull() {
            addCriterion("weekday is null");
            return (Criteria) this;
        }

        public Criteria andWeekdayIsNotNull() {
            addCriterion("weekday is not null");
            return (Criteria) this;
        }

        public Criteria andWeekdayEqualTo(String value) {
            addCriterion("weekday =", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotEqualTo(String value) {
            addCriterion("weekday <>", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayGreaterThan(String value) {
            addCriterion("weekday >", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayGreaterThanOrEqualTo(String value) {
            addCriterion("weekday >=", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLessThan(String value) {
            addCriterion("weekday <", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLessThanOrEqualTo(String value) {
            addCriterion("weekday <=", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLike(String value) {
            addCriterion("weekday like", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotLike(String value) {
            addCriterion("weekday not like", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayIn(List<String> values) {
            addCriterion("weekday in", values, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotIn(List<String> values) {
            addCriterion("weekday not in", values, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayBetween(String value1, String value2) {
            addCriterion("weekday between", value1, value2, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotBetween(String value1, String value2) {
            addCriterion("weekday not between", value1, value2, "weekday");
            return (Criteria) this;
        }

        public Criteria andDayofmonthIsNull() {
            addCriterion("dayOfMonth is null");
            return (Criteria) this;
        }

        public Criteria andDayofmonthIsNotNull() {
            addCriterion("dayOfMonth is not null");
            return (Criteria) this;
        }

        public Criteria andDayofmonthEqualTo(String value) {
            addCriterion("dayOfMonth =", value, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthNotEqualTo(String value) {
            addCriterion("dayOfMonth <>", value, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthGreaterThan(String value) {
            addCriterion("dayOfMonth >", value, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthGreaterThanOrEqualTo(String value) {
            addCriterion("dayOfMonth >=", value, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthLessThan(String value) {
            addCriterion("dayOfMonth <", value, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthLessThanOrEqualTo(String value) {
            addCriterion("dayOfMonth <=", value, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthLike(String value) {
            addCriterion("dayOfMonth like", value, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthNotLike(String value) {
            addCriterion("dayOfMonth not like", value, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthIn(List<String> values) {
            addCriterion("dayOfMonth in", values, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthNotIn(List<String> values) {
            addCriterion("dayOfMonth not in", values, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthBetween(String value1, String value2) {
            addCriterion("dayOfMonth between", value1, value2, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andDayofmonthNotBetween(String value1, String value2) {
            addCriterion("dayOfMonth not between", value1, value2, "dayofmonth");
            return (Criteria) this;
        }

        public Criteria andMonthsIsNull() {
            addCriterion("months is null");
            return (Criteria) this;
        }

        public Criteria andMonthsIsNotNull() {
            addCriterion("months is not null");
            return (Criteria) this;
        }

        public Criteria andMonthsEqualTo(String value) {
            addCriterion("months =", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotEqualTo(String value) {
            addCriterion("months <>", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsGreaterThan(String value) {
            addCriterion("months >", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsGreaterThanOrEqualTo(String value) {
            addCriterion("months >=", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsLessThan(String value) {
            addCriterion("months <", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsLessThanOrEqualTo(String value) {
            addCriterion("months <=", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsLike(String value) {
            addCriterion("months like", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotLike(String value) {
            addCriterion("months not like", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsIn(List<String> values) {
            addCriterion("months in", values, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotIn(List<String> values) {
            addCriterion("months not in", values, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsBetween(String value1, String value2) {
            addCriterion("months between", value1, value2, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotBetween(String value1, String value2) {
            addCriterion("months not between", value1, value2, "months");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigIsNull() {
            addCriterion("executionConfig is null");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigIsNotNull() {
            addCriterion("executionConfig is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigEqualTo(String value) {
            addCriterion("executionConfig =", value, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigNotEqualTo(String value) {
            addCriterion("executionConfig <>", value, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigGreaterThan(String value) {
            addCriterion("executionConfig >", value, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigGreaterThanOrEqualTo(String value) {
            addCriterion("executionConfig >=", value, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigLessThan(String value) {
            addCriterion("executionConfig <", value, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigLessThanOrEqualTo(String value) {
            addCriterion("executionConfig <=", value, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigLike(String value) {
            addCriterion("executionConfig like", value, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigNotLike(String value) {
            addCriterion("executionConfig not like", value, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigIn(List<String> values) {
            addCriterion("executionConfig in", values, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigNotIn(List<String> values) {
            addCriterion("executionConfig not in", values, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigBetween(String value1, String value2) {
            addCriterion("executionConfig between", value1, value2, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andExecutionconfigNotBetween(String value1, String value2) {
            addCriterion("executionConfig not between", value1, value2, "executionconfig");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * k_jobscheduler 2019-07-29
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