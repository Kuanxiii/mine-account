package mine.account.account.server.po.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillsExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Integer value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Integer value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Integer value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Integer value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Integer value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Integer> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Integer> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Integer value1, Integer value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDayNoIsNull() {
            addCriterion("day_no is null");
            return (Criteria) this;
        }

        public Criteria andDayNoIsNotNull() {
            addCriterion("day_no is not null");
            return (Criteria) this;
        }

        public Criteria andDayNoEqualTo(Integer value) {
            addCriterion("day_no =", value, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoNotEqualTo(Integer value) {
            addCriterion("day_no <>", value, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoGreaterThan(Integer value) {
            addCriterion("day_no >", value, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_no >=", value, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoLessThan(Integer value) {
            addCriterion("day_no <", value, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoLessThanOrEqualTo(Integer value) {
            addCriterion("day_no <=", value, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoIn(List<Integer> values) {
            addCriterion("day_no in", values, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoNotIn(List<Integer> values) {
            addCriterion("day_no not in", values, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoBetween(Integer value1, Integer value2) {
            addCriterion("day_no between", value1, value2, "dayNo");
            return (Criteria) this;
        }

        public Criteria andDayNoNotBetween(Integer value1, Integer value2) {
            addCriterion("day_no not between", value1, value2, "dayNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoIsNull() {
            addCriterion("week_no is null");
            return (Criteria) this;
        }

        public Criteria andWeekNoIsNotNull() {
            addCriterion("week_no is not null");
            return (Criteria) this;
        }

        public Criteria andWeekNoEqualTo(Integer value) {
            addCriterion("week_no =", value, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoNotEqualTo(Integer value) {
            addCriterion("week_no <>", value, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoGreaterThan(Integer value) {
            addCriterion("week_no >", value, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_no >=", value, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoLessThan(Integer value) {
            addCriterion("week_no <", value, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoLessThanOrEqualTo(Integer value) {
            addCriterion("week_no <=", value, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoIn(List<Integer> values) {
            addCriterion("week_no in", values, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoNotIn(List<Integer> values) {
            addCriterion("week_no not in", values, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoBetween(Integer value1, Integer value2) {
            addCriterion("week_no between", value1, value2, "weekNo");
            return (Criteria) this;
        }

        public Criteria andWeekNoNotBetween(Integer value1, Integer value2) {
            addCriterion("week_no not between", value1, value2, "weekNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoIsNull() {
            addCriterion("mouth_no is null");
            return (Criteria) this;
        }

        public Criteria andMouthNoIsNotNull() {
            addCriterion("mouth_no is not null");
            return (Criteria) this;
        }

        public Criteria andMouthNoEqualTo(Integer value) {
            addCriterion("mouth_no =", value, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoNotEqualTo(Integer value) {
            addCriterion("mouth_no <>", value, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoGreaterThan(Integer value) {
            addCriterion("mouth_no >", value, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("mouth_no >=", value, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoLessThan(Integer value) {
            addCriterion("mouth_no <", value, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoLessThanOrEqualTo(Integer value) {
            addCriterion("mouth_no <=", value, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoIn(List<Integer> values) {
            addCriterion("mouth_no in", values, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoNotIn(List<Integer> values) {
            addCriterion("mouth_no not in", values, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoBetween(Integer value1, Integer value2) {
            addCriterion("mouth_no between", value1, value2, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andMouthNoNotBetween(Integer value1, Integer value2) {
            addCriterion("mouth_no not between", value1, value2, "mouthNo");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("stat is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("stat is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("stat =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("stat <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("stat >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("stat >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("stat <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("stat <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("stat like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("stat not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("stat in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("stat not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("stat between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("stat not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andUseInIsNull() {
            addCriterion("use_in is null");
            return (Criteria) this;
        }

        public Criteria andUseInIsNotNull() {
            addCriterion("use_in is not null");
            return (Criteria) this;
        }

        public Criteria andUseInEqualTo(String value) {
            addCriterion("use_in =", value, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInNotEqualTo(String value) {
            addCriterion("use_in <>", value, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInGreaterThan(String value) {
            addCriterion("use_in >", value, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInGreaterThanOrEqualTo(String value) {
            addCriterion("use_in >=", value, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInLessThan(String value) {
            addCriterion("use_in <", value, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInLessThanOrEqualTo(String value) {
            addCriterion("use_in <=", value, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInLike(String value) {
            addCriterion("use_in like", value, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInNotLike(String value) {
            addCriterion("use_in not like", value, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInIn(List<String> values) {
            addCriterion("use_in in", values, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInNotIn(List<String> values) {
            addCriterion("use_in not in", values, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInBetween(String value1, String value2) {
            addCriterion("use_in between", value1, value2, "useIn");
            return (Criteria) this;
        }

        public Criteria andUseInNotBetween(String value1, String value2) {
            addCriterion("use_in not between", value1, value2, "useIn");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdIsNull() {
            addCriterion("economic_attribute_id is null");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdIsNotNull() {
            addCriterion("economic_attribute_id is not null");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdEqualTo(Integer value) {
            addCriterion("economic_attribute_id =", value, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdNotEqualTo(Integer value) {
            addCriterion("economic_attribute_id <>", value, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdGreaterThan(Integer value) {
            addCriterion("economic_attribute_id >", value, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("economic_attribute_id >=", value, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdLessThan(Integer value) {
            addCriterion("economic_attribute_id <", value, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdLessThanOrEqualTo(Integer value) {
            addCriterion("economic_attribute_id <=", value, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdIn(List<Integer> values) {
            addCriterion("economic_attribute_id in", values, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdNotIn(List<Integer> values) {
            addCriterion("economic_attribute_id not in", values, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdBetween(Integer value1, Integer value2) {
            addCriterion("economic_attribute_id between", value1, value2, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andEconomicAttributeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("economic_attribute_id not between", value1, value2, "economicAttributeId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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