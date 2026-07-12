package com.customer.feedback.sdk.model;

import D2.g;
import D2.k;

/* loaded from: classes.dex */
public abstract class RequestData {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE_BRAND = "brand";
    public static final String TYPE_CONTACT = "contact";
    public static final String TYPE_FEEDBACK = "feedback";
    public static final String TYPE_LOG = "log";
    public static final String TYPE_MODEL = "model";
    public static final String TYPE_OPEN_ID = "openId";
    public static final String TYPE_OS = "os";
    public static final String TYPE_STATISTICS = "statistics";

    public static final class Brand extends RequestData {
        private final String content;
        private final String des;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Brand(String str, String str2) {
            super(null);
            k.e(str, "des");
            k.e(str2, "content");
            this.des = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDes() {
            return this.des;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final RequestData fromString(String str, String str2) {
            k.e(str, "des");
            k.e(str2, "content");
            switch (str.hashCode()) {
                case -1010580219:
                    if (str.equals(RequestData.TYPE_OPEN_ID)) {
                        return new OpenId(str, str2);
                    }
                    return null;
                case -191501435:
                    if (str.equals(RequestData.TYPE_FEEDBACK)) {
                        return new Feedback(str, str2);
                    }
                    return null;
                case -94588637:
                    if (str.equals(RequestData.TYPE_STATISTICS)) {
                        return new Statistics(str, str2);
                    }
                    return null;
                case 3556:
                    if (str.equals(RequestData.TYPE_OS)) {
                        return new Os(str, str2);
                    }
                    return null;
                case 107332:
                    if (str.equals(RequestData.TYPE_LOG)) {
                        return new Log(str, str2);
                    }
                    return null;
                case 93997959:
                    if (str.equals(RequestData.TYPE_BRAND)) {
                        return new Brand(str, str2);
                    }
                    return null;
                case 104069929:
                    if (str.equals(RequestData.TYPE_MODEL)) {
                        return new Model(str, str2);
                    }
                    return null;
                case 951526432:
                    if (str.equals(RequestData.TYPE_CONTACT)) {
                        return new Contact(str, str2);
                    }
                    return null;
                default:
                    return null;
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class Contact extends RequestData {
        private final String content;
        private final String des;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Contact(String str, String str2) {
            super(null);
            k.e(str, "des");
            k.e(str2, "content");
            this.des = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDes() {
            return this.des;
        }
    }

    public static final class Feedback extends RequestData {
        private final String content;
        private final String des;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Feedback(String str, String str2) {
            super(null);
            k.e(str, "des");
            k.e(str2, "content");
            this.des = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDes() {
            return this.des;
        }
    }

    public static final class Log extends RequestData {
        private final String content;
        private final String des;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Log(String str, String str2) {
            super(null);
            k.e(str, "des");
            k.e(str2, "content");
            this.des = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDes() {
            return this.des;
        }
    }

    public static final class Model extends RequestData {
        private final String content;
        private final String des;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Model(String str, String str2) {
            super(null);
            k.e(str, "des");
            k.e(str2, "content");
            this.des = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDes() {
            return this.des;
        }
    }

    public static final class OpenId extends RequestData {
        private final String content;
        private final String des;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenId(String str, String str2) {
            super(null);
            k.e(str, "des");
            k.e(str2, "content");
            this.des = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDes() {
            return this.des;
        }
    }

    public static final class Os extends RequestData {
        private final String content;
        private final String des;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Os(String str, String str2) {
            super(null);
            k.e(str, "des");
            k.e(str2, "content");
            this.des = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDes() {
            return this.des;
        }
    }

    public static final class Statistics extends RequestData {
        private final String content;
        private final String des;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Statistics(String str, String str2) {
            super(null);
            k.e(str, "des");
            k.e(str2, "content");
            this.des = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDes() {
            return this.des;
        }
    }

    private RequestData() {
    }

    public /* synthetic */ RequestData(g gVar) {
        this();
    }
}
