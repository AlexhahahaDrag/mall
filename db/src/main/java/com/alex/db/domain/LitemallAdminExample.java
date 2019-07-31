package com.alex.db.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/7/31 16:53
 * @Version:    1.0
 *
*/
public class LitemallAdminExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LitemallAdminExample() {
        oredCriteria = new ArrayList<>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

    public LitemallAdminExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public LitemallAdminExample orderBy(String ... orderByClauses) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1)
                sb.append(" , ");
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0)
            oredCriteria.add(criteria);
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        LitemallAdminExample example = new LitemallAdminExample();
        return example.createCriteria();
    }

    public LitemallAdminExample when(boolean condition, IExampleWhen when) {
        if (condition)
            when.example(this);
        return this;
    }

    public LitemallAdminExample when(boolean condition, IExampleWhen when, IExampleWhen otherwise) {
        if (condition)
            when.example(this);
        else
            otherwise.example(this);
        return this;
    }

    protected abstract static class GeneratedCriteria {

        protected List<Criterion> roleIdsCriteria;

        protected List<Criterion> allCriteria;

        protected  List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
            roleIdsCriteria = new ArrayList<>();
        }

        public List<Criterion> getRoleIdsCriteria() {
            return roleIdsCriteria;
        }

        protected void addRoleIdsCriteria(String condition, Object value, String property) {
            if (value == null)
                throw new RuntimeException("Value for " + property + "can't be null");
            roleIdsCriteria.add(new Criterion(condition, value, "com.alex.db.mybatis.JsonIntegerArrayTypeHandler"));
            allCriteria = null;
        }

        protected void addRoleIdsCriterion(String condition, Integer[] value1, Integer[] value2, String property) {
            if (value1 == null || value2 == null)
                throw new RuntimeException("Between values for " + property + " can't be null");
            roleIdsCriteria.add(new Criterion(condition, value1, value2, "com.alex.db.mybatis.JsonIntegerArrayTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0 || roleIdsCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(roleIdsCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriteria (String condition) {
            if (condition == null)
                throw new RuntimeException("Value for condition cannot be null");
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected  void addCriteria (String condition, Object value, String property) {
            if (value == null)
                throw new RuntimeException("Value for " + property + " cannot be null");
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriteria (String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null)
                throw new RuntimeException("Between values for " + property + "  cannot be null");
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id = ", value, "id");
            return (Criteria) this;
        }

        public

        protected void addCriterion(String condition) {
            if (condition == null)
                throw new RuntimeException("Value for condition cannot be null");
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }
    }


    public static class Criteria extends GeneratedCriteria {

        private LitemallAdminExample example;

        protected Criteria(LitemallAdminExample example) {
            super();
            this.example = example;
        }

        public LitemallAdminExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add){
            if (ifAdd)
                add.add(this);
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen when) {
            if (condition)
                when.criteria(this);
            return this;
        }

        public Criteria when(boolean conditon, ICriteriaWhen when, ICriteriaWhen otherwise) {
            if (conditon)
                when.criteria(this);
            else
                otherwise.criteria(this);
            return this;
        }

        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? andDeletedEqualTo(LitemallAdminExample.Deleted.IS_DELETED.value()) : andDeletedNotEqualTo(LitemallAdmin.Deleted.IS_DELETED.value());
        }


        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
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

        private  String typeHandler;

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
            if (value instanceof List<?>)
                this.listValue = true;
            else
                this.singleValue = true;
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

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(LitemallAdminExample example);
    }
}
