package com.example.myapplication.model;




import java.util.List;

public class MainTagBean {

    private List<SubModulesEntity> subModules;

    public void setSubModules(List<SubModulesEntity> subModules) {
        this.subModules = subModules;
    }

    public List<SubModulesEntity> getSubModules() {
        return subModules;
    }

    public static class SubModulesEntity {
        private String parent;
        private int sequence;
        private int isDefault;
        private int isCategory;
        private String color;
        private String webUrl;
        private int id;
        private String title;
        private String categoryId;
        private String direction;

        public void setId(int id) {
            this.id = id;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public void setIsDefault(int isDefault) {
            this.isDefault = isDefault;
        }

        public int getId() {
            return id;
        }

        public String getParent() {
            return parent;
        }

        public String getDirection() {
            return direction;
        }

        public String getTitle() {
            return title;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public String getColor() {
            return color;
        }

        public int getSequence() {
            return sequence;
        }

        public int getIsDefault() {
            return isDefault;
        }

        public int getIsCategory() {
            return isCategory;
        }

        public void setIsCategory(int isCategory) {
            this.isCategory = isCategory;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        @Override
        public String toString() {
            StringBuffer buffer=new StringBuffer();
            buffer.append("parent=").append(parent).append(",")
                    .append("sequence=").append(sequence).append(",")
                    .append("isDefault=").append(isDefault).append(",")
                    .append("isCategory=").append(isCategory).append(",")
                    .append("color=").append(color).append(",")
                    .append("webUrl=").append(webUrl).append(",")
                    .append("id=").append(id).append(",")
                    .append("title=").append(title).append(",")
                    .append("categoryId=").append(categoryId).append(",")
                    .append("direction=").append(direction);
            return buffer.toString();
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer=new StringBuffer();
        int size=subModules.size();
        for (int i=0;i<size;i++){
            buffer.append("list["+(i+1)+"]=").append(subModules.get(i).toString());
            if (i!=size-1){
                buffer.append(",");
            }
        }
        return buffer.toString();
    }
}
