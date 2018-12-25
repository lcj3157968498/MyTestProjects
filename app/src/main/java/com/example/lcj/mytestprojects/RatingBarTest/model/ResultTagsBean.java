package com.example.lcj.mytestprojects.RatingBarTest.model;

import java.util.List;

/**
 * Created by lcj on 2018/12/4.
 * Description:
 */
public class ResultTagsBean {
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * level : 1
         * tags : [{"name":"差评1"},{"name":"差评2"},{"name":"差评3"}]
         */

        private int level;
        private List<TagsBean> tags;

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean {
            /**
             * name : 差评1
             */

            private String name;

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }

            private boolean isCheck;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
