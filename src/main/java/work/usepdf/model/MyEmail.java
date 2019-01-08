//package work.usepdf.model;
//
//import com.sun.xml.internal.ws.api.message.Attachment;
//import freemarker.template.Template;
//
//
//public class MyEmail {
//
//    private Template template;
//    private Object data;
//    private String picFileName;
//    private Attachment attachment;
//
//    private MyEmail(Template template, Object data, String picFileName, Attachment attachment) {
//        this.template = template;
//        this.data = data;
//        this.picFileName = picFileName;
//        this.attachment = attachment;
//    }
//
//    public Template getTemplate() {
//        return template;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public String getPicFileName() {
//        return picFileName;
//    }
//
//    public Attachment getAttachment() {
//        return attachment;
//    }
//
//    public static class Builder {
//        private Template template;
//        private Object data;
//        private String picFileName;
//        private Attachment attachment;
//
//        public Builder setTemplate(Template template) {
//            this.template = template;
//            return this;
//        }
//
//        public Builder setData(Object data) {
//            this.data = data;
//            return this;
//        }
//
//        public Builder setPicFileName(String picFileName) {
//            this.picFileName = picFileName;
//            return this;
//        }
//
//        public Builder setAttachment(Attachment attachment) {
//            this.attachment = attachment;
//            return this;
//        }
//
//        public MyEmail build() {
//            return new MyEmail( template, data, picFileName, attachment);
//        }
//    }
//
//}
